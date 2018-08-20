package com.prosay;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages={"com.prosay.mapper"})
public class Quarez0815Application {

	public static void main(String[] args) {
		SpringApplication.run(Quarez0815Application.class, args);
	}
}
