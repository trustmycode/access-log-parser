package practice.extracurricular.leetcode.middle_of_the_linkedlist;

import java.util.LinkedList;

public class ListNode {

  int val;
  ListNode next;

  ListNode() {
  }

  ListNode(int val) {
    this.val = val;
  }

  ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }

  @Override
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    if (next != null) {
      stringBuilder.append(val).append(", ").append(next);
    } else {
      stringBuilder.append(val);
    }
    return stringBuilder.toString();
  }
}

class Main {

  public static void main(String[] args) {
    LinkedList<String> list = new LinkedList<>();
    ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
    System.out.println(new Solution().middleNode(listNode));
  }
}

class Solution {

  public ListNode middleNode(ListNode head) {
    ListNode slowList = head;
    ListNode fastList = head;
    while (fastList != null && fastList.next != null) {
      slowList = slowList.next;
      fastList = fastList.next.next;
    }
    return slowList;
  }
}
