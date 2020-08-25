package learning;

public class MergeSortedLinkedList {

	// Idea is to maintain head that initially points to dummy value and as we find l1 < l2
	// means l1 is lesser value , so assign prev.next to l1 and proceed
	// Time Com : O(n+m) space O(1)
	 public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		 ListNode head = new ListNode(-1);
		 ListNode prev = head;
		 while(l1!=null && l2!=null) {
			 if(l1.val <= l2.val) {
				 prev.next = l1;
				 l1 = l1.next;
			 }else {
				 prev.next = l2;
				 l2 = l2.next;
			 }
			 prev = prev.next;
		 }
		 prev.next = l1 == null ? l2 : l1;
		return head.next;
		 
	 }
	 
	 public static class ListNode {
	      int val;
	      ListNode next;
	      ListNode() {}
	      ListNode(int val) { this.val = val; }
	      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
		  }
	 
	 
	 // Driver code 
	    public static void main(String[] args) 
	    { 
	    	ListNode head1 = new ListNode(1); 
	        head1.next = new ListNode(3); 
	        head1.next.next = new ListNode(5); 
	  
	        // 1->3->5 LinkedList created 
	  
	        ListNode head2 = new ListNode(0); 
	        head2.next = new ListNode(2); 
	        head2.next.next = new ListNode(4); 
	  
	        // 0->2->4 LinkedList created 
	        MergeSortedLinkedList mergeSortedLinkedList = new MergeSortedLinkedList();
	  
	        ListNode mergedhead = mergeSortedLinkedList.mergeTwoLists(head1, head2); 
	  
	        mergeSortedLinkedList.printList(mergedhead); 
	    } 
	    
	    // A utility function to print linked list 
	    void printList(ListNode node) 
	    { 
	        while (node != null) { 
	            System.out.print(node.val + " "); 
	            node = node.next; 
	        } 
	    } 
	 
	
}
