package team.sipe.office;

import org.springframework.boot.SpringApplication;

public class TestOfficeApplication {

	public static void main(String[] args) {
		SpringApplication.from(OfficeApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
