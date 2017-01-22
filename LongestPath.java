/**
 * Print the longest path from root to leaf in a Binary tree (Basically the nodes that lie on the height path). 
 * 
 * Company : Amazon 
 *
 * @author : Deep Kholia
 */
public class LongestPath {
	
	private String longestPath = null;
	
	public static void main(String[] args) {
		LongestPath instance = new LongestPath();	
		TreeNode rootNode = instance.createTree();
		System.out.println("Longest path is : " + instance.getLongestPath(rootNode));
	}
	
	private TreeNode createTree(){
		TreeNode rootNode = new TreeNode(0);
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);
		TreeNode node7 = new TreeNode(7);
		TreeNode node8 = new TreeNode(8);
		TreeNode node9 = new TreeNode(9);
		TreeNode node10 = new TreeNode(10);
		TreeNode node11 = new TreeNode(11);
		TreeNode node12 = new TreeNode(12);
		
		
		rootNode.setLeft(node1);
		rootNode.setRight(node2);
		
		node1.setLeft(node3);
		node1.setRight(node4);
		
		node3.setLeft(node5);
		node3.setRight(node6);
		node6.setRight(node7);
		node5.setLeft(node8);
		
		node2.setLeft(node9);
		node9.setLeft(node10);
		node10.setLeft(node11);
		//node11.setRight(node12);
		
		return rootNode;
	}
	private String getLongestPath(TreeNode rootNode){
		if(rootNode==null)
			return null;
		
		String path ="";
		getPath(path, rootNode);
		return longestPath;
	}
	
	private Integer getPath(String path, TreeNode node) {
		
		path+="/"+node.value;
		if(node.left==null && node.right==null){
			String tempPath = longestPath;
			if(longestPath!=null && longestPath.contains(","))
				tempPath = longestPath.split(",")[0]; 
			if(tempPath==null || tempPath.split("/").length<path.split("/").length)
				longestPath = path;
			else if(tempPath.split("/").length == path.split("/").length)
				longestPath+=","+path; 
			return 1;
		}
		if(node.left==null && node.right!=null)
			return 1+ getPath(path, node.right);
		else if( node.left!=null && node.right==null)
			return 1+ getPath(path, node.left);
		else
			return 1+ Math.max(getPath(path,node.left), getPath(path, node.right) );
	}
	
}

class TreeNode {
	TreeNode left;
	TreeNode right;
	Integer value;
	
	public TreeNode(Integer value) {
		left = null;
		right= null;
		this.value = value;
	}

	public void setLeft(TreeNode left) {
		this.left = left;
	}

	public void setRight(TreeNode right) {
		this.right = right;
	}

	@Override
	public String toString() {
		return "TreeNode [left=" + left + ", right=" + right + ", value=" + value + "]";
	}
}
