package challenge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@EnableWebSecurity
@SpringBootApplication
public class MyAutoBlogChallengeApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyAutoBlogChallengeApplication.class, args);
	}
	
	/*@Bean
	public LocalValidatorFactoryBean validator() {
		LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
		return bean;
	}*/

}
