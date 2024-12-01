# **1. 두 수의 합**

<!-- Language and Info Table Set for English -->
[English Ver/영어 버전](README.md)

|Difficulty |Topics |Hints |URL |
|---:|---:|---:|---:|
|Easy|<code>Array</code><code>Hash Table</code> |3 |https://leetcode.com/problems/two-sum/description/ |

---
<p>&nbsp;</p>

# 목차

- [설명](#설명)
- [예시](#예시)
- [제약 조건](#제약-조건)

## 설명

- 정수 배열 `nums`와 정수 `target`이 주어졌을 때, 합이 `target`이 되는 두 숫자의 인덱스를 반환하세요.

- 각 입력에는 **정확히 한 가지 솔루션**이 있다고 가정할 수 있으며, **같은 요소를 두 번 사용할 수는 없습니다.**
- 답변은 어떤 순서로 반환해도 됩니다.

<p>&nbsp;</p>

## **예시**

**예시 1:**

```plaintext
입력: nums = [2,7,11,15], target = 9
출력: [0,1]
설명: nums[0] + nums[1] == 9 이므로 [0, 1]을 반환합니다.
```

**예시 2:**

```plaintext
입력: nums = [3,2,4], target = 6
출력: [1,2]
```

**예시 3:**

```plaintext
입력: nums = [3,3], target = 6
출력: [0,1]
```

---

### **제약 조건**

- `2 <= nums.length <= 10^4`
- `-10^9 <= nums[i] <= 10^9`
- `-10^9 <= target <= 10^9`
- **정확히 하나의 유효한 답변이 존재합니다.**

---

### **추가 문제**

- 시간 복잡도가 `O(n^2)`보다 적은 알고리즘을 생각할 수 있나요?


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
