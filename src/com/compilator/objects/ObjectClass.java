/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.compilator.objects;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

/**
 *
 * @author jmendieta
 */
public class ObjectClass {
    private String name;
    private ArrayList<ObjectFunction> functions = new ArrayList();
	private ArrayList<String> definitions = new ArrayList();
    
    public ObjectClass addfunction(ObjectFunction function){
		functions.add(function);
		return this;
    }

	public ObjectClass addDefinitions(String definition){
		this.definitions.add(definition);
		return this;
	}
    
    
    public Object setName(String name) {
        this.name = new String(name);
        return this;
    }

    
    public String getName() {
        return this.name;
    }

    public void setDefinitions(ArrayList<String> definitions) {
        this.definitions = definitions;
    }

    
    public void build() throws FileNotFoundException, UnsupportedEncodingException {
        PrintWriter writer = new PrintWriter(this.name+".java", "UTF-8");
        writer.println("public class "+this.name+" {");
        for(ObjectFunction function : this.functions){
            writer.append(function.getContent());
        }
        writer.println("}");
        writer.close();
    }
}
