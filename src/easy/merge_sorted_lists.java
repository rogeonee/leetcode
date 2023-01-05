package easy;

public class merge_sorted_lists {
    public static void main(String[] args) {
        /*
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        a.next = b;

        // CASE 1
        ListNode case1_1 = new ListNode(1);
        ListNode c2 = new ListNode(2);
        ListNode c3 = new ListNode(4);
        case1_1.next = c2;
        c2.next = c3;
        ListNode case1_2 = new ListNode(1);
        ListNode ca2 = new ListNode(3);
        ListNode ca3 = new ListNode(4);
        case1_2.next = ca2;
        ca2.next = ca3;

        // CASE 2
        ListNode case2_1 = null;
        ListNode case2_2 = new ListNode();

        ListNode temp = case2_2;

        System.out.println();

        while(temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        */

    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        boolean first_empty = list1 == null;
        boolean second_empty = list2 == null;

        System.out.println("Fisrt empty: " + (list1 == null));
        System.out.println("Second empty: " + (list2 == null));

        // both are empty
        if(first_empty && second_empty) {
            ListNode n = null;
            return n;
        }

        // one is empty
        if(first_empty) return list2;
        
        if(second_empty) return list1;
        
        // none are empty
        ListNode p1 = list1;
        ListNode p2 = list2;
        ListNode head = new ListNode();
        ListNode temp = head;
        boolean aa = true;

        while(p1 != null || p2 != null) {
            // add fisrt value
            if(aa) {
                if(list1.val < list2.val) {
                    head.val = list1.val;
                    list1 = list1.next;
                } else {
                    head.val = list2.val;
                    list2 = list2.next;
                }
                aa = false;
                continue;
            }

            // if one of lists run out
            first_empty = list1 == null;
            second_empty = list2 == null;

            if(first_empty) {
                temp.next = list2;
                break;
            }
            if(second_empty) {
                temp.next = list1;
                break;
            }

            System.out.println("Compare p1: " + p1.val + " and p2: " + p2.val);
            System.out.println();

            // add the rest
            if(list1.val < list2.val || list1.val == list2.val) {
                temp.next = list1;
                temp = temp.next;
                list1 = list1.next;
            } else {
                temp.next = list2;
                temp = temp.next;
                list2 = list2.next;
            }
        }

        return head;
    }

    public ListNode recursion(ListNode l1, ListNode l2) {
		if(l1 == null) return l2;
		if(l2 == null) return l1;

		if(l1.val < l2.val) {
			l1.next = mergeTwoLists(l1.next, l2);
			return l1;
		} else {
			l2.next = mergeTwoLists(l1, l2.next);
			return l2;
		}
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { 
        this.val = val; 
        this.next = next; }
}
