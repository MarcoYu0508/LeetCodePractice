package Array;

import org.junit.Assert;
import org.junit.Test;

public class DesignHashMapTest {


    private static class MyHashMap {
        private final int size = 500;
        private final Node[] nodes = new Node[size];

        public MyHashMap() {

        }

        public void put(int key, int value) {
            int index = hash(key);
            Node temp = nodes[index];
            if (temp == null) {
                nodes[index] = new Node(key, value);
                return;
            }
            Node prev = temp;
            while (temp != null) {
                if (temp.key == key) {
                    temp.val = value;
                    return;
                }
                prev = temp;
                temp = temp.next;
            }
            prev.next = new Node(key, value);
        }

        public int get(int key) {
            int index = hash(key);
            Node temp = nodes[index];
            while (temp != null) {
                if (temp.key == key) {
                    return temp.val;
                }
                temp = temp.next;
            }
            return -1;
        }

        public void remove(int key) {
            int index = hash(key);
            Node temp = nodes[index];
            if (temp == null){
                return;
            }
            if (temp.key == key){
                nodes[index] = nodes[index].next;
            }
            while (temp.next != null ){
                if (temp.next.key == key){
                    temp.next = temp.next.next;
                    return;
                }
                temp = temp.next;
            }
        }

        private int hash(int key) {
            return key % size;
        }

        private static class Node {
            Node next;
            int key;
            int val;

            Node(int key, int val) {
                this.key = key;
                this.val = val;
            }
        }

    }

    @Test
    public void basicTest() {
        MyHashMap map = new MyHashMap();
        map.put(1, 1);
        map.put(2, 2);
        Assert.assertEquals(1, map.get(1));
        Assert.assertEquals(-1, map.get(3));
        map.put(2, 1);
        Assert.assertEquals(1, map.get(2));
        map.remove(2);
        Assert.assertEquals(-1, map.get(2));
    }
}
