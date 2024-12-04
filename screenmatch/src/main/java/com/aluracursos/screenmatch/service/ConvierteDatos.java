package com.aluracursos.screenmatch.service;

import com.aluracursos.screenmatch.Model.DatosSerie;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.swing.*;

public class ConvierteDatos implements IConvierteDatos {
    private ObjectMapper objectmapper = new ObjectMapper();

    //para obtener los datos de forma generica y despues convertirlos a la funcion que se necesita.
    @Override
    public <T> T obtenerDatos(String json, Class<T> clase) {

        try {
//            Esta funcion necesita si o si un metodo Try para evitar errores
            return objectmapper.readValue(json,clase);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
