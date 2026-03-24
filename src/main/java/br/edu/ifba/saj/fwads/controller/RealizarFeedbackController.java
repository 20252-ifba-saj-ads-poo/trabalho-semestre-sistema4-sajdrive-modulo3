package br.edu.ifba.saj.fwads.controller;

import br.edu.ifba.saj.fwads.Biblioteca;
import br.edu.ifba.saj.fwads.model.Avaliacao;
import br.edu.ifba.saj.fwads.model.Motorista;
import br.edu.ifba.saj.fwads.model.Problema;
import br.edu.ifba.saj.fwads.model.Sugestao;
import br.edu.ifba.saj.fwads.model.TipoProblema;
import br.edu.ifba.saj.fwads.model.TipoSugestao;
import br.edu.ifba.saj.fwads.model.Veiculo;
import java.time.LocalDateTime;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;

public class RealizarFeedbackController {

    @FXML
    private Button btnEnviarAvaliacao;

    @FXML
    private Button btnEnviarSugestao;

    @FXML
    private Button btnReportarProblema;

    @FXML
    private ComboBox<Motorista> cbMotorista;

    @FXML
    private ComboBox<TipoProblema> cbTipoProblema;

    @FXML
    private ComboBox<Veiculo> cbVeiculoProblema;

    @FXML
    private ComboBox<Veiculo> cbVeiculoSugestao;

    @FXML
    private CheckBox chkAnonimo;

    @FXML
    private RadioButton rbAplicativo;

    @FXML
    private RadioButton rbTransporte;

    @FXML
    private Slider slNota;

    @FXML
    private TextArea taDescricaoAvaliacao;

    @FXML
    private TextArea taDescricaoProblema;

    @FXML
    private TextArea taDescricaoSugestao;

    @FXML
    public void initialize() {
        // Preenche os ComboBoxes com dados do sistema
        cbMotorista.setItems(FXCollections.observableArrayList(
            Biblioteca.motoristaService.listarTodos()
        ));
        cbTipoProblema.setItems(FXCollections.observableArrayList(
            Biblioteca.tipoProblemaService.listarTodos()
        ));
        cbVeiculoProblema.setItems(FXCollections.observableArrayList(
            Biblioteca.veiculoService.listarTodos()
        ));
        cbVeiculoSugestao.setItems(FXCollections.observableArrayList(
            Biblioteca.veiculoService.listarTodos()
        ));

        // Para mostrar o nome do motorista no ComboBox
        cbMotorista.setCellFactory(lv -> new ListCell<Motorista>() {
            protected void updateItem(Motorista m, boolean empty) {
                super.updateItem(m, empty);
                setText(empty || m == null ? null : m.getNome());
            }
        });
        cbMotorista.setButtonCell(new ListCell<Motorista>() {
            protected void updateItem(Motorista m, boolean empty) {
                super.updateItem(m, empty);
                setText(empty || m == null ? null : m.getNome());
            }
        });

        // Para mostrar a descrição do tipo de problema no ComboBox
        cbTipoProblema.setCellFactory(lv -> new ListCell<TipoProblema>() {
            protected void updateItem(TipoProblema t, boolean empty) {
                super.updateItem(t, empty);
                setText(empty || t == null ? null : t.getDescricao());
            }
        });
        cbTipoProblema.setButtonCell(new ListCell<TipoProblema>() {
            protected void updateItem(TipoProblema t, boolean empty) {
                super.updateItem(t, empty);
                setText(empty || t == null ? null : t.getDescricao());
            }
        });

        // Para mostrar a placa do veículo no ComboBox
        cbVeiculoProblema.setCellFactory(lv -> new ListCell<Veiculo>() {
            protected void updateItem(Veiculo v, boolean empty) {
                super.updateItem(v, empty);
                setText(empty || v == null ? null : v.getPlaca());
            }
        });
        cbVeiculoProblema.setButtonCell(new ListCell<Veiculo>() {
            protected void updateItem(Veiculo v, boolean empty) {
                super.updateItem(v, empty);
                setText(empty || v == null ? null : v.getPlaca());
            }
        });
        cbVeiculoSugestao.setCellFactory(lv -> new ListCell<Veiculo>() {
            protected void updateItem(Veiculo v, boolean empty) {
                super.updateItem(v, empty);
                setText(empty || v == null ? null : v.getPlaca());
            }
        });
        cbVeiculoSugestao.setButtonCell(new ListCell<Veiculo>() {
            protected void updateItem(Veiculo v, boolean empty) {
                super.updateItem(v, empty);
                setText(empty || v == null ? null : v.getPlaca());
            }
        });
    }

    @FXML
    public void reportarProblema() {
        try {
            // Para pegar as informações que o usuário escolheu
            TipoProblema tipo = cbTipoProblema.getValue();
            Veiculo veiculo = cbVeiculoProblema.getValue();
            String descricao = taDescricaoProblema.getText();

            // Para criar o objeto e salvar
            Problema problema = new Problema(descricao, LocalDateTime.now(), null, tipo, null, veiculo);
            Biblioteca.problemaService.salvar(problema);

            // Para limpar os campos
            cbTipoProblema.setValue(null);
            cbVeiculoProblema.setValue(null);
            taDescricaoProblema.clear();

            // Para avisar o usuário que deu certo
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Sucesso");
            alert.setHeaderText(null);
            alert.setContentText("Problema reportado com sucesso!");
            alert.showAndWait();

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
    public void enviarSugestao() {
        try {
            // Para pegar as informações que o usuário escolheu
            Veiculo veiculo = cbVeiculoSugestao.getValue();
            String descricao = taDescricaoSugestao.getText();
            TipoSugestao tipo = rbAplicativo.isSelected() ?
                Biblioteca.tipoSugestaoService.listarTodos().get(0) :
                Biblioteca.tipoSugestaoService.listarTodos().get(1);

            // Para criar o objeto e salvar
            Sugestao sugestao = new Sugestao(descricao, LocalDateTime.now(), null, tipo, veiculo);
            Biblioteca.sugestaoService.salvar(sugestao);

            // Para limpar os campos
            cbVeiculoSugestao.setValue(null);
            taDescricaoSugestao.clear();
            rbAplicativo.setSelected(false);
            rbTransporte.setSelected(false);

            // Para avisar o usuário que deu certo
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Sucesso");
            alert.setHeaderText(null);
            alert.setContentText("Sugestão enviada com sucesso!");
            alert.showAndWait();

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
    public void enviarAvaliacao() {
        try {
            // Para pegar as informações que o usuário escolheu
            Motorista motorista = cbMotorista.getValue();
            int nota = (int) slNota.getValue();
            String descricao = taDescricaoAvaliacao.getText();

            // Para criar o objeto e salvar
            Avaliacao avaliacao = new Avaliacao(descricao, LocalDateTime.now(), null, motorista, nota);
            Biblioteca.avaliacaoService.salvar(avaliacao);

            // Para limpar os campos
            cbMotorista.setValue(null);
            slNota.setValue(1);
            taDescricaoAvaliacao.clear();
            chkAnonimo.setSelected(false);

            // Para avisar o usuário que deu certo
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Sucesso");
            alert.setHeaderText(null);
            alert.setContentText("Avaliação enviada com sucesso!");
            alert.showAndWait();

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