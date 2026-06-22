class Solution {
    public boolean isValidSudoku(char[][] board) {

        HashSet<Character>[] rows = new HashSet[9];
        HashSet<Character>[] cols = new HashSet[9];
        HashSet<Character>[] boxes = new HashSet[9];

        for(int i = 0; i<9; i++){
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        for(int i = 0; i<9; i++){
            for(int j = 0; j<9; j++){
                char currentVal =  board[i][j];

                if(currentVal == '.'){
                    continue;
                }

                int boxesIndex = ((i/3)*3 + (j/3));

                if(rows[i].contains(currentVal) ||
                   cols[j].contains(currentVal) ||
                   boxes[boxesIndex].contains(currentVal)){
                    
                    return false;
                   }

                rows[i].add(currentVal);
                cols[j].add(currentVal);
                boxes[boxesIndex].add(currentVal);
            }
        }
        return true;
        
    }
}
