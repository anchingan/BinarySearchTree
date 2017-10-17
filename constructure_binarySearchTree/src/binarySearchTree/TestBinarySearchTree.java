package binarySearchTree;

import java.util.Scanner;

public class TestBinarySearchTree {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		BinaryTree btree = new BinaryTree();
		String str;
		while (true) {
			String name, phone;
			System.out.println("Command:");
			while ((str = scanner.nextLine()).equals(""));
			if (str.equals("q"))
				break;
			switch(str) {
			case "i":
				System.out.print("Name:");
				while ((name = scanner.nextLine()).equals(""));
				System.out.print("Phone:");
				while ((phone = scanner.nextLine()).equals(""));
				btree.insert(name, phone);
				break;
			case "d":
				System.out.print("Delete name:");
				while ((name = scanner.nextLine()).equals(""));
				btree.delete(name);
				break;
			case "f":
				System.out.print("Name:");
				while ((name = scanner.nextLine()).equals(""));
				TreeNode result = btree.search(name);
				if (result == null)
					System.out.println("'" + name + "' not found!");
				else
					System.out.println(result);
				break;
			case "l":
				btree.printAll();
				break;
			}
		}
	}
	
}
