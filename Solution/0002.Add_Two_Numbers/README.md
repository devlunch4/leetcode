# 2. Add Two Numbers

<!-- Language and Info Table Set for English -->
[한글 버전/KOREAN Ver](README_ko.md)

|Difficulty |Topics |Hints |URL |
|---:|---:|---:|---:|
|Medium|<code>Linked_List</code><br><code>Math</code><br><code>Recursion</code> |0 |https://leetcode.com/problems/add-two-numbers/description/ |

---
<p>&nbsp;</p>

<!-- Contents -->
## Table of Contents
- [Description](#description)
- [Examples](#examples)
- [Solutions](#solutions)

<!-- Find class "elfjS" in Origianl html -->
## Description

<div class="elfjS" data-track-load="description_content"><p>You are given two <strong>non-empty</strong> linked lists representing two non-negative integers. The digits are stored in <strong>reverse order</strong>, and each of their nodes contains a single digit. Add the two numbers and return the sum&nbsp;as a linked list.</p>

<p>You may assume the two numbers do not contain any leading zero, except the number 0 itself.</p>

<p>&nbsp;</p>

## Examples
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/10/02/addtwonumber1.jpg" style="width: 483px; height: 342px;">
<pre><strong>Input:</strong> l1 = [2,4,3], l2 = [5,6,4]
<strong>Output:</strong> [7,0,8]
<strong>Explanation:</strong> 342 + 465 = 807.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> l1 = [0], l2 = [0]
<strong>Output:</strong> [0]
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
<strong>Output:</strong> [8,9,9,9,0,0,0,1]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li>The number of nodes in each linked list is in the range <code>[1, 100]</code>.</li>
	<li><code>0 &lt;= Node.val &lt;= 9</code></li>
	<li>It is guaranteed that the list represents a number that does not have leading zeros.</li>
</ul>
</div>

<p>&nbsp;</p>

## Solution

JAVA
```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node = new ListNode(0);
        ListNode result = node;
        int carry = 0;

        while (l1 != null || l2 != null) {
            int sum = carry;

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            if (sum >= 10) {
                node.next = new ListNode(sum - 10);
                carry = 1;
            } else {
                node.next = new ListNode(sum);
                carry = 0;
            }
            node = node.next;
        }

        if (carry == 1) {
            node.next = new ListNode(1); 
        }
        return result.next;
    }    
}
```