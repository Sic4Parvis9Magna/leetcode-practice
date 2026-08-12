

'''
291 / 305 test cases passed.

Last executed input:
0.00001
2147483647

Runtime Error Message:
RecursionError: maximum recursion depth exceeded in comparison
    if n == 0:
Line 3 in myPow (Solution.py)
  [Previous line repeated 996 more times]
    return x * self.myPow(x, n-1) if n > 0 else 1/(x * self.myPow(x, (-1*n)-1))
Line 8 in myPow (Solution.py)
    return x * self.myPow(x, n-1) if n > 0 else 1/(x * self.myPow(x, (-1*n)-1))
Line 8 in myPow (Solution.py)
    return x * self.myPow(x, n-1) if n > 0 else 1/(x * self.myPow(x, (-1*n)-1))
Line 8 in myPow (Solution.py)
'''


class Solution:
    def myPow(self, x: float, n: int) -> float:
        abs_x = abs(x)
        if abs_x > 0 and abs_x < 1:
            counter = 0
            current_value = abs_x
            while current_value < 1:
                current_value *= 10
                counter += 1
            return self.myPow(current_value, n)/self.myPow(10, counter*n)

        if n < 0:
            return 1/self.myPow(x, abs(n))
        if n == 0:
            return 1
        if n == 1:
            return x
        
        return x * self.myPow(x, n - 1)

        # return x * self.myPow(x, n-1) if n > 0 else 1/(x * self.myPow(x, (-1*n)-1))
