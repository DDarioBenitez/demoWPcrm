package pruebaChaWP.PruebaChatWP.modules.senderMessage;

public class ResponseWhatsappContact {

    private  String input;
    private String wa_id;

    public ResponseWhatsappContact(){

    }
    public ResponseWhatsappContact(String input, String wa_id){
        this.input=input;
        this.wa_id=wa_id;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getWa_id() {
        return wa_id;
    }

    public void setWa_id(String wa_id) {
        this.wa_id = wa_id;
    }
}
