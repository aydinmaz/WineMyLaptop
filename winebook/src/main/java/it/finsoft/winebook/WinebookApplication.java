package it.finsoft.winebook;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;

@SpringBootApplication
@EnableAutoConfiguration(exclude = ErrorMvcAutoConfiguration.class)
public class WinebookApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(WinebookApplication.class, args);
	}

	public void run(String... arg0) throws Exception {

	}

}
