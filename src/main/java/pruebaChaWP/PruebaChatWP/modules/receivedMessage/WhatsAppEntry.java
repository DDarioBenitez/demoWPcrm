package pruebaChaWP.PruebaChatWP.modules.receivedMessage;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WhatsAppEntry {

    @JsonProperty("id")
    private String id;

    @JsonProperty("changes")
    private WhatsAppChange[] changes;

    public WhatsAppEntry(String id, WhatsAppChange[] changes) {
        this.id = id;
        this.changes = changes;
    }

    public WhatsAppEntry (){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public WhatsAppChange[] getChanges() {
        return changes;
    }

    public void setChanges(WhatsAppChange[] changes) {
        this.changes = changes;
    }
}
