package task49;

/*
    DESCRIPTION:
    Complete the method/function so that it converts dash/underscore delimited words into camel casing.
    The first word within the output should be capitalized only if the original word was capitalized
    (known as Upper Camel Case, also often referred to as Pascal case).
     The next words should be always capitalized.

    Examples
    "the-stealth-warrior" gets converted to "theStealthWarrior"

    "The_Stealth_Warrior" gets converted to "TheStealthWarrior"

    "The_Stealth-Warrior" gets converted to "TheStealthWarrior"
 */

import org.apache.commons.lang3.StringUtils;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Solution{

    static String toCamelCase(String s){
        if (s.indexOf("-")==-1 && s.indexOf("_")==-1)
            return s;
        else
            return s.substring(0,index(s)) + Arrays.stream(s.substring(index(s)).split("-|_"))
                    .map(w ->  StringUtils.capitalize(w))
                    .collect(Collectors.joining(""));
    }

    static int index(String s){
        int indexOf1=s.indexOf("-");
        int indexOf2=s.indexOf("_");
        if (indexOf1!=-1)
            if (indexOf2!=-1)
                if (indexOf1<indexOf2)
                    return indexOf1;
                else return indexOf2;
            else
                return indexOf1;
        return indexOf2;
    }
}
