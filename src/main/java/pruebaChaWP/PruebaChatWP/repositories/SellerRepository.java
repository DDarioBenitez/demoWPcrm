package pruebaChaWP.PruebaChatWP.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pruebaChaWP.PruebaChatWP.modules.entity.Seller;

public interface SellerRepository extends JpaRepository<Seller, Long> {

    Seller findByUserName(String userName);
}
