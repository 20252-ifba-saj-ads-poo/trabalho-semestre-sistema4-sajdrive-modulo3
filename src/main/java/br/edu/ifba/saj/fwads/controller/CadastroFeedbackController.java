package br.edu.ifba.saj.fwads.controller;

import br.edu.ifba.saj.fwads.Biblioteca;
import br.edu.ifba.saj.fwads.model.Motorista;
import br.edu.ifba.saj.fwads.model.Passageiro;
import br.edu.ifba.saj.fwads.model.Prioridade;
import br.edu.ifba.saj.fwads.model.TipoProblema;
import br.edu.ifba.saj.fwads.model.TipoSugestao;
import br.edu.ifba.saj.fwads.model.Veiculo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.beans.property.SimpleStringProperty;

public class CadastroFeedbackController {

    @FXML
    private Button btnSalvarMotorista;

    @FXML
    private Button btnSalvarPassageiro;

    @FXML
    private Button btnSalvarTipoProblema;

    @FXML
    private Button btnSalvarTipoSugestao;

    @FXML
    private Button btnSalvarVeiculo;

    @FXML
    private ComboBox<Prioridade> cbPrioridadeProblema;

    @FXML
    private CheckBox chkExigeVeiculoProblema;

    @FXML
    private TableColumn<Veiculo, String> colAnoVeiculo;

    @FXML
    private TableColumn<Veiculo, String> colCapacidadeVeiculo;

    @FXML
    private TableColumn<Motorista, String> colCpfMotorista;

    @FXML
    private TableColumn<Passageiro, String> colCpfPassageiro;

    @FXML
    private TableColumn<Motorista, String> colEmailMotorista;

    @FXML
    private TableColumn<Passageiro, String> colEmailPassageiro;

    @FXML
    private TableColumn<Motorista, String> colIdMotorista;

    @FXML
    private TableColumn<Passageiro, String> colIdPassageiro;

    @FXML
    private TableColumn<Veiculo, String> colIdVeiculo;

    @FXML
    private TableColumn<Motorista, String> colMatriculaMotorista;

    @FXML
    private TableColumn<Veiculo, String> colModeloVeiculo;

    @FXML
    private TableColumn<Motorista, String> colNascimentoMotorista;

    @FXML
    private TableColumn<Passageiro, String> colNascimentoPassageiro;

    @FXML
    private TableColumn<Motorista, String> colNomeMotorista;

    @FXML
    private TableColumn<Passageiro, String> colNomePassageiro;

    @FXML
    private TableColumn<Veiculo, String> colPlacaVeiculo;

    @FXML
    private TableView<Motorista> tbMotoristas;

    @FXML
    private TableView<Passageiro> tbPassageiros;

    @FXML
    private TableView<Veiculo> tbVeiculos;

    @FXML
    private TextField txtAnoVeiculo;

    @FXML
    private TextField txtCapacidadeVeiculo;

    @FXML
    private TextField txtCpfMotorista;

    @FXML
    private TextField txtCpfPassageiro;

    @FXML
    private TextField txtEmailMotorista;

    @FXML
    private TextField txtEmailPassageiro;

    @FXML
    private TextField txtMatriculaMotorista;

    @FXML
    private TextField txtModeloVeiculo;

    @FXML
    private TextField txtNascimentoMotorista;

    @FXML
    private TextField txtNascimentoPassageiro;

    @FXML
    private TextField txtNomeMotorista;

    @FXML
    private TextField txtNomePassageiro;

    @FXML
    private TextField txtNomeTipoProblema;

    @FXML
    private TextField txtNomeTipoSugestao;

    @FXML
    private TextField txtPlacaVeiculo;

    @FXML
public void initialize() {
    // Preenche com os enum
    cbPrioridadeProblema.setItems(
        FXCollections.observableArrayList(Prioridade.values())
    );

    // Para as colunas da tabela dos motoristas
    colIdMotorista.setCellValueFactory(
        data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getId())
    );
    colNomeMotorista.setCellValueFactory(
        data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getNome())
    );
    colCpfMotorista.setCellValueFactory(
        data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getCPF())
    );
    colNascimentoMotorista.setCellValueFactory(
        data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getNascimento())
    );
    colMatriculaMotorista.setCellValueFactory(
        data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getMatricula())
    );
    colEmailMotorista.setCellValueFactory(
        data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getEmail())
    );

    // Para mostrar os motoristas na tabela
    ObservableList<Motorista> motoristas = FXCollections.observableArrayList(
        Biblioteca.motoristaService.buscarTodos()
    );
    tbMotoristas.setItems(motoristas);

    // Para as colunas da tabela dos passageiros
    colIdPassageiro.setCellValueFactory(
        data -> new SimpleStringProperty(data.getValue().getId())
    );
    colNomePassageiro.setCellValueFactory(
        data -> new SimpleStringProperty(data.getValue().getNome())
    );
    colCpfPassageiro.setCellValueFactory(
        data -> new SimpleStringProperty(data.getValue().getCPF())
    );
    colNascimentoPassageiro.setCellValueFactory(
        data -> new SimpleStringProperty(data.getValue().getNascimento())
    );
    colEmailPassageiro.setCellValueFactory(
        data -> new SimpleStringProperty(data.getValue().getEmail())
    );

    // Para mostrar os passageiros na tabela
    ObservableList<Passageiro> passageiros = FXCollections.observableArrayList(
        Biblioteca.passageiroService.buscarTodos()
    );
    tbPassageiros.setItems(passageiros);

    // Para as colunas da tabela dos veículos
    colIdVeiculo.setCellValueFactory(
        data -> new SimpleStringProperty(data.getValue().getId())
    );
    colPlacaVeiculo.setCellValueFactory(
        data -> new SimpleStringProperty(data.getValue().getPlaca())
    );
    colModeloVeiculo.setCellValueFactory(
        data -> new SimpleStringProperty(data.getValue().getModelo())
    );
    colAnoVeiculo.setCellValueFactory(
        data -> new SimpleStringProperty(String.valueOf(data.getValue().getAno()))
    );
    colCapacidadeVeiculo.setCellValueFactory(
        data -> new SimpleStringProperty(String.valueOf(data.getValue().getCapacidade()))
    );

    // Para mostrar os veículos na tabela
    ObservableList<Veiculo> veiculos = FXCollections.observableArrayList(
        Biblioteca.veiculoService.buscarTodos()
    );
    tbVeiculos.setItems(veiculos);  
    }

    @FXML
public void salvarMotorista() {
    try {
        // Para pegar as informações que o usuário digitou
        String nome = txtNomeMotorista.getText();
        String cpf = txtCpfMotorista.getText();
        String nascimento = txtNascimentoMotorista.getText();
        String email = txtEmailMotorista.getText();
        String matricula = txtMatriculaMotorista.getText();

        // Para criar o objeto e salvar
        Motorista motorista = new Motorista(nome, email, cpf, nascimento, matricula);
        Biblioteca.motoristaService.salvar(motorista);

        // Para atualizar a tabela
        tbMotoristas.setItems(FXCollections.observableArrayList(
            Biblioteca.motoristaService.buscarTodos()
        ));

        // Para limpar os campos
        txtNomeMotorista.clear();
        txtCpfMotorista.clear();
        txtNascimentoMotorista.clear();
        txtEmailMotorista.clear();
        txtMatriculaMotorista.clear();

    } catch (IllegalArgumentException e) {
        // Para mostrar o erro para o usuário
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erro");
        alert.setHeaderText("Dados inválidos");
        alert.setContentText(e.getMessage());
        alert.showAndWait();
    }
}

    @FXML
public void salvarPassageiro() {
    try {
        // Para pegar as informações que o usuário digitou
        String nome = txtNomePassageiro.getText();
        String cpf = txtCpfPassageiro.getText();
        String nascimento = txtNascimentoPassageiro.getText();
        String email = txtEmailPassageiro.getText();

        // Para criar o objeto e salvar
        Passageiro passageiro = new Passageiro(nome, email, cpf, nascimento, null);
        Biblioteca.passageiroService.salvar(passageiro);

        // Para atualizar a tabela
        tbPassageiros.setItems(FXCollections.observableArrayList(
            Biblioteca.passageiroService.buscarTodos()
        ));

        // Para limpar os campos
        txtNomePassageiro.clear();
        txtCpfPassageiro.clear();
        txtNascimentoPassageiro.clear();
        txtEmailPassageiro.clear();

    } catch (IllegalArgumentException e) {
        // Para mostrar o erro para o usuário
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erro");
        alert.setHeaderText("Dados inválidos");
        alert.setContentText(e.getMessage());
        alert.showAndWait();
    }
}

    @FXML
public void salvarVeiculo() {
    try {
        // Para pegar as informações que o usuário digitou
        String placa = txtPlacaVeiculo.getText();
        String modelo = txtModeloVeiculo.getText();
        int ano = Integer.parseInt(txtAnoVeiculo.getText());
        int capacidade = Integer.parseInt(txtCapacidadeVeiculo.getText());

        // Para criar o objeto e salvar
        Veiculo veiculo = new Veiculo(modelo, ano, placa, capacidade);
        Biblioteca.veiculoService.salvar(veiculo);

        // Para atualizar a tabela
        tbVeiculos.setItems(FXCollections.observableArrayList(
            Biblioteca.veiculoService.buscarTodos()
        ));

        // Para limpar os campos
        txtPlacaVeiculo.clear();
        txtModeloVeiculo.clear();
        txtAnoVeiculo.clear();
        txtCapacidadeVeiculo.clear();

    } catch (IllegalArgumentException e) {
        // Para mostrar o erro para o usuário
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erro");
        alert.setHeaderText("Dados inválidos");
        alert.setContentText(e.getMessage());
        alert.showAndWait();
    }
}

    @FXML
public void salvarTipoProblema() {
    try {
        // Para pegar as informações que o usuário digitou
        String descricao = txtNomeTipoProblema.getText();
        Prioridade prioridade = cbPrioridadeProblema.getValue();
        boolean exigeVeiculo = chkExigeVeiculoProblema.isSelected();

        // Para criar o objeto e salvar
        TipoProblema tipoProblema = new TipoProblema(descricao, prioridade, exigeVeiculo);
        Biblioteca.tipoProblemaService.salvar(tipoProblema);

        // Para limpar os campos
        txtNomeTipoProblema.clear();
        cbPrioridadeProblema.setValue(null);
        chkExigeVeiculoProblema.setSelected(false);

    } catch (IllegalArgumentException e) {
        // Para mostrar o erro para o usuário
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erro");
        alert.setHeaderText("Dados inválidos");
        alert.setContentText(e.getMessage());
        alert.showAndWait();
    }
}

    @FXML
public void salvarTipoSugestao() {
    try {
        // Para pegar as informações que o usuário digitou
        String descricao = txtNomeTipoSugestao.getText();

        // Para criar o objeto e salvar
        TipoSugestao tipoSugestao = new TipoSugestao(descricao);
        Biblioteca.tipoSugestaoService.salvar(tipoSugestao);

        // Para limpar os campos
        txtNomeTipoSugestao.clear();

    } catch (IllegalArgumentException e) {
        // Para mostrar o erro para o usuário
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erro");
        alert.setHeaderText("Dados inválidos");
        alert.setContentText(e.getMessage());
        alert.showAndWait();
    }
}
}