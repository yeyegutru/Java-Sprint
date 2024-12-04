package com.aluracursos.screenmatch.Principal;

import com.aluracursos.screenmatch.Model.DatosEpisodios;
import com.aluracursos.screenmatch.Model.DatosSerie;
import com.aluracursos.screenmatch.Model.DatosTemporadas;
import com.aluracursos.screenmatch.Model.Episodio;
import com.aluracursos.screenmatch.service.ConsumoAPI;
import com.aluracursos.screenmatch.service.ConvierteDatos;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

//se va generar el funcionamiento basico de la aplicacion por medio de menu
public class Principal {

    private Scanner teclado = new Scanner(System.in);
    //Se va realizar la instancia para generar la instancia de las peticiones API
    private ConsumoAPI consumoApi = new ConsumoAPI();
    private static String KEY_API = "&apikey=7a846b85";
    private static String URL_API = "http://www.omdbapi.com/?";
    private ConvierteDatos convertidor = new ConvierteDatos();

    public void MostrarMenuPrincipal(){

//        Obtener informacion basica de la serie :
        System.out.println("Por favor ingresa el nombre de la serie a buscar : ");
        String nombre = teclado.nextLine();
        var json = consumoApi.obtenerDatos(URL_API +"t="+nombre.replace(" ","+")+ KEY_API);
        var datos = convertidor.obtenerDatos(json, DatosSerie.class);
        System.out.println(URL_API +"t="+nombre.replace(" ","+")+ KEY_API);
        System.out.println("Estos Son los Datos : "+ datos);

//        Obtener informacion de todas las temporadas de las series
        List<DatosTemporadas> listaTemporadas = new ArrayList<>();
        for (int i =1 ; i <= datos.totalTemporadas(); i++){
            json = consumoApi.obtenerDatos(URL_API +"t="+nombre.replace(" ","+")+"&Season="+i+ KEY_API);
            listaTemporadas.add(convertidor.obtenerDatos(json, DatosTemporadas.class));
        }
        listaTemporadas.forEach(System.out::println);


//        Mostrar solo el titulo de los episodios por temporadas
        for (int i = 0; i < datos.totalTemporadas(); i++) {
            List<DatosEpisodios> episodiosTemporadas  = listaTemporadas.get(i).Episodios();
            System.out.println("Temporada : "+ listaTemporadas.get(i).numero());
            for (int j = 0; j < episodiosTemporadas.size(); j++) {
                System.out.println(episodiosTemporadas.get(j).titulo());
            }
        }

//        Funciones lamda para simplificar todo estos bucles for
//        ¿Qué son las funciones Lambda?
        System.out.println("----------------------------------------------------------");
        System.out.println("Funciones con lamda ");
        listaTemporadas.forEach(t -> t.Episodios().forEach(e-> System.out.println(e.titulo())));
//
//        List<Integer> lista = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
//        lista.stream().filter(i -> i % 2 == 0).forEach(System.out::println);

//        Convertir todas la funciones a una lista del tipo DatosEpisodios.
          List<DatosEpisodios> listaEpisodios =  listaTemporadas.stream()
                  .flatMap(t->t.Episodios().stream())
                  .collect(Collectors.toList());


          //Top 5 Episodios
//        System.out.println("----------------------------------------------------------------");
//        System.out.println("Top 5 Episodios : ");
////        para ver como es que funcionan la logica de Java en cuanto a los streams  PEEK
//        listaEpisodios.stream()
//                .filter(t->!t.evaluacion().equalsIgnoreCase("N/A"))
//                .peek(p -> System.out.println("Primer Filtro N/A : "+p))
//                .sorted(Comparator.comparing(DatosEpisodios::evaluacion).reversed())
//                .peek(p -> System.out.println("Segundo Filtro Ordenacion : "+p))
//                .map(e ->e.titulo().toUpperCase())
//                .peek(p -> System.out.println("Tercer Filtro Mayusculas : "+p))
//                .limit(5)
//                .forEach(System.out::println);


//
//        Trabajando con la clase Episodio y convirtiendo a una lista de tipo episodio.
        List<Episodio> episodios = listaTemporadas.stream()
                .flatMap(t->t.Episodios().stream()
                        .map(d->new Episodio(t.numero(),d)))
                .collect(Collectors.toList());
//
//        episodios.forEach(System.out::println);
//
//        //busqueda de Episodios apartir de X años
//        System.out.println("Por favor indica el año apartir del cual deseas ver los episodios : ");
//        var fecha = teclado.nextInt();
//        teclado.nextLine();
//        // para la creacion de fechas por variable respectiva
//        LocalDate fechaBusqueda = LocalDate.of(fecha,1,1);
//
//        //Stream filtro para generar los episodios de la fecha
//        //Formateador de Fechas :  DTF
//        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//        episodios.stream()
//                .filter(e->e.getFechaDeLanzamiento()!=null && e.getFechaDeLanzamiento().isAfter(fechaBusqueda))
//
//                .forEach(e-> System.out.println(
//                        "Temporada : " + e.getTemporada() +
//                                "Episodio : "+ e.getTitulo() +
//                                "Fecha de lanazamiento : " + e.getFechaDeLanzamiento().format(dtf)+
//                                "Evaluacion : " + e.getEvaluacion()
//                ));



//        busca episodio por pedazo de titulo
        System.out.println("Por favor escriba el titulo del episodio que desea ver ; ");
        var titulo = teclado.nextLine();
        // especial para trabajar con datos, porque puede que se obtenga un dato como puede que no.
        Optional<Episodio> first = episodios.stream()
                .filter(e -> e.getTitulo().toLowerCase().contains(titulo.toLowerCase()))
                .findFirst();
        if (first.isPresent()){
            System.out.println("Episodio Encontrado : " + first.get());
        }else {
            System.out.println("Episodio no encontrado");
        }



//        Generacion de una colleccion para evaluar la temporadas :

        Map<Integer, Double> evaluacionesPorTemporadas  = episodios.stream()
                .collect(Collectors.groupingBy(Episodio::getTemporada,
                        Collectors.averagingDouble(Episodio::getEvaluacion)));
        System.out.println("Mapa De evaluacion de temporadas : "+ evaluacionesPorTemporadas);

        DoubleSummaryStatistics est = episodios.stream()
                .collect(Collectors.summarizingDouble(Episodio::getEvaluacion));
        System.out.println("Estadisticas : "+est);
        System.out.println("La media de las evaluaciones : "+ est.getAverage());
        System.out.println("El mejor Episodio Evaluado : "+ est.getMax());
        System.out.println("El episodio peor Evaluado : "+est.getMin());
    }

}
