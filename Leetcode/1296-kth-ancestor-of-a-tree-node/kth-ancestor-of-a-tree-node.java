class TreeAncestor {
    int LOG=17;
    int[][] up;;

    public TreeAncestor(int n, int[] parent) {
        up=new int[n][LOG];
        //base case
        for(int i=0; i<n; i++){
            up[i][0]=parent[i];
        }

        //fill table
        for(int j=1; j<LOG; j++){
            for(int i=0; i<n; i++){
                if(up[i][j-1] != -1){  //if previous ancestor exists 
                    up[i][j]= up[ up[i][j-1] ][j-1];//ex: up[3][1]=0 -> up[0][0]= -1
                }else{
                    up[i][j]= -1; //no ancestor exists
                }
            }
        }
    }
    
    public int getKthAncestor(int node, int k) {
        
        for(int j=0; j<LOG; j++){
            if((k & (1<<j)) != 0){ //ex: k=5 -> binary=(101) -> 4+1 steps
                                 //(k & (1<<0))=(101 & 001)= 001 =1 (true)  
                                 //(k & (1<<1))=(101 & 010)= 000 =0 (false)
                                 //(k & (1<<2))=(101 & 100)= 100 =4 (true)
                node= up[node][j]; //jump 2^j steps upward
                if(node == -1) return -1; //if we reach above root
            }
        }
        return node;
    }
}

/**
 * Your TreeAncestor object will be instantiated and called as such:
 * TreeAncestor obj = new TreeAncestor(n, parent);
 * int param_1 = obj.getKthAncestor(node,k);
 */