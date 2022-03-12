class Solution
{
    static class Pair {
        int dist;
        Node node;
        Pair(int i, Node n) {
            this.dist = i;
            this.node = n;
        }
    }
    //Function to return a list containing the bottom view of the given tree.
    public ArrayList <Integer> bottomView(Node root)
    {
        Queue<Pair> q = new LinkedList<>();
        Map<Integer, Node> map = new TreeMap<>();
        
        q.offer(new Pair(0, root));
        while(!q.isEmpty()){
            Pair curr = q.poll();
            map.put(curr.dist, curr.node);
            
            if(curr.node.left!=null) {
                q.offer(new Pair(curr.dist-1, curr.node.left));
            }
            if(curr.node.right!=null) {
                q.offer(new Pair(curr.dist+1, curr.node.right));
            }
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i : map.keySet()) {
            ans.add(map.get(i).data);
        }
        return ans;
    }
}
