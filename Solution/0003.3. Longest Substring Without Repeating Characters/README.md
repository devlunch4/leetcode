# 3. Longest Substring Without Repeating Characters

[한글 버전/KOREAN Ver](README_ko.md)

|Difficulty |Topics |Hints |URL |
|---:|---:|---:|---:|
|Easy|<code>Hash_Table</code><br><code>String</code><br><code>Sliding_Window</code> |1 |https://leetcode.com/problems/longest-substring-without-repeating-characters/description/ |

---
<p>&nbsp;</p>

## Table of Contents
- [Description](#description)
- [Examples](#examples)
- [Solutions](#solutions)

<!-- Find class "elfjS" in Origianl html -->
## Description
<p>Given a string <code>s</code>, find the length of the <strong>longest</strong> 
<strong><span style="border-bottom: 1px dotted; cursor: help;" title="A substring is a contiguous non-empty sequence of characters within a string.">substring</span></strong> without repeating characters.</p>


<p>&nbsp;</p>

## Examples

<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> s = "abcabcbb"
<strong>Output:</strong> 3
<strong>Explanation:</strong> The answer is "abc", with the length of 3.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> s = "bbbbb"
<strong>Output:</strong> 1
<strong>Explanation:</strong> The answer is "b", with the length of 1.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> s = "pwwkew"
<strong>Output:</strong> 3
<strong>Explanation:</strong> The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
    <li><code>0 &lt;= s.length &lt;= 5 * 10<sup>4</sup></code></li>
    <li><code>s</code> consists of English letters, digits, symbols and spaces.</li>
</ul>
</div>

<p>&nbsp;</p>

## Solutions

#### JAVA
```java
class Solution {
    public int lengthOfLongestSubstring(String s) {
          Set<Object> set = new HashSet<>();
        int strLength = s.length();
        int begin = 0;
        int end = 0;
        int res = 0;
        while (end < strLength) {
            if (set.contains(s.charAt(end))) {
                set.remove(s.charAt(begin++));
            } else {
                set.add(s.charAt(end++));
                res = Math.max(res, end - begin);
            }
        }
        return res;
    }
}
```