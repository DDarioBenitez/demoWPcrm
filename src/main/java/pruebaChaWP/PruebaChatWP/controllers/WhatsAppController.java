package pruebaChaWP.PruebaChatWP.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pruebaChaWP.PruebaChatWP.dtos.MessageWhatsappDTO;
import pruebaChaWP.PruebaChatWP.dtos.StorageMessageDTO;
import pruebaChaWP.PruebaChatWP.modules.entity.Seller;
import pruebaChaWP.PruebaChatWP.modules.senderMessage.ResponseWhatsapp;
import pruebaChaWP.PruebaChatWP.modules.receivedMessage.*;
import pruebaChaWP.PruebaChatWP.modules.storageMessage.ClientMessage;
import pruebaChaWP.PruebaChatWP.modules.storageMessage.StorageMessage;
import pruebaChaWP.PruebaChatWP.repositories.ClientMessageRepository;
import pruebaChaWP.PruebaChatWP.repositories.SellerMessageRepository;
import pruebaChaWP.PruebaChatWP.repositories.SellerRepository;
import pruebaChaWP.PruebaChatWP.repositories.StorageMessageRepository;
import pruebaChaWP.PruebaChatWP.service.ApiWhatsappService;

import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/api/v1/whatsapp")
public class WhatsAppController {

    @Autowired
    private ApiWhatsappService apiWhatsappService;

    @Value("${whatsapp.tokenReceived}")
    private String expectedToken;

    @Autowired
    private StorageMessageRepository storageRepository;

    @Autowired
    private SellerRepository sellerRepository;

    @Autowired
    private ClientMessageRepository clientMessageRepository;

    @Autowired
    private SellerMessageRepository sellerMessageRepository;


    private static final Logger logger = LoggerFactory.getLogger(WhatsAppController.class);


    @PostMapping("/enviar")
    public ResponseWhatsapp enviar(@RequestBody MessageWhatsappDTO payload){
        logger.info("Mensaje enviado con éxito");
        return  apiWhatsappService.sendMessage(payload);
    }

    @GetMapping("/recibido")
    public ResponseEntity<String> verifyWebhook(@RequestParam("hub.mode") String mode,
                                                @RequestParam("hub.verify_token") String receivedVerifyToken,
                                                @RequestParam("hub.challenge") String challenge) {
        if ("subscribe".equals(mode) && expectedToken.equals(receivedVerifyToken)) {
            System.out.println(challenge);
            System.out.println(mode);
            System.out.println(receivedVerifyToken);
            System.out.println("si entro");
            logger.info("Verificación exitosa");
            return ResponseEntity.ok(challenge);
        } else {
            logger.error("Verificación fallida");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Verification failed");
        }
    }

    @PostMapping("/recibido")
    public ResponseEntity<Void> handleWebhook(@RequestBody WhatsAppWebhookPayload whatsAppWebhookPayload) {
        WhatsAppEntry payload = whatsAppWebhookPayload.getEntry()[0];
        if (payload != null && payload.getChanges() != null && payload.getChanges()[0] != null) {
            WhatsAppChange changes = payload.getChanges()[0];
            if (changes.getValue() != null && changes.getValue().getMessages() != null
                    && changes.getValue().getMessages()[0] != null) {
                WhatsAppMessage messages = changes.getValue().getMessages()[0];
                String from = messages.getFrom();
                WhatsAppMessageText text = messages.getText();
                if (text != null) {
                    String body = text.getBody();

                    logger.info("Mensaje recibido: {}", body);

                    System.out.println(body);
                    System.out.println(from);

                    Seller seller = sellerRepository.findByUserName(asignarVendedorEquitativo(3));
                    StorageMessage storageMessage = storageRepository.findByNumber(from);
                    if (storageMessage == null) {
                        StorageMessage newStorageMessage = new StorageMessage();
                        newStorageMessage.setNumber(from);
                        ClientMessage clientMessage = new ClientMessage(from, body);
                        newStorageMessage.addClientMessageList(clientMessage);
                        seller.addStorageMessageList(newStorageMessage);
                        sellerRepository.save(seller);
                        storageRepository.save(newStorageMessage);
                        clientMessageRepository.save(clientMessage);
                    } else if (!storageMessage.getClientMessageList().isEmpty()) {
                        ClientMessage clientMessage = new ClientMessage(from, body);
                        storageMessage.addClientMessageList(clientMessage);
                        storageRepository.save(storageMessage);
                        clientMessageRepository.save(clientMessage);
                    }
                }
            }
        }

        // Resto de tu lógica
        logger.info("Webhook entrante");
        System.out.println("Incoming webhook");
        return ResponseEntity.ok().build();
    }

//    @PostMapping("/recibido")
//    public ResponseEntity<Void> handleWebhook(@RequestBody WhatsAppWebhookPayload whatsAppWebhookPayload) {
//        // Acceder a los diferentes campos del WhatsAppWebhookPayload
//
//        WhatsAppEntry payload = whatsAppWebhookPayload.getEntry()[0];
//        if (payload != null && payload.getChanges() != null && payload.getChanges()[0] != null) {
//            WhatsAppChange changes = payload.getChanges()[0];
//            if (changes.getValue() != null && changes.getValue().getMessages() != null
//                    && changes.getValue().getMessages()[0] != null) {
//                WhatsAppMessage messages = changes.getValue().getMessages()[0];
//                String from = messages.getFrom();
//                WhatsAppMessageText text = messages.getText();
//                if (text != null) {
//                    String body = text.getBody();
//                    // Ahora puedes utilizar 'from' y 'body' sin preocuparte por NullPointerException
//
//                    System.out.println(body);
//                    System.out.println(from);
//
//
//                    Seller seller = sellerRepository.findByUserName(asignarVendedorEquitativo(3));
//                    StorageMessage storageMessage = storageRepository.findByNumber(from);
//                    if(storageMessage == null){
//                        StorageMessage newStorageMessage = new StorageMessage();
//                        newStorageMessage.setNumber(from);
//                        ClientMessage clientMessage = new ClientMessage(from, body);
//                        newStorageMessage.addClientMessageList(clientMessage);
//                        seller.addStorageMessageList(newStorageMessage);
//                        sellerRepository.save(seller);
//                        storageRepository.save(newStorageMessage);
//                        clientMessageRepository.save(clientMessage);
//                    }else if (!storageMessage.getClientMessageList().isEmpty()){
//                        ClientMessage clientMessage = new ClientMessage(from, body);
//                        storageMessage.addClientMessageList(clientMessage);
//                        storageRepository.save(storageMessage);
//                        clientMessageRepository.save(clientMessage);
//                    }
//                }
//            }
//        }
////        String object = whatsAppWebhookPayload.getObject();
////        System.out.println("Object: " + object);
////
////        WhatsAppEntry[] entries = whatsAppWebhookPayload.getEntry();
////        if (entries != null) {
////            for (WhatsAppEntry entry : entries) {
////                String entryId = entry.getId();
////                System.out.println("Entry ID: " + entryId);
////
////                WhatsAppChange[] changes = entry.getChanges();
////                if (changes != null) {
////                    for (WhatsAppChange change : changes) {
////                        String changeField = change.getField();
////                        System.out.println("Change Field: " + changeField);
////
////                        WhatsAppChangeValue changeValue = change.getValue();
////                        if (changeValue != null) {
////                            String messagingProduct = changeValue.getMessagingProduct();
////                            System.out.println("Messaging Product: " + messagingProduct);
////
////                            // Puedes seguir imprimiendo según sea necesario
////                            WhatsAppMessage [] messages= change.getValue().getMessages();
////                            if(messages != null){
////                                for (WhatsAppMessage message : messages){
////                                    WhatsAppMessageText message1= message.getText();
////                                    System.out.println(message1.getBody());
////                                }
////                            }
////                        }
////                    }
////                }
////            }
////        }
//
//        // Lógica adicional según tus necesidades
//
//        System.out.println("Incoming webhook");
//        return ResponseEntity.ok().build();
//    }

    @GetMapping("/storage/{numberPhone}")
    public ResponseEntity<Object> getStorage(@PathVariable String numberPhone){
        StorageMessage storageMessage = storageRepository.findByNumber(numberPhone);
        StorageMessageDTO storageMessageDTO = new StorageMessageDTO(storageMessage.getId(), storageMessage.getClientMessageList(), storageMessage.getSellerMessageList());
        return ResponseEntity.ok(storageMessageDTO);
    }

    private String asignarVendedorEquitativo(int intentos) {
        if (intentos <= 0) {
            // Evitar recursividad infinita
            throw new IllegalStateException("No se pudo asignar un vendedor después de varios intentos");
        }

        List<Seller> sellers = sellerRepository.findAll();
        int indexSeller = new Random().nextInt(sellers.size());
        return sellers.get(indexSeller).getUserName();
    }
}
