/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.compilator.analizer;

import com.compilator.generator.CodeGenerator;
import com.compilator.objects.ObjectClass;
import com.compilator.objects.ObjectFunction;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jmendieta
 */
public class Analizer implements AnalizerConstants {

    ObjectFunction generalScope =  new ObjectFunction();
    List<String> clases = null;
    String fileContent = null;
    CodeGenerator generator = new CodeGenerator();
    List<ObjectClass> objectClases = new ArrayList<>();

    public List<String> getMatches(String text, String regx, boolean update) {
        List<String> allMatches = new ArrayList<String>();
        
        Matcher m = Pattern.compile(regx)
                .matcher(text);
        while (m.find()) {
            String group = m.group();
            if (!group.equals("")) {
                allMatches.add(group);
            }
        }
        if (update) {
            fileContent = fileContent.replaceAll(regx, "");
        }
        return allMatches;
    }

    public String getFirstMatch(String text, String regx, boolean update) {
        Matcher m = Pattern.compile(regx)
                .matcher(text);
        if (m.find()) {
            return m.group();
        }
        return new String("");
    }
    
    public void validateSintax(String fromFile) throws Exception{
        String file = fromFile;
        if(getMatches(file, definitios, true).size()+
            getMatches(file, functions, true).size()+
            getMatches(file, structures, true).size() == 
            getMatches(file, "end", true).size()){
            getMatches(file, sentences, true);
            getMatches(file, callers, true);
        }
        if(!fileContent.trim().equals("")){
            int i =0;
            for(String line: fileContent.split(System.getProperty("line.separator"))){
                if(i++ > 0 && !line.trim().equals("")) {
                    System.out.println("error en la linea "+i);
                    throw new Exception("sintax error");
                }
            }
        }
        else System.out.println("archivo bien formado");
        this.fileContent= file;
            
    }

    public void analizeFile(String stringFromFile) throws Exception {
        this.fileContent = stringFromFile;
        validateSintax(stringFromFile);
        clases = getMatches(fileContent, clasesRegx, true);
        analizeClases(clases);
        List<String> sentences = getMatches(fileContent, clasesRegx, true);
    }

    public void analizeClases(List<String> clases) throws FileNotFoundException, UnsupportedEncodingException, IOException {
        for (String classContent : clases) {
            ObjectClass objectClass = new ObjectClass();
            objectClass.setName(getFirstMatch(classContent, className, false).trim());
            List<String> functions = getMatches(classContent, functionRegx, false);
            analizeFunctions(functions, objectClass);
            classContent = classContent.replaceAll(functionRegx, "");
            objectClass.setDefinitions((ArrayList<String>) getMatches(classContent, classDefs, false));
            objectClases.add(objectClass);
        }
		this.generalScope.setContent(generator.refactorCode(this.fileContent));
        this.build();
    }

    public void analizeFunctions(List<String> functions, ObjectClass objectClass) {
        for (String function : functions) {
            ObjectFunction funtionObj = new ObjectFunction();
            funtionObj.setContent(generator.refactorCode(function));
            objectClass.addfunction(funtionObj);
        }
    }
    public void build() throws FileNotFoundException, UnsupportedEncodingException, IOException{
        for(ObjectClass object: objectClases){	
            object.build();
		}
		Path path = Paths.get("config/Generated.java");
		String stringFromFile = new String(
		java.nio.file.Files.readAllBytes(path));
		writeInfile("code/Generated.java",String.format(stringFromFile, "",this.generalScope.getContent()));	
    }
	public void writeInfile(String path,String text) 
			throws FileNotFoundException, UnsupportedEncodingException{
		PrintWriter writer = new PrintWriter(path, "UTF-8");
        writer.print(text);
        writer.close();
	}
}
