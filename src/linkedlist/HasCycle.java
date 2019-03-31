package linkedlist;

public class HasCycle {
    public boolean hasCycle(ListNode head){
        ListNode cursor = head; //a reference to the original head
        ListNode curHead;
        while (cursor != null){
            curHead = cursor.next;  //update new head
            curHead.next = cursor;   //keep a reference to the old head
            cursor = cursor.next; //switch the order of the adjacent nodes
            if (cursor == head){
                return true;
            }
        }
        return false;

    }
}
