package pruebaChaWP.PruebaChatWP.modules.receivedMessage;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WhatsAppWebhookPayload {

    @JsonProperty("object")
    private String object;

    @JsonProperty("entry")
    private WhatsAppEntry[] entry;

    public WhatsAppWebhookPayload(String object, WhatsAppEntry[] entry) {
        this.object = object;
        this.entry = entry;
    }

    public WhatsAppWebhookPayload (){

    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public WhatsAppEntry[] getEntry() {
        return entry;
    }

    public void setEntry(WhatsAppEntry[] entry) {
        this.entry = entry;
    }


}

