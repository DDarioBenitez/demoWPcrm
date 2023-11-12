package pruebaChaWP.PruebaChatWP.modules.storageMessage;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class ClientMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name="native",strategy = "native")
    private long id;

    private String number;
    private String body;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "storage_message_id")
    private StorageMessage storageMessage;

    public ClientMessage(String number, String body) {
        this.number = number;
        this.body = body;
    }

    public ClientMessage(){}

    public long getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public StorageMessage getStorageMessage() {
        return storageMessage;
    }

    public void setStorageMessage(StorageMessage storageMessage) {
        this.storageMessage = storageMessage;
    }
}
