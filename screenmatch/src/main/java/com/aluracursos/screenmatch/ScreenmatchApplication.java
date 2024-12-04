package com.aluracursos.screenmatch;

import com.aluracursos.screenmatch.Model.DatosEpisodios;
import com.aluracursos.screenmatch.Model.DatosSerie;
import com.aluracursos.screenmatch.Model.DatosTemporadas;
import com.aluracursos.screenmatch.Principal.EjemploStreams;
import com.aluracursos.screenmatch.Principal.Principal;
import com.aluracursos.screenmatch.service.ConsumoAPI;
import com.aluracursos.screenmatch.service.ConvierteDatos;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ScreenmatchApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        //      para poder trabajar en este proyecto se Añadio la dependencia JACKSON DATABIN para la serializacion y desearializacion.
//        System.out.println("Hola mundo como esta ? ");
////        Servicio que contiene toda la informacion del servicio o la conexion al servicio.
//        var servicio = new ConsumoAPI();
//        var json = servicio.obtenerDatos("http://www.omdbapi.com/?t=game+of+thrones&apikey=7a846b85");
//        System.out.println(json);
//
////        Vamos a convertir datos ya por medio de la serializacion y deserializacion.
//        ConvierteDatos convertidor = new ConvierteDatos();
//        var datos = convertidor.obtenerDatos(json, DatosSerie.class);
//        System.out.println("Estos son los datos : " + datos);
//
////        Mapear datos por episodios y temporadas
//        json = servicio.obtenerDatos("http://www.omdbapi.com/?t=game+of+thrones&Season=1&episode=1&apikey=7a846b85");
//        DatosEpisodios datos2 = convertidor.obtenerDatos(json, DatosEpisodios.class);
//        System.out.println("Datos de Episodio : " + datos2);
//
//
////        obtener los datos de las temporada
//        json = servicio.obtenerDatos("http://www.omdbapi.com/?t=game+of+thrones&Season=1&apikey=7a846b85");
//        DatosTemporadas datosTemporadas = convertidor.obtenerDatos(json, DatosTemporadas.class);
//        System.out.println("Datos temporadas : " + datosTemporadas);
//
////        obtener los datos de las temporadas completas
//
//        List<DatosTemporadas> listaTemporadas = new ArrayList<>();
//        for (int i = 1; i <= datos.totalTemporadas(); i++) {
//            json = servicio.obtenerDatos("http://www.omdbapi.com/?t=game+of+thrones&Season=" + i + "&apikey=7a846b85");
//            listaTemporadas.add(convertidor.obtenerDatos(json, DatosTemporadas.class));
//
//        }
//        listaTemporadas.forEach(System.out::println);
//// Obtener todos los datos por medio de la clase principal del package principal
        System.out.println("--------------------------------------------------");
        System.out.println("Aqui va lo de la clase principal   : ");
        Principal principal = new Principal();
        principal.MostrarMenuPrincipal();
//        EjemploStreams ejemploStreams = new EjemploStreams();
//        ejemploStreams.muestraEjemplo();

//        ejemploStreams.muestraEjemploDeTodito();


    }

}
