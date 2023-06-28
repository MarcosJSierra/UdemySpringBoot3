package org.kurokami.util;

import java.io.File;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public class Utileria {
    public static String guardarArchivo(MultipartFile multipartFile, String ruta) {
        String nombreOriginal = multipartFile.getOriginalFilename();
        try{
            File imageFile = new File(ruta + nombreOriginal);
            System.out.println("Archivo: " + imageFile.getAbsolutePath());
            multipartFile.transferTo(imageFile);
            return nombreOriginal;
            
        } catch (IOException e){
            return null;
        }
    }
}
