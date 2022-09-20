/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import java.util.Scanner;

/**
 *
 * @author ana gomez simon
 */
public class Menu {
    static Scanner sc = new Scanner(System.in);
    
    public static int menu() throws MiExcepcion{
        int opcion;
        System.out.println("Gestor servidor DNS");
        System.out.println("==============");
        System.out.println("1. Añadir un nuevo par IP/nombre");
        System.out.println("2. Consultar IP a partir del nombre");
        System.out.println("0. Salir");
        System.out.println("Opcion: ");
        opcion = sc.nextInt();
        
        if(opcion < 0 || opcion >2){
           throw new MiExcepcion(); 
        }
        return opcion;
    }
    
    public static String pedirDatos(String pantalla){
        sc.nextLine();
        System.out.println(pantalla);
        return sc.nextLine();
    }
}
