package com.twister;

import java.io.*;

public class SmallestSubstring {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        String S = br.readLine();

        int out_ = SmallestSubString(S);
        wr.println(out_);

        wr.close();
        br.close();
    }

    private static int SmallestSubString(String text) {
        text = text.toLowerCase();
        String distinct = distinctChar(text);
        for(int i=distinct.length(); i<=text.length(); i++){
            for(int j=0; (j+i)<=text.length();j++) {
                String temp = text.substring(j, j + i);
                if (containAllDistinctChar(temp, distinct)) {
                    return temp.length();
                }
            }
        }
        return text.length();
    }

    private static boolean containAllDistinctChar(String text, String dis){
        for(char c : dis.toCharArray()){
            if(!text.contains(c+""))
                return false;
        }
        return true;
    }

    private static String distinctChar(String text){
        char[] charArr = text.toCharArray();
        StringBuilder uniChar = new StringBuilder();
        for (char c : charArr) {
            if (uniChar.indexOf(c+"") == -1) {
                uniChar.append(c);
            }
        }
        return new String(uniChar);
    }
}
