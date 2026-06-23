package Recursion;
public class TowerOfHanoi {
    public static void main(String [] args){
        hanoi(5,'A','B','C');
    }
    public static void hanoi(int n,char A,char B,char C){
        if(n==0) return;
        hanoi(n-1,A,C,B); //A to B via C
        System.out.println(A+ "->" +C); // Print Larget A to C
        hanoi(n-1,B,A,C); //B to C via A

    }
    
}
