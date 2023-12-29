package com.example.demo;

import com.example.demo.entities.Framework;
import com.example.demo.repository.FrameworkRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.UUID;

@SpringBootApplication
public class DemoApplication {


	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	//@Bean
//	CommandLineRunner commandLineRunner(FrameworkRepository frameworkRepository){
//		return args -> {
//			Framework framework1 = new Framework(UUID.randomUUID().toString());
//			Framework framework2 = new Framework(UUID.randomUUID().toString());
//			frameworkRepository.save(framework1);
//			frameworkRepository.save(framework2);
//			List<Framework> all = frameworkRepository.findAll();
//			System.out.println(all);
//
//		};
//	}

}
