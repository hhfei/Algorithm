package ZHIHU;

public class Main20171009004 {

	/**
	 * 判断一个树是否是另一个树的子树
	 */
	private static class Node{
		int value;
		Node left, right;
		Node(int value){
			this.value = value;
			left =null;
			right = null;
		}
	}
	
	
	private static boolean isSubTree(Node root1, Node root2){
		boolean ans = false;
		if(root1 != null && root2 != null){
			if(root1.value == root2.value){
				ans = isSub(root1, root2);
			}else{
				ans = isSubTree(root1.left, root2);
				if(!ans){
					ans = isSubTree(root1.right, root2);
				}
			}
		}
		return ans;
	}
	
	//
	private static boolean isSub(Node root1, Node root2){
		if(root2 == null){
			return true;
		}
		if(root1 == null){
			return false;
		}
		if(root1.value != root2.value)
			return false;
		
		return isSub(root1.left, root2.left) && isSub(root1.right, root2.right);
	}
	
	public static void main(String[] args) {

		Node root1 = new Node(1);
		Node node1 = new Node(2);
		Node node2 = new Node(2);
		root1.left = node1;
		root1.right = node2;
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(3);		
		root1.left.left = node3;
		root1.left.right = node4;
		root1.right.left = node5;
		Node node6 = new Node(2);
		root1.left.right.left = node6;
		
		Node root2 = new Node(2);
		Node node7 = new Node(3);
		Node node8 = new Node(4);
		root2.left = node7;
		root2.right = node8;
		
		System.out.println(isSubTree(root1, root2));
		
	}

}
