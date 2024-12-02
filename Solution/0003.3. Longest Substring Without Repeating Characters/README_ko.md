# 3. 중복되지 않는 가장 긴 부분 문자열 찾기

[영문 버전/ENGLISH Ver](README.md)

|Difficulty |Topics |Hints |URL |
|---:|---:|---:|---:|
|Easy|<code>Hash_Table</code><br><code>String</code><br><code>Sliding_Window</code> |1 |https://leetcode.com/problems/longest-substring-without-repeating-characters/description/ |

---
<p>&nbsp;</p>

## Table of Contents
- [설명](#설명)
- [예제](#예제)
- [Solutions](#solutions)

<!-- Find class "elfjS" in Origianl html -->
## 설명
<p>문자열 <code>s</code>가 주어졌을 때, 중복된 문자가 없는 <strong>가장 긴</strong> <strong><span style="border-bottom: 1px dotted; cursor: help;" title="부분 문자열은 문자열 내에서 연속적으로 나타나는 비어 있지 않은 문자들의 시퀀스를 의미합니다.">부분 문자열</span></strong>의 길이를 구하세요.</p> <p>&nbsp;</p>


<p>&nbsp;</p>

## 예제

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

<p><strong>제약 사항:</strong></p>
 
<ul>
    <li><code>0 &lt;= s.length &lt;= 5 * 10<sup>4</sup></code></li> 
    <li><code>s</code>는 영어 대소문자, 숫자, 기호 및 공백으로 이루어져 있습니다.</li>
</ul> 

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