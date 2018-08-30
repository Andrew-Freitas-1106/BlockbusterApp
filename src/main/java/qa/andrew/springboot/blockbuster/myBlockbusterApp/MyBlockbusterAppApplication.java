package qa.andrew.springboot.blockbuster.myBlockbusterApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class MyBlockbusterAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyBlockbusterAppApplication.class, args);
	}
}
