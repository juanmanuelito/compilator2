/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compilator;

import com.compilator.analizer.Analizer;
import com.compilator.reader.Reader;

/**
 *
 * @author jmendieta
 */
public class Compilator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
		if(args.length > 0){
			Reader a = new Reader(args[0], new Analizer());
			a.readFile();
		}else{
			throw new Error("No file name ");
		}
    }
}
