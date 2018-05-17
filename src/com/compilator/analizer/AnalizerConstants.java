/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.compilator.analizer;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author jmendieta
 */
public interface AnalizerConstants {
	final String clasesRegx = "(class\\s+\\w+(\\s*|\\s*\\n*)((\\s*|\\n*)(.*?)(\\s*|\\n*))*(function\\s+\\w*\\((.*)\\)(\\s*|\\n*)(.*?)(\\s*|\\n*)end)(\\s*|\\s*\\n*))*end";
	final String className = "(?<=class)\\s+\\w+\\s(?=(\\s*|\\s*\\n*\\s*))";
	final String functionRegx = "(function\\s+\\w*(\\(\\)|\\((.*)\\))(\\s*|\\n*)((\\s*\\n*).*?(\\s*\\n*))*(\\s*|\\n*)end)+";
	final String classDefs = "((private|public|)\\s*)(int|string|bool|float)(.*)";
	
}
