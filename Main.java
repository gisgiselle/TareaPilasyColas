package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Main extends Application {
    private BorderPane bp =new BorderPane();
    private TextField dato;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Mamada");


        VBox vb = new VBox();
        VBox vbPila = new VBox();
        VBox vbCola = new VBox();
        Label pilaLabel = new Label("Pila");
        Label colaLabel = new Label("Cola");
        TextField dato = new TextField("Insert data");
        Button bDeq = new Button("Dequeue");
        Button bPeek = new Button("Peek");
        Button bPush = new Button("Push");
        Button bPop = new Button("Pop");

        bp.setPrefSize(600,575);
        bp.setCenter(vb);
        bp.setLeft(vbPila);
        bp.setRight(vbCola);

        vbPila.getChildren().add(pilaLabel);
        vbPila.setAlignment(Pos.TOP_CENTER);
        vbCola.setAlignment(Pos.TOP_CENTER);
        vb.setAlignment(Pos.TOP_CENTER);
        vbCola.getChildren().add(colaLabel);
        vb.getChildren().addAll(dato,bDeq,bPeek,bPush,bPop);
        vb.setPrefSize(100,575);
        vbPila.setPrefSize(100,575);
        vbCola.setPrefSize(100,575);

        bDeq.addEventHandler(MouseEvent.MOUSE_CLICKED, new DequeueHandler());
        bPeek.addEventFilter(MouseEvent.MOUSE_CLICKED, new PeekHandler());
        bPush.addEventFilter(MouseEvent.MOUSE_CLICKED, new PushHandler());

        Group g = new Group();
        g.getChildren().add(bp);
        primaryStage.setScene(new Scene(g, 600, 575));
        primaryStage.show();
    }

         public class DequeueHandler implements EventHandler<MouseEvent>{
        @Override
        public void handle(MouseEvent event){
            Cola<String> cola = new Cola<>();
            cola.dequeue();
        }
    }

    public class PeekHandler implements EventHandler<MouseEvent>{
        @Override
        public void handle(MouseEvent event) {
            Cola<String> cola = new Cola<>();
            Pila<String> pila = new Pila<>();
            cola.peek();
            pila.peek();
        }
    }

    public class PushHandler implements EventHandler<MouseEvent>{
        @Override
        public void handle(MouseEvent event) {
            Pila<String> pila = new Pila<>();
            Cola<String> cola = new Cola<>();
            pila.push(dato.getText());
            cola.enque(dato.getText());

        }
    }

    public static void main(String[] args) {
        launch(args);

    }
}
