package com.facebook;

public class ValidWordAbbreviation {
    public boolean validWordAbbreviation(String word, String abbr) {
        int i =0, j=0;
        while(i<word.length() && j<abbr.length()){
            if(word.charAt(i)==abbr.charAt(j)){
                i++;
                j++;
            }else if(abbr.charAt(j) > '0' && abbr.charAt(j) <='9'){
                int start = j;
                while(j<abbr.length() && Character.isDigit(abbr.charAt(j))){
                    j++;
                }
                i += Integer.valueOf(abbr.substring(start, j));
            }else{
                return false;
            }
        }
        return (i==word.length() &&  j==abbr.length());
    }
    public static void main(String ar[]){
        ValidWordAbbreviation va = new ValidWordAbbreviation();
        String s = "internationalization";
        String abbr = "i12iz4n";
        System.out.println(va.validWordAbbreviation(s, abbr));
    }
}
