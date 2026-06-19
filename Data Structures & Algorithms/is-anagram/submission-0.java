class Solution {
    public boolean isAnagram(String s, String t) {
    HashMap <Character, Integer> word1 = new HashMap<>();
    HashMap <Character, Integer> word2 = new HashMap<>();

    for (int i = 0; i<s.length();i++){
        char ch = s.charAt(i);
        word1.put(ch, word1.getOrDefault(ch , 0)+1);
    }

     for (int i = 0; i<t.length();i++){
        char ch = t.charAt(i);
        word2.put(ch, word2.getOrDefault(ch , 0)+1);
    }
 
     return word1.equals(word2);
    }
}
