package br.com.luisbraga.projetoClinica.api.handler;

public record Problema(Integer status,
                       String message,
                       String detail) {
}
