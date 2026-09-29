class Solution {
    public class Drone implements Comparable<Drone>{
            int i;
            int sum;
            Drone(int i,int sum){
                this.i=i;
                this.sum=sum;
            }

            @Override
            public int compareTo(Drone d1){
                return this.sum-d1.sum;
            }
        }
    public int nearestDrone(int[][] drones, int[] target) {
        PriorityQueue<Drone> pq=new PriorityQueue<>();
        for(int i=0;i<drones.length;i++){
            int val=Math.abs(drones[i][0]-target[0]);
            int val1=Math.abs(drones[i][1]-target[1]);
            int sum=val+val1;
            if(sum<=drones[i][2]){
                pq.add(new Drone(i,sum));
            }
        }
        
        return pq.isEmpty() ? -1 : pq.poll().i;
        
    }

}