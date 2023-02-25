/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    Map<Integer,Node> cloned=new HashMap<>();
    public Node cloneGraph(Node node) {
        if(node==null)
            return null;
        if(cloned.containsKey(node.val)) return cloned.get(node.val);
        Node clone=new Node(node.val);
        cloned.put(node.val,clone);
        for(Node neighbor:node.neighbors)
            clone.neighbors.add(cloneGraph(neighbor));
        return cloned.get(node.val);
    }
}