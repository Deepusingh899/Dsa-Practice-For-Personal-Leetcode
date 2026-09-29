import java.util.Arrays;

public class MinSumOfAbsolute {
    public static void main(String[]aregs){
        int []A={1,2,3};
        int []B={3,2,1};
        System.out.println(AbsoluteSum(A,B));
    }
    public static int AbsoluteSum(int[] A,int[] B){
        Arrays.sort(A);
        Arrays.sort(B);
        int sum=0;
        for(int i=0;i<A.length;i++){
            sum+=Math.abs(A[i]-B[i]);
        }
        return sum;
    }
}
