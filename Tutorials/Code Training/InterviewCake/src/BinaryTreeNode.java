import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

public class BinaryTreeNode {

	public int value;
	public BinaryTreeNode left;
	public BinaryTreeNode right;

	public BinaryTreeNode(int value) {
		this.value = value;
	}

	public BinaryTreeNode insertLeft(int leftValue) {
		this.left = new BinaryTreeNode(leftValue);
		return this.left;
	}

	public BinaryTreeNode insertRight(int rightValue) {
		this.right = new BinaryTreeNode(rightValue);
		return this.right;
	}
	
	//BFS
	public static Integer findDistBfs(BinaryTreeNode b, int n){
		
		Map<BinaryTreeNode, Integer> visited = new HashMap<BinaryTreeNode,Integer>();
		visited.put(b, 0);
		Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
		q.add(b);
		
		while(!q.isEmpty()){
			BinaryTreeNode bt = q.poll();
			int d = visited.get(bt);
			
			// Here we examine the two children individually
			// We can scale this step with 
				// for (V w in g.successors()) {
				//		if(!visited.containsKey(w){
				//			q.add(w);
				//			visited.put(w,d+1)
				//		}
				// }
			
			if (!visited.containsKey(bt.left)){
				if (bt.left.value == b.value)
					return d+1;
				q.add(bt.left);
				visited.put(bt.left, d+1);
			}
			
			if (!visited.containsKey(bt.right)){
				if (bt.right.value == b.value)
					return d+1;
				q.add(bt.right);
				visited.put(bt.right, d+1);
			}
		}
		
		return -1;
	}
	//DFS: use a stack
	public static Integer findDistDfs(BinaryTreeNode b, int n){
		
		Map<BinaryTreeNode, Boolean> visited = new HashMap<BinaryTreeNode,Boolean>();
		boolean t = true;
		visited.put(b, true);
		Stack<BinaryTreeNode> q = new Stack<BinaryTreeNode>();
		q.push(b);
		
		while(!q.isEmpty()){
			BinaryTreeNode bt = q.pop();
			
			// Here we examine the two children individually
			// We can scale this step with 
				// if(!visited.containsKey(bt)){
				//		visited.put(w,True) // We could create a class with a field visited, or use a HashSet
				//		for (V w in bt.successors()) {
				//			q.push(w);
				//		}
				// }
			
		}
		
		return -1;
	}
	
	public class NodeDepthPair {
		BinaryTreeNode node;
		int depth;

		public NodeDepthPair(BinaryTreeNode node, int depth) {
			this.node = node;
			this.depth = depth;
		}
	}

	public boolean checkBalanced(BinaryTreeNode b) {

		List<Integer> depths = new ArrayList<Integer>(3);

		Stack<NodeDepthPair> nodes = new Stack<NodeDepthPair>();
		nodes.push(new NodeDepthPair(b, 0));

		while (!nodes.empty()) {
			NodeDepthPair ndp = nodes.pop();

		}
		return false;
	}

	// Probleme: Ici on ne considere pas ALL VALUES!!
	// A reecrire, cela est faux
	public static boolean checkBSTfalse(BinaryTreeNode b) {
		if (b == null)
			return true;

		boolean condLeft = (b.left == null) ? true : (b.left.value <= b.value);
		boolean condRight = (b.right == null) ? true : (b.right.value >= b.value);

		return (condLeft && condRight && checkBSTfalse(b.left) && checkBSTfalse(b.right));
	}

	// Methode corrigee
	public static boolean checkBST(BinaryTreeNode b, int low, int up) {
		if (b == null)
			return true;
		
		if (b.value > up)
			return false;
					
		if (b.value < low)
			return false;
		
		return (checkBST(b.left,low,b.value) && checkBST(b.right,b.value,up));
	}
	
	// Mauvaise approche
	public static int find2LargestFalse(BinaryTreeNode b, int max, int max2) {
		if (b.right != null) {
			int tmp = Math.max(max, b.right.value);
			max2 = (max == tmp) ? b.right.value : max;
			max = tmp;
			return find2LargestFalse(b.right, max, max2);
		}
		else if (b.left != null) {
			return find2LargestFalse(b.right, max, Math.max(b.left.value, max2));
		}
		else {
			
		}
		return max2;
	}
	
	// Bonne approche 
	// count donne le nombre d'element rencontre sans fils droit
	// Hypothese: plus d'un noeud --> besoin de return null sinon
	public static int find2Largest(BinaryTreeNode b, int count, int max2) {
		if (b.right != null) 
			return find2Largest(b.right, count, b.value);
		
		if (count >= 1) 
			return b.value;
		
		count++;
		
		if (b.left != null) 
			return find2Largest(b.left, count, max2);
		
		else 
			return max2;
	}
	
	// Autre possibilite: utiliser une sous-fonction findLargest iterative
	public int findLargest(BinaryTreeNode rootNode) {
	    BinaryTreeNode current = rootNode;
	    while (current.right != null) {
	        current = current.right;
	    }
	    return current.value;
	}
	
	public int findSecondLargest(BinaryTreeNode rootNode) {
	    if (rootNode.left == null && rootNode.right == null) {
	        throw new IllegalArgumentException("Tree must have at least 2 nodes");
	    }

	    BinaryTreeNode current = rootNode;

	    while (true) {
	        // case: current is largest and has a left subtree
	        // 2nd largest is the largest in that subtree
	        if (current.left != null && current.right == null) {
	            return findLargest(current.left);
	        }

	        // case: current is parent of largest, and
	        // largest has no children, so
	        // current is 2nd largest
	        if (current.right != null &&
	           current.right.left == null &&
	           current.right.right == null) {
	            return current.value;
	        }

	        current = current.right;
	    }
	}
	
	// Test of function
	public static void main(String[] args) {
		BinaryTreeNode b = new BinaryTreeNode(100);
		b.insertLeft(30);
		b.insertRight(150);
		b.right.insertRight(180);
		b.right.right.insertLeft(170);
		b.right.right.left.insertRight(175);

		System.out.println(find2Largest(b,0, - Integer.MAX_VALUE));
	}
}