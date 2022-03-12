class Solution
{
    static class Pair {
        int hd;
        Node node;
        Pair(int n, Node node) {
            this.hd = n;
            this.node = node;
        }
    }
    //Function to return a list of nodes visible from the top view 
    //from left to right in Binary Tree.
    static ArrayList<Integer> topView(Node root)
    {
        Queue<Pair> q = new LinkedList<>();
        Map<Integer, Node> map = new TreeMap<>();
        
        q.add(new Pair(0, root));
        
        while(!q.isEmpty()) {
            Pair curr = q.poll();
            if(!map.containsKey(curr.hd)) {
                map.put(curr.hd, curr.node);
            }
            
            if(curr.node.left!=null) {
                q.offer(new Pair(curr.hd-1, curr.node.left));
            }
            if(curr.node.right!=null) {
                q.offer(new Pair(curr.hd+1, curr.node.right));
            }
        }
        ArrayList<Integer> ans = new ArrayList();
        for(int i : map.keySet()){
            ans.add(map.get(i).data);
        }
        return ans;
    }
}
