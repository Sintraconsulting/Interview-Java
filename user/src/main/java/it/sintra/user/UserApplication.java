package it.sintra.user;

import java.security.Security;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;




@Configuration
@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@ComponentScan("it.sintra.user")
@EnableJpaRepositories("it.sintra.user.repository")
public class UserApplication {

	public static void main(String[] args) {
		Security.addProvider(new BouncyCastleProvider());
		SpringApplication.run(UserApplication.class, args);
	}

}
