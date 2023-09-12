package br.com.luisbraga.projetoClinica.api.controller;

import br.com.luisbraga.projetoClinica.api.dto.request.ClinicaRequest;
import br.com.luisbraga.projetoClinica.api.dto.response.ClinicaResponse;
import br.com.luisbraga.projetoClinica.api.dto.response.ContatoResponse;
import br.com.luisbraga.projetoClinica.api.dto.response.EnderecoResponse;
import br.com.luisbraga.projetoClinica.domain.entity.Clinica;
import br.com.luisbraga.projetoClinica.domain.entity.Contato;
import br.com.luisbraga.projetoClinica.domain.entity.Endereco;
import br.com.luisbraga.projetoClinica.domain.service.ClinicaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("v1/clinicas")
public class ClinicaController {

    private final ClinicaService clinicaService;

    @Autowired
    public ClinicaController(ClinicaService clinicaService) {
        this.clinicaService = clinicaService;
    }

    @GetMapping("{id}")
    ResponseEntity<ClinicaResponse> buscarPorId(@PathVariable UUID id) {
        Clinica clinica = clinicaService.buscarClinicaPorId(id);
        ClinicaResponse response = clinicaResponseByClinica(clinica);
        return ResponseEntity.ok(response);
    }
    @PostMapping
    ResponseEntity<?> criarClinica(@RequestBody @Valid ClinicaRequest request) {
        Clinica clinica = new Clinica();
        clinica.setCnpj(request.getCnpj());
        clinica.setNome(request.getNome());
        clinica.setRazaoSocial(request.getRazaoSocial());
        clinica.setDescricao(request.getDescricao());

        Contato contato = new Contato();
        contato.setEmail(request.getContato().getEmail());
        contato.setTelefone(request.getContato().getTelefone());
        clinica.setContato(contato);

        Endereco endereco = new Endereco();
        endereco.setLogradouro(request.getEndereco().getLogradouro());
        endereco.setBairro(request.getEndereco().getBairro());
        endereco.setCidade(request.getEndereco().getCidade());
        endereco.setEstado(request.getEndereco().getEstado());
        endereco.setCep(request.getEndereco().getCep());
        clinica.setEndereco(endereco);

        Clinica clinicaCriada = clinicaService.criarClinica(clinica);
        return ResponseEntity.ok(clinicaCriada);
    }

    private ClinicaResponse clinicaResponseByClinica(Clinica clinica) {
        ClinicaResponse clinicaResponse = new ClinicaResponse();
        clinicaResponse.setId(clinica.getId());
        clinicaResponse.setNome(clinica.getNome());
        clinicaResponse.setCnpj(clinica.getCnpj());
        clinicaResponse.setRazaoSocial(clinica.getRazaoSocial());
        clinicaResponse.setDescricao(clinica.getDescricao());

        ContatoResponse contato = new ContatoResponse();
        contato.setId(clinica.getContato().getId());
        contato.setEmail(clinica.getContato().getEmail());
        contato.setTelefone(clinica.getContato().getTelefone());

        EnderecoResponse endereco = new EnderecoResponse();
        endereco.setId(clinica.getEndereco().getId());
        endereco.setLogradouro(clinica.getEndereco().getLogradouro());
        endereco.setBairro(clinica.getEndereco().getBairro());
        endereco.setCidade(clinica.getEndereco().getCidade());
        endereco.setEstado(clinica.getEndereco().getEstado());
        endereco.setCep(clinica.getEndereco().getCep());

        clinicaResponse.setContato(contato);
        clinicaResponse.setEndereco(endereco);

        return clinicaResponse;
    }

}
