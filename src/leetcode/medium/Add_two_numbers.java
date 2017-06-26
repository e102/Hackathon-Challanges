package leetcode.medium;

import java.math.BigInteger;

/**
 * <p>
 * You are given two non-empty linked lists representing two non-negative longegers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * i.e: 342 + 465 = 807
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 */

//TODO: Handle length 1 linked lists

public class Add_two_numbers {
    public ListNode addTwoNumbers(ListNode node_1, ListNode node_2) {
        BigInteger node_1_value = new BigInteger(linked_list_to_string(node_1));
        BigInteger node_2_value = new BigInteger(linked_list_to_string(node_2));
        BigInteger total = node_1_value.add(node_2_value);

        BigInteger reversedTotal = reverseBigInt(total);
        return bigInt_to_listNode(reversedTotal);
    }

    private String linked_list_to_string(ListNode node) {
        StringBuilder string_value = new StringBuilder();

        while (true) {
            string_value.insert( 0, node.val);

            if (node.next == null) {
                break;
            } else {
                node = node.next;
            }
        }

        return string_value.toString();
    }

    private ListNode bigInt_to_listNode(BigInteger input) {
        char[] input_as_char_array = new String(input.toByteArray()).toCharArray();
        ListNode[] outputList = new ListNode[input_as_char_array.length];

        for (int i = 0; i < input_as_char_array.length; i++) {
            outputList[i] = new ListNode(Character.getNumericValue(input_as_char_array[i]));
            if (i != 0) {
                outputList[i - 1].next = outputList[i];
            }
        }

        return outputList[0];
    }

    private BigInteger reverseBigInt(BigInteger input) {    //todo number format error
        System.out.println(new String(input.toByteArray()).toCharArray());
        char[] input_as_char_array = new String(input.toByteArray()).toCharArray();
        for (int i = 0; i < input_as_char_array.length / 2; i++) {
            char temp = input_as_char_array[i];
            input_as_char_array[i] = input_as_char_array[input_as_char_array.length - i - 1];
            input_as_char_array[input_as_char_array.length - i - 1] = temp;
        }

        return new BigInteger(new String(input_as_char_array));
    }

    private class ListNode {
        long val;
        ListNode next;

        ListNode(long x) {
            val = x;
        }
    }
}