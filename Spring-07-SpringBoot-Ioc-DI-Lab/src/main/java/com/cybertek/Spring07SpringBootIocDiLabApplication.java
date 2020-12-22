package com.cybertek;

import com.cybertek.calculator.Calculator;
import com.cybertek.enums.City;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Spring07SpringBootIocDiLabApplication {

	public static void main(String[] args) throws Exception {

		ApplicationContext context = SpringApplication.run(Spring07SpringBootIocDiLabApplication.class, args);

		Calculator calculator = context.getBean("calculator", Calculator.class);

		System.out.println(calculator.getTotalCarpetCost(City.AUSTIN));
	}

}
