package dominio;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import presentacion.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ana gomez simon
 */
public class AplicacionCliente implements AutoCloseable {

    private Socket sc;
    private DataInputStream dis;
    private DataOutputStream dos;
    private Scanner scan = new Scanner(System.in);

    public AplicacionCliente(String host, int port) throws IOException {
        sc = new Socket(host, port);
        openStream();
    }

    public final void openStream() throws IOException {
        dis = new DataInputStream(sc.getInputStream());
        dos = new DataOutputStream(sc.getOutputStream());
    }

    @Override
    public void close() throws IOException {
        try (Socket socket = sc;
                DataInputStream dis2 = dis;
                DataOutputStream dos2 = dos;) {
        }
    }

    public void aplicacion() throws IOException, MiExcepcion {
        System.out.println(dis.readUTF());
        System.out.println();
        int opcion;
        do {
            opcion = Menu.menu();
            dos.writeInt(opcion);
            switch (opcion) {
                case 1:
                    dos.writeUTF(Menu.pedirDatos("IP a añadir: "));
                    dos.writeUTF(Menu.pedirDatos("Nombre a añadir: "));
                    break;
                case 2:
                    dos.writeUTF(Menu.pedirDatos("Nombre a buscar: "));
                    System.out.println("La IP asociada es: " + dis.readUTF());
                    break;
                case 0:
                    break;
            }
        } while (opcion != 0);
    }

}
