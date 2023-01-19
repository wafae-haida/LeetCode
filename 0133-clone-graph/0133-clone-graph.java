
class Solution{
    Map<Integer,Node> map=new HashMap<>();
    Node cloneGraph(Node node){
        if(node==null)return null;
        if(map.containsKey(node.val))return map.get(node.val);
        Node copy=new Node(node.val);
        map.put(copy.val,copy);
        for(Node nei:node.neighbors){
            copy.neighbors.add(cloneGraph(nei));
        }
        return copy;
    }
}