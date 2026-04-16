Problem 1: Min Cost Climbing Stairs
Question:
During our second recitation, we talked about a recursion algorithm, Climbing Stairs.
This question is an improvement on that algorithm.
You are given an integer array cost where cost[i] is the cost of i-th step on a staircase.
Once you pay the cost, you can either climb one or two steps. You can either start from
the step with index 0 or the step with index 1.
Write an algorithm that returns the minimum cost to reach the top of the floor. And draw
the recursion tree for cost = [10, 15, 20].
Example:
Input: cost = [10, 15, 20]
Output: 15
Explanation: Start at index 1, pay 15, and climb two steps to reach the top.
Input: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
Output: 6
Explanation: Cheapest path is 1 -> 3 -> 4 -> 6 -> 7 -> 9 -> top with a total cost of 6.
Hint:
●
Solving this recursively without dynamic programming may result in a time limit
exceeded error on LeetCode, but for this homework question, DP is not needed.
Problem 2: Jump Game
Question: https://leetcode.com/problems/jump-game/
You are given an integer array nums. You are initially positioned at the array's first
index, and each element in the array represents your maximum jump length at that
position.
Return true if you can reach the last index, or false otherwise.
Example 1:
Input: nums = [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:
Input: nums = [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3. Its maximum jump length is 0, which
means you cannot move forward.
Task:
●
●
Draw the recursion tree for nums = [2,3,1,1,4] to show all possible recursive calls.
You may only use recursion (no loops or extra data structures).
Problem 3: Word Break (Recursive)
Problem Statement：
Given a string s and a dictionary of strings wordDict, return true if s can be segmented
into a space-separated sequence of one or more dictionary words.
Example 1:
Input: s = "leetcode", wordDict = ["leet", "code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".
Example 2:
Input: s = "applepenapple", wordDict = ["apple", "pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen
apple".
Example 3:
Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
Output: false
Task:
●
●
●
Implement a recursive approach to solve the problem.
You are only allowed to use recursion (no loops or extra data structures).
Draw the recursion tree for s = "leetcode" and wordDict = ["leet", "code"].
Problem 4: Find the First Index of an Element (10 pts)
Description:
Given an array arr and an integer x, implement a recursive function to return the first
occurrence (0-based index) of x in arr. If x is not found, return -1.
Your function should not use loops; it must be implemented using recursion.
Constraints:
●
●
●
1 <= arr.length <= 10^5
-10^9 <= arr[i], x <= 10^9
The function must be efficient with minimal auxiliary space.
Example:
Testcase 1:
Input:
arr = [2, 4, 1, 4, 7]
x = 4
Output:
1
Explanation:
The first occurrence of 4 is at index 1.
Testcase 2:
Input:
arr = [5, 3, 8, 9, 1]
x = 10
Output:
-1
Explanation:
The element 10 is not present in the array, so we return -1.
Problem 5: Implement Power Function (10 pts)
Description:
Given a floating-point number x and an integer n, implement a function to calculate x
raised to the power of n (xⁿ) using recursion.
Constraints:
●
●
●
-100 <= n <= 100
-100.0 <= x <= 100.0
The function must run efficiently in O(log n) time.
Example:
Testcase 1:
Input:
x = 2.10000
n = 3
Output:
9.26100
Explanation:
2.1³ = 2.1 × 2.1 × 2.1 = 9.261
Testcase 2:
Input:
x = 2.00000
n = 10
Output:
1024.00000
Explanation:
2¹⁰ = 1024
Testcase 3:
Input:
x = 2.00000
n = -2
Output:
0.25000
Explanation:
2⁻² = 1 / (2²) = 1 / 4 = 0.25
Problem 6: Find the Missing Number using Recursion
Description:
You are given an array containing n-1 distinct numbers in the range 1 to n. This means
that exactly one number is missing from the sequence. Your task is to find the missing
number using recursion.
Constraints:
●
●
●
●
The array contains n-1 elements.
The elements in the array are distinct.
The numbers are in the range 1 to n.
The solution must use recursion.
Input:
●
An integer array arr of size n-1, containing numbers in the range [1, n] with one
missing.
An integer n representing the expected full range.
●
Output:
●
Return the missing number.
Examples:
Example 1:
Input:
arr = [1, 2, 4, 5]
n = 5
Output:
3
Explanation:
The numbers in the full range [1, 2, 3, 4, 5] should be present. The missing number is
3.
Example 2:
Input:
arr = [2, 3, 1, 5]
n = 5
Output:
4
Explanation:
The full sequence should be [1, 2, 3, 4, 5,]. The missing number is 4.
Problem 7: Reverse String Recursively
Question:
Given a string s, implement a recursive function to return its reverse.
Note: You must solve this problem using recursion only (i.e., without using iterative
loops).
Constraints:
●
●
1 <= s.length <= 1000
s consists of printable ASCII characters.
Example 1:
Input: s = "hello"
Output: "olleh"
Explanation: The reverse of "hello" is "olleh".
Example 2:
Input: s = "a"
Output: "a"
Explanation: The reverse of a single-character string is the string itself.
Problem 8: Permutations of an Array
Question:
Given an array nums of distinct integers, return all possible permutations of the array.
You must solve the problem using recursion (e.g., backtracking) and must not use any
iterative loops.
Constraints:
●
●
1 <= nums.length <= 6
-10 <= nums[i] <= 10
Example 1:
Input: nums = [1, 2, 3]
Output: [[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], [3,2,1]]
Explanation: All possible permutations of [1, 2, 3] are returned.
Example 2:
Input: nums = [0, 1]
Output: [[0,1], [1,0]]
Explanation: Both possible permutations of [0, 1] are returned.
Problem 9: Sort a Stack Recursively
Question:
You are given a stack containing n integers. Your task is to sort the stack in ascending
order using recursion only. After sorting, the smallest element should be at the top of the
stack. You are not allowed to use any loops (for, while) or any auxiliary data structures
(arrays, lists, queues, etc.)—only the call stack and a few extra variables are permitted.
Note:
●
●
You may only use standard stack operations such as push(), pop(), and peek().
A helper recursive function to insert an element into a sorted stack is
recommended.
Constraints:
●
●
1 <= n <= 1000
-10^9 <= stack[i] <= 10^9
Example 1:
Input: stack = [34, 3, 31, 98, 92, 23]
Output: [3, 23, 31, 34, 92, 98]
Example 2:
Input: stack = [3, 5, 1, 4, 2]
Output: [1, 2, 3, 4, 5]
Problem 10: Combination Sum (10 pts)
Question:
Given an array of distinct integers candidates and a target integer target, return a list of
all unique combinations of candidates where the chosen numbers sum to target. You
may return the combinations in any order.
The same number may be chosen from candidates an unlimited number of times. Two
combinations are unique if the frequency of at least one of the chosen numbers is
different.
The test cases are generated such that the number of unique combinations that sum up
to target is less than 150 combinations for the given input.
Constraints:
●
●
●
●
1 <= candidates.length <= 30
2 <= candidates[i] <= 40
All elements of candidates are distinct.
1 <= target <= 40
Example 1:
Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]
Explanation:
2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
7 is a candidate, and 7 = 7.
These are the only two combinations.
Example 2:
Input: candidates = [2,3,5], target = 8
Output: [[2,2,2,2],[2,3,3],[3,5]]
Example 3:
Input: candidates = [2], target = 1
Output: []
Problem 11: Subsets (10 pts)
Question:
Given an integer array nums of unique elements, return all possible subsets (the power
set). The solution set must not contain duplicate subsets. Return the solution in any
order.
Constraints:
●
●
●
1 <= nums.length <= 10
-10 <= nums[i] <= 10
All the numbers are unique.
Example 1:
Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
Example 2:
Input: nums = [0]
Output: [[],[0]]
Problem 12: Generate Parentheses (10 pts)
Question:
Given n pairs of parentheses, write a function to generate all combinations of
well-formed parentheses.
Constraints:
●
●
●
1 <= nums.length <= 10
-10 <= nums[i] <= 10
All the numbers are unique.
Example 1:
Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]
Example 2:
Input: n = 1
Output: ["()"]