class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        // int[][] units=new int [boxTypes.length][3];
        // for(int k=0;k<boxTypes.length;k++){
        //     units[k][0]=k;
        //     units[k][1]=boxTypes[k][0];
        //     units[k][2]=boxTypes[k][1];
        // }
        // Arrays.sort(units,Comparator.comparingDouble((a,b)-> b[2]-a[2]));
        Arrays.sort(boxTypes,(a,b) -> b[1]-a[1]);
        // for(int i=0;i<boxTypes.length;i++){
        //     for(int j=0;j<boxTypes[0].length;j++){
        //         System.out.print(boxTypes[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        int i=0;
        int ans=0;
        while(truckSize>0 && i<boxTypes.length){
            if(boxTypes[i][0]<=truckSize){
                ans+=boxTypes[i][0]*boxTypes[i][1];
                truckSize-=boxTypes[i][0];
            }else{
                ans+=truckSize*boxTypes[i][1];
                truckSize=0;
            }
            i++;
        }
        return ans;
    }
}