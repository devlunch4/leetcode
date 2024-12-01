# 1. Two Sum

<!-- Language and Info Table Set for English -->
[한글 버전/KOREAN Ver](README_ko.md)

|Difficulty |Topics |Hints |URL |
|---:|---:|---:|---:|
|Easy|<code>Array</code><code>Hash Table</code> |3 |https://leetcode.com/problems/two-sum/description/ |

---
<p>&nbsp;</p>

<!-- Contents -->
## Table of Contents
- [Description](#description)
- [Examples](#examples)
- [Solutions](#solutions)

<!-- Find class "elfjS" in Origianl html -->
## Description

<div class="elfjS" data-track-load="description_content"><p>Given an array of integers <code>nums</code>&nbsp;and an integer <code>target</code>, return <em>indices of the two numbers such that they add up to <code>target</code></em>.</p>

<p>You may assume that each input would have <strong><em>exactly</em> one solution</strong>, and you may not use the <em>same</em> element twice.</p>

<p>You can return the answer in any order.</p>

<p>&nbsp;</p>

## Examples
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> nums = [2,7,11,15], target = 9
<strong>Output:</strong> [0,1]
<strong>Explanation:</strong> Because nums[0] + nums[1] == 9, we return [0, 1].
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> nums = [3,2,4], target = 6
<strong>Output:</strong> [1,2]
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> nums = [3,3], target = 6
<strong>Output:</strong> [0,1]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>2 &lt;= nums.length &lt;= 10<sup>4</sup></code></li>
	<li><code>-10<sup>9</sup> &lt;= nums[i] &lt;= 10<sup>9</sup></code></li>
	<li><code>-10<sup>9</sup> &lt;= target &lt;= 10<sup>9</sup></code></li>
	<li><strong>Only one valid answer exists.</strong></li>
</ul>

<p>&nbsp;</p>
<strong>Follow-up:&nbsp;</strong>Can you come up with an algorithm that is less than <code>O(n<sup>2</sup>)</code><font face="monospace">&nbsp;</font>time complexity?</div>

<p>&nbsp;</p>

## Solutions

#### JAVA (Array)
```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
                int numsLength = nums.length;
        for (int i = 0; i < numsLength - 1; ++i) {
            for (int j = i + 1; j < numsLength; ++j) {
                if (target == nums[i] + nums[j]) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[2];
    }
}
```

#### JAVA (Hash Table)
```java
import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }
}
```
