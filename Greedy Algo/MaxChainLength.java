import java.util.Arrays;
import java.util.Comparator;

public class MaxChainLength {
    public static void main(String[]args){
        int [][]pairs={{5,24},{15,25},{27,40},{50,60}};
        System.out.println("Maximum length of chain is " + findLongestChain(pairs));
    }
    public static int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs,Comparator.comparingDouble((a)->a[1]));
        // for(int i=0;i<pairs.length;i++){
        //     for(int j=0;j<pairs[0].length;j++){
        //         System.out.print(pairs[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        int maxChain=1;
        int lastPair=pairs[0][1];
        for(int i=1;i<pairs.length;i++){
            if(pairs[i][0]>lastPair){
                maxChain++;
                lastPair=pairs[i][1];
            }
        }
        return maxChain;
        
    }
}
