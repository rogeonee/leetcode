package easy;

import java.util.HashSet;

public class linked_list_cycle {
    public static void main(String[] args) {

    }

    // old one
    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> hs = new HashSet<ListNode>();
        ListNode curr = head;
        
        while(curr != null) {
            if(hs.contains(curr))
                return true;
            
            hs.add(curr);
            curr = curr.next;
        }
        return false;
    }
    
}
