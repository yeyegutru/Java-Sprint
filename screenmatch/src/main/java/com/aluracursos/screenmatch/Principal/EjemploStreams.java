package com.aluracursos.screenmatch.Principal;

import java.util.Arrays;
import java.util.List;

public class EjemploStreams {
    public void muestraEjemplo(){
        List<String> nombres = Arrays.asList("Yeinner","Alejandro","Stiben","Guezguan","Tatiana");

        nombres.stream()
                .sorted()
                .forEach(System.out::println);

    }
    public void muestraEjemploLimitado(){
        List<String> nombres = Arrays.asList("Yeinner","Alejandro","Stiben","Guezguan","Tatiana");

        nombres.stream()
                .sorted()
                .limit(4)
                .forEach(System.out::println);

    }
    public void muestraEjemploDeTodito(){
        List<String> nombres = Arrays.asList("Yeinner","Alejandro","Stiben","Guezguan","Tatiana");

        nombres.stream()
                .sorted()
                .limit(4)
                .filter(n-> n.startsWith("S"))
                .map(n->n.toUpperCase())
                .forEach(System.out::println);

    }
}
