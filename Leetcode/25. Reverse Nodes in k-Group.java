//Definition for singly-linked list.
package Leetcode;
 
/** Steps and Approach to Solve this problem
    1. We will use Recuseive to solve this problem we will pass the small set of list after the k nodes to the same function
    because we should have faith to recusrion that remaining list it solve and return to the head;
    2. now we need to reverse the current K node and merge in to returned list of recusrion
    3. check if K node exist if exist then pass to recusrion next small set else return head only
    which we are doing in line no 27
    4. rest list will call the resurion which we are doing line 32;
    5 reversing the current group which we are doing from 33 to last
       1.  here we again we are ponting to temp to head and count=0
       2. running while loop till the count reach to K
            1. creating new node to point the next node of temp because if we point our temp to returned list from recursive method next node may loose
            2. now temp node pointing to head returned list from recursion  
            3. now assingnig prevNode to temp Node and temp Node to nextNode
            4. step 1 to 3 will continue once while loop will end 
    6.return prevNode as head node;
**/

class Solution {

    // Class for creatiing a node
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    //The method to reverse Node in k Group 

    public ListNode reverseKGroup(ListNode head, int k) {
        int count=0;
        ListNode temp=head;
        while(count<k){
            if(temp==null) return head;
            temp=temp.next;
            count++;
        }
        ListNode prevNode=reverseKGroup(temp,k);
        temp=head;
        count=0;
        while(count<k){
            ListNode nextNode=temp.next;
            temp.next=prevNode;
            prevNode=temp;
            temp=nextNode;
            count++;
        }
        return prevNode;        
    }
}