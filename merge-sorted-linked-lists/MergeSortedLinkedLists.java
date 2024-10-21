// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class MergeSortedLinkedLists {
    // 1, 2, 4
    // 1, 3, 4
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        while (list1 != null && list2 != null) {
            if (list2.val >= list1.val) {
                curr.next = list1;
                // 1it. -1 -> 1
                // 3it. -1 -> 1 -> 1 -> 2
                // 5it. -1 -> 1 -> 1 -> 2 -> 3 -> 4
                list1 = list1.next;
                // L1 = 2-> 4
                // 3it. L1 = 4
                // 5it. L1 = null
            } else {
                curr.next = list2;
                // 2it. -1 -> 1 -> 1
                // 4it. -1 -> 1 -> 1 -> 2 -> 3
                list2 = list2.next;
                // L2 = 3-> 4
                // 4it. L2 = 4
            }
            curr = curr.next;
            // 1it. curr = 1 (-1 -> 1)
            // 2it. curr = 1 (-1 -> 1 -> 1)
            // 3it. curr = 2 (-1 -> 1 -> 1 -> 2)
            // 4it. curr = 3 (-1 -> 1 -> 1 -> 2 -> 3)
            // 5it. curr = 4 (-1 -> 1 -> 1 -> 2 -> 3 -> 4)
        }

        if (list1 != null) {
            curr.next = list1;
        }

        if (list2 != null) {
            curr.next = list2;
            // curr = 4 (-1 -> 1 -> 1 -> 2 -> 3 -> 4 -> 4)
        }

        return dummy.next;
    }

    public static ListNode arrayToList(int[] arr) {
        if (arr.length == 0)
            return null;
        ListNode head = new ListNode(arr[0]);
        ListNode current = head;
        for (int i = 1; i < arr.length; i++) {
            current.next = new ListNode(arr[i]);
            current = current.next;
        }
        return head;
    }

    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val);
            if (current.next != null)
                System.out.print(" -> ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr1 = { 1, 2, 4 };
        int[] arr2 = { 1, 3, 4 };
        ListNode list1 = arrayToList(arr1);
        ListNode list2 = arrayToList(arr2);
        ListNode mergedList = mergeTwoLists(list1, list2);
        printList(mergedList);
    }
}