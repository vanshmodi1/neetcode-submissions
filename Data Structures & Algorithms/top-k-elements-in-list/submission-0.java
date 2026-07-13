class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> freq = new HashMap<>();

        //count freq
        for(int num : nums){
            freq.put(num, freq.getOrDefault(num, 0) +1);
        }

        //bucket array
        List<Integer>[] bucket = new ArrayList[nums.length + 1];

        for(int key: freq.keySet()){
            int count = freq.get(key);

            if(bucket[count] == null){
                bucket[count] = new ArrayList<>();
            }

            bucket[count].add(key);
        }

        //top k elements
        int[] ans = new int[k];
        int index = 0;

        for(int i = bucket.length - 1; i>=0 && index<k; i--){
            if(bucket[i]!=null){
                for(int num : bucket[i]){
                    ans[index++] = num;

                    if(index==k) break;
                }
            }
        }
        return ans;
    }
}
