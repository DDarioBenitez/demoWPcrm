package pruebaChaWP.PruebaChatWP.modules.senderMessage;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class MessageWhatsapp {

    private String phoneNumber;
    private String message;

    public MessageWhatsapp(String phoneNumber, String message) {
        this.phoneNumber = phoneNumber;
        this.message = message;
    }
    public MessageWhatsapp() {}

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
