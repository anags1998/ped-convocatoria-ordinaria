/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import presentacion.*;
import java.io.IOException;
/**
 *
 * @author ana gomez simon
 */

public class MainClient {
    public static void main(String[] args) {
      try(AplicacionCliente app = new AplicacionCliente(servicios.Servicios.HOST,servicios.Servicios.PORT)){
            app.aplicacion();
      }catch(IOException | MiExcepcion e){
          System.out.println("Hay un problema en la operacion: " + e.getMessage());
    }
}
}
