package assignment6;

public class HashMap {
	class ListNode{
		public int key;
		public int val;
		public ListNode next;
		public ListNode(int key, int val) {
			this.key = key;
			this.val = val;
		}
	}
	ListNode[] node = new ListNode[1000];
	public HashMap() {
	}
	
	public void put(int key, int val) {
		int i = key%node.length;
		if(node[i]!=null) {
			ListNode current = node[i];
			if(current.next!=null && current.key!=key) {
				current = current.next;
			}else if(current.key==key) {
				current.val=val;
			}else {
				current.next = new ListNode(key,val);
			}
		}else {
			node[i] = new ListNode(key,val);
		}
	}
	
	public int get(int key) {
		int i = key%node.length;
		ListNode current = node[i];
		if(current==null) {
			return -1;
		}else if(current.key==key) {
			return current.val;
		}
		return -1;
	}
	
	public void remove(int key) {
		int i = key%node.length;
		ListNode current = node[i];
		if(current==null) {
			return;
		}
		if(current.key==key) {
			node[i]=current.next;
		}else {
			if(current.next.key==key) {
				if(current.next.next==null) {
					current.next=null;
				}else {
					current = current.next;
					current.next = current.next.next;
				}
			}
		}
	}

}
