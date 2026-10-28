class Pair{
    int x;
    int y;
    int z;
    Pair(int x,int y,int z){
        this.x=x;
        this.y=y;
        this.z=z;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int fresh=0;
        Queue<Pair> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    q.add(new Pair(i,j,0));
                }else if(grid[i][j]==1){
                    fresh++;
                }
            }
        }
        int ans=0;
        while(!q.isEmpty()){
            Pair p=q.remove();
            int i=p.x;
            int j=p.y;
            int t=p.z;
            ans=Math.max(ans,t);
            if(i-1>=0 && grid[i-1][j]==1){
                fresh--;
                grid[i-1][j]=2;
                q.add(new Pair(i-1,j,t+1));
            }
            if(i+1<n && grid[i+1][j]==1){
                fresh--;
                grid[i+1][j]=2;
                q.add(new Pair(i+1,j,t+1));
            }
            if(j-1>=0 && grid[i][j-1]==1){
                fresh--;
                grid[i][j-1]=2;
                q.add(new Pair(i,j-1,t+1));
            }
            if(j+1<m && grid[i][j+1]==1){
                fresh--;
                grid[i][j+1]=2;
                q.add(new Pair(i,j+1,t+1));
            }
        }
        if(fresh==0) return ans;
        return -1;
    }
}