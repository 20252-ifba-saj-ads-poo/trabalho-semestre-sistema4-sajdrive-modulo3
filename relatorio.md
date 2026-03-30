### 📝 Resumo e Nota
- **Nota Final:** 53/100
- **Visão Geral:** O Módulo 3 (Feedback e Avaliação) apresenta um esforço válido de modelagem de domínio com uso de herança nas entidades (`Motorista`/`Passageiro` estendendo `Usuario`) e criação de Services específicos para o módulo. Entretanto, **a aplicação não inicia** devido à configuração incorreta dos caminhos dos arquivos FXML, impossibilitando a verificação funcional da interface. Além disso, o controller único `CadastroFeedbackController` atua como uma "God Class" com quase 400 linhas gerenciando todas as entidades, e o `AbstractModel` omitiu a sobrescrita de `hashCode()`. A nota reflete rigorosamente estas falhas estruturais e arquiteturais acumuladas.

### 📊 Detalhamento do Barema
- **[15/20] Interface Gráfica:** A aplicação **não inicia**. Os arquivos FXML estão em um diretório diferente do esperado pela aplicação, impedindo a carga das telas. Embora os controllers do módulo (`CadastroFeedbackController`, `RealizarFeedbackController`) existam no código e demonstrem a intenção de tratar `Alerts` de erro, a impossibilidade de execução impede a verificação funcional completa. O boilerplate do template inicial (Autores/Livros) não foi extirpado do projeto.
- **[12/30] Camada de Negócio:** Existem Services específicos para o módulo (`MotoristaService`, `PassageiroService`, `VeiculoService`, `AvaliacaoService`, etc.) com validações de campos obrigatórios e de domínio, o que evita a nota zero pela regra de boilerplate. Destaque positivo para a exceção customizada `AvaliacaoInvalidaException`. Contudo, a penalização é severa porque: a maioria das exceções lançadas são `IllegalArgumentException` genéricas ao invés de exceções customizadas de domínio; 
- **[12/20] Camada de Dados (Repository/Modelagem):** O `RepositorioGenerico<T>` implementa corretamente o CRUD genérico e as entidades do módulo estendem `AbstractModel`. Os modelos exploram bem a herança (`Usuario` → `Motorista`/`Passageiro`) e composição. Porém, a classe `AbstractModel` implementa `equals()` baseado no `id` mas **omite a sobrescrita de `hashCode()`**, quebrando o contrato `equals/hashCode` do Java e comprometendo a integridade em coleções baseadas em Hash (`HashMap`, `HashSet`). Adicionalmente, o modelo é anêmico — aceita estados inválidos sem qualquer validação nos construtores (ex: `Motorista` com CPF nulo ou em branco).
- **[10/20] Separação em Camadas:** O fluxo básico Controller → Service → DAO é respeitado: controllers não acessam diretamente o DAO e Services delegam a persistência ao repositório. Porém, há violações relevantes: (1) `CadastroFeedbackController` é uma **"God Class"** com quase 400 linhas, gerenciando `TableViews`, `ComboBoxes` e operações CRUD de Motoristas, Passageiros, Veículos e Categorias de Problemas em um único arquivo; (2) `Biblioteca.java` atua como **Global State** expondo instâncias estáticas públicas dos Services, escondendo o acoplamento; (3) conversões de tipo perigosas (`Integer.parseInt`) são feitas diretamente no Controller ao invés de serem delegadas e tratadas pelo Service.
- **[4/10] Boas Práticas e POO:** Modelo de Domínio Anêmico — as classes do `model` são recipientes passivos de dados (getters/setters puros) sem encapsular seu próprio comportamento ou proteger seu estado. O atributo `nascimento` é tipado como `String` ao invés de `java.time.LocalDate`, permitindo inserções inválidas. Há duplicação massiva de código nos Services (cada um reescrevendo CRUD idêntico).

### 🐛 Erros Lógicos, Arquiteturais e Execução
- **Aplicação não inicia:** Caminhos de FXML incorretos impedem a carga da interface JavaFX.
- **`AbstractModel` tem `equals()` sem `hashCode()`:** Viola o contrato fundamental do Java — objetos iguais pelo `equals` devem retornar o mesmo `hashCode`. Causa comportamento imprevisível em `HashMap` e `HashSet`.
- **"God Class" no Controller:** `CadastroFeedbackController` (~400 linhas) concentra a gestão de todas as entidades do módulo, violando frontalmente o Princípio de Responsabilidade Única.
- **Global State via `Biblioteca.java`:** Services expostos como `public static`, impossibilitando testes unitários isolados e escondendo acoplamento real entre as camadas.
- **`Integer.parseInt` sem tratamento no Controller:** Se o usuário digitar texto não numérico no campo "ano", a aplicação lançará `NumberFormatException` com mensagem técnica do Java na tela de `Alert`, confundindo o usuário.
- **Exceções genéricas nos Services:** Uso massivo de `IllegalArgumentException` ao invés de exceções customizadas de domínio descritivas. Apenas `AvaliacaoInvalidaException` é customizada.
- **Modelo Anêmico:** É possível criar `Motorista` com CPF nulo, `Passageiro` com email vazio, e `nascimento` como "Hoje" sem qualquer barreira no construtor.

### 💡 Refatoração / Código
**1. Completando o contrato `equals/hashCode` no `AbstractModel`:**
O Java exige que se `equals()` for sobrescrito, `hashCode()` também deve ser, utilizando os mesmos campos de comparação. Sem isso, um objeto encontrado por `equals` pode não ser localizado dentro de um `HashMap`:
```java
public abstract class AbstractModel<T> {
    private T id;

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof AbstractModel)) return false;
        AbstractModel<?> outro = (AbstractModel<?>) obj;
        return this.id != null && this.id.equals(outro.id);
    }

    // OBRIGATÓRIO: contrato do Java exige hashCode consistente com equals
    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
```

**2. Eliminando a duplicação com Service Genérico:**
Cada Service reescreve `salvar()`, `remover()`, `buscarTodos()` com `this.repositorio = new RepositorioGenerico<>()`. A arquitetura de referência exige herança genérica para centralizar o CRUD:
```java
// Base Genérica — escrita uma vez, herdada por todos:
public abstract class ServiceBase<T extends AbstractModel<String>> {
    protected RepositorioGenerico<T> repositorio = new RepositorioGenerico<>();

    public void salvar(T entidade) throws Exception {
        // Validações base aqui
        repositorio.salvar(entidade);
    }

    public List<T> buscarTodos() {
        return repositorio.buscarTodos();
    }

    public void remover(String id) {
        repositorio.deletar(id);
    }

}

// O Service específico foca APENAS nas regras do domínio:
public class AvaliacaoService extends ServiceBase<Avaliacao> {
    @Override
    public void salvar(Avaliacao aval) throws AvaliacaoInvalidaException {
        if (aval.getNota() < 0 || aval.getNota() > 10)
            throw new AvaliacaoInvalidaException("Nota deve ser entre 0 e 10.");
        super.salvar(aval); // Delega o CRUD base
    }
}
```

**3. Quebrando a "God Class" `CadastroFeedbackController`:**
Um controller de ~400 linhas gerenciando 4+ entidades viola SRP. Cada domínio deveria ter seu próprio controller com seu próprio FXML:
```java
// Antes (ERRADO — tudo junto):
public class CadastroFeedbackController {
    @FXML private TableView<Motorista> tbMotoristas;
    @FXML private TableView<Passageiro> tbPassageiros;
    @FXML private TableView<Veiculo> tbVeiculos;
    // ~400 linhas...
}

// Depois (CORRETO — cada domínio isolado):
public class MotoristaController {
    @FXML private TableView<Motorista> tbMotoristas;
    // Apenas lógica de tela para Motorista
}
public class VeiculoController {
    @FXML private TableView<Veiculo> tbVeiculos;
    // Apenas lógica de tela para Veículo
}
```

**4. Tipagem Rica e Exceções de Domínio:**
Usar `String` para datas e `IllegalArgumentException` genérica contradiz a tipagem expressiva e tratamento descritivo exigidos:
```java
// Antes (ERRADO):
private String nascimento; // Aceita "Hoje", "abc", "50/50/2000"

// Depois (CORRETO):
private LocalDate nascimento; // Java valida formato e lógica de data automaticamente

// Antes (ERRADO — exceção genérica):
throw new IllegalArgumentException("CPF inválido");

// Depois (CORRETO — exceção de domínio):
public class CpfInvalidoException extends Exception {
    public CpfInvalidoException(String msg) { super(msg); }
}
throw new CpfInvalidoException("CPF não pode ser nulo ou vazio.");
```
