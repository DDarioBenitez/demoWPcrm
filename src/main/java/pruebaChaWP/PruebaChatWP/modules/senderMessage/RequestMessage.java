package pruebaChaWP.PruebaChatWP.modules.senderMessage;

public class RequestMessage {

    private String messaging_product;
    private String to;
    private RequestMessageText text;

    public RequestMessage(String messaging_product, String to, RequestMessageText text) {
        this.messaging_product = messaging_product;
        this.to = to;
        this.text = text;
    }

    public RequestMessage(){

    }

    public String getMessaging_product() {
        return messaging_product;
    }

    public void setMessaging_product(String messaging_product) {
        this.messaging_product = messaging_product;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public RequestMessageText getText() {
        return text;
    }

    public void setText(RequestMessageText text) {
        this.text = text;
    }
}
