# NUM TITLE

[한글 버전/KOREAN Ver](README_ko.md)

|Difficulty |Topics |Hints |URL |
|---:|---:|---:|---:|
|Hard|<code>Array</code> <code>Binary Search</code> <code>Divide and Conquer</code> |0 |https://leetcode.com/problems/median-of-two-sorted-arrays/description/ |

---
<p>&nbsp;</p>

## Table of Contents
- [Description](#description)
- [Examples](#examples)
- [Solutions](#solutions)

<!-- Find class "elfjS" in Origianl html -->
## Description

<div class="elfjS" data-track-load="description_content"><p>Given two sorted arrays <code>nums1</code> and <code>nums2</code> of size <code>m</code> and <code>n</code> respectively, return <strong>the median</strong> of the two sorted arrays.</p>

<p>The overall run time complexity should be <code>O(log (m+n))</code>.</p>

<p>&nbsp;</p>


## Examples
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> nums1 = [1,3], nums2 = [2]
<strong>Output:</strong> 2.00000
<strong>Explanation:</strong> merged array = [1,2,3] and median is 2.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> nums1 = [1,2], nums2 = [3,4]
<strong>Output:</strong> 2.50000
<strong>Explanation:</strong> merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>nums1.length == m</code></li>
	<li><code>nums2.length == n</code></li>
	<li><code>0 &lt;= m &lt;= 1000</code></li>
	<li><code>0 &lt;= n &lt;= 1000</code></li>
	<li><code>1 &lt;= m + n &lt;= 2000</code></li>
	<li><code>-10<sup>6</sup> &lt;= nums1[i], nums2[i] &lt;= 10<sup>6</sup></code></li>
</ul>
</div>

<p>&nbsp;</p>
<p>&nbsp;</p>

## Solutions



#### JAVA
```java
class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 항상 nums1이 짧은 배열이 되도록 설정
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;
        int totalLeft = (m + n + 1) / 2;

        int left = 0;
        int right = m;

        while (left <= right) {
            int i = (left + right) / 2; // nums1의 분할 위치
            int j = totalLeft - i; // nums2의 분할 위치

            // 분할 기준 값 설정 (인덱스가 경계를 넘는 경우 최소/최대 값으로 보정)
            int maxLeft1 = (i == 0) ? Integer.MIN_VALUE : nums1[i - 1];
            int minRight1 = (i == m) ? Integer.MAX_VALUE : nums1[i];

            int maxLeft2 = (j == 0) ? Integer.MIN_VALUE : nums2[j - 1];
            int minRight2 = (j == n) ? Integer.MAX_VALUE : nums2[j];

            // 유효한 분할인지 확인
            if (maxLeft1 <= minRight2 && maxLeft2 <= minRight1) {
                // 총 길이가 짝수면 중앙 두 수의 평균
                if ((m + n) % 2 == 0) {
                    return (Math.max(maxLeft1, maxLeft2) + Math.min(minRight1, minRight2)) / 2.0;
                } else {
                    // 홀수면 중앙값 하나 반환
                    return Math.max(maxLeft1, maxLeft2);
                }
            } else if (maxLeft1 > minRight2) {
                // 왼쪽 값이 너무 큼 → 더 왼쪽으로 이동
                right = i - 1;
            } else {
                // 오른쪽 값이 너무 큼 → 더 오른쪽으로 이동
                left = i + 1;
            }
        }

        // 여기 도달하면 잘못된 입력이므로 예외 발생
        throw new IllegalArgumentException("입력이 유효하지 않습니다.");
    }
}

```
