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
    ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3)));
    System.out.println(new Solution().middleNode(listNode));
  }
}

class Solution {

  public ListNode middleNode(ListNode head) {
    int n = 0;
    int i = 1;
    ListNode listNode = new ListNode(0, head);
    while (head != null) {
      n++;
      head = head.next;
    }
    n = n / 2 + 1;
    head = listNode.next;
    while (i < n) {
      i++;
      head = head.next;
    }
    return head;
  }
}
