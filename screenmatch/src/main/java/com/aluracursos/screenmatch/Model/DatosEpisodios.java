package com.aluracursos.screenmatch.Model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//ingnoramos las demas propiedades que pueda traer la consulta
@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosEpisodios(
        @JsonAlias("Title") String titulo,
        @JsonAlias("Episode") Integer numeroEpisodio,
        @JsonAlias("imdbRating") String evaluacion,
        @JsonAlias("Released") String fechaNacimiento
) {
}
