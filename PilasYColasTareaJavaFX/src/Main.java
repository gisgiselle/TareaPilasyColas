import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.Scene;
import javafx.stage.Stage;



public class Main extends Application{
    public static void Main(String[] args){
        Application.launch(args);

    }

    public void start (Stage primaryStage) throws Exception{
        //GridPane donde está contenido todoo
        GridPane mainGP = new GridPane();
        mainGP.setPadding( new Insets(10,10, 10, 10));
        mainGP.setVgap(10);
        mainGP.setHgap(10);

        //VBox con coordenadas(0,0). Este VBox es donde está la pila y aquí está el textArea donde se va a ver la pila
        VBox pilaVB = new VBox();
       pilaVB.setSpacing(10);

        Label pilaLb = new Label("Pila");
        TextArea pilaTA = new TextArea();
        pilaTA.setPromptText("La pila está vacía");
        pilaTA.setEditable(false);

        pilaVB.getChildren().addAll(pilaLb,pilaTA);
        pilaVB.setAlignment(Pos.CENTER);

        mainGP.setConstraints(pilaVB,0,0);

        //VBox con coordenadas(0,1). Este VBox es donde está los el textfield para ingresar los datos, los botones y también una label para ver el dato que se saca.
        VBox buttonsVB = new VBox();
        buttonsVB.setSpacing(15);
        Label valoresLb = new Label("Ingrese el dato:");
        TextField valoresTF = new TextField();
        valoresTF.setPromptText("Ingrese el dato");

        Button btnCola = new Button("Cola");

        Button btnDequeue = new Button("Dequeue");

        Button btnPila = new Button("Pila");

        Button btnPop = new Button("Pop");

        Button btnPeekCola = new Button("Peek Cola");

        Button btnPeekPila = new Button("Peek Pila");


        Label sacarLb = new Label("El dato que sacaste es: ");
        sacarLb.setVisible(false);
        Label datoLb = new Label();


        buttonsVB.getChildren().addAll(valoresLb, valoresTF, btnCola, btnDequeue, btnPila, btnPop,  btnPeekCola, btnPeekPila,sacarLb,datoLb);
        buttonsVB.setAlignment(Pos.CENTER);

        mainGP.setConstraints(buttonsVB,1, 0);

        //VBox con coordenadas(0,2). Este VBox es donde está la cola y aquí está el textArea donde se va a ver la cola
        VBox colaVB = new VBox();
        colaVB.setSpacing(10);

        Label colaLb = new Label("Cola");
        TextArea colaTA = new TextArea();
        colaTA.setPromptText("La cola está vacía");
        colaTA.setEditable(false);

        colaVB.getChildren().addAll(colaLb, colaTA);
        colaVB.setAlignment(Pos.CENTER);

        mainGP.setConstraints(pilaVB,2,0);


        mainGP.getChildren().addAll(pilaVB,colaVB, buttonsVB);

        ColaSinLista<String> cola= new ColaSinLista<>();
        PilaSinLista<String> pila = new PilaSinLista<>();


        //Acciones de botones
        btnCola.setOnAction(a-> { if(!valoresTF.getText().isEmpty()){
                                    cola.enqueue(valoresTF.getText());
                                    colaTA.setText(cola.listaValores()) ;
                                    valoresTF.setText("");
                                     }
                                sacarLb.setVisible(false);
                                datoLb.setVisible(false);
                                });

        btnDequeue.setOnAction(a->{ sacarLb.setVisible(true);
                                    datoLb.setVisible(true);
                                    if(colaTA.getText().isEmpty()){
                                    datoLb.setText(colaTA.getPromptText());
                                    }
                                    else{datoLb.setText(cola.dequeue());
                                    }
                                    colaTA.setText(cola.listaValores()) ;
                                  }
                              );

        btnPila.setOnAction(a-> {
                    if (!valoresTF.getText().isEmpty()) {
                        pila.push(valoresTF.getText());
                        pilaTA.setText(pila.listaValores());
                        valoresTF.setText("");
                    }
                    sacarLb.setVisible(false);
                    datoLb.setVisible(false);
                });

        btnPop.setOnAction(a->{sacarLb.setVisible(true);
                                datoLb.setVisible(true);
                                if(pilaTA.getText().isEmpty()){
                                   datoLb.setText(pilaTA.getPromptText());
                                }
                                else{ datoLb.setText(pila.pop());

                                }

                               pilaTA.setText(pila.listaValores());
                                }
                            );
        btnPeekCola.setOnAction(a->{ sacarLb.setText("El dato de peek en cola es: ");
                                    sacarLb.setVisible(true);
                                    datoLb.setVisible(true);

                                    if(colaTA.getText().isEmpty()){
                                    datoLb.setText("No hay datos en la cola");}
                                    else{
                                            datoLb.setText(cola.peek());}

                                    }

                                );

        btnPeekPila.setOnAction(a->{sacarLb.setText("El dato de peek en pila es: ");
                                    sacarLb.setVisible(true);
                                    datoLb.setVisible(true);
                                    if(pilaTA.getText().isEmpty()){
                                    datoLb.setText("No hay datos en la pila");}
                                    else{
                                        datoLb.setText(pila.peek());
                                    }
        });



        Scene scene = new Scene (mainGP);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Colas y Pilas");
        primaryStage.sizeToScene();
        primaryStage.show();
        primaryStage.setMinWidth(primaryStage.getWidth());
        primaryStage.setMinHeight(primaryStage.getHeight());


    }
}
