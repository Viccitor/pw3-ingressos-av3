package br.com.etechoracio.ingresso.service;

import br.com.etechoracio.ingresso.dto.SalaResponseDTO;
import br.com.etechoracio.ingresso.entity.Sala;
import br.com.etechoracio.ingresso.mapper.SalaMapper;
import br.com.etechoracio.ingresso.repository.SalaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SalaService {

    private SalaRepository salaRepository;
    private SalaMapper salaMapper;

    public SalaService(SalaRepository salaRepository, SalaMapper salaMapper){
        this.salaRepository = salaRepository;
        this.salaMapper = salaMapper;
    }

    public List<SalaResponseDTO> listarSalasAtivas(){
        List<Sala> salas = salaRepository.findAllByDataExclusaoIsNull();
        return salaMapper.toResponseDTOList(salas);
    }

    public Optional<SalaResponseDTO> buscarSalaAtivaPorId(Long id){
        return salaRepository.findAllByIdAndDataExclusaoIsNull(id).map(salaMapper::toResponseDTO);
    }

}
