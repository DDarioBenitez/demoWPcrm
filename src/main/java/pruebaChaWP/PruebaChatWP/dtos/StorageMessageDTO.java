package pruebaChaWP.PruebaChatWP.dtos;

import pruebaChaWP.PruebaChatWP.modules.storageMessage.ClientMessage;
import pruebaChaWP.PruebaChatWP.modules.storageMessage.SellerMessage;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StorageMessageDTO {

    private long id;

    private List<ClientMessageDTO> clientMessageList = new ArrayList<>();

    private List<SellerMessageDTO> sellerMessageList = new ArrayList<>();

    public StorageMessageDTO(long id, List<ClientMessage> clientMessageList, List<SellerMessage> sellerMessageList) {
        this.clientMessageList = clientMessageList.stream().map(ClientMessageDTO::new).collect(Collectors.toList());
        this.sellerMessageList = sellerMessageList.stream().map(SellerMessageDTO::new).collect(Collectors.toList());
    }

    public StorageMessageDTO(){}

    public long getId() {
        return id;
    }

    public List<ClientMessageDTO> getClientMessageList() {
        return clientMessageList;
    }

    public List<SellerMessageDTO> getSellerMessageList() {
        return sellerMessageList;
    }
}
