package com.lucamusic.event.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lucamusic.event.controller.ErrorMessage;
import org.springframework.validation.BindingResult;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Utils
 * Clase de utilidades
 * @version 1.0 Septiembre 2021
 * @author Julio
 */
public class Utils {
    /**
     * Convierte un objeto a string
     * @param o Objeto a parsear
     * @return Objeto parseado
     */
    public static String objectToJsonStringParser(Object o){
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = "";
        try {
            jsonString = objectMapper.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return jsonString;
    }

    /**
     * Formatea los errores de un objeto tipo BindingResult a String
     * @param result Resultados de la validación de parámetros
     * @return Cadena de texto con los errores tipo BindingResult
     */
    public static String formatBindingResult(BindingResult result){
        List<Map<String, String>> errors = result.getFieldErrors().stream()
                .map(err -> {
                    Map<String, String> error = new HashMap<>();
                    error.put(err.getField(), err.getDefaultMessage());
                    return error;
                }).collect(Collectors.toList());

        ErrorMessage errorMessage = ErrorMessage.builder()
                .code("01")
                .messages(errors).build();

        return Utils.objectToJsonStringParser(errors);
    }
}
