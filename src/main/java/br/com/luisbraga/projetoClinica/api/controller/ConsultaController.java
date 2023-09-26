package br.com.luisbraga.projetoClinica.api.controller;

import br.com.luisbraga.projetoClinica.api.dto.request.ConsultaRequest;
import br.com.luisbraga.projetoClinica.api.dto.response.ConsultaResponse;
import br.com.luisbraga.projetoClinica.api.dto.response.List.ConsultaListResponse;
import br.com.luisbraga.projetoClinica.api.dto.response.Wrapper.ConsultaWrapperResponse;
import br.com.luisbraga.projetoClinica.domain.entity.Consulta;
import br.com.luisbraga.projetoClinica.domain.service.ConsultaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("v1/consultas")
public class ConsultaController {

    private final ConsultaService consultaService;

    @Autowired
    public ConsultaController(ConsultaService consultaService) {
        this.consultaService = consultaService;
    }

    @GetMapping
    ResponseEntity<ConsultaWrapperResponse> buscarConsultas() {
        List<Consulta> consultas = consultaService.buscarConsultas();
        ConsultaWrapperResponse consultaWrapperResponse = new ConsultaWrapperResponse();

        consultaWrapperResponse.setConsultas( consultas.stream().map( consulta -> {
            ConsultaListResponse consultaListResponse = new ConsultaListResponse();
            consultaListResponse.setId(consulta.getId());
            consultaListResponse.setDataConsulta(consulta.getDataConsulta());
            return consultaListResponse;
        }).toList());

        return ResponseEntity.ok(consultaWrapperResponse);
    }

    @GetMapping("{id}")
    ResponseEntity<ConsultaResponse> buscarConsultaPorId(@PathVariable UUID id) {
        Consulta consulta = consultaService.buscarConsultaPorId(id);
        ConsultaResponse response = consultaResponseByConsulta(consulta);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    ResponseEntity<ConsultaResponse> criarConsulta(@RequestBody @Valid ConsultaRequest request) {

        Consulta consulta = new Consulta();
        consulta.setPaciente(request.getPaciente());
        consulta.setDentista(request.getDentista());
        consulta.setClinica(request.getClinica());
        consulta.setDataConsulta(request.getDataConsulta());
        consulta.setDescricao(request.getDescricao());
        consulta.setCancelada(request.getCancelada());
        consulta.setMotivoCancelamento(request.getMotivoCancelamento());

        Consulta consultaCriada = consultaService.criarConsulta(consulta);
        ConsultaResponse response = consultaResponseByConsulta(consultaCriada);
        return ResponseEntity.ok(response);

    }

    @PutMapping("{id}")
    ResponseEntity<ConsultaResponse> atualizarConsulta(@PathVariable UUID id, @RequestBody @Valid ConsultaRequest request) {

        Consulta consulta = consultaService.buscarConsultaPorId(id);
        consulta.setPaciente(request.getPaciente());
        consulta.setDentista(request.getDentista());
        consulta.setClinica(request.getClinica());
        consulta.setDataConsulta(request.getDataConsulta());
        consulta.setDescricao(request.getDescricao());
        consulta.setCancelada(request.getCancelada());
        consulta.setMotivoCancelamento(request.getMotivoCancelamento());

        Consulta consultaAtualizada = consultaService.atualizarConsulta(id, consulta);
        ConsultaResponse response = consultaResponseByConsulta(consultaAtualizada);
        return ResponseEntity.ok(response);

    }

    @DeleteMapping("{id}")
    ResponseEntity<Void> deletarConsulta(@PathVariable UUID id) {
        consultaService.deletarConsulta(id);
        return ResponseEntity.ok().build();
    }

    private ConsultaResponse consultaResponseByConsulta(Consulta consulta) {

        ConsultaResponse consultaResponse = new ConsultaResponse();
        consultaResponse.setId(consulta.getId());

        consultaResponse.setPaciente(consulta.getPaciente().getId());
        consultaResponse.setDentista(consulta.getDentista().getId());
        consultaResponse.setClinica(consulta.getClinica().getId());

        consultaResponse.setDataConsulta(consulta.getDataConsulta());
        consultaResponse.setCreatedAt(consulta.getCreatedAt());
        consultaResponse.setUpdateAt(consulta.getUpdateAt());
        consultaResponse.setDescricao(consulta.getDescricao());
        consultaResponse.setCancelada(consulta.getCancelada());
        consultaResponse.setMotivoCancelamento(consulta.getMotivoCancelamento());

        return consultaResponse;

    }


}
