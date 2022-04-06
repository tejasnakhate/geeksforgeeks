class Solution{
    //Function to check whether there is a subarray present with 0-sum or not.
    static boolean findsum(int arr[],int n)
    {
        Set<Integer> set = new HashSet();
        int curr = 0;
        
        for(int i : arr) {
            curr+=i;
            
            // either element is 0, or presum is 0 or we have seen presum before
            // then we will return true which means we have seen a subarray with 0 sum
            if(i==0 || curr==0 || set.contains(curr)) return true;
            set.add(curr);
        }
        
        return false;
    }
}
