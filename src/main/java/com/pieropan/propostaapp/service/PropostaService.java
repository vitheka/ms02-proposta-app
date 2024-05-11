package com.pieropan.propostaapp.service;

import com.pieropan.propostaapp.dto.PropostaRequestDto;
import com.pieropan.propostaapp.dto.PropostaResponseDto;
import com.pieropan.propostaapp.mapper.PropostaMapper;
import com.pieropan.propostaapp.repository.PropostaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PropostaService {

    private final PropostaRepository propostaRepository;
    private final PropostaMapper mapper;

    public PropostaResponseDto criar(PropostaRequestDto requestDto) {

        var proposta = mapper.convertDtoToProposta(requestDto);

        proposta = propostaRepository.save(proposta);

        return mapper.propostaToPropostaResponseDto(proposta);
    }
}
