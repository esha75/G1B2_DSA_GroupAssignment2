package Assignment2;



public class Driver {
	
	public static  Node node;
	static Node prevNode = null;
	static Node headNode=null;
	
	static void skewed(Node root) {
			
			if (root==null) {
				return;
			}
		
				skewed(root.left);
			
			if(headNode==null) {
				headNode=root;
				root.left=null;
				prevNode=root;
			}
			else {
				prevNode.right=root;
				root.left=null;
				prevNode=root;
			}
			
			skewed(root.right);	
				
		}
	
	
	static void inorder(Node root) {
		if(root!=null) {
			inorder(root.left);
			System.out.print(root.data+",");
			inorder(root.right);
		}
		
	}
	
	static void traverseRightSkewedTree(Node root) {
		if(root==null) {
			return;
		}
		System.out.print(root.data+",");
		traverseRightSkewedTree(root.right);
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		node =new Node(50);
		node.left=new Node(30);
		node.right=new Node(60);
		node.left.left=new Node (10);
		node.left.right= new Node(20);
		node.right.left=new Node(55);
		
		System.out.println("In Skewed Tree:");
		skewed(node);
		traverseRightSkewedTree(headNode);

	}

}
