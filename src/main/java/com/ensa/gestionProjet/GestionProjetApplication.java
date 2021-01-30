package com.ensa.gestionProjet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan("entities")
@SpringBootApplication
public class GestionProjetApplication {

    public static void main(String[] args) {
        SpringApplication.run(GestionProjetApplication.class, args);
    }

}
