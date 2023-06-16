package practice.extracurricular.leetcode.linked_list_cycle;

public class ListNode {

  int val;
  ListNode next;

  ListNode(int x) {
    val = x;
    next = null;
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
    ListNode listNode = new ListNode(3);
    listNode.next = new ListNode(2);
    listNode.next.next = new ListNode(0);
    listNode.next.next.next = new ListNode(4);
//    listNode.next.next.next.next = listNode.next;
    System.out.println(new Solution().hasCycle(listNode));
  }
}

class Solution {

  public boolean hasCycle(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (slow.equals(fast)) {
        return true;
      }
    }
    return false;
  }
}