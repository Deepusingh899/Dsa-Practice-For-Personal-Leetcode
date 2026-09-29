import java.util.ArrayList;
import java.util.Collections;

public class JobSequencing{
    public static class Job{
        int id;
        int deadline;
        int profit;
        Job(int id,int deadline,int profit){
            this.id=id;
            this.deadline=deadline;
            this.profit=profit;
        }
    }
    public static void main(String[]args){
        int[][] arr ={{4,1},{1,2},{1,3},{1,4},{1,5}};
        ArrayList<Job> jobs=new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            jobs.add(new Job(i,arr[i][0],arr[i][1]));
        }
        Collections.sort(jobs,(a,b)->b.profit-a.profit);
        int maxDeadline=0;
        ArrayList<Integer> seq=new ArrayList<>();
        for(int i=0;i<jobs.size();i++){
            Job jobss=jobs.get(i);
            if(maxDeadline<jobss.deadline){
                seq.add(jobss.id);
                maxDeadline++;
            }
        }
        for(int i=0;i<seq.size();i++){
            System.out.print(seq.get(i)+" ");
        }
    }
}