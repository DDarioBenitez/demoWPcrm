package pruebaChaWP.PruebaChatWP.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pruebaChaWP.PruebaChatWP.modules.storageMessage.ClientMessage;

public interface ClientMessageRepository extends JpaRepository<ClientMessage, Long> {
}
