/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.compilator.analizer;

import com.compilator.objects.Object;
import com.compilator.objects.ObjectClass;
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

	public void analizeWord(String word) throws Exception {

	}
	public List<String> getMatches(String text,String regx,boolean update){
		List<String> allMatches = new ArrayList<String>();
		Matcher m = Pattern.compile(regx)
				.matcher(text);
		while (m.find()) {
			allMatches.add(m.group());
		}	
		if(update) fileContent = fileContent.replaceAll(regx,"");
		return allMatches; 
	}
	public String getFirstMatch(String text,String regx,boolean update){
		Matcher m = Pattern.compile(regx)
				.matcher(text);
		if(m.find()) return m.group(); 	
		return new String("");
	}
	public void analizeFile(String stringFromFile) {
		this.fileContent = stringFromFile;
		clases = getMatches(fileContent,clasesRegx,true);
		analizeClases(clases);
		System.out.println("string final");
		System.out.println(this.fileContent);
	}
	public void analizeClases(List<String> clases){
		for(String classContent: clases){
			ObjectClass objectClass = new ObjectClass();
			objectClass.setName(getFirstMatch(classContent,className, false).trim());
			List<String> functions = getMatches(classContent, functionRegx, false);
			analizeFunctions(functions, objectClass);	
			classContent = classContent.replaceAll(functionRegx, "");
			
			System.out.println(classContent);
		}
	}
	public void analizeFunctions(List<String> functions,ObjectClass objectClass){
		for(String function : functions){
			
		}	
	}
}
