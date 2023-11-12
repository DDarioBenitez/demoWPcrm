package pruebaChaWP.PruebaChatWP.modules.receivedMessage;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WhatsAppContact {

    @JsonProperty("profile")
    private WhatsAppProfile profile;

    @JsonProperty("wa_id")
    private String waId;

    public WhatsAppContact(WhatsAppProfile profile, String waId) {
        this.profile = profile;
        this.waId = waId;
    }

    public WhatsAppContact (){}

    public WhatsAppProfile getProfile() {
        return profile;
    }

    public void setProfile(WhatsAppProfile profile) {
        this.profile = profile;
    }

    public String getWaId() {
        return waId;
    }

    public void setWaId(String waId) {
        this.waId = waId;
    }
}
