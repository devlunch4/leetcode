# 2. 두 수 더하기

<!-- Language and Info Table Set for English -->
[영문 버전/ENGLISH Ver](README.md)

|Difficulty |Topics |Hints |URL |
|---:|---:|---:|---:|
|Medium|<code>Linked_List</code><br><code>Math</code><br><code>Recursion</code> |0 |https://leetcode.com/problems/add-two-numbers/description/ |

---
<p>&nbsp;</p>

<!-- Contents -->
## Table of Contents
- [설명](#설명)
- [예제](#예제)
- [Solutions](#solutions)

<!-- Find class "elfjS" in Origianl html -->
## 설명

<div class="elfjS" data-track-load="description_content">
    <p>두 개의 <strong>비어 있지 않은</strong> 연결 리스트가 주어지며, 이는 두 개의 음이 아닌 정수를 나타냅니다.<br>
    숫자는 <strong>역순</strong>으로 저장되어 있으며, 각 노드는 한 자리 숫자를 포함하고 있습니다.<br>
    두 숫자를 더한 결과를 연결 리스트로 반환하세요.</p>
    <br>
    <p>두 숫자는 숫자 0 자체를 제외하고는 선행 0이 포함되지 않는다고 가정할 수 있습니다.</p>
</div>

<p>&nbsp;</p>

## 예제

<p><strong class="example">예제 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/10/02/addtwonumber1.jpg" style="width: 483px; height: 342px;">
<pre><strong>입력:</strong> l1 = [2,4,3], l2 = [5,6,4]
<strong>출력:</strong> [7,0,8]
<strong>설명:</strong> 342 + 465 = 807.
</pre>

<p><strong class="example">예제 2:</strong></p>

<pre><strong>입력:</strong> l1 = [0], l2 = [0]
<strong>출력:</strong> [0]
</pre>

<p><strong class="example">예제 3:</strong></p>

<pre><strong>입력:</strong> l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
<strong>출력:</strong> [8,9,9,9,0,0,0,1]
</pre>

<p>&nbsp;</p>
<p><strong>제약:</strong></p>

<ul>
	<li>각 연결 리스트의 노드 개수는 <code>[1, 100]</code> 범위에 속합니다.</li>
	<li><code>0 &lt;= Node.val &lt;= 9</code></li>
	<li>리스트는 선행 0이 없는 숫자를 나타냅니다.</li>
</ul>

<p>&nbsp;</p>

## Solutions

#### JAVA
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