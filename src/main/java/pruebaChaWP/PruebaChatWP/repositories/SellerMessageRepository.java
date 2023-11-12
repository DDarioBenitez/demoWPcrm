package pruebaChaWP.PruebaChatWP.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pruebaChaWP.PruebaChatWP.modules.storageMessage.SellerMessage;

public interface SellerMessageRepository extends JpaRepository <SellerMessage, Long> {
}
