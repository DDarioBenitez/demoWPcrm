package pruebaChaWP.PruebaChatWP.modules.senderMessage;

import java.util.List;

public class ResponseWhatsapp {

    private String messaging_product;
    private List<ResponseWhatsappContact> contacts;
    private List<ResponseWhatsappMessage> messages;

    public ResponseWhatsapp(){}

    public ResponseWhatsapp(String messaging_product, List<ResponseWhatsappContact> contacts, List<ResponseWhatsappMessage> messages) {
        this.messaging_product = messaging_product;
        this.contacts = contacts;
        this.messages = messages;
    }

    public String getMessaging_product() {
        return messaging_product;
    }

    public void setMessaging_product(String messaging_product) {
        this.messaging_product = messaging_product;
    }

    public List<ResponseWhatsappContact> getContacts() {
        return contacts;
    }

    public void setContacts(List<ResponseWhatsappContact> contacts) {
        this.contacts = contacts;
    }

    public List<ResponseWhatsappMessage> getMessages() {
        return messages;
    }

    public void setMessages(List<ResponseWhatsappMessage> messages) {
        this.messages = messages;
    }
}
