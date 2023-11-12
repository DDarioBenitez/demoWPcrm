package pruebaChaWP.PruebaChatWP.modules.storageMessage;

import org.hibernate.annotations.GenericGenerator;
import pruebaChaWP.PruebaChatWP.modules.entity.Seller;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class StorageMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name="native",strategy = "native")
    private long id;

    @OneToMany(mappedBy = "storageMessage")
    private List<ClientMessage> clientMessageList = new ArrayList<>();

    @OneToMany(mappedBy = "storageMessage")
    private  List<SellerMessage> sellerMessageList = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    private Seller seller;

    private String number;

    public StorageMessage(List<ClientMessage> clientMessageList, List<SellerMessage> sellerMessageList) {
        this.clientMessageList = clientMessageList;
        this.sellerMessageList = sellerMessageList;
    }

    public StorageMessage(){}

    public long getId() {
        return id;
    }

    public List<ClientMessage> getClientMessageList() {
        return clientMessageList;
    }

    public void addClientMessageList(ClientMessage clientMessage) {
        clientMessage.setStorageMessage(this);
        this.clientMessageList.add(clientMessage);
    }

    public List<SellerMessage> getSellerMessageList() {
        return sellerMessageList;
    }

    public void addSellerMessageList(SellerMessage sellerMessage) {
        sellerMessage.setStorageMessage(this);
        this.sellerMessageList.add(sellerMessage);
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
