package com.aluracursos.screenmatch.Model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

//para ignorar todas aquellas propiedades que no hemos mapeado.
@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosSerie(

//        Tener en cuenta que para evitar errores se deben obtener todos los datos o especificar que no se va realizar de esa manera.
//        como lo que necesitamos es oculta la variable verdadera para guardar la integridad de la API, colocamos el nombre que queramos y utilizamos el @JsonAlias para poder hacerlo con el valor necesario para la API
        @JsonAlias("Title") String titulo, @JsonAlias("totalSeasons") Integer totalTemporadas,
        @JsonAlias("imdbRating") String evaluacion) {}
