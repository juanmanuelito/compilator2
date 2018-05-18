/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.compilator.generator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author jmendieta
 */
public class CodeUtils implements CodeConstants {
	public String refactorCode(String code){
		if(code == null) return "";
		for(int i = 0;i < target.size();i++){
			Matcher m = Pattern.compile(target.get(i)).matcher(code);	
			boolean find = m.find();
			int j = 0;
			for(j = 0;j < type.get(i).size();j++){
				int jp = type.get(i).size() > 1 ? j+1 : j ;	
				if(find){
					if(type.get(i).get(j).equals("add"))
						code = code.replace(m.group(jp),
							m.group(jp).trim()+remplacement.get(i).get(j));
					else if(type.get(i).get(j).equals("replace"))
						code = code.replace(m.group(j+1),
							remplacement.get(i).get(j));
				}	
			}
		}
		return code;
	}	
}
