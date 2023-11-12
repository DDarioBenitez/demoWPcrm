package pruebaChaWP.PruebaChatWP.modules.receivedMessage;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WhatsAppProfile {

    @JsonProperty("name")
    private String name;

    public WhatsAppProfile(String name) {
        this.name = name;
    }
    public WhatsAppProfile (){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
