/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compilator;

import com.compilator.analizer.Analizer;
import com.compilator.generator.CodeUtils;
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
        Reader a = new Reader("program.txt", new Analizer());
        a.readFile();
		CodeUtils utils = new CodeUtils();
		System.out.println(utils.refactorCode("int a = 10 \nif(a == c)\n puts() \nend \nif(a == b)\n puts() \nend"));
    }

}
