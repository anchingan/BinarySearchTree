package binarySearchTree;

public class BinaryTree {
	public enum ChildType{
		LEFTCHILD,
		RIGHTCHILD
	}
	private TreeNode root;

	public BinaryTree() {
		this.root = null;
	}
	
	public BinaryTree(String name, String phone) {
		this.root = new TreeNode(name, phone);
	}
	
	public TreeNode getRoot() {
		return this.root;
	}
	
	public TreeNode search(String name) {
		return doSearch(this.root, name);
	}
	private TreeNode doSearch(TreeNode ptr, String name) {
		//If key_name is in the tree, return treenode.
		TreeNode tmp;
		while (ptr != null) {
			if (ptr.getName().equals(name))
				return ptr;
			else {
				tmp = doSearch(ptr.getLeftChild(), name);
				if(tmp != null)
					return tmp;
				tmp = doSearch(ptr.getRightChild(), name);
				if(tmp != null)
					return tmp;
			}
		}
		return null;
	}
	
	public void insert(String name, String phone) {
		TreeNode newNode = new TreeNode(name, phone);
		if (root == null)
			this.root = newNode;
		else {
			TreeNode current = this.root;
			TreeNode parent = null;
			while (current != null) {
				parent = current;
				if (current.getName().compareToIgnoreCase(name) > 0)
					current = current.getLeftChild();
				else if (current.getName().compareToIgnoreCase(name) < 0)
					current = current.getRightChild();
				else {
					System.out.println("Repeated name!");
					break;
				}
			}
			if (parent.getName().compareToIgnoreCase(name) > 0)
				parent.setLeftChild(newNode);
			else
				parent.setRightChild(newNode);
		}
	}
	
	
	public void delete(String name) {
		TreeNode current = this.root, parent = this.root;
		ChildType t = null;
		while (current != null) {
			int i = current.getName().compareTo(name);
			if (i == 0) {
				remove(parent, current, t);
				break;
			}
			parent = current;
			if (i > 0) {
				current = current.getLeftChild();
				t = ChildType.LEFTCHILD;
			}
			else {
				current = current.getRightChild();
				t = ChildType.RIGHTCHILD;
			}
		}
	}
	
	private void remove(TreeNode parent, TreeNode target, ChildType t) {
		if (t == null)
			this.root = null;
		TreeNode l = target.getLeftChild(), r = target.getRightChild();
		//If there is no left child of delete node
		if (l == null) {
			///If no right child
			if (r == null) {
				if (t == ChildType.LEFTCHILD)
					parent.setLeftChild(null);
				else if (t == ChildType.RIGHTCHILD)
					parent.setRightChild(null);
			}
			///If delete node is root
			else if (target == this.root) {
				this.root = root.getRightChild();
			}
			else {
				if (t == ChildType.LEFTCHILD)
					parent.setLeftChild(r);
				else if (t == ChildType.RIGHTCHILD)
					parent.setRightChild(r);
			}
		}
		//If there is no right child of delete node
		else if (r == null){
			///If delete node is root
			if (target == this.root)
				this.root = l;
			else {
				if (t == ChildType.LEFTCHILD)
					parent.setLeftChild(l);
				else if (t == ChildType.RIGHTCHILD)
					parent.setRightChild(l);
			}
		}
		//If there are both right and left child of delete node
		else {
			///If delete node is root
			if (target == this.root) {
				///If there is no right child of left child
				if (l.getRightChild() == null) {
					l.setRightChild(r);
					this.root = l;
				}
				else {
					///Find far right child of left child and its parent.
					TreeNode farRight = l.getRightChild(), parentFarRight = l;
					while (farRight.getRightChild() != null) {
						parentFarRight = farRight;
						farRight = farRight.getRightChild();
					}
					//If there is no left child of far right
					parentFarRight.setRightChild(null);
					if (farRight.getLeftChild() == null) {
						farRight.setLeftChild(this.root.getLeftChild());
						farRight.setRightChild(this.root.getRightChild());
						this.root = farRight;
					}
					else {
						farRight.getLeftChild().setLeftChild(this.root.getLeftChild());
						farRight.setRightChild(this.root.getRightChild());
						this.root = farRight;
					}
				}

			}
			//Delete node is not root.
			else{
				///Find far right child of left child and its parent.
				TreeNode farRight = l.getRightChild(), parentFarRight = l;
				while (farRight.getRightChild() != null) {
					parentFarRight = farRight;
					farRight = farRight.getRightChild();
				}
				parentFarRight.setRightChild(null);
				if (farRight.getLeftChild() == null) {
					farRight.setLeftChild(target.getLeftChild());
					farRight.setRightChild(target.getRightChild());
					if (t == ChildType.LEFTCHILD)
						parent.setLeftChild(farRight);
					else
						parent.setRightChild(farRight);
				}
			}
		}
	}
	
	public void printAll() {
		this.printInOrder(this.root);
	}
	
	private void printInOrder(TreeNode ptr) {
		if (ptr != null) {
			printInOrder(ptr.getLeftChild());
			System.out.println(ptr);
			printInOrder(ptr.getRightChild());
		}
	}
	
}
