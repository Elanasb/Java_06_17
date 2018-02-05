package com.company;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private String _failoVardas = "duomenys.txt";
    private FileReader _in;
    private BufferedReader _bufferis;
    private static final char SEPARATOR = '|';
    private static final String SEPARATOR_REGEX = "\\|";

    public static void main(String[] args) {
        // write your code here
        /*
         *
         *
         * */
        Main obj = new Main();
        obj.skaitymasIsFailo();
    }

    public void atidarytiFaila() {
        try {
            _in = new FileReader(_failoVardas);
            _bufferis = new BufferedReader(_in);
        } catch (Exception e) {

        }
    }


    public void skaitymasIsFailo() {

        atidarytiFaila();
        ArrayList<dot> sarasas = new ArrayList<dot>();
        try {
            String eilute = _bufferis.readLine();

            while (eilute != null) {

                String[] zodziai = eilute.split(SEPARATOR_REGEX);
                double x = Double.parseDouble(zodziai[0]);
                double y = Double.parseDouble(zodziai[1]);
                String spalva = zodziai[2];
                sarasas.add(new dot(x, y, spalva));
                eilute = _bufferis.readLine();

            }
            _bufferis.close();
            _in.close();

            skaiciuok(sarasas);

        } catch (Exception e) {

        }
    }

    private void skaiciuok(ArrayList<dot> sarasas) {
        double atstumas = 0;
        dot pirmas = null;
        dot antras = null;
        for (int i = 0; i < sarasas.size() - 1; i++) {
            for (int j = 1; j < sarasas.size(); j++) {
                if (sarasas.get(i).getDistance(sarasas.get(j)) > atstumas) {
                    atstumas = sarasas.get(i).getDistance(sarasas.get(j));
                    pirmas = sarasas.get(i);
                    antras = sarasas.get(j);
                }
            }

        }
        System.out.println("Max atstumas yra : " + atstumas);
        System.out.println("Pirmas taskas  : " + pirmas);
        System.out.println("Antras taskas : " + antras);


    }


}