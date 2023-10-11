// https://leetcode.com/problems/max-number-of-k-sum-pairs/description/

class Solution {
    public int maxOperations(int[] nums, int k) {

        int count = 0 ;
        int n = nums.length;
        HashMap<Integer,Integer> HM = new HashMap<>();

        for(int i = 0 ; i<n ; i++){
            HM.put(nums[i], HM.getOrDefault(nums[i], 0) + 1);
        }

        for(int i = 0 ; i<n ; i++){
            int a = nums[i];
            int b = k - a;

            
            if(HM.containsKey(b)  &&  HM.containsKey(a)){
                if(a == b && HM.get(a)<2){
                continue;
                }
                count++;

                HM.put(b, HM.getOrDefault(b, 0) - 1);
                if(HM.get(b) == 0){
                    HM.remove(b);
                }

                HM.put(a, HM.getOrDefault(a, 0) - 1);
                if(HM.get(a) == 0){
                    HM.remove(a);
                }

                
            }
        }


        return count;
    }
}
