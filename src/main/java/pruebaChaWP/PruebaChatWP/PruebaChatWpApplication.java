package pruebaChaWP.PruebaChatWP;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pruebaChaWP.PruebaChatWP.modules.entity.Seller;
import pruebaChaWP.PruebaChatWP.modules.storageMessage.SellerMessage;
import pruebaChaWP.PruebaChatWP.repositories.SellerRepository;

@SpringBootApplication
public class PruebaChatWpApplication {

	@Autowired
	private SellerRepository sellerRepository;

	public static void main(String[] args) {
		SpringApplication.run(PruebaChatWpApplication.class, args);
	}


	@Bean
	public CommandLineRunner initData(SellerRepository sellerRepository) {
		return args -> {
			Seller seller = new Seller("Admin1", "12345");
			sellerRepository.save(seller);
		};
	}
}
