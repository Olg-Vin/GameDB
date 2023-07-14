package summerProject.demo;

import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
//		(scanBasePackages={
//		"summerProject.demo.services.CharacterService", "summerProject.demo.CommandLineRunnerImpl"})
public class GameDbApplication {
	@Bean
	public ModelMapper modelMapper(){
		ModelMapper modelMapper = new ModelMapper();

		modelMapper.getConfiguration()
				.setFieldMatchingEnabled(true)
				.setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);

		return modelMapper;
	}

	public static void main(String[] args) {
		SpringApplication.run(GameDbApplication.class, args);
	}

}
