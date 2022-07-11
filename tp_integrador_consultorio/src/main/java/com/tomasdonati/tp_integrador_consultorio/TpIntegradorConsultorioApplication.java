package com.tomasdonati.tp_integrador_consultorio;

import org.apache.log4j.PropertyConfigurator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TpIntegradorConsultorioApplication {

	public static void main(String[] args) {
		PropertyConfigurator.configure("log4j.properties");
		SpringApplication.run(TpIntegradorConsultorioApplication.class, args);
	}
}
