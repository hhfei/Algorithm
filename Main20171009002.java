package ZHIHU;

import ZHIHU.Main20170930_001.Node;

public class Main20171009002 {

	/**
	 * 单链表的逆置
	 */
	private static class Node{
		int value;
		Node next;
	}
	
	private static Node reverse(Node head){
		if(head == null){
			return null;
		}
		Node pre = null;
		Node cur = head;
		Node next = cur.next;
		
		while(cur != null){
			next = cur.next;
			cur.next = pre;
			pre = cur;
			cur = next;
		}
		return pre;
	}
	
	
	//打印一个单链表
	private static void printList(Node head) {
		Node p = head;
		while (p != null) {
			System.out.print(p.value + " ");
			p = p.next;
		}
		System.out.println();
	}
	
	public static void main(String[] args) {

		Node head1 = new Node();
		head1.value = 1;
		head1.next = new Node();
		head1.next.value = 2;
		head1.next.next = new Node();
		head1.next.next.value = 3;
		head1.next.next.next = new Node();
		head1.next.next.next.value = 4;
		head1.next.next.next.next = new Node();
		head1.next.next.next.next.value = 5;
		
		Node h = reverse(head1);
		printList(h);
		
	}

}
