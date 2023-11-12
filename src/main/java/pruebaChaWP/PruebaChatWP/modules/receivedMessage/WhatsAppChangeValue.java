package pruebaChaWP.PruebaChatWP.modules.receivedMessage;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WhatsAppChangeValue {

    @JsonProperty("messaging_product")
    private String messagingProduct;

    @JsonProperty("metadata")
    private WhatsAppMetadata metadata;

    @JsonProperty("contacts")
    private WhatsAppContact[] contacts;

    @JsonProperty("messages")
    private WhatsAppMessage[] messages;

    public WhatsAppChangeValue(String messagingProduct, WhatsAppMetadata metadata, WhatsAppContact[] contacts, WhatsAppMessage[] messages) {
        this.messagingProduct = messagingProduct;
        this.metadata = metadata;
        this.contacts = contacts;
        this.messages = messages;
    }

    public WhatsAppChangeValue (){}

    public String getMessagingProduct() {
        return messagingProduct;
    }

    public void setMessagingProduct(String messagingProduct) {
        this.messagingProduct = messagingProduct;
    }

    public WhatsAppMetadata getMetadata() {
        return metadata;
    }

    public void setMetadata(WhatsAppMetadata metadata) {
        this.metadata = metadata;
    }

    public WhatsAppContact[] getContacts() {
        return contacts;
    }

    public void setContacts(WhatsAppContact[] contacts) {
        this.contacts = contacts;
    }

    public WhatsAppMessage[] getMessages() {
        return messages;
    }

    public void setMessages(WhatsAppMessage[] messages) {
        this.messages = messages;
    }
}
