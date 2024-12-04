package com.aluracursos.screenmatch.service;

public interface IConvierteDatos {
    //para trabajar con tipos de datos genericos
    <T> T obtenerDatos(String json, Class<T> clase);
}
