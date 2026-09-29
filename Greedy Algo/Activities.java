import java.util.*;

class Activities{
    public static void main(String[]args){
        int start[]={1,3,0,5,8,5};
        int end[]={2,4,6,9,7,9};
        int[][] activities=new int[start.length][3];
        for(int i=0;i<start.length;i++){
            activities[i][0]=i;
            activities[i][1]=start[i];
            activities[i][2]=end[i];
        }
        Arrays.sort(activities,Comparator.comparingDouble(a -> a[2]));

        for(int i=0;i<activities.length;i++){
            for(int j=0;j<activities[0].length;j++){
                System.out.print(activities[i][j]+" ");
            }
            System.out.println();
        }
        int maxAct=1;
        int lastActEnd=activities[0][2];
        List<Integer> selectedActivities=new ArrayList<>();
        selectedActivities.add(activities[0][0]);
        for(int i=1;i<end.length;i++){
            if(activities[i][1]>=lastActEnd){
                maxAct++;
                lastActEnd=activities[i][2];
                selectedActivities.add(activities[i][0]);
            }

        }
        System.out.println("Maximum number of activities: " + maxAct);
        System.out.println("Selected activities: " + selectedActivities);
    }
}