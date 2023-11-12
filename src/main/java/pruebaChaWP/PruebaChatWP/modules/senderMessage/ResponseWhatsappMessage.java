package pruebaChaWP.PruebaChatWP.modules.senderMessage;

public class ResponseWhatsappMessage {
    private String id;

    public ResponseWhatsappMessage(String id){
        this.id=id;
    }

    public ResponseWhatsappMessage(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
