package Recursion;
import java.util.Arrays;

class NQueens{
    public static void main(String[] args){
        int n=4;
        possibleQueens(n);
    }

    public static void possibleQueens(int n){
        String[][] arr=new String[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(arr[i], ".");
        }
        // String[][] ans=new String[n][n];
        sitNqueens(arr,0,n);
    }
    public static void sitNqueens(String[][] arr,int row,int n){
        if(row==n){
            print(arr);
            return;
        }

        for(int i=0;i<n;i++){
            if(isValid(arr,row,i,n)){
                arr[row][i]="Q";
                sitNqueens(arr,row+1,n);
                arr[row][i]=".";
            }
        }
    }
    public static boolean isValid(String[][] arr,int row,int col,int n){
        for(int i=row;i>=0;i--){
            if(arr[i][col]=="Q") return false;
        }
        for(int i=row,j=col;i>=0 && j<n;i--,j++){
            if(arr[i][j]=="Q") return false;
        }
        for(int i=row,j=col;i>=0 && j>=0;i--,j--){
            if(arr[i][j]=="Q") return false;
        }
        return true;
    }
    public static void print(String[][] arr){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}