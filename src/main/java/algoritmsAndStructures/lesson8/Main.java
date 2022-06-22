package algoritmsAndStructures.lesson8;

import java.util.LinkedList;
import java.util.Objects;

public class Main {
    private static class Cat {
        int age;
        String name;

        public int getKey() {
            return age;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Cat cat = (Cat) o;
            return age == cat.age && Objects.equals(name, cat.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(age, name);
        }

        public Cat(int age) {
            this.age = age;
        }
    }

    static class HashTable {
        private LinkedList<Cat>[] hashArr;
        private int arrSize;

        public HashTable(int size) {
            this.arrSize = size;
            this.hashArr = new LinkedList[size];
        }

        private int hashFunction (int key) {
            return key % arrSize;
        }

        public void insert(Cat item) {
            int key = item.getKey();
            int hashVal = hashFunction(key);
            if (hashArr[hashVal] == null) {
                LinkedList<Cat> ll = new LinkedList<>();
                ll.add(item);
                hashArr[hashVal] = ll;
            } else {
                hashArr[hashVal].add(item);
            }
        }

        public Cat delete(int key) {
            int hashVal = hashFunction(key);
            if (hashArr[hashVal] != null) {
                for (Cat c :
                        hashArr[hashVal]) {
                    if (c.getKey() == key) {
                        hashArr[hashVal].remove(c);
                        return c;
                    }
                }
            }
            return null;
        }

        public Cat find(int key) {
            int hashVal = hashFunction(key);
            if (hashArr[hashVal] != null) {
                for (Cat c :
                        hashArr[hashVal]) {
                    if (c.getKey() == key) {
                        return c;
                    }
                }
            }
            return null;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("HashTable[");
            for (LinkedList<Cat> ll :
                    hashArr) {
                sb.append("{");
                if (ll == null) {
                    sb.append("*");
                } else {
                    for (Cat c :
                            ll) {
                        sb.append(c.getKey());
                        sb.append(", ");
                    }
                }
                sb.append("}, ");
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        HashTable ht = new HashTable(5);
        ht.insert(new Cat(5));
        ht.insert(new Cat(4));
        ht.insert(new Cat(6));
        ht.insert(new Cat(9));
        ht.insert(new Cat(23));
        ht.insert(new Cat(12));
        ht.insert(new Cat(14));
        ht.insert(new Cat(21));
        ht.insert(new Cat(13));
        ht.insert(new Cat(16));
        ht.insert(new Cat(17));

        System.out.println(ht);

        System.out.println(ht.find(21));

    }
}
