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
	final String clasesRegx = "(class\\s+\\w+(\\s*|\\s*\\n*)((\\s*|\\n*)(.*?)(\\s*|\\n*))*(((private|public|)\\s*)(int|string|bool|float)(.*))*((function\\s+\\w*(\\(\\)|\\((.*)\\))(\\s*|\\n*)((\\s*\\n*).*?(\\s*\\n*))*(\\s*|\\n*)end)+)*(\\s*|\\s*\\n*)end)*";
	final String className = "(?<=class|function)\\s*\\w+\\s*(?=(\\s*|\\s*\\n*\\s*))";
	final String functionRegx = "(function\\s+\\w*(\\(\\)|\\((.*)\\))(\\s*|\\n*)((\\s*\\n*).*?(\\s*\\n*))*(\\s*|\\n*)end)+";
	final String classDefs = "((private|public|)\\s*)(int|string|bool|float)(.*)";
        final String imports = "import\\b \\w|import\\b \\'.*\\'|import\\b \\\".*\\\"";
        final String definitios = "class\\s+\\w+\\s+(?:extends|implement)\\s+\\w+|class\\s+\\w+";
        final String sentences = "(?:private\\s|public\\s|)(?:int|bool|string)((?!;).)*";
        final String callers = "\\w+\\s+=\\s+new\\s+\\w+\\(.*\\)|\\w+\\.\\w+\\(.*\\)|\\w+\\(.*\\)";
        final String functions = "function\\s*\\w+\\s*\\(.*?\\)";
        final String structures = "(?:if|while|for|switch)\\s*\\(.*?\\)";
	
}
