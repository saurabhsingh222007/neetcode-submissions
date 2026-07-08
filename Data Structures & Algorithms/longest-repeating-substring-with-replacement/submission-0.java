class Solution {
    public int characterReplacement(String s, int k) {

        int[] count = new int[26];
        int left = 0;
        int maxChar = 0;
        int maxLength = 0;

        for(int right = 0; right<s.length(); right++){

            count[s.charAt(right) - 'A']++;

            maxChar = Math.max(maxChar, count[s.charAt(right) - 'A']);

            if((right - left + 1) - maxChar > k){
              count[s.charAt(left) - 'A']--;
              left++;
            }

            maxLength = Math.max(maxLength, right-left + 1 );
        }

        return maxLength;
        
    }
}
