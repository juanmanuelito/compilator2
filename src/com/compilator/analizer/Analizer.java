/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.compilator.analizer;

import com.compilator.generator.CodeGenerator;
import com.compilator.objects.ObjectClass;
import com.compilator.objects.ObjectFunction;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jmendieta
 */
public class Analizer implements AnalizerConstants {

    Object generalScope;
    Object currentScope = null;
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
            System.out.println("actualiza");
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
    
    public void validateSintax(String fromFile){
        String file = fromFile;
        if(getMatches(file, definitios, true).size()+
            getMatches(file, functions, true).size()+
            getMatches(file, structures, true).size() == 
            getMatches(file, "end", true).size()){
            System.out.println("entra");
            getMatches(file, sentences, true);
            getMatches(file, callers, true);
        }
            System.out.println(fileContent);
        if(!fileContent.trim().equals("")){
            int i =0;
            System.out.println(fileContent.split(System.getProperty("line.separator")).length);
            for(String line: fileContent.split(System.getProperty("line.separator"))){
                if(i++ > 0 && !line.trim().equals("")) System.out.println("error en la linea "+i);
                System.out.println("linea "+i);
            }
        }
        else System.out.println("archivo bien formado");
        this.fileContent= file;
            
    }

    public void analizeFile(String stringFromFile) {
        this.fileContent = stringFromFile;
        validateSintax(stringFromFile);
        clases = getMatches(fileContent, clasesRegx, true);
        analizeClases(clases);
    }

    public void analizeClases(List<String> clases) {
        for (String classContent : clases) {
            ObjectClass objectClass = new ObjectClass();
            objectClases.add(objectClass);
            objectClass.setName(getFirstMatch(classContent, className, false).trim());
            List<String> functions = getMatches(classContent, functionRegx, false);
            analizeFunctions(functions, objectClass);
            classContent = classContent.replaceAll(functionRegx, "");
            objectClass.setDefinitions((ArrayList<String>) getMatches(classContent, classDefs, false));
            objectClases.add(objectClass);
        }
    }

    public void analizeFunctions(List<String> functions, ObjectClass objectClass) {
        for (String function : functions) {
            ObjectFunction funtionObj = new ObjectFunction();
            funtionObj.setContent(generator.refactorCode(function));
            objectClass.addfunction(funtionObj);
        }
    }
    public void build(){
        for(ObjectClass object: objectClases)
            object.build();
    }
}
