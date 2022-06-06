package algoritmsAndStructures.lesson3;

public class PriorityQueue {

        private int maxSize;
        private int[] queue;
        private int head;
        private int tail;
        private int items;

        public PriorityQueue(int s) {
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
        }
        int[] tmpArr = new int[maxSize];
       int idx = getInsertIndex(i);
        if (tail >= head || tail < 0) {
            if (idx == -1) {
                System.arraycopy(queue, 0, tmpArr, 0, queue.length);
                tmpArr[++tail] = i;
            } else if (idx == this.items || idx == 0) {
                System.arraycopy(queue, 0, tmpArr, 1, queue.length - 1);
                tmpArr[head] = i;
            } else {
                System.arraycopy(queue, 0, tmpArr, 0, idx);
                System.arraycopy(queue, idx, tmpArr, idx +1, queue.length - idx -1);
                tmpArr[idx] = i;
                tail++;
            }
        } else {
            System.arraycopy(queue, 0, tmpArr, 0, tail + 1);
            System.arraycopy(queue, head, tmpArr,
                    maxSize - (queue.length - head), queue.length - head);
            head = maxSize - head - 1;
            queue[++tail] = i;
        }
        if (tail == maxSize - 1) {
            tail = -1;
        }

        this.queue = tmpArr;
        ++items;
    }

    private int getInsertIndex(int value) {
        int med;
        int min = head;
        int max = tail;
        if (items == 0 || tail < 0 || queue[tail] <= value) {
            return -1;
        } else if (queue[head] >= value) {
            return 0;
        }
        while (true) {
            if (min <= max) {
                med = (max + min) / 2;
            } else {
                med = (min - max + maxSize)%maxSize / 2;
            }
            if (Math.abs(max - min) <= 1) {
                return queue[max] >= value ? max : max + 1;
            }
            if (queue[med] > value) {
                max = med;
            } else if (queue[med] < value) {
                min = med;
            } else {
                return med;
            }
        }
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
        public void display() {
            for (int i = 0; i < this.items; ++i) {
                System.out.print(this.queue[(i + head)%(this.items + 1)] + " ");
            }
            System.out.println();
        }
    }
