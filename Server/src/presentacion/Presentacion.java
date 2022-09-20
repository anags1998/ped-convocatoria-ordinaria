/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.HashMap;

/**
 *
 * @author ana gomez simon
 */
public class Presentacion implements AutoCloseable {

    private DataInputStream dis;
    private DataOutputStream dos;

    public void openStream(Socket sc) throws IOException {
        dis = new DataInputStream(sc.getInputStream());
        dos = new DataOutputStream(sc.getOutputStream());
        dos.writeUTF("Cliente conectado correctamente.");
    }

    @Override
    public void close() throws Exception {
        try (DataInputStream dis2 = dis;
                DataOutputStream dos2 = dos) {
        }

    }

    public void presentacion() throws IOException, ClassNotFoundException {
        int opcion;
        String s, n;
        HashMap<String, String> objeto = new HashMap<>();
        do {
            opcion = dis.readInt();
            switch (opcion) {
                case 1:
                    s = dis.readUTF();
                    n = dis.readUTF();
                    objeto.put(n, s);
                   presentacion.Metodos.escribir(objeto);
                    break;
                case 2:
                    n = dis.readUTF();
                    s = presentacion.Metodos.leer(n);
                    dos.writeUTF(s);
                    break;
                case 0:
                    break;

            }
        } while (opcion != 0);
    }

}
