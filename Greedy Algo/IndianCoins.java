import java.util.Arrays;

public class IndianCoins {
    public static void main(String[] args){
        int [] coins={1,2,5,10,20,50,100,200,500,2000};
        int amount=569;
        System.out.println("Minimum number of coins required is "+findMinCoins(coins,amount));
    }
    public static int findMinCoins(int [] coins, int amount){
        Arrays.sort(coins);
        int count=0;
        int i=coins.length-1;
        while(i>=0){
            if(coins[i]<=amount){
                count++;
                amount-=coins[i];
            }else{
                i--;
            }
            // System.out.println(coins[i]+" "+amount);
            if(amount==0) break;
            // System.out.println(coins[i]+" "+amount);
        }
        return amount==0 ? count : -1;
    }
}