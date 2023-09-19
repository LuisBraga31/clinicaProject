package br.com.luisbraga.projetoClinica.api.controller;

import br.com.luisbraga.projetoClinica.api.dto.request.DentistaRequest;
import br.com.luisbraga.projetoClinica.api.dto.response.ContatoResponse;
import br.com.luisbraga.projetoClinica.api.dto.response.DentistaResponse;
import br.com.luisbraga.projetoClinica.api.dto.response.List.DentistaListResponse;
import br.com.luisbraga.projetoClinica.api.dto.response.Wrapper.DentistaWrapperResponse;
import br.com.luisbraga.projetoClinica.domain.entity.Contato;
import br.com.luisbraga.projetoClinica.domain.entity.Dentista;
import br.com.luisbraga.projetoClinica.domain.service.DentistaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
        List<Dentista> dentistas = dentistaService.buscarDentistas();
        DentistaWrapperResponse dentistaWrapperResponse = new DentistaWrapperResponse();

        dentistaWrapperResponse.setDentistas( dentistas.stream().map( dentista -> {
            DentistaListResponse dentistaListResponse = new DentistaListResponse();
            dentistaListResponse.setId(dentista.getId());
            dentistaListResponse.setNome(dentista.getNome());
            dentistaListResponse.setCro(dentista.getCro());
            return dentistaListResponse;
        }).toList());

        return ResponseEntity.ok(dentistaWrapperResponse);
    }

    @GetMapping("{id}")
    ResponseEntity<DentistaResponse> buscarDentistaPorId(@PathVariable UUID id) {
        Dentista dentista = dentistaService.buscarDentistaPorId(id);
        DentistaResponse response = dentistaResponseByDentista(dentista);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    ResponseEntity<DentistaResponse> criarDentista(@RequestBody @Valid DentistaRequest request) {
        Dentista dentista = new Dentista();
        dentista.setNome(request.getNome());
        dentista.setCro(request.getCro());
        dentista.setDataNascimento(request.getDataNascimento());
        dentista.setEspecialidade(request.getEspecialidade());
        dentista.setSexo(request.getSexo());

        Contato contato = new Contato();
        contato.setEmail(request.getContato().getEmail());
        contato.setTelefone(request.getContato().getTelefone());
        dentista.setContato(contato);

        dentista.setClinicasDentistas(request.getClinicasDentistas());

        Dentista dentistaCriado = dentistaService.criarDentista(dentista);
        DentistaResponse response = dentistaResponseByDentista(dentistaCriado);
        return ResponseEntity.ok(response);
    }

    @PutMapping("{id}")
    ResponseEntity<DentistaResponse> atualizarDentista(@PathVariable UUID id, @RequestBody DentistaRequest request) {

        Dentista dentista = dentistaService.buscarDentistaPorId(id);

        dentista.setNome(request.getNome());
        dentista.setCro(request.getCro());
        dentista.setDataNascimento(request.getDataNascimento());
        dentista.setEspecialidade(request.getEspecialidade());
        dentista.setSexo(request.getSexo());

        Contato contato = new Contato();
        contato.setEmail(request.getContato().getEmail());
        contato.setTelefone(request.getContato().getTelefone());
        dentista.setContato(contato);

        dentista.setClinicasDentistas(request.getClinicasDentistas());

        Dentista dentistaAtualizado = dentistaService.criarDentista(dentista);
        DentistaResponse response = dentistaResponseByDentista(dentistaAtualizado);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("{id}")
    ResponseEntity<Void> deletarDentista(@PathVariable UUID id) {
        dentistaService.deletarDentista(id);
        return ResponseEntity.ok().build();
    }

    private DentistaResponse dentistaResponseByDentista(Dentista dentista) {

        DentistaResponse dentistaResponse = new DentistaResponse();
        dentistaResponse.setId(dentista.getId());
        dentistaResponse.setNome(dentista.getNome());
        dentistaResponse.setCro(dentista.getCro());
        dentistaResponse.setDataNascimento(dentista.getDataNascimento());
        dentistaResponse.setEspecialidade(dentista.getEspecialidade());
        dentistaResponse.setSexo(dentista.getSexo());
        dentistaResponse.setCreatedAt(dentista.getCreatedAt());
        dentistaResponse.setUpdateAt(dentista.getUpdateAt());

        ContatoResponse contato = new ContatoResponse();
        contato.setId(dentista.getContato().getId());
        contato.setEmail(dentista.getContato().getEmail());
        contato.setTelefone(dentista.getContato().getTelefone());
        contato.setCreatedAt(dentista.getContato().getCreatedAt());
        contato.setUpdateAt(dentista.getContato().getUpdateAt());

        dentistaResponse.setContato(contato);
        dentistaResponse.setClinicasDentistas(dentista.getClinicasDentistas());

        return dentistaResponse;
    }

}
