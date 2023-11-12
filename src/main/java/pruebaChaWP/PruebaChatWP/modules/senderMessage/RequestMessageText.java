package pruebaChaWP.PruebaChatWP.modules.senderMessage;

public class RequestMessageText {

    private String body;

    public RequestMessageText(String body) {
        this.body = body;
    }

    public RequestMessageText(){

    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
