/**
 * Write a function that takes the binary representation of an unsigned integer
 * and returns the number of '1' bits it has (also known as the Hamming weight).
 * 
 * Note:
 * 
 * Note that in some languages, such as Java, there is no unsigned integer type.
 * In this case, the input will be given as a signed integer type. It should not
 * affect your implementation, as the integer's internal binary representation
 * is the same, whether it is signed or unsigned.
 * In Java, the compiler represents the signed integers using 2's complement
 * notation. Therefore, in Example 3, the input represents the signed integer.
 * -3.
 * 
 * 
 * Example 1:
 * Input: n = 00000000000000000000000000001011 // 11
 * Output: 3
 * Explanation: The input binary string 00000000000000000000000000001011 has a
 * total of three '1' bits.
 * 
 * Example 2:
 * Input: n = 00000000000000000000000010000000 // 128
 * Output: 1
 * Explanation: The input binary string 00000000000000000000000010000000 has a
 * total of one '1' bit.
 * 
 * Example 3:
 * Input: n = 11111111111111111111111111111101 // 4294967293
 * Output: 31
 * Explanation: The input binary string 11111111111111111111111111111101 has a
 * total of thirty one '1' bits.
 * 
 * 
 * Constraints:
 * 
 * The input must be a binary string of length 32.
 * 
 * 
 * Follow up: If this function is called many times, how would you optimize it?
 * 
 * NumberOfOneBits
 * 
 * STATUS: COMPLETED
 * 
 */
public class NumberOfOneBits {

}

public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int setBits = 0;
        for (int i = 0; i < 32; i++) {
            boolean bitSet = getBitValue(n, i);
            if (bitSet) {
                setBits++;
            }
        }

        return setBits;
    }

    private boolean getBitValue(int number, int order) {
        return (number & (1 << order)) != 0;
    }
}