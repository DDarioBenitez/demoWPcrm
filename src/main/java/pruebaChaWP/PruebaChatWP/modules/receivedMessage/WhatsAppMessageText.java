package pruebaChaWP.PruebaChatWP.modules.receivedMessage;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WhatsAppMessageText {

    @JsonProperty("body")
    private String body;

    public WhatsAppMessageText(String body) {
        this.body = body;
    }

    public WhatsAppMessageText (){}

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
