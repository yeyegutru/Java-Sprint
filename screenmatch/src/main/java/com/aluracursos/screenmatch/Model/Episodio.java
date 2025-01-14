package com.aluracursos.screenmatch.Model;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class Episodio {
    private Integer temporada ;
    private String titulo;
    private Integer numeroEpisodio;
    private Double evaluacion;
    private LocalDate FechaDeLanzamiento;

    public Episodio(Integer temporada,DatosEpisodios datos) {
        this.temporada = temporada;
        this.titulo = datos.titulo();
        this.numeroEpisodio = datos.numeroEpisodio();
        try {
            this.evaluacion = Double.valueOf(datos.evaluacion());
        }catch(NumberFormatException e) {
        this.evaluacion=0.0;
        }
        try{
            FechaDeLanzamiento = LocalDate.parse(datos.fechaNacimiento());
        }catch(DateTimeParseException e){
            this.FechaDeLanzamiento=null;
        }

    }

    public Integer getTemporada() {
        return temporada;
    }

    public void setTemporada(Integer temporada) {
        this.temporada = temporada;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getNumeroEpisodio() {
        return numeroEpisodio;
    }

    public void setNumeroEpisodio(Integer numeroEpisodio) {
        this.numeroEpisodio = numeroEpisodio;
    }

    public Double getEvaluacion() {
        return evaluacion;
    }

    public void setEvaluacion(Double evaluacion) {
        this.evaluacion = evaluacion;
    }

    public LocalDate getFechaDeLanzamiento() {
        return FechaDeLanzamiento;
    }

    public void setFechaDeLanzamiento(LocalDate fechaDeLanzamiento) {
        FechaDeLanzamiento = fechaDeLanzamiento;
    }

    @Override
    public String toString() {
        return
                "temporada=" + temporada +
                ", titulo='" + titulo + '\'' +
                ", numeroEpisodio=" + numeroEpisodio +
                ", evaluacion=" + evaluacion +
                ", FechaDeLanzamiento=" + FechaDeLanzamiento ;
    }
}
