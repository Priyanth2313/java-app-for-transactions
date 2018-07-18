package com.pri.HCLTransactionPri;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@ComponentScan(basePackages="com.pri")
@EntityScan(basePackages= {"com.pri.java.entity"})
@EnableJpaAuditing
public class HclTransactionPriApplication {

	public static void main(String[] args) {
		SpringApplication.run(HclTransactionPriApplication.class, args);
	}
}
