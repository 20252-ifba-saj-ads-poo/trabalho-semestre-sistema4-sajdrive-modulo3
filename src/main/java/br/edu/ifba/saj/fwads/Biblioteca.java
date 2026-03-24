package br.edu.ifba.saj.fwads;

import br.edu.ifba.saj.fwads.model.*;
import br.edu.ifba.saj.fwads.service.*;

public class Biblioteca {

    public static MotoristaService motoristaService = new MotoristaService();
    public static PassageiroService passageiroService = new PassageiroService();
    public static VeiculoService veiculoService = new VeiculoService();
    public static TipoProblemaService tipoProblemaService = new TipoProblemaService();
    public static TipoSugestaoService tipoSugestaoService = new TipoSugestaoService();
    public static ProblemaService problemaService = new ProblemaService();
    public static SugestaoService sugestaoService = new SugestaoService();
    public static AvaliacaoService avaliacaoService = new AvaliacaoService();

    static {
        // Motoristas 
        motoristaService.salvar(new Motorista("Leandro Costa", "leandro@email.com", "111.111.111-11", "01/01/1990", "MAT-001"));
        motoristaService.salvar(new Motorista("Erik Amorim", "erik@email.com", "222.222.222-22", "17/05/2003", "MAT-002"));
        // Veículos
        veiculoService.salvar(new Veiculo("Ônibus", 2020, "ABC-1234", 40));
        veiculoService.salvar(new Veiculo("Van", 2019, "DEF-5678", 15));
        veiculoService.salvar(new Veiculo("Carro", 2022, "GHI-9012", 4));
        // Tipos de problema
        tipoProblemaService.salvar(new TipoProblema("Ar-condicionado quebrado", Prioridade.Alta, true));
        tipoProblemaService.salvar(new TipoProblema("Atraso na linha", Prioridade.Regular, false));
        // Tipos de sugestão
        tipoSugestaoService.salvar(new TipoSugestao("Melhoria no App"));
        tipoSugestaoService.salvar(new TipoSugestao("Melhoria no Transporte"));
    }
}