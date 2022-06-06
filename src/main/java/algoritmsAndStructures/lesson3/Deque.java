package algoritmsAndStructures.lesson3;

public class Deque {

        private int maxSize;
        private int[] deque;
        private int head;
        private int tail;
        private int items;

        public Deque(int s) {
            maxSize = s;
            deque = new int[maxSize];
            head = -1;
            tail = -1;
            items = 0;
        }

        public boolean isEmpty() {
            return items == 0;
        }

        public boolean isFull() {
            return this.items == this.maxSize;
        }

        public void insertLeft(int i) {
            if (isFull()) {
                maxSize *= 2;
            }
            int[] tmpArr = new int[maxSize];
            if (tail >= head) {
                System.arraycopy(deque, 0, tmpArr, 1, deque.length - 1);
                head = 0;
            } else {
                System.arraycopy(deque, 0, tmpArr, 0, tail);
                System.arraycopy(deque, head, tmpArr,
                        head + 1, deque.length - tail);
            }
            deque = tmpArr;
            tail++;
            deque[head] = i;
            ++items;
        }

        public void insertRight(int i) {
            if (isFull()) {
                maxSize *= 2;
            }
            int[] tmpArr = new int[maxSize];
            if (tail >= head) {
                System.arraycopy(deque, 0, tmpArr, 0, deque.length);
                if(head < 0) {head = 0;}
            } else {
                System.arraycopy(deque, 0, tmpArr, 0, Math.max(tail, 0) + 1);
                System.arraycopy(deque, head, tmpArr,
                        maxSize - (deque.length - head), deque.length - head);
                //head = maxSize - head - 1;
            }
            deque = tmpArr;
            deque[++tail] = i;
            ++items;
        }

        public int removeLeft() {
            checkForEmpty();
            int temp = deque[head++];
            head %= maxSize;
            items--;
            return temp;
        }

        public int removeRight() {
            checkForEmpty();
            int temp = deque[tail--];
            items--;
            if (tail == -1) {
                tail = head + items;
            }
            return temp;
        }

    private void checkForEmpty() {
        if (isEmpty()) throw new RuntimeException("Empty deque");
    }

    public int peekLeft() {
        checkForEmpty();
        return getValue(this.head);
        }

        public int peekRight() {
            checkForEmpty();
            return getValue(this.tail);
        }

        private int getValue(int idx) {
            return this.deque[idx];
        }

    void display() {
        for (int i = 0; i < this.items; ++i) {
            System.out.print(this.deque[(i + head)%(this.items + 1)] + " ");
        }
        System.out.println();
    }

    void displayAll() {
        for (int i = 0; i < this.maxSize; ++i) {
            System.out.print(this.deque[i] + " ");
        }
        System.out.println();
    }

}
