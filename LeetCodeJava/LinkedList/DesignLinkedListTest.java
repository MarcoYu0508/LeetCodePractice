package LinkedList;

import org.junit.Assert;
import org.junit.Test;

public class DesignLinkedListTest {
    private static class MyLinkedList {

        static class Node {
            Node next = null;
            int val = 0;

            public Node(int val) {
                this.val = val;
            }
        }

        private Node head;
        private Node tail;
        private int size;

        public MyLinkedList() {

        }

        public int get(int index) {
            if (index < 0 || index >= this.size) return -1;

            Node current = this.head;
            while (index-- > 0) {
                current = current.next;
            }
            return current.val;
        }

        public void addAtHead(int val) {
            Node node = new Node(val);
            if (this.size == 0) {
                this.head = node;
                this.tail = node;
            } else {
                node.next = this.head;
                this.head = node;
            }
            this.size++;
        }

        public void addAtTail(int val) {
            Node node = new Node(val);
            if (this.size == 0) {
                this.head = node;
            } else {
                this.tail.next = node;
                node.next = null;
            }
            this.tail = node;
            this.size++;
        }

        public void addAtIndex(int index, int val) {
            if (index < 0 || index > this.size) return;

            if (index == 0) {
                addAtHead(val);
            } else if (index == this.size) {
                addAtTail(val);
            } else {
                Node previous = getNodeAt(index - 1);
                Node next = previous.next;
                Node current = new Node(val);
                previous.next = current;
                current.next = next;
                this.size++;
            }
        }

        public void deleteAtIndex(int index) {
            if (index < 0 || index >= this.size) return;

            if (index == 0) {
                deleteFirst();
            } else if (index == this.size - 1) {
                deleteLast();
            } else {
                Node previous = getNodeAt(index - 1);
                Node current = previous.next;
                previous.next = previous.next.next;
                current.next = null;
                this.size--;
            }
        }

        public Node getNodeAt(int index) {
            Node curr = head;
            while (index-- > 0) {
                curr = curr.next;
            }

            return curr;
        }

        private void deleteFirst() {
            if (this.size == 0) return;
            else if (this.size == 1) {
                this.head = null;
                this.tail = null;
            } else {
                Node current = this.head;
                Node forward = current.next;
                current.next = null;
                this.head = forward;
            }
            this.size--;
        }

        private void deleteLast() {
            if (this.size == 0) return;
            else if (this.size == 1) {
                this.head = null;
                this.tail = null;
            } else {
                Node secondLast = getNodeAt(this.size - 2);
                secondLast.next = null;
                this.tail = secondLast;
            }
            this.size--;
        }
    }

    @Test
    public void basicTest() {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(1);
        myLinkedList.addAtTail(3);
        myLinkedList.addAtIndex(1, 2);    // linked list becomes 1->2->3
        Assert.assertEquals(2, myLinkedList.get(1));    // return 2
        myLinkedList.deleteAtIndex(1);              // now the linked list is 1->3
        Assert.assertEquals(3, myLinkedList.get(1));    // return 3
    }

}
