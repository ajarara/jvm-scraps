class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val index = mutableMapOf<Int, MutableList<Int>>()
        for ((idx, num) in nums.withIndex()) {
            index.computeIfAbsent(num) { mutableListOf() }
                .add(idx)
        }
        for ((idx, num) in nums.withIndex()) {
            val lookingFor = target - num
            val indices = index[lookingFor]
            if (indices != null) {
                val otherIdx = indices.firstOrNull {
                    it != idx
                }
                if (otherIdx != null) {
                    return intArrayOf(idx, otherIdx)
                }
            }
        }
        error("Guaranteed a solution for ${nums.joinToString()}")


    }
}