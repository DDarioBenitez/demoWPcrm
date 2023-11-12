package pruebaChaWP.PruebaChatWP.dtos;

import pruebaChaWP.PruebaChatWP.modules.storageMessage.ClientMessage;

public class ClientMessageDTO {

    private String number;

    private String body;

    public ClientMessageDTO(){}

    public ClientMessageDTO(String number, String body) {
        this.number = number;
        this.body = body;
    }

    public ClientMessageDTO(ClientMessage clientMessage){
        this.number = clientMessage.getNumber();
        this.body = clientMessage.getBody();
    }

    public String getNumber() {
        return number;
    }

    public String getBody() {
        return body;
    }
}
