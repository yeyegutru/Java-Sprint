package com.aluracursos.screenmatch.Model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
//esto es para ignorar las demas propiedades de la API
@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosTemporadas(
        @JsonAlias("Season") Integer numero,
        @JsonAlias("Episodes") List<DatosEpisodios> Episodios
) {
}
