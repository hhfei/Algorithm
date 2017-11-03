package ZHIHU;

public class Main20171009001 {

	/**
	 * 输入两个递增排序的链表，合并这两个链表并使新链表中的结点仍然是按照递增排序的
	 */
	public static void main(String[] args) {

		ListNode head1 = new ListNode();
		head1.value = 1;
		head1.next = new ListNode();
		head1.next.value = 2;
		head1.next.next = new ListNode();
		head1.next.next.value = 3;
		head1.next.next.next = new ListNode();
		head1.next.next.next.value = 4;
		head1.next.next.next.next = new ListNode();
		head1.next.next.next.next.value = 5;
		ListNode head2 = new ListNode();
		head2.value = 1;
		head2.next = new ListNode();
		head2.next.value = 3;
		head2.next.next = new ListNode();
		head2.next.next.value = 5;
		head2.next.next.next = new ListNode();
		head2.next.next.next.value = 6;
		head2.next.next.next.next = new ListNode();
		head2.next.next.next.next.value = 7;

		ListNode root = merge2(head1, head2);
		System.out.println("--------------------------");
		printList(root);
		System.out.println("--------------------------");
		printList(head1);
	}

	private static class ListNode {
		int value;
		ListNode next;
	}

	// 破坏原来的两个链表的结构
	public static ListNode merge(ListNode head1, ListNode head2) {

		if (head1 == null) {
			return head2;
		}
		if (head2 == null) {
			return head1;
		}
		ListNode root = new ListNode();
		ListNode p = root;
		while (head1 != null && head2 != null) {
			if (head1.value <head2.value) {
				p.next = head1;
				head1 = head1.next;
			} else {
				p.next = head2;
				head2 = head2.next;
			}
			p = p.next;
		}
		if (head1 != null) {
			p.next = head1;
		}
		if (head2 != null) {
			p.next = head2;
		}
		return root.next;
	}

	// 不破坏原来的两个链表的结构
	public static ListNode merge2(ListNode head1, ListNode head2) {
		if (head1 == null) {
			return head2;
		}
		if (head2 == null) {
			return head1;
		}
		ListNode root = new ListNode();
		ListNode p = root;

		while (head1 != null && head2 != null) {
			if (head1.value <head2.value) {
				ListNode node = new ListNode();
				node.value = head1.value;
				node.next = null;
				p.next = node;
				head1 = head1.next;
			} else {
				ListNode node = new ListNode();
				node.value = head2.value;
				node.next = null;
				p.next = node;
				head2 = head2.next;
			}
			p = p.next;
		}
		while (head1 != null) {
			ListNode node = new ListNode();
			node.value = head1.value;
			node.next = null;
			p.next = node;
			p = p.next;
			head1 = head1.next;
		}
		while (head2 != null) {
			ListNode node = new ListNode();
			node.value = head2.value;
			node.next = null;
			p.next = node;
			p = p.next;
			head2 = head2.next;
		}
		return root.next;
	}


	private static void printList(ListNode head) {
		ListNode p = head;
		while (p != null) {
			System.out.print(p.value + " ");
			p = p.next;
		}
		System.out.println();
	}
}
