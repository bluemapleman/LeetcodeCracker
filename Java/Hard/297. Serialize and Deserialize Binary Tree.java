/*
Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.

Example: 

You may serialize the following tree:

    1
   / \
  2   3
     / \
    4   5

as "[1,2,3,null,null,4,5]"
Clarification: The above format is the same as how LeetCode serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.

Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class Codec {

    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
    	// use "@" to represent null node
    	if(root==null)
    		return "@";
    	
    	String ans=""+root.val;
    	
    	ArrayDeque<TreeNode> queue=new ArrayDeque<>();
    	queue.add(root);
    	
    	
    	TreeNode currentNode=null;
    	while(!queue.isEmpty()) {
    		currentNode=queue.poll();
    		if(currentNode.left!=null) {
    			queue.add(currentNode.left);
    			ans+=","+currentNode.left.val;
    		}else
    			ans+=",@";
    			
    		
    		if(currentNode.right!=null) {
    			queue.add(currentNode.right);
    			ans+=","+currentNode.right.val;
    		}else
    			ans+=",@";
    	}
    	
    	return ans;
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
    	if(data.startsWith("@"))
        	return null;
    	
        List<TreeNode> nodeList=new ArrayList<>();
        String[] nodeStrs=data.split(",");
        TreeNode root=new TreeNode(Integer.valueOf(nodeStrs[0]));
        nodeList.add(root);
        
        int fatherLayerNodeCount=1,fatherLayerStartIndex=0;
        int sonLayerStartIndex=fatherLayerStartIndex+fatherLayerNodeCount;
        int nextLayerNodeCount=0;
        while(sonLayerStartIndex<nodeStrs.length) {
        	TreeNode father=nodeList.get(fatherLayerStartIndex);
        	while(father==null)
        		father=nodeList.get(++fatherLayerStartIndex);

        	int indicator=0;
	        for(int i=sonLayerStartIndex;i<sonLayerStartIndex+fatherLayerNodeCount*2 && i<nodeStrs.length;i++) {
	        	String ele=nodeStrs[i];

	        	if(!ele.equals("@")) {
	        		nextLayerNodeCount++;
	        		TreeNode temp=new TreeNode(Integer.valueOf(ele));
	        		if(indicator%2==0) 
	        			father.left=temp;
	        		else {
	        			father.right=temp;
	        		}
	        		nodeList.add(temp);
	        	}else
	        		nodeList.add(null);
	        	
	        	indicator++;
	        	if(indicator%2==0) {
	        		father=nodeList.get(++fatherLayerStartIndex);
	        		// ensure father is not null, but not to get to the node of next layer.
	        		while(father==null && fatherLayerStartIndex<sonLayerStartIndex) {
	        			father=nodeList.get(++fatherLayerStartIndex);
	        		}
	        	}
	        }
	        // new next layer
	        sonLayerStartIndex=fatherLayerStartIndex+fatherLayerNodeCount*2;
	        // next layet turn to father layer
	        fatherLayerNodeCount=nextLayerNodeCount;
	        nextLayerNodeCount=0;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
