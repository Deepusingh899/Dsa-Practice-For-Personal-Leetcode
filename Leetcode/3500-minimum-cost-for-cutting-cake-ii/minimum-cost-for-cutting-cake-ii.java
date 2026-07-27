class Solution {
    public long minimumCost(int m, int n, int[] horizontalCut, int[] verticalCut) {
        Arrays.sort(verticalCut);
        Arrays.sort(horizontalCut);
        int h=horizontalCut.length-1;
        int v=verticalCut.length-1;
        int hp=1,vp=1;
        long cost=0;
        while(h>=0 && v>=0){
            if(horizontalCut[h]<=verticalCut[v]){
                cost+=hp*verticalCut[v];
                vp++;
                v--;
            }else{
                cost+=vp*horizontalCut[h];
                hp++;
                h--;
            }
        }
        while(h>=0){
            cost+=vp*horizontalCut[h];
            hp++;
            h--;
        }
        while(v>=0){
            cost+=hp*verticalCut[v];
            vp++;
            v--;
        }
        return cost;
    }
}