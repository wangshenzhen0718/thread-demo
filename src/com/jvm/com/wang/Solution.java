package com.jvm.com.wang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        final String[] strings=new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        for (String string : strings) {

            char[] chars = string.toCharArray();
            System.out.println(chars);
        }

    }
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map=new HashMap<>();
        for(String str:strs){
            char[] ch=str.toCharArray();
            System.out.println(ch);
            Arrays.sort(ch);
            String key=String.valueOf(ch);
            if(!map.containsKey(key))
                map.put(key,new ArrayList<>());
                map.get(key).add(str);
            
        }
        return new ArrayList<>(map.values());
        


    }

}