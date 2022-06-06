package algoritmsAndStructures.lesson3;

public class Main {
    private static class Stack {
        private int maxSize; // СЂР°Р·РјРµСЂ
        private int[] stack; // РјРµСЃС‚Рѕ С…СЂР°РЅРµРЅРёСЏ
        private int head;    // РІРµСЂС€РёРЅР°

        public Stack(int size) {
            this.maxSize = size;
            this.stack = new int[this.maxSize];
            this.head = -1;
        }

        public boolean isEmpty() {
            return this.head == -1;
        }

        public boolean isFull() {
            return this.head == this.maxSize - 1;
        }

        public void push(int i) {
            if (isFull()) {
                this.maxSize *= 2;
                int[] newStack = new int[this.maxSize];
                System.arraycopy(this.stack, 0, newStack, 0, this.stack.length);
                this.stack = newStack;
            }
            this.stack[++this.head] = i;
        }

        public int pop() {
            if (isEmpty()) throw new RuntimeException("Stack is empty"); //ret -1
            return this.stack[this.head--];
        }

        public int peek() {
            return this.stack[this.head];
        }
    }

    private static class Queue {
        private int maxSize; // СЂР°Р·РјРµСЂ
        private int[] queue; // РјРµСЃС‚Рѕ С…СЂР°РЅРµРЅРёСЏ
        private int head;    // РѕС‚СЃСЋРґР° СѓС…РѕРґСЏС‚
        private int tail;    // СЃСЋРґР° РїСЂРёС…РѕРґСЏС‚
        private int items;   // С‚РµРєСѓС‰РµРµ РєРѕР»РёС‡РµСЃС‚РІРѕ

        public Queue(int s) {
            maxSize = s;
            queue = new int[maxSize];
            head = 0;
            tail = -1;
            items = 0;
        }

        public boolean isEmpty() {
            return (items == 0);
        }

        public boolean isFull() {
            return (items == maxSize);
        }

        public int size() {
            return items;
        }

        public void insert(int i) {
            if (isFull()) {
                maxSize *= 2;
                int[] tmpArr = new int[maxSize];
                if (tail >= head) {
                    System.arraycopy(queue, 0, tmpArr, 0, queue.length);
                } else {
                    System.arraycopy(queue, 0, tmpArr, 0, tail + 1);
                    System.arraycopy(queue, head, tmpArr,
                            maxSize - (queue.length - head), queue.length - head);
                    head = maxSize - head - 1;
                }
            }
            if (tail == maxSize - 1) {
                tail = -1;
            }
            queue[++tail] = i;
            ++items;
        }

        public int remove() {
            int temp = queue[head++];
            head %= maxSize;
            items--;
            return temp;
        }

        public int peek() {
            return queue[head];
        }
    }

    public static void main(String[] args) {

        testDeque();
        System.out.println();
        String str = "{{}}{";
        System.out.println(isCloseBrackets(str));
        System.out.println();
        testPriorityQueue();

    }

    private static void testPriorityQueue() {
        PriorityQueue queue = new PriorityQueue(10);
        queue.insert(1);
        queue.insert(2);
        queue.insert(4);
        queue.insert(5);
        queue.insert(6);
        queue.insert(7);
        queue.insert(3);
        queue.insert(6);
        queue.insert(2);
        queue.display();
        System.out.println(queue.remove());
        queue.display();
        queue.insert(4);
        queue.display();
    }

    private static boolean isCloseBrackets(String str) {
        Deque queue = new Deque(10);
        if (str.isEmpty()) {
            return true;
        } else if (str.indexOf("{") > str.indexOf("}")) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            if (str.substring(i, i + 1).equals("{")) {
                queue.insertRight(1);
            } else if (str.substring(i, i + 1).equals("{") & queue.isEmpty()) {
                return false;
            } else if (str.substring(i, i + 1).equals("}")) {
                queue.removeRight();
            }
            queue.display();
        }
        queue.displayAll();
        return queue.isEmpty();
    }

    static void testDeque() {
        Deque deque = new Deque(10);

        deque.insertLeft(5);
        deque.insertLeft(2);
        deque.insertLeft(1);
        deque.insertRight(9);
        deque.insertLeft(7);
        //deque.display();
/*
        System.out.println(deque.peekLeft());
        System.out.println(deque.peekRight());
*/
        //deque.display();
        //System.out.println(deque.removeLeft());
        deque.display();
        System.out.println(deque.removeRight());
        System.out.println(deque.removeRight());
        System.out.println(deque.removeRight());
        System.out.println(deque.removeRight());
        //deque.display();
        //System.out.println(deque.peekLeft());
        //System.out.println(deque.peekRight());
        System.out.println(deque.removeRight());
        //System.out.println(deque.peekRight());
        //System.out.println(deque.removeRight());
        deque.display();
        deque.insertLeft(5);
        deque.insertLeft(2);
        deque.insertLeft(1);
        deque.insertRight(9);
        deque.insertLeft(7);
        deque.display();
    }

}
