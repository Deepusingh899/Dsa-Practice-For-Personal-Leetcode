import java.util.Arrays;

public class Knapsack {

    public static void main (String[] args){
        int[] value={100,120,100};
        int[] weight={60,10,30};
        int W=50;
        System.out.println("Maximums value in Knapsack = " + maximumValue(value,weight,W));
    }
    public static double maximumValue(int[] value,int[] weight,int W){
        int n = value.length;
        double ratio[][]=new double[n][2];
        for(int i=0;i<n;i++){
            ratio[i][0]=i;
            ratio[i][1]= (double) value[i] / weight[i];
        }
        Arrays.sort(ratio, (a, b) -> Double.compare(b[1], a[1]));
        double maxValue=0;
        for(int i=0;i<n;i++){
            int k=(int) ratio[i][0];
            if(weight[k]<W){
                maxValue+=value[k];
                W-=weight[k];
            }else{
                System.out.println("Weight of item " + k + " is greater than remaining capacity. Taking fraction of it.");
                maxValue+=W*ratio[i][1];
                W=0;
                break;
            }
        }
        return maxValue;
    }
    
}
