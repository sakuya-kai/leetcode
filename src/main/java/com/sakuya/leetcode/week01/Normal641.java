package com.sakuya.leetcode.week01;

import java.util.Arrays;


/**
 * 设计实现双端队列。
 * 你的实现需要支持以下操作：
 *
 * MyCircularDeque(k)：构造函数,双端队列的大小为k。
 * insertFront()：将一个元素添加到双端队列头部。 如果操作成功返回 true。
 * insertLast()：将一个元素添加到双端队列尾部。如果操作成功返回 true。
 * deleteFront()：从双端队列头部删除一个元素。 如果操作成功返回 true。
 * deleteLast()：从双端队列尾部删除一个元素。如果操作成功返回 true。
 * getFront()：从双端队列头部获得一个元素。如果双端队列为空，返回 -1。
 * getRear()：获得双端队列的最后一个元素。 如果双端队列为空，返回 -1。
 * isEmpty()：检查双端队列是否为空。
 * isFull()：检查双端队列是否满了。
 * 示例：
 *
 * MyCircularDeque circularDeque = new MycircularDeque(3); // 设置容量大小为3
 * circularDeque.insertLast(1);			        // 返回 true
 * circularDeque.insertLast(2);			        // 返回 true
 * circularDeque.insertFront(3);			        // 返回 true
 * circularDeque.insertFront(4);			        // 已经满了，返回 false
 * circularDeque.getRear();  				// 返回 2
 * circularDeque.isFull();				        // 返回 true
 * circularDeque.deleteLast();			        // 返回 true
 * circularDeque.insertFront(4);			        // 返回 true
 * circularDeque.getFront();				// 返回 4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/design-circular-deque
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Normal641 {

    static class MyCircularDeque {

        /**
         * 值
         */
        private int[] values;
        /**
         * 当前元素个数
         */
        private int capacity;
        /**
         * 头下标
         */
        private int head;
        /**
         * 尾下标
         */
        private int tail;

        /**
         * Initialize your data structure here. Set the size of the deque to be k.
         */
        public MyCircularDeque(int k) {
            capacity = k + 1;
            values = new int[capacity];
        }

        /**
         * Adds an item at the front of Deque. Return true if the operation is successful.
         */
        public boolean insertFront(int value) {
            if (isFull()) return false;
            head = (head - 1 + capacity) % capacity;
            values[head] = value;
            return true;
        }

        /**
         * Adds an item at the rear of Deque. Return true if the operation is successful.
         */
        public boolean insertLast(int value) {
            if (isFull()) return false;
            values[tail] = value;
            tail = (tail + 1) % capacity;
            return true;
        }

        /**
         * Deletes an item from the front of Deque. Return true if the operation is successful.
         */
        public boolean deleteFront() {
            if (isEmpty()) return false;
            head = (head + 1) % capacity;
            return true;
        }

        /**
         * Deletes an item from the rear of Deque. Return true if the operation is successful.
         */
        public boolean deleteLast() {
            if (isEmpty()) return false;
            tail = (tail - 1 + capacity) % capacity;
            return true;
        }

        /**
         * Get the front item from the deque.
         */
        public int getFront() {
            if (isEmpty()) throw new RuntimeException("deque is empty");
            return values[head];
        }

        /**
         * Get the last item from the deque.
         */
        public int getRear() {
            if (isEmpty()) throw new RuntimeException("deque is empty");
            return values[(tail - 1 + capacity) % capacity];
        }

        /**
         * Checks whether the circular deque is empty or not.
         */
        public boolean isEmpty() {
            return head == tail;
        }

        /**
         * Checks whether the circular deque is full or not.
         */
        public boolean isFull() {
            return (tail + 1) % capacity == head;
        }
    }

    public static void main(String[] args) {
        MyCircularDeque deque = new MyCircularDeque(3);
        System.out.println(deque.insertLast(1) + "   " + Arrays.toString(deque.values));
        System.out.println(deque.insertLast(2) + "   " + Arrays.toString(deque.values));
        System.out.println(deque.insertFront(3) + "   " + Arrays.toString(deque.values));
        System.out.println(deque.insertFront(4) + "   " + Arrays.toString(deque.values));
        System.out.println(deque.getRear() + "   " + Arrays.toString(deque.values));
        System.out.println(deque.isFull() + "   " + Arrays.toString(deque.values));
        System.out.println(deque.deleteLast() + "   " + Arrays.toString(deque.values));
    }

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */

}
