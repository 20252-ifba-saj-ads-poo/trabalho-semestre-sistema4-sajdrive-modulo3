package br.edu.ifba.saj.fwads;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class App extends Application {
    
    private static Scene scene;    

    @Override
public void start(Stage stage) throws IOException {
    // Para carregar a tela inicial do aplicativo
    FXMLLoader loader = new FXMLLoader(App.class.getResource("controller/RealizarFeedback.fxml"));
    scene = new Scene(loader.load(), 800, 600);
    stage.setScene(scene);
    stage.show();
    }

public static void setRoot(String fxml) {
    try {
        scene.setRoot(loadFXML(fxml));
    } catch (Exception e) {
        // Para mostrar o erro para o usuário caso a tela não carregue
        new Alert(AlertType.ERROR, "Erro ao carregar o arquivo " + fxml).show();
        e.printStackTrace();
    }
    }

private static Parent loadFXML(String fxml) throws Exception {
    // Para carregar o arquivo FXML e associar o controller
    FXMLLoader loader = new FXMLLoader(App.class.getResource(fxml));
    Parent parent = loader.load();
    Object controller =loader.getController();
    if(controller!= null){
        parent.getProperties().put("controller", loader.getController());
    }
    return parent;
    }

public static void main(String[] args) {
    launch();
    }
}