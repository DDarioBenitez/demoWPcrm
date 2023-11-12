package pruebaChaWP.PruebaChatWP.modules.receivedMessage;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WhatsAppMetadata {

    @JsonProperty("display_phone_number")
    private String displayPhoneNumber;

    @JsonProperty("phone_number_id")
    private String phoneNumberId;

    public WhatsAppMetadata(String displayPhoneNumber, String phoneNumberId) {
        this.displayPhoneNumber = displayPhoneNumber;
        this.phoneNumberId = phoneNumberId;
    }

    public WhatsAppMetadata (){}

    public String getDisplayPhoneNumber() {
        return displayPhoneNumber;
    }

    public void setDisplayPhoneNumber(String displayPhoneNumber) {
        this.displayPhoneNumber = displayPhoneNumber;
    }

    public String getPhoneNumberId() {
        return phoneNumberId;
    }

    public void setPhoneNumberId(String phoneNumberId) {
        this.phoneNumberId = phoneNumberId;
    }
}
