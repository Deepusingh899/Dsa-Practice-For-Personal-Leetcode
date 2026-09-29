package Heap;

import java.util.ArrayList;

public class Remove {
    static class  Heap{
        ArrayList<Integer> arr=new ArrayList<>();
        public void add(int val){
            arr.add(val);
            int child=arr.size()-1;
            int par=(child-1)/2;
            while(arr.get(child)<arr.get(par)){
                int temp=arr.get(child);
                arr.set(child,arr.get(par));
                arr.set(par,temp);
                child=par;
                par=(child-1)/2;
            }

        }
        public int peek(){
            return arr.get(0);
        }
        public void Heapify(int i){
            int left =2*i+1;
            int right=2*i+2;
            int min=i;
            if(left<arr.size() && arr.get(min)>arr.get(left)){
                min=left;
            }
            if(right<arr.size() && arr.get(min)>arr.get(right)){
                min=right;
            }
            if(min!=i){
                int temp=arr.get(i);
                arr.set(i,arr.get(min));
                arr.set(min,temp);
                Heapify(min);
            }
        }
        public void remove(){
            // int temp=arr.get(0);
            arr.set(0,arr.get(arr.size()-1));
            // arr.set(arr.size()-1,temp);
            arr.remove(arr.size()-1);
            Heapify( 0);
        }
        public void print(){
            for(int i=0;i<arr.size();i++){
                System.out.print(arr.get(i)+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args){
        Heap h=new Heap();
        h.add(2);
        h.add(3);
        h.add(4);
        h.add(5);
        h.add(10);
        h.print();
        h.add(1);
        h.print();
        h.remove();
        h.print();
    }
}
