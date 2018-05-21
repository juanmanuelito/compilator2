/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.compilator.generator;

import static com.compilator.generator.CodeConstants.remplacement;
import static com.compilator.generator.CodeConstants.target;
import static com.compilator.generator.CodeConstants.type;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author jmendieta
 */
public class CodeGenerator implements CodeConstants {

    public String refactorCode(String code) {
        if (code == null) {
            return "";
        }
        for (int i = 0; i < target.size(); i++) {
            Matcher m = Pattern.compile(target.get(i)).matcher(code);
            int j = 0;
            while (m.find()) {
                for (j = 0; j < type.get(i).size(); j++) {
                    int jp = type.get(i).size() > 1 ? j + 1 : j;
                    if (type.get(i).get(j).equals("add")) {
                        code = code.replace(m.group(jp),
                                m.group(jp) + remplacement.get(i).get(j));
                    } else if (type.get(i).get(j).equals("replace")) {
                        code = code.replace(m.group(jp),
                                remplacement.get(i).get(j));
                    }

                }
            }

        }
        return code;
    }
}
