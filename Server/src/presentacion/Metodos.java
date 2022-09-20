/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author ana
 */
public class Metodos {
    public static void escribir(HashMap<String, String> mapa) throws FileNotFoundException {

        try {
            File f = new File("DNS.txt");
            FileOutputStream fos = new FileOutputStream(f);
            PrintWriter pw = new PrintWriter(fos);
            for (Map.Entry<String, String> m : mapa.entrySet()) {
                pw.println(m.getKey() + "," + m.getValue());
            }
            pw.flush();
            pw.close();
            fos.close();
        } catch (Exception e) {
        }
    }

    public static String leer(String n) throws FileNotFoundException, IOException, ClassNotFoundException {
        File f = new File("DNS.txt");
        String s, linea;
        FileInputStream fis = new FileInputStream(f);
        Scanner sc = new Scanner(fis);
        HashMap<String, String> objeto = new HashMap<String, String>();
        while(sc.hasNextLine()){
            linea = sc.nextLine();
            StringTokenizer st = new StringTokenizer(linea, ",", false);
            objeto.put(st.nextToken(), st.nextToken());
        }
        s = objeto.get(n);
        fis.close();
        return s;
    }
}
