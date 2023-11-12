package pruebaChaWP.PruebaChatWP.modules.entity;

import org.hibernate.annotations.GenericGenerator;
import pruebaChaWP.PruebaChatWP.modules.storageMessage.StorageMessage;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Seller {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "native")
    @GenericGenerator(name="native",strategy = "native")
    private long id;

    private String userName;

    private String password;

    @OneToMany(mappedBy = "seller")
    private List<StorageMessage> storageMessageList = new ArrayList<>();

    public Seller(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
    public Seller(){

    }

    public long getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<StorageMessage> getStorageMessageList() {
        return storageMessageList;
    }

    public void addStorageMessageList(StorageMessage storageMessage) {
        storageMessage.setSeller(this);
        this.storageMessageList.add(storageMessage);
    }
}
