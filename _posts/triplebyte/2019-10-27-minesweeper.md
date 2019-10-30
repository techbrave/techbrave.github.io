# MineSweeper

[LC](https://leetcode.com/problems/minesweeper/)

[Official page](https://techdevguide.withgoogle.com/resources/coding-question-minesweeper/)

```java
class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        int i = click[0]; int j = click[1]; 
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) return board; 
        reveal(board, i, j); 
        return board;
    }
    
    private void reveal(char[][] board, int i, int j) {
        if (board[i][j] != 'M'  && board[i][j] != 'E') return; // already been reveal
        if (board[i][j] == 'M') {
            board[i][j] = 'X'; 
            return; 
        }
        // most interesting 'E'
        int numOfMines = 0;
        for (int k = 0; k < dx.length; k++) {
            int ni = i + dx[k]; int nj = j + dy[k]; 
            if (ni < 0 || ni >= board.length || nj < 0 || nj >= board[0].length) continue; // illegal
            if (board[ni][nj] == 'M')  numOfMines++;
        }
        if (numOfMines == 0) board[i][j] = 'B';
        else board[i][j] = (char) ('0' + numOfMines); 

        if (board[i][j] == 'B') {
            for (int k = 0; k < dx.length; k++) {
                int ni = i + dx[k]; int nj = j + dy[k]; 
                if (ni < 0 || ni >= board.length || nj < 0 || nj >= board[0].length) continue; // illegal
                if (board[ni][nj] == 'E')  reveal(board, ni, nj);
            }
        }
    }
    
    private int[] dx = new int[]{-1, -1, -1, 0, 0, 1, 1, 1}; 
    private int[] dy = new int[]{-1, 0, 1, -1, 1, -1, 0, 1};
}
```