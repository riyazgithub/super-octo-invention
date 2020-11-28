package com.recursion;

/**
 * Definition for singly-linked list.
 */
 class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

class Solution {
  public ListNode swapPairs(ListNode head) {
    ListNode newHead = new ListNode(-1);
    if(head!=null)
    helperSwap(head,newHead);
    return newHead.next;
  }

  private void helperSwap(ListNode head, ListNode newHead) {
    if(head == null) return;
    if(head.next == null){
    newHead.next = new ListNode(head.val);
    return;
	}
	newHead.next = new ListNode(head.next.val, null);
    newHead = newHead.next;
	newHead.next = new ListNode(head.val, null);
	helperSwap(head.next.next, newHead.next);
  }

  private void printNode(ListNode head) {
    while (head!=null){
	  System.out.print(head.val + "->");
      head = head.next;
	}
	System.out.println();
  }
  public ListNode reverseList(ListNode head) {

    if(head==null || head.next == null)
      return head;
    ListNode p = reverseList(head.next);
    head.next.next = head;
    head.next = null;
    return p;
  }
}