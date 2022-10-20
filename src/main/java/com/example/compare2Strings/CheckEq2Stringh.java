package com.example.compare2Strings;

import java.util.List;
import java.util.regex.Pattern;

public class CheckEq2Stringh {
    public static String checkStr(String s1, String s2){
        if(s1.isEmpty() && s2.isEmpty()){
            return "";
        }else if(s1.equals(s2)){
            return "true";
        }else  {
            return "false";
        }

    }
}

