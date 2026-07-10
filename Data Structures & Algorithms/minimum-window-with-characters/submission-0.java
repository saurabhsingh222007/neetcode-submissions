class Solution {
    public String minWindow(String s, String t) {

        if(s == null || t == null || s.length() < t.length()){
            return "";
        }

        HashMap<Character, Integer> storeT = new HashMap<>();

        for(char c : t.toCharArray()){
            storeT.put(c , storeT.getOrDefault(c, 0)+1);
        }

        int required = storeT.size();

        HashMap<Character, Integer> windowCounts = new HashMap<>();

        int formed = 0;
        int left = 0;

        int[] ans = {-1, 0, 0};

        for(int right = 0; right<s.length(); right++){
            char c = s.charAt(right);

            windowCounts.put(c, windowCounts.getOrDefault(c, 0)+1);

            if(storeT.containsKey(c) && windowCounts.get(c).intValue() == storeT.get(c).intValue()){
                formed++;
            }

            while(left<= right && formed == required){
                c = s.charAt(left);

                int windowLen = right - left + 1;

                if(ans[0] == -1 || windowLen < ans[0]){
                    ans[0] = windowLen;
                    ans[1] = left;
                    ans[2] = right;
                }

                windowCounts.put(c,windowCounts.get(c) -1 );

                if(storeT.containsKey(c) && windowCounts.get(c).intValue() < storeT.get(c).intValue() ){
                    formed--;
                }
                left++;
            }
        }

        return ans[0] == -1? "" : s.substring(ans[1], ans[2]+1);
        
    }
}
