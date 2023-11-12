package pruebaChaWP.PruebaChatWP.dtos;

public class MessageWhatsappDTO {

    private String phoneNumber;

    private String message;

    public MessageWhatsappDTO(String phoneNumber, String message) {
        this.phoneNumber = phoneNumber;
        this.message = message;
    }

    public MessageWhatsappDTO(){}

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
