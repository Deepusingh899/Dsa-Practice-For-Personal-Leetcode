package Array;

import java.util.Scanner;
// Bruteforce Solution with O(1) space but O((n*m)*(n+m)*(n*m)) which is nearly O(n^3)
// class Solution {
//     public void setRow(int i,int m,int[][] matrix){
//         for(int j=0;j<m;j++){
//             matrix[i][j]=-1;
//         }
//     }
//     public void setCol(int j,int n,int[][] matrix){
//         for(int i=0;i<n;i++){
//             matrix[i][j]=-1;
//         }
//     }
//     public int[][] setZeroes(int[][] matrix) {
//         int n=matrix.length;
//         int m=matrix[0].length;
//         for(int i=0;i<n;i++){
//             for(int j=0;j<m;j++){
//                 if(matrix[i][j]==0){
//                     setRow(i,n,matrix);
//                     setCol(j,m,matrix);
//                 }
//             }
//         }
//         for(int i=0;i<n;i++){
//             for(int j=0;j<m;j++){
//                 if(matrix[i][j]==-1){
//                     matrix[i][j]=0;
//                 }
//             }
//         }
//         return matrix;
        
//     }
// }

//Better Solution with O(n) space and O(nm) Time Complexity

// class Solution {
//     public int[][] setZeroes(int[][] matrix) {
//         int n=matrix.length;
//         int m=matrix[0].length;
//         int []row=new int[n];
//         int []col=new int[m];
//         for(int i=0;i<n;i++){
//             for(int j=0;j<m;j++){
//                 if(matrix[i][j]==0){
//                     row[i]=1;
//                     col[j]=1;
//                 }
//             }
//         }
//         for(int i=0;i<n;i++){
//             for(int j=0;j<m;j++){
//                 if(row[i]==1 || col[j]==1){
//                     matrix[i][j]=0;
//                 }
//             }
//         }
//         return matrix;
        
//     }
// }

//Optimised Solution with O(1) Space and O(nm) Time Complexity

class Solution {
    public int[][] setZeroes(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        int col0=-1;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]==0){
                    matrix[i][0]=0; //assigning 0 in first col;
                    if(j!=0){
                        matrix[0][j]=0; //assiging 0 in first row avoiding matrix[o][o]
                    }else{
                        col0=0; //assign one variable to track first row if i,j is having 0;
                    }
                }
            }
        }
        // solving remaining matrix apart from first row and first column
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(matrix[i][0]==0 || matrix[0][j]==0){
                    matrix[i][j]=0;
                }
            }
        }
        //solving first row
        if(matrix[0][0]==0){
            for(int j=0;j<m;j++){
                matrix[0][j]=0;
            }
        }
        //solving first column
        if(col0==0){
            for(int i=0;i<n;i++){
                matrix[i][0]=0;
            }
        }
        return matrix;
    }
}

class SetMatrixZeroes{
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int[][] matrix=new int [n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                matrix[i][j]=sc.nextInt();
            }
        }
        Solution sl=new Solution();
        int[][] arr=sl.setZeroes(matrix);
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}