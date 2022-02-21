class Solution {
    public int majorityElement(int[] nums) {
        int major = nums[0];
        int count = 1;
        for(int i=1;i<nums.length;i++){
            if(nums[i] == major){
                count++;
            }
            else{
                if(count>0){
                    count--;
                }
                else{
                    major = nums[i];
                    count = 1;
                }
            }
            
        }
        return major;
    }
}