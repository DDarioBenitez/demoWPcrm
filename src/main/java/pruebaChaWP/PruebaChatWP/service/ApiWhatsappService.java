package pruebaChaWP.PruebaChatWP.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import pruebaChaWP.PruebaChatWP.dtos.MessageWhatsappDTO;
import pruebaChaWP.PruebaChatWP.modules.senderMessage.RequestMessage;
import pruebaChaWP.PruebaChatWP.modules.senderMessage.RequestMessageText;
import pruebaChaWP.PruebaChatWP.modules.senderMessage.ResponseWhatsapp;

@Service
public class ApiWhatsappService {

    private final WebClient webClient;

    public ApiWhatsappService(
            @Value("${whatsapp.identificador}") String identificador,
            @Value("${whatsapp.token}") String token
    ) {
        webClient = WebClient.builder()
                .baseUrl("https://graph.facebook.com/v17.0/" + identificador + "/messages")
                .defaultHeader("Authorization", "Bearer " + token)
                .build();
    }

    public ResponseWhatsapp sendMessage(MessageWhatsappDTO payload) {
        RequestMessage requestMessage = new RequestMessage("whatsapp", payload.getPhoneNumber() , new RequestMessageText(payload.getMessage()));

            return webClient.post()
                    .uri("")
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(BodyInserters.fromValue(requestMessage))
                    .retrieve()
                    .bodyToMono(ResponseWhatsapp.class)
                    .block();
}}
