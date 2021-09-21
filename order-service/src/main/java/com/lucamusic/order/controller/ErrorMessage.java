package com.lucamusic.order.controller;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

/**
 * ErrorMessage
 * Clase contenedora de los errores de validación de una entidad recibida como parámetro en una consulta REST
 * @version 1.0 Septiembre 2021
 * @author Julio
 */
@Getter @Setter @Builder
public class ErrorMessage {
    private String code ;
    private List<Map<String, String >> messages ;
}