
package org.danielcatalan.system; 
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import org.danielcatalan.view.CalculadoraView;

import org.danielcatalan.controller.CalculadoraController;
 
public class Main extends Application {
 
    public static void main(String[] args) {   

        System.out.println("Hola kinal esta es mi primera calculadora de java fx"); 

        launch(args); 

    }
 
    @Override

    public void start(Stage escenarioPrincipal) throws Exception {

        //controlador de la calculadora

        CalculadoraController controlador = new CalculadoraController();

        //vista de la calculadora 

        CalculadoraView calculadora = new CalculadoraView(controlador); 

        //nodos

        Pane raiz = new Pane(calculadora.getView());

        //escena(nodoRaiz, ancho, largo)

        Scene escena = new Scene(raiz, 266, 390); 

        //cargar escena y mostrar escenario principal

        escenarioPrincipal.setTitle("Calculadora de Daniel");

        escenarioPrincipal.setScene(escena); 

        escenarioPrincipal.show();

    }

}
 