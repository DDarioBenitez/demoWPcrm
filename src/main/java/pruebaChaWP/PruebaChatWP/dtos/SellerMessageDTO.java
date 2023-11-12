package pruebaChaWP.PruebaChatWP.dtos;

import pruebaChaWP.PruebaChatWP.modules.storageMessage.SellerMessage;

public class SellerMessageDTO {

    private String userName;

    private String body;

    public SellerMessageDTO(String userName, String body) {
        this.userName = userName;
        this.body = body;
    }

    public SellerMessageDTO(){}

    public SellerMessageDTO(SellerMessage sellerMessage){
        this.userName = sellerMessage.getUserName();
        this.body = sellerMessage.getBody();
    }
    public String getUserName() {
        return userName;
    }

    public String getBody() {
        return body;
    }
}
