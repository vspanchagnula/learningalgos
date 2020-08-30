package learning;

// Given a singly linked list L: L0 - L1 - … - Ln-1 - Ln,
// reorder it to: L0 - Ln - L1 - Ln-1 - L2 - Ln-2…
// TC : O(n) SC : O(1)
public class ReorderLinkedList {
	
	 public static void main(String[] args) 
	    { 
	  
		 ListNode list = new ListNode(1); 
	        list.next = new ListNode(2); 
	        list.next.next = new ListNode(3); 
	        list.next.next.next = new ListNode(4); 
	        list.next.next.next.next = new ListNode(5); 
	        ReorderLinkedList reorderLinkedList = new ReorderLinkedList();
	        printlist(list); // print original list 
	        reorderLinkedList.reorderList(list); // rearrange list as per ques 
	        System.out.println(""); 
	        printlist(list); // print modified list 
	    } 
	 
	 static void printlist(ListNode node) 
	    { 
	        if (node == null) { 
	            return; 
	        } 
	        while (node != null) { 
	            System.out.print(node.data + " -> "); 
	            node = node.next; 
	        } 
	    } 
	 
	 
	public void reorderList(ListNode head) {
		if (head == null)
			return;

		// find the middle of linked list [Problem 876]
		// in 1->2->3->4->5->6 find 4
		ListNode slow = head, fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		// reverse the second part of the list [Problem 206]
		// convert 1->2->3->4->5->6 into 1->2->3->4 and 6->5->4
		// reverse the second half in-place
		ListNode prev = null, curr = slow, tmp;
		while (curr != null) {
			tmp = curr.next;

			curr.next = prev;
			prev = curr;
			curr = tmp;
		}

		// merge two sorted linked lists [Problem 21]
		// merge 1->2->3->4 and 6->5->4 into 1->6->2->5->3->4
		ListNode first = head, second = prev;
		while (second.next != null) {
			tmp = first.next;
			first.next = second;
			first = tmp;

			tmp = second.next;
			second.next = first;
			second = tmp;
		}
	}

	static class ListNode {

		int data;
		ListNode next;

		// Constructor to create a new node
		ListNode(int d) {
			data = d;
			next = null;
		}
	}
}
