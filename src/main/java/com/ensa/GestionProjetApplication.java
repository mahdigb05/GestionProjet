package com.ensa;

import com.ensa.Utils.UtilMethodes;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;


@SpringBootApplication
public class GestionProjetApplication {

    public static void main(String[] args) {
        new File(UtilMethodes.uploadDir).mkdir();
        SpringApplication.run(GestionProjetApplication.class, args);
    }

}
