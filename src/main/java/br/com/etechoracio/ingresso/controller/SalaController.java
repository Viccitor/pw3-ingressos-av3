package br.com.etechoracio.ingresso.controller;

import br.com.etechoracio.ingresso.dto.SalaResponseDTO;
import br.com.etechoracio.ingresso.service.SalaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@CrossOrigin("*")
public class SalaController {

    private SalaService salaService;

    public SalaController(SalaService salaService){
        this.salaService = salaService;
    }

    @GetMapping
    public List<SalaResponseDTO>listarSalas() {
        return salaService.listarSalasAtivas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SalaResponseDTO> buscarSalaPorId(@PathVariable long id){
        return salaService.buscarSalaAtivaPorId(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }



}
