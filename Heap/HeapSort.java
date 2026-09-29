package Heap;
class HeapSort{
    public static void main(String[] args){
        int[] arr={4,3,5,2,1};  
        heapSort(arr);
        print(arr);
    }
    public static void print(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
    public static void heapify(int [] arr,int i,int n){
        int left=2*i+1;
        int right=2*i+2;
        int maxIdx=i;
        if(left<n && arr[maxIdx]>arr[left]){
            maxIdx=left;
        }
        if(right<n && arr[maxIdx]>arr[right]){
            maxIdx=right;
        }
        if(maxIdx!=i){
            int temp=arr[i];
            arr[i]=arr[maxIdx];
            arr[maxIdx]=temp;
            heapify(arr,maxIdx,n);
        }
    }
    public static void heapSort(int[] arr){
        int n=arr.length;
        //step 1 : Build Heap
        for(int i=n/2;i>=0;i--){
            heapify(arr,i,n);
        }

        //step 2 : Remove elements from heap and Sort
        for(int i=n-1;i>0;i--){
            int temp=arr[0];
            arr[0]=arr[i];
            arr[i]=temp;
            heapify(arr,0,i);
        }
    }
}