class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> countNums = new HashMap<>();

        for(int num : nums){
            countNums.put(num, countNums.getOrDefault(num, 0)+1);
        }

        PriorityQueue <Integer> minHeap = new PriorityQueue<>( 
            (a, b) -> countNums.get(a) - countNums.get(b));

        for(int num : countNums.keySet()){
            minHeap.add(num);
            if(minHeap.size() > k){
                minHeap.poll();
            }
        }

        int[] result = new int[k];

        for(int i = 0; i<k; i++){
            result[i] = minHeap.poll();
        }

        return result;
        
    }
}
