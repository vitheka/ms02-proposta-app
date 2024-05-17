package com.pieropan.propostaapp.service;

import com.pieropan.propostaapp.dto.PropostaResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificacaoService {

    private final RabbitTemplate rabbitTemplate;

    public void notificar(PropostaResponseDto proposta, String exchange) {

        rabbitTemplate.convertAndSend(exchange, "", proposta);

    }
}
