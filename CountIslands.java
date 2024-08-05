import java.util.*;
public class CountIslands {
    public static class Edge{
        int src, nbr, wt;
        Edge(int src, int nbr, int wt){
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }
    }
    public static int numOfIslands(int board[][]){
        int count = 0;
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==0){
                    count++;
                    numOfIslandsHelper(board, i, j);
                }
            }
        }
        return count;
    }
    public static void numOfIslandsHelper(int[][] board, int r, int c){
        if(r<0 || c<0 || r>=board.length || c>=board[0].length || board[r][c]==1 || board[r][c]==2){
            return;
        }

        board[r][c]=2;
        numOfIslandsHelper(board, r-1, c);   //north
        numOfIslandsHelper(board, r, c-1);   //west
        numOfIslandsHelper(board, r, c+1);   //east
        numOfIslandsHelper(board, r+1, c);   //south
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int rows = sc.nextInt();
        int cols = sc.nextInt();

        int[][] arr = new int[rows][cols];
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println(numOfIslands(arr));
    }
}
