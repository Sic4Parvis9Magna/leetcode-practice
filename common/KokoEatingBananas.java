package common;

import java.util.Arrays;

/*
 * 
Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas.
The guards have gone and will come back in h hours.

Koko can decide her bananas-per-hour eating speed of k. Each hour,
she chooses some pile of bananas and eats k bananas from that pile.
If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.

Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.

Return the minimum integer k such that she can eat all the bananas within h hours.

 

Example 1:

Input: piles = [3,6,7,11], h = 8
Output: 4
Example 2:

Input: piles = [30,11,23,4,20], h = 5
Output: 30
Example 3:

Input: piles = [30,11,23,4,20], h = 6
Output: 23
 

Constraints:

1 <= piles.length <= 104
piles.length <= h <= 109
1 <= piles[i] <= 109
 */

// TODO try to do the following:
// 1- find max a[i]
// this will be max possible k
// then go backwards reducing k until number of hours will be > h
// take the pevious k
public class KokoEatingBananas {
    public static void main(String[] args) {
        test1();
        // test2();
        // test3();
        // test4();
    }

    private static void test1() {
        // given
        KokoEatingBananasSolution sol = new KokoEatingBananasSolution();
        int[] piles = new int[] { 3, 6, 7, 11 };
        int h = 8;
        int expectedResult = 4;

        // when
        int actualResult = sol.minEatingSpeed(piles, h);

        // then
        System.out.println(String.format("Result is: %d, expected result is %d", actualResult, expectedResult));
    }

    private static void test2() {
        // given
        KokoEatingBananasSolution sol = new KokoEatingBananasSolution();
        int[] piles = new int[] { 30, 11, 23, 4, 20 };
        int h = 5;
        int expectedResult = 30;

        // when
        int actualResult = sol.minEatingSpeed(piles, h);

        // then
        System.out.println(String.format("Result is: %d, expected result is %d", actualResult, expectedResult));
    }

    private static void test3() {
        // given
        KokoEatingBananasSolution sol = new KokoEatingBananasSolution();
        int[] piles = new int[] { 30, 11, 23, 4, 20 };
        int h = 6;
        int expectedResult = 23;

        // when
        int actualResult = sol.minEatingSpeed(piles, h);

        // then
        System.out.println(String.format("Result is: %d, expected result is %d", actualResult, expectedResult));
    }

    private static void test4() {
        // given
        KokoEatingBananasSolution sol = new KokoEatingBananasSolution();
        int[] piles = new int[] { 332484035, 524908576, 855865114, 632922376, 222257295, 690155293, 112677673,
                679580077, 337406589, 290818316, 877337160, 901728858, 679284947, 688210097, 692137887, 718203285,
                629455728, 941802184 };
        int arraySum = 0;
        for (int i : piles) {
            arraySum += i;
        }
        System.out.println(String.format("Array sum is: %d", arraySum));
        int h = 823855818;
        int expectedResult = 14;

        // when
        int actualResult = sol.minEatingSpeed(piles, h);

        // then
        System.out.println(String.format("Result is: %d, expected result is %d", actualResult, expectedResult));
    }
}

class KokoEatingBananasSolution {
    public int minEatingSpeed(int[] piles, int h) {
        long arrSum = sumArray(piles);
        // int perfectRatio = (int) ((arrSum / h) + (arrSum % h == 0 ? 0 : 1));
        int perfectRatio = piles.length / h + (piles.length / h == 0 ? 0 : 1);
        System.out.printf("Perfect ratio is : %d\n", perfectRatio);

        return gethMinFromTheTop(perfectRatio, piles, h);
    }

    private int gethMinFromTheTop(int top, int[] piles, int hours) {
        int prevMin = top;
        int nextMin = prevMin;
        while (true) {
            nextMin -= 1;
            long calcHours = calculateHours(piles, nextMin);
            if (calcHours > hours || nextMin == 1) {
                return prevMin;
            }
            prevMin = nextMin;
        }
    }
    // public int minEatingSpeed(int[] piles, int h) {
    // int nextSpeed = 1;
    // while (true) {
    // long requiredHours = calculateHours(piles, nextSpeed);
    // if (requiredHours <= h) {
    // return nextSpeed;
    // }
    // nextSpeed++;
    // }
    // }

    private long calculateHours(int[] piles, int speed) {
        long numberOfHours = 0;
        for (int pile : piles) {
            numberOfHours += pile / speed;
            numberOfHours += pile % speed == 0 ? 0 : 1;
        }

        return numberOfHours;
    }

    private long sumArray(int[] arr) {
        long arraySum = 0;
        for (int i = 0; i < arr.length; i++) {
            arraySum += i;
        }

        return arraySum;
    }
}