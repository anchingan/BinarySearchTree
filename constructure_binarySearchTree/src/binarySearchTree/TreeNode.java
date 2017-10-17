package binarySearchTree;

public class TreeNode {
	private String name, phone;
	private TreeNode leftChild, rightChild;

	public TreeNode(String name, String phone) {
		this.name = name;
		this.phone = phone;
		this.leftChild = null;
		this.rightChild = null;
	}
	
	public void setLeftChild(TreeNode left) {
		this.leftChild = left;
	}
	
	public void setRightChild(TreeNode right) {
		this.rightChild = right;
	}
	
	public TreeNode getLeftChild() {
		return this.leftChild;
	}
	
	public TreeNode getRightChild() {
		return this.rightChild;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getPhone() {
		return this.phone;
	}
	
	@Override
	public String toString() {
		return String.format("Name: %-8s Phone: %-10s", this.name, this.phone);
	}

}
