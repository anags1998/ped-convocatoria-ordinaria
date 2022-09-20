/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import presentacion.*;
/**
 *
 * @author ana gomez simon
 */
public class MainServer {
    public static void main(String[] args) throws ClassNotFoundException {
       try(ServerSocket socket = new ServerSocket(servicios.Servicios.PORT)){
           do{
               System.out.println("Esperando cliente....");
               try(Socket sClient = socket.accept()){
                   System.out.println("Nuevo cliente: " + sClient.getInetAddress().getHostAddress());
                   Presentacion pres = new Presentacion();
                   pres.openStream(sClient);
                   pres.presentacion();
               }catch(IOException e){
                   System.out.println("Problemas en el cliente: " + e.getMessage());
               }
           }while(true);
       }catch(IOException e){
           System.out.println("Problemas en la presentacion" + e.getMessage());
       }
    }
}
