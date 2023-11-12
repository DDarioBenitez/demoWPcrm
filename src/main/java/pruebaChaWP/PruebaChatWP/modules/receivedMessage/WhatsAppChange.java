package pruebaChaWP.PruebaChatWP.modules.receivedMessage;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WhatsAppChange {

    @JsonProperty("field")
    private String field;

    @JsonProperty("value")
    private WhatsAppChangeValue value;

    public WhatsAppChange (){}

    public WhatsAppChange(String field, WhatsAppChangeValue value) {
        this.field = field;
        this.value = value;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public WhatsAppChangeValue getValue() {
        return value;
    }

    public void setValue(WhatsAppChangeValue value) {
        this.value = value;
    }


}
