package pruebaChaWP.PruebaChatWP.modules.receivedMessage;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WhatsAppMessage {

    @JsonProperty("from")
    private String from;

    @JsonProperty("id")
    private String id;

    @JsonProperty("timestamp")
    private String timestamp;

    @JsonProperty("type")
    private String type;

    @JsonProperty("text")
    private WhatsAppMessageText text;

    public WhatsAppMessage(String from, String id, String timestamp, String type, WhatsAppMessageText text) {
        this.from = from;
        this.id = id;
        this.timestamp = timestamp;
        this.type = type;
        this.text = text;
    }

    public WhatsAppMessage(){}

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public WhatsAppMessageText getText() {
        return text;
    }

    public void setText(WhatsAppMessageText text) {
        this.text = text;
    }
}
