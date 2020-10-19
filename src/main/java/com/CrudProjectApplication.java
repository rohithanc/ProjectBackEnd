package com.example.crudProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.crudProject.service.PlayersService;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class CrudProjectApplication {

	public static void main(String[] args) {
		//new CrudController(new PlayersService(null));
		SpringApplication.run(CrudProjectApplication.class, args);
		/*ApplicationContext ac =SpringApplication.run(SpringExampleApplication.class, args);
		System.out.println(ac.getBean(PlayersService.class));
		*/
	}
}
