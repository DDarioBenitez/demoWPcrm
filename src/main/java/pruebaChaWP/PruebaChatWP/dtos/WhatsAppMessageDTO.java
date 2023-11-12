package pruebaChaWP.PruebaChatWP.dtos;

public class WhatsAppMessageDTO {
    private String from;
    private String textBody;

    // Constructores, getters y setters

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTextBody() {
        return textBody;
    }

    public void setTextBody(String textBody) {
        this.textBody = textBody;
    }

    @Override
    public String toString() {
        return "WhatsAppMessageDTO{" +
                "from='" + from + '\'' +
                ", textBody='" + textBody + '\'' +
                '}';
    }
}
