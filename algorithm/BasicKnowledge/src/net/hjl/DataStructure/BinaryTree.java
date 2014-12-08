package net.hjl.DataStructure;

public class BinaryTree {
	
	private class BinaryNode{
		private BinaryNode left;
		private BinaryNode right;
		private int value;
		
		BinaryNode(int value){
			this.left = null;
			this.right = null;
			this.value = value;
		}
	}
	
	private BinaryNode root;
	
	public BinaryTree(){
		root=null;
	}
	
	public BinaryTree(int value){
		root = new BinaryNode(value);
	}
	
	public void insertNodeV2(int data){
		if(root == null){
			root = new BinaryNode(data);
			return;
		}
		BinaryNode temp = root;
		BinaryNode parent = null;
		while(temp!=null){
			parent = temp;
			if(data < temp.value){
				temp = temp.left;
			}else{
				temp = temp.right;
			}
		}
		if(data < parent.value){
			parent.left = new BinaryNode(data);
		}else{
			parent.right = new BinaryNode(data);
		}
		
	}
	
	public void insertNode(int data){
		if(root == null)
		{
			root = new BinaryNode(data);
		}else{
			BinaryNode temp = root;
			while(temp.left!=null || temp.right!=null){
				if(data < temp.value){
					if(temp.left == null){
						temp.left = new BinaryNode(data);
						return;
					}else{
						temp = temp.left;
					}
				}else{
					if(temp.right == null){
						temp.right = new BinaryNode(data);
						return;
					}else{
						temp = temp.right;
					}
				}
			}
			if(data < temp.value){
				temp.left = new BinaryNode(data);
			}else{
				temp.right = new BinaryNode(data);
			}
		}
	}

	public void displayTreeNode(BinaryNode node, int h){
		if(node == null) return;
		for(int i =0; i<h; i++){
			System.out.print(" ");
		}
		System.out.print(node.value);
		System.out.println();
		displayTreeNode(node.left,h+1);
		displayTreeNode(node.right,h+1);
	}
	
	public void pre_display(BinaryNode root){
		if(root != null){
			System.out.print(root.value);
			pre_display(root.left);
			pre_display(root.right);
		}
	}
	
	public void mid_display(BinaryNode root){
		if(root != null){
			mid_display(root.left);
			System.out.print(root.value);
			mid_display(root.right);
		}
	}
	
	public void aft_display(BinaryNode root){
		if(root != null){
			aft_display(root.left);
			aft_display(root.right);
			System.out.print(root.value);
		}
	}
	
	public int depth(BinaryNode root){
		int h = 0;
		if(root != null){
			h = 1;
			if(depth(root.left) > depth(root.right)){
				h += depth(root.left);
			}else{
				h += depth(root.right);
			}
		}
		return h;
	} 
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BinaryTree b_tree = new BinaryTree();
//		b_tree.insertNode(9);
//		b_tree.insertNode(8);
//		b_tree.insertNode(10);
//		b_tree.insertNode(7);
		b_tree.insertNodeV2(9);
		b_tree.insertNodeV2(8);
		b_tree.insertNodeV2(10);
		b_tree.insertNodeV2(7);
		b_tree.insertNodeV2(6);
		b_tree.insertNodeV2(11);
		b_tree.displayTreeNode(b_tree.root,1);
		b_tree.pre_display(b_tree.root);
		System.out.println();
		b_tree.mid_display(b_tree.root);
		System.out.println();
		b_tree.aft_display(b_tree.root);
		System.out.println();
		System.out.println(b_tree.depth(b_tree.root));
	}

}
