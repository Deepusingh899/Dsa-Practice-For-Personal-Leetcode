package Stack;
import java.util.Stack;
public class Stocks {
    public static void calculateSpan(int[]stocks,int span[]){
        Stack<Integer> s=new Stack<>();
        span[0]=1;
        s.push(0);
        for(int i=1;i<stocks.length;i++){
            int currentPrice=stocks[i];;
            while(!s.isEmpty() && stocks[s.peek()]<= currentPrice){
                s.pop();
            }
            if(s.isEmpty()){
                span[i]=i;
            }else{
                span[i]=i-s.peek();;
                // s.push(i);
            }
            s.push(i);
        }
    
    }
    public static void main(String[]args){
        int[] stocks={100,80,60,70,60,85,100};
        int [] span=new int[stocks.length];
        calculateSpan(stocks,span);
        for(int i=0;i<span.length;i++){
            System.out.println(span[i]);
        }
    }
    
    
}
