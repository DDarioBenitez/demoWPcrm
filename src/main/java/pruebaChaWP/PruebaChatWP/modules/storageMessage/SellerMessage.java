package pruebaChaWP.PruebaChatWP.modules.storageMessage;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class SellerMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name="native",strategy = "native")
    private long id;

    private String userName;
    private String body;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "storage_message_id")
    private StorageMessage storageMessage;

    public SellerMessage(String userName, String body) {
        this.userName = userName;
        this.body = body;
    }
    public SellerMessage(){}

    public long getId() {
        return id;
    }
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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
