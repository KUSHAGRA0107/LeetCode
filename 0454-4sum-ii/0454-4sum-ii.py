class Solution:
    def fourSumCount(self, nums1: List[int], nums2: List[int], nums3: List[int], nums4: List[int]) -> int:
        hashMap = {}
        for i in range(len(nums3)):
            for j in range(len(nums4)):
                hashMap[nums3[i] + nums4[j]] = hashMap.get(nums3[i] + nums4[j], 0) + 1
            
        answer = 0
        for i in range(len(nums1)):
            for j in range(len(nums2)):
                sum = - nums1[i] - nums2[j]
                answer += hashMap.get(sum, 0)
        return answer