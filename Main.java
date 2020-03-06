package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent

import java.awt.*;
import java.awt.event.MouseEvent;

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
        Button bPick = new Button("Pick");
        Button bPush = new Button("Push");
        //enqueue = push
        Button bDeq = new Button("Dequeue");
        Button bPop = new Button("Pop");
        TextField txt = new TextField("Inserta un dato");
        VBox vb2 = new VBox(bPick,txt,bPush,bDeq,bPop);
        HBox hb = new HBox(vb1,vb2,vb3);
        Scene scene = new Scene(hb, 350,350);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

    public void handle(MouseEvent e){
        Pilas<Integer> pila = new Pilas<>();
        Colas<Integer> cola = new Colas<>();


    }

    public static void main(String[] args) {
        launch(args);
               /* Pilas<Integer> pila= new Pilas<>();
                pila.push(4);
                pila.push(5);
                pila.pop();
               */


    }
}
