package br.com.luisbraga.projetoClinica.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException{

    public NotFoundException(String id) {
        super("Entidade de id: %s não encontrada!".formatted(id));
    }

}
