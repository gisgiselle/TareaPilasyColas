package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.TextField;

public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Pilas y colas");
        TextField txtf1 = new TextField("Pilas");
        TextField txtf2= new TextField("Colas");
        VBox vb1 = new VBox(txtf1);
        txtf1.setEditable(false);
        VBox vb3 = new VBox(txtf2);
        txtf2.setEditable(false);
        Button btn1 = new Button("Boton a Cola");
        Button btn2 = new Button("Boton a Pila");
        Button btn3 = new Button("Deque");
        Button btn4 = new Button("Pop");
        TextField txt = new TextField("Inserta un dato");
        VBox vb2 = new VBox(txt,btn1,btn2,btn3,btn4);
        HBox hb = new HBox(vb1,vb2,vb3);
        Scene scene = new Scene(hb, 350,350);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
