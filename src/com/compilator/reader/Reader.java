/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.compilator.reader;

import com.compilator.analizer.Analizer;
import java.io.File;
import java.nio.file.Files;
import java.util.Scanner;

/**
 *
 * @author jmendieta
 */
public class Reader {
	String fileName = null;
	Analizer analizer = null;
	public Reader(String fileName,Analizer analizer) {
		this.fileName = fileName;
		this.analizer = analizer;
	}	
	public void readFile(){	
		try{
			File file = new File(this.fileName);
			Scanner input = new Scanner(file); 
			int count = 0;
			while (input.hasNext()) {
			  String word  = input.next();
			  this.analizer; 
			  count = count + 1;
			}
			System.out.println("Word count: " + count);
		}catch(Exception e){
			System.out.println("Error al leer el archivo ...");
		}
	}	
}
