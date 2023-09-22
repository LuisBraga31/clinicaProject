package br.com.luisbraga.projetoClinica.api.controller;

import br.com.luisbraga.projetoClinica.api.dto.request.PacienteRequest;
import br.com.luisbraga.projetoClinica.api.dto.response.ContatoResponse;
import br.com.luisbraga.projetoClinica.api.dto.response.EnderecoResponse;
import br.com.luisbraga.projetoClinica.api.dto.response.List.PacienteListResponse;
import br.com.luisbraga.projetoClinica.api.dto.response.PacienteResponse;
import br.com.luisbraga.projetoClinica.api.dto.response.Wrapper.PacienteWrapperResponse;
import br.com.luisbraga.projetoClinica.domain.entity.Contato;
import br.com.luisbraga.projetoClinica.domain.entity.Endereco;
import br.com.luisbraga.projetoClinica.domain.entity.Paciente;
import br.com.luisbraga.projetoClinica.domain.service.PacienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("v1/pacientes")
public class PacienteController {

    private final PacienteService pacienteService;

    @Autowired
    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @GetMapping
    ResponseEntity<PacienteWrapperResponse> buscarPacientes() {
        List<Paciente> pacientes = pacienteService.buscarPacientes();
        PacienteWrapperResponse pacienteWrapperResponse = new PacienteWrapperResponse();

        pacienteWrapperResponse.setPacientes( pacientes.stream().map( paciente -> {
            PacienteListResponse pacienteListResponse = new PacienteListResponse();
            pacienteListResponse.setId(paciente.getId());
            pacienteListResponse.setNome(paciente.getNome());
            return pacienteListResponse;
        }).toList());

        return ResponseEntity.ok(pacienteWrapperResponse);
    }

    @GetMapping("{id}")
    ResponseEntity<PacienteResponse> buscarPacientePorId(@PathVariable UUID id) {
        Paciente paciente = pacienteService.buscarPacientePorId(id);
        PacienteResponse response = pacienteResponseByPaciente(paciente);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    ResponseEntity<PacienteResponse> criarPaciente(@RequestBody @Valid PacienteRequest request) {

        Paciente paciente = new Paciente();
        paciente.setNome(request.getNome());
        paciente.setDataNascimento(request.getDataNascimento());
        paciente.setSexo(request.getSexo());

        Contato contato = new Contato();
        contato.setEmail(request.getContato().getEmail());
        contato.setTelefone(request.getContato().getTelefone());
        paciente.setContato(contato);

        Endereco endereco = new Endereco();
        endereco.setLogradouro(request.getEndereco().getLogradouro());
        endereco.setBairro(request.getEndereco().getBairro());
        endereco.setCidade(request.getEndereco().getCidade());
        endereco.setEstado(request.getEndereco().getEstado());
        endereco.setCep(request.getEndereco().getCep());
        paciente.setEndereco(endereco);

        Paciente pacienteCriado = pacienteService.criarPaciente(paciente);
        PacienteResponse response = pacienteResponseByPaciente(pacienteCriado);
        return ResponseEntity.ok(response);

    }

    @PutMapping("{id}")
    ResponseEntity<PacienteResponse> atualizarPaciente(@PathVariable UUID id, @RequestBody @Valid PacienteRequest request) {
        Paciente paciente = pacienteService.buscarPacientePorId(id);

        paciente.setNome(request.getNome());
        paciente.setDataNascimento(request.getDataNascimento());
        paciente.setSexo(request.getSexo());

        Contato contato = paciente.getContato();
        contato.setEmail(request.getContato().getEmail());
        contato.setTelefone(request.getContato().getTelefone());
        paciente.setContato(contato);

        Endereco endereco = paciente.getEndereco();
        endereco.setLogradouro(request.getEndereco().getLogradouro());
        endereco.setBairro(request.getEndereco().getBairro());
        endereco.setCidade(request.getEndereco().getCidade());
        endereco.setEstado(request.getEndereco().getEstado());
        endereco.setCep(request.getEndereco().getCep());
        paciente.setEndereco(endereco);

        Paciente pacienteAtualizado = pacienteService.atualizarPaciente(id, paciente);
        PacienteResponse response = pacienteResponseByPaciente(pacienteAtualizado);
        return ResponseEntity.ok(response);

    }

    @DeleteMapping("{id}")
    ResponseEntity<Void> deletarPaciente(@PathVariable UUID id) {
        pacienteService.deletarPaciente(id);
        return ResponseEntity.ok().build();
    }

    private PacienteResponse pacienteResponseByPaciente(Paciente paciente) {

        PacienteResponse pacienteResponse = new PacienteResponse();
        pacienteResponse.setId(paciente.getId());
        pacienteResponse.setNome(paciente.getNome());
        pacienteResponse.setDataNascimento(paciente.getDataNascimento());
        pacienteResponse.setSexo(paciente.getSexo());
        pacienteResponse.setCreatedAt(paciente.getCreatedAt());
        pacienteResponse.setUpdateAt(paciente.getUpdateAt());

        ContatoResponse contato = new ContatoResponse();
        contato.setId(paciente.getContato().getId());
        contato.setEmail(paciente.getContato().getEmail());
        contato.setTelefone(paciente.getContato().getTelefone());
        contato.setCreatedAt(paciente.getContato().getCreatedAt());
        contato.setUpdateAt(paciente.getContato().getUpdateAt());

        EnderecoResponse endereco = new EnderecoResponse();
        endereco.setId(paciente.getEndereco().getId());
        endereco.setLogradouro(paciente.getEndereco().getLogradouro());
        endereco.setBairro(paciente.getEndereco().getBairro());
        endereco.setCidade(paciente.getEndereco().getCidade());
        endereco.setEstado(paciente.getEndereco().getEstado());
        endereco.setCep(paciente.getEndereco().getCep());
        endereco.setCreatedAt(paciente.getEndereco().getCreatedAt());
        endereco.setUpdateAt(paciente.getEndereco().getUpdateAt());

        pacienteResponse.setContato(contato);
        pacienteResponse.setEndereco(endereco);

        return pacienteResponse;

    }

}
