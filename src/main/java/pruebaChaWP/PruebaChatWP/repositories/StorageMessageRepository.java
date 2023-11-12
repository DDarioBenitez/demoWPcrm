package pruebaChaWP.PruebaChatWP.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pruebaChaWP.PruebaChatWP.modules.entity.Seller;
import pruebaChaWP.PruebaChatWP.modules.storageMessage.StorageMessage;

public interface StorageMessageRepository extends JpaRepository<StorageMessage, Long> {

    StorageMessageRepository findBySeller(Seller seller);

    StorageMessage findByNumber(String number);
}
