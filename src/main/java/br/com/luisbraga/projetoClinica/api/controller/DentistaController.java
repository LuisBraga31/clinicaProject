package br.com.luisbraga.projetoClinica.api.controller;

import br.com.luisbraga.projetoClinica.api.dto.request.DentistaRequest;
import br.com.luisbraga.projetoClinica.api.dto.response.DentistaResponse;
import br.com.luisbraga.projetoClinica.api.dto.response.Wrapper.DentistaWrapperResponse;
import br.com.luisbraga.projetoClinica.domain.service.DentistaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("v1/dentistas")
public class DentistaController {

    private final DentistaService dentistaService;

    @Autowired
    public DentistaController(DentistaService dentistaService) {
        this.dentistaService = dentistaService;
    }

    @GetMapping
    ResponseEntity<DentistaWrapperResponse> buscarDentistas() {
        return ResponseEntity.ok().build();
    }

    @GetMapping("id")
    ResponseEntity<DentistaResponse> buscarDentistaPorId(@PathVariable UUID id) {
        return ResponseEntity.ok().build();
    }

    @PostMapping
    ResponseEntity<?> criarDentista(@RequestBody @Valid DentistaRequest request) {
        return ResponseEntity.ok().build();
    }

    @PutMapping("id")
    ResponseEntity<?> atualizarDentista(@PathVariable UUID id, @RequestBody DentistaRequest request) {
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("id")
    ResponseEntity<Void> deletarDentista(@PathVariable UUID id) {
        return ResponseEntity.ok().build();
    }


}
