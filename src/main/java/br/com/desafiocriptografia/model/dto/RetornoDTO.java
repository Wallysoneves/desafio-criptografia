package br.com.desafiocriptografia.model.dto;

import org.springframework.http.HttpStatus;

public record RetornoDTO(String mensagem, HttpStatus status, Integer statusCode, Object retorno) {
}
