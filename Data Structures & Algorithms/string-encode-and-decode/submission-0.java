class Solution {

    public String encode(List<String> strs) {

        StringBuilder encodeStr = new StringBuilder();

        for(String str : strs){
            encodeStr.append(str.length()).append("#").append(str);
        }
        return encodeStr.toString();

    }

    public List<String> decode(String str) {
        List<String> decodedStr = new ArrayList<>();
        int i = 0;
        while(i < str.length()){
            int j = i;
        
        while(str.charAt(j) != '#'){
            j++;
        }

        int length = Integer.parseInt(str.substring(i, j));
        String originalStr = str.substring(j + 1, j+1+length);
        decodedStr.add(originalStr);
        
        i = j+1+length;
        }

        return decodedStr;

    }
}
