import java.util.*;

public class Chocola {
    public static void main(String[]args){
        Integer[] ver={4,1,3,2,1};
        Integer[] hor={2,1,4};
        Arrays.sort(ver,Collections.reverseOrder());
        Arrays.sort(hor,Collections.reverseOrder());
        for(int i=0;i<ver.length;i++){
            System.out.print(ver[i]+" ");
        }
        System.out.println();
        for(int i=0;i<hor.length;i++){
            System.out.print(hor[i]+" ");
        }
        System.out.println();
        int h=0;
        int v=0;
        int hp=1,vp=1;
        int cost=0;
        while(h<hor.length && v<ver.length){
            if(hor[h]<=ver[v]){
                cost+=hp*ver[v];
                vp++;
                v++;
            }else{
                cost+=vp*hor[h];
                hp++;
                h++;
            }
        }
        while(h<hor.length){
            cost+=vp*hor[h];
            hp++;
            h++;
        }
        while(v<ver.length){
            cost+=hp*ver[v];
            vp++;
            v++;
        }
        System.out.println("Minimum cost is "+cost);
    }
}
