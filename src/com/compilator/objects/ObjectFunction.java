/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.compilator.objects;

import java.util.Scanner;

/**
 *
 * @author jmendieta
 */
public class ObjectFunction  {
    private String name = new String("");
    private String content = new String("");

    public void setContent(String content) {
        this.content = content;
    }

    
    public String getName() {
        return this.name;
    }

    public String getContent() {
        return content;
    }

    public void build() {
        
    }
    
}
