package algoritmsAndStructures.lesson2;

public class MyArray {
    private int[] arr;
    private int capacity;

    //new int[5];
    public MyArray(int size) {
        this.capacity = 0;
        this.arr = new int[size];
    }

    // = {1,2,3,4,5};
    public MyArray(int[] init) {
        this.capacity = init.length;
        this.arr = init;
    }

    void display() {
        for (int i = 0; i < this.capacity; ++i) {
            System.out.print(this.arr[i] + " ");
        }
        System.out.println();
    }

    public int get(int idx) {
        return arr[idx];
    }

    public void set(int value, int idx) {
        arr[idx] = value;
    }

    // удаление всех элементов
    boolean deleteAll() {
        this.arr = new int[this.capacity];
        return true;
    }

    // удаление всех элементов по значению
    boolean deleteAll(int value) {
        int oldCapacity = this.capacity;
        for (int i = 0; i < this.capacity; i++) {
            if (this.arr[i] == value) {
                System.arraycopy(this.arr, i + 1, this.arr, i, this.capacity - i - 1);
                i--;
                --this.capacity;
            }
        }
        return oldCapacity > this.capacity;
    }

    // Вставка элемента
    void insert(int idx, int value) {
        if (this.capacity == this.arr.length) {
            int[] old = this.arr;
            this.arr = new int[old.length * 2];
            System.arraycopy(old, 0, arr, 0, old.length);
        }
        System.arraycopy(this.arr, idx, this.arr, idx + 1, ++this.capacity);
        this.arr[idx] = value;
    }
    boolean delete(int value) {
        for (int i = 0; i < this.capacity; i++) {
            if (this.arr[i] == value) {
                System.arraycopy(this.arr, i + 1, this.arr, i, this.capacity - i - 1);
                --capacity;
                return true;
            }
        }
        return false;
    }

    void append(int value) {
        if (this.capacity == this.arr.length) {
            int[] old = this.arr;
            this.arr = new int[old.length * 2];
            System.arraycopy(old, 0, arr, 0, old.length);
        }
        this.arr[this.capacity++] = value;
    }

    public boolean isInArray(int value) { // O(n)
        for (int i = 0; i < this.capacity; i++)
            if (this.arr[i] == value)
                return true;
        return false;
    }

    //O(log(N))
    public boolean hasValue(int value) {
        int low = 0;
        int high = this.capacity - 1;
        int mid;
        while (low < high) {
            mid = (low + high) / 2;
            if (value == this.arr[mid]) {
                return true;
            } else {
                if (value < this.arr[mid]) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }
        }
        return false;
    }

    private void swap(int a, int b) {
        int tmp = this.arr[a];
        this.arr[a] = this.arr[b];
        this.arr[b] = tmp;
    }

    public int sortBubble() {
        int iterCount = 0;
        for (int iter = 0; iter < capacity; iter++) {
            for (int idx = 0; idx < capacity - 1; idx++) {
                if (this.arr[idx] > this.arr[idx + 1])
                    swap(idx, idx + 1);
                iterCount++;
            }
        }
        return iterCount;
    }

    public int sortBubbleImproved() {
        int iterCount = 0;
        for (int iter = 0; iter < capacity; iter++) {
            for (int idx = 0; idx < capacity - 1; idx++) {
                if (this.arr[idx] > this.arr[idx + 1]) {
                    swap(idx, idx + 1);
                }
                if (idx + 2 < capacity && this.arr[idx + 1] > this.arr[idx + 2]){
                    swap(idx + 1, idx + 2);
                    idx++;
                }
                iterCount++;
            }
        }
        return iterCount;
    }

    public int sortSelect() {
        int iterCount = 0;
        for (int idx = 0; idx < capacity; idx++) {
            int curr = idx;
            for (int srch = idx + 1; srch < capacity; srch++) {
                if (this.arr[srch] < this.arr[curr])
                    curr = srch;
                iterCount++;
            }
            if (curr != idx)
                swap(idx, curr);
        }
        return iterCount;
    }

    public int sortInsert() {
        int iterCount = 0;
        int iterCount2;
        for (int curr = 1; curr < capacity; curr++) {
            int temp = this.arr[curr];
            int move = curr;
            iterCount++;
            iterCount2 = 0;
            while (move > 0 && this.arr[move - 1] >= temp) {
                this.arr[move] = this.arr[move - 1];
                move--;
                iterCount2++;
            }
            this.arr[move] = temp;
            iterCount += iterCount2;
        }
        return iterCount;
    }

    public int sortByCounting() {
        int iterCount = 0;
        int maxValue = 0;
        int minValue = 0;
        for (int value :
                this.arr) {
            if (minValue > value)
                minValue = value;
            if (maxValue < value)
                maxValue = value;
        }
        Integer[] mapArr = new Integer[maxValue - minValue + 1];
        int bias = minValue;
        for (int i:this.arr) {
            if (mapArr[i - bias] == null) {
                mapArr[i - bias] = 1;
            } else {
                mapArr[i - bias]++;
            }
            iterCount++;
        }
        int position = 0;
        for (int j = minValue; j < maxValue + 1; j++) {
            if (mapArr[j - bias] != null) {
                for (int k = 0; k < mapArr[j - bias]; k++) {
                    this.arr[position] = j;
                    position++;
                    iterCount++;
                }
            }
        }
        return iterCount;
    }
}