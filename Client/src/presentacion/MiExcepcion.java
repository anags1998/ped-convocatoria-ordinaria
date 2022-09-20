/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

/**
 *
 * @author ana gomez simon
 */
public class MiExcepcion extends Exception{
    public MiExcepcion(){
        super("El numero no esta dentro del rango admitido");
    }
}
