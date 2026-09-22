package br.com.etechoracio.ingresso.controller;

import br.com.etechoracio.ingresso.dto.SalaResponseDTO;
import br.com.etechoracio.ingresso.service.SalaService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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



}
