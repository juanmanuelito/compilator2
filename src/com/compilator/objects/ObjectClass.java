/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.compilator.objects;

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

    
    public void build() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
