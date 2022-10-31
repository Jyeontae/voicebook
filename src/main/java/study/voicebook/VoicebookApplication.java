package study.voicebook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


import javax.persistence.EntityManager;

@EnableJpaAuditing
@SpringBootApplication
public class VoicebookApplication {

	@Autowired
	EntityManager em;

	public static void main(String[] args) {
		SpringApplication.run(VoicebookApplication.class, args);

	}
}
