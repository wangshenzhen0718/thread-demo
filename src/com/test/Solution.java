package com.test;

import java.util.*;

class Solution {
    public static void main(String[] args) {
       int[] nums = {1,1,1,2,2,3};
      String[]  strs = {"eat", "tea", "tan", "ate","nat", "bat"};
        groupAnagrams(strs);

    }
    public static int[] topKFrequent(int[] nums, int k) {
        int[] result=new int[k];
        HashMap<Integer,Integer> map=new HashMap();
        for(int i:nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((o1, o2) -> {
            return o1.getValue()-o2.getValue();
        });
        for (Map.Entry<Integer, Integer> entry : entries) {
            queue.offer(entry);
            if (queue.size()>k){
                queue.poll();
            }

        }
        for (int i=k-1;i>=0;i--){
            result[i]=queue.poll().getKey();

        }

        System.out.println(map.values());
        return result;
        

    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map=new HashMap();
        for(String s:strs){
            char[] ch=s.toCharArray();
            Arrays.sort(ch);
            String key=String.valueOf(ch);
            if(!map.containsKey(key))map.put(key,new ArrayList());
            map.get(key).add(s);
            Set<String> keySet = map.keySet();
            for (String s1 : keySet) {

            }
        }
        System.out.println(map.values());
        return new ArrayList(map.values());



    }
}