package leetcode.medium;

/**
 * <p>
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * i.e: 342 + 465 = 807
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 */
//public class Solution {
public class Add_two_numbers {
    public ListNode addTwoNumbers(ListNode node_1, ListNode node_2) {
        int node_1_int_value = linked_list_to_int(node_1);
        int node_2_int_value = linked_list_to_int(node_2);
        int total = node_1_int_value + node_2_int_value;

        return int_to_listNode(total);
    }

    private int linked_list_to_int(ListNode node) {
        String int_as_string = "";

        while (true) {
            int_as_string = node.val + int_as_string;

            if (node.next == null) {
                break;
            }
        }

        return Integer.parseInt(int_as_string);
    }

    private ListNode int_to_listNode(int input) {
        char[] input_as_char_array = Integer.toString(input).toCharArray();
        ListNode[] outputList = new ListNode[input_as_char_array.length];

        for (int i = 0; i < input_as_char_array.length; i++) {
            outputList[outputList.length - 1 - i] = new ListNode(input_as_char_array[i]);
            if (i != 0) {
                outputList[outputList.length - 1 - i].next = outputList[outputList.length - i];
            }
        }

        return outputList[0];
    }

    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}