package br.com.mb.stockmanagerwallet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class StockmanagerWalletApplication {

	public static void main(String[] args)  throws Exception {
		SpringApplication.run(StockmanagerWalletApplication.class, args);
	}
}
