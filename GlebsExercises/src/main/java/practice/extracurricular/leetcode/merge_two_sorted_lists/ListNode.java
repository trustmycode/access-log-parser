package practice.extracurricular.leetcode.merge_two_sorted_lists;


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
    ListNode listNode1 = new ListNode(2);
    ListNode listNode2 = new ListNode(1);
    System.out.println(listNode1);
    System.out.println(listNode2);
    System.out.println(new Solution().mergeTwoLists(listNode1, listNode2));
  }
}

class Solution {

  public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    ListNode listNodeMerge = new ListNode();
    ListNode tmp = listNodeMerge;
    if (list1 == null && list2 != null) {
      return list2;
    }
    if (list1 != null && list2 == null) {
      return list1;
    }
    while (list1 != null || list2 != null) {
      if (list1 == null || list2 != null && list2.val < list1.val) {
        listNodeMerge.next = new ListNode(list2.val);
        listNodeMerge = listNodeMerge.next;
        list2 = list2.next;
      } else {
        listNodeMerge.next = new ListNode(list1.val);
        listNodeMerge = listNodeMerge.next;
        list1 = list1.next;
      }
    }

    return tmp.next;
  }
}
