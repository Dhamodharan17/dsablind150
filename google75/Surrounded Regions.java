import java.util.LinkedList;
import java.util.Queue;

// Surround: The region is surrounded with 'X' cells if you can connect the region with 'X' cells and 
// none of the region cells are on the edge of the board.

// make all the node connected to boundy S using bfs with 4 directions, whatever remaining after that also flip to X
class Solution {
    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        
        int rows = board.length;
        int cols = board[0].length;
        Queue<int[]> queue = new LinkedList<>();
        
        // Add all boundary 'O's to the queue
        for (int i = 0; i < rows; i++) {
            if (board[i][0] == 'O') queue.add(new int[]{i, 0});
            if (board[i][cols - 1] == 'O') queue.add(new int[]{i, cols - 1});
        }
        for (int j = 0; j < cols; j++) {
            if (board[0][j] == 'O') queue.add(new int[]{0, j});
            if (board[rows - 1][j] == 'O') queue.add(new int[]{rows - 1, j});
        }
        
        // Perform BFS from the boundary 'O's
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            
            board[x][y] = 'S'; // Mark as safe
            
            int[] dx = {-1, 1, 0, 0};
            int[] dy = {0, 0, -1, 1};
            
            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];
                if (newX >= 0 && newX < rows && newY >= 0 && newY < cols && board[newX][newY] == 'O') {
                    queue.add(new int[]{newX, newY});
                }
            }
        }
        
        // Flip all 'O's to 'X's and 'S's back to 'O's
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'S') {
                    board[i][j] = 'O';
                }
            }
        }
    }
}
