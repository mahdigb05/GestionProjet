package com.ensa.Utils;

import com.ensa.exceptions.FileAdditionFailedException;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class UtilMethodes {
    public static String uploadDir = System.getProperty("user.dir")+"/uploadedDocs";
    public static String sauvegarderFichier(MultipartFile file){
        File fichier = new File(uploadDir,file.getOriginalFilename());
        Path chemin = Paths.get(fichier.getAbsolutePath());
        try{
            Files.write(chemin,file.getBytes());
        }
        catch (IOException e){
            throw new FileAdditionFailedException("fichier n’a pas pu être enregistré ");
        }
        return fichier.getAbsolutePath();
    }

}
