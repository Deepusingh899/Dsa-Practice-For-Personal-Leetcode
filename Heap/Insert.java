package Heap;
import java.util.ArrayList;

class Insert{
    public static class Heap{
        ArrayList<Integer> arr=new ArrayList<>();
        public void add(int data){
            arr.add(data);
            int x=arr.size()-1;
            int a= (x-1)/2;
            while(arr.get(x)<arr.get(a)){
                int temp=arr.get(x);
                arr.set(x,arr.get(a));
                arr.set(a,temp);
                x=a;
                a=(x-1)/2;
            }
        }
        public int peek(){
            return arr.get(0);
        }
        public void print(){
            for(int i=0;i<arr.size();i++){
                System.out.print(arr.get(i)+" ");
            }
            System.out.println();
        }
    }
    public static void main(String [] args){
        Heap h=new Heap();
        h.add(2);
        h.add(3);
        h.add(4);
        h.add(5);
        h.add(10);
        h.add(1);
        System.out.println(h.peek());
        h.print();
    }
}