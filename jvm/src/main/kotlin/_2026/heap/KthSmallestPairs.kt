package _2026.heap

import java.util.PriorityQueue
import kotlin.math.asin

class KthSmallestPairs {
    fun kSmallestPairs(nums1: IntArray, nums2: IntArray, k: Int): List<List<Int>> {
        val ans = mutableListOf<List<Int>>()
        val heap = PriorityQueue<Pair<Int, Int>>(compareBy { nums1[it.first]+nums2[it.second] })
        nums1.indices.forEach { heap.add(Pair(it, 0)) }
        while (ans.size < k) {
            val nextP = heap.poll()
            ans.add(listOf(nums1[nextP.first], nums2[nextP.second]))
            if (nextP.second + 1 < nums2.size) {
                heap.add(Pair(nextP.first, nextP.second+1))
            }
        }
        return ans
    }

    fun kSmallestPairs3(nums1: IntArray, nums2: IntArray, k: Int): List<List<Int>> {
        val ans = mutableListOf<List<Int>>()
        val heap = PriorityQueue<Pair<Int, Int>>(compareBy { it.first+it.second })
        nums2.forEach { heap.add(Pair(nums1[0], it)) }
        for(i in 1 until nums1.size) {
            for (j in 0 until nums2.size) {
                if (ans.size == k) return ans
                val next = heap.poll()
                ans.add(listOf(next.first, next.second))
                heap.add(Pair(nums1[i], nums2[j]))
            }
        }
        return ans
    }


    fun kSmallestPairs2(nums1: IntArray, nums2: IntArray, k: Int): List<List<Int>> {
        val ans = mutableListOf<List<Int>>()
        var i1 = 0
        var i2 = 0
        ans.add(listOf(nums1[i1], nums2[i2]))
        while (ans.size < k) {
            // both have more
            if (i1+1< nums1.size && i2+1<nums2.size) {
                if ((nums1[i1+1] + nums2[i2]) > (nums2[i2+1] + nums1[i1])) {
                    i2++
                } else {
                    i1++
                }
            } else if (i1+1 >= nums1.size) {
                i2++
            } else {
                i1++
            }
            ans.add(listOf(nums1[i1], nums2[i2]))
        }
        return ans
    }
}