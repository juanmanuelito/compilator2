/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.compilator.reader;

import com.compilator.analizer.Analizer;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 *
 * @author jmendieta
 */
public class Reader {

    String fileName = null;
    Analizer analizer = null;

    public Reader(String fileName, Analizer analizer) {
        this.fileName = fileName;
        this.analizer = analizer;
    }

    public void readFile() {
        try {
			Path path = Paths.get(this.fileName);
    		String stringFromFile = new String(
            java.nio.file.Files.readAllBytes(path));
			System.out.println(stringFromFile);
			this.analizer.analizeFile(stringFromFile);
        } catch (Exception e) {
			e.printStackTrace();
            System.out.println(e.getMessage());
            System.out.println("Error al leer el archivo ...");
        }
    }
}
