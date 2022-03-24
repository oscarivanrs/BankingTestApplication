package com.test.account.banking;

import com.test.account.banking.model.Account;
import com.test.account.banking.model.TestAccount;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class BankingTestApplication {

	@Bean
	public static RestTemplate getRestTemplate(){
		return new PlatfrRestTemplate();
	}

	@Bean
	public static Account getAccount(){
		return new TestAccount(null);
	}

	public static void main(String[] args) {
		SpringApplication.run(BankingTestApplication.class, args);
	}
}
