package algoritmsAndStructures.lesson4;

public class Main {
    public static void main(String[] args) {
        testLinkedList();
        testQueue();
        testIter();
    }

    private static void testIter() {
        LinkedList linkedList = new LinkedList();
        Cat cat1 = new Cat(2, "Pushok");
        Cat cat2 = new Cat(3, "Murzik");
        Cat cat3 = new Cat(1, "Vasya");
        Cat cat4 = new Cat(4, "Filya");

        linkedList.pushTail(cat1);
        linkedList.pushHead(cat2);
        linkedList.pushTail(cat3);
        linkedList.pushHead(cat4);

        LinkedList.Iterator iter = linkedList.iterator();
        System.out.println(linkedList);
        iter.reset();
        do {
            System.out.println(iter.getCurrent());
        } while (iter.next());

        iter.atEnd();
        iter.deleteCurrent();

        System.out.println(linkedList);
    }

    private static void testQueue() {

        Cat cat1 = new Cat(2, "Pushok");
        Cat cat2 = new Cat(3, "Murzik");
        Cat cat3 = new Cat(1, "Vasya");
        Cat cat4 = new Cat(4, "Filya");

        QueueInt queue = new Queue();
        queue.push(cat1);
        queue.push(cat2);
        queue.push(cat3);

        System.out.println(queue);

        while (!queue.isEmpty()) {
            System.out.println(queue.pop());
        }
    }

    private static void testLinkedList() {
        LinkedList linkedList = new LinkedList();
        Cat cat1 = new Cat(2, "Pushok");
        Cat cat2 = new Cat(3, "Murzik");
        Cat cat3 = new Cat(1, "Vasya");
        Cat cat4 = new Cat(4, "Filya");

        linkedList.pushTail(cat1);
        linkedList.pushHead(cat2);
        linkedList.pushTail(cat3);
        linkedList.pushHead(cat4);

        System.out.println(linkedList);

        linkedList.delete(cat3);

        System.out.println(linkedList);

        while (!linkedList.isEmpty()) {
            linkedList.popHead();
        }

    }

    private static class Cat{
        int age;
        String name;

        public Cat(int age, String name) {
            this.age = age;
            this.name = name;
        }
        @Override
        public String toString() {
            return String.format("Cat(%s, %d)", name, age);
        }
    }
    private static class LinkedList {
        private static class Node {
            Cat c;
            Node next;
            Node previous;

            public Node(Cat c) {
                this.c = c;
            }

            @Override
            public String toString() {
                return String.format("N(%s)", c);
            }
        }

        public static class Iterator {
            private Node current;
            private final LinkedList l;
            public Iterator(LinkedList l) {
                this.l = l;
            }

            public void reset() {
                this.current = l.getHead();
            }

            public boolean next() {
                if (current != null && current.next != null) {
                    current = current.next;
                    return true;
                }
                return false;
            }

            public Cat getCurrent() {
                if (current == null) {
                    return null;
                }
                return current.c;
            }

            public boolean atEnd() {
                return current.next == null;
            }

            public void insertAfter(Cat c) {
                if (current == null) {
                    return;
                } else if (current.next == null) {
                    l.pushTail(c);
                } else {
                    Node newNode = new Node(c);
                    newNode.next = current.next;
                    newNode.previous = current;
                    newNode.next.previous = newNode;
                    newNode.previous.next = newNode;
                }
            }

            public void insertBefore(Cat c) {
                if (current == null) {
                    return;
                } else if (current.previous == null) {
                    l.pushHead(c);
                } else {
                    Node newNode = new Node(c);
                    newNode.next = current;
                    newNode.previous = current.previous;
                    newNode.next.previous = newNode;
                    newNode.previous.next = newNode;
                }
            }

            public void deleteCurrent() {
                if (current == null) {
                    return;
                } else if (current.previous == null) {
                    l.popHead();
                } else if (current.next == null) {
                    l.popTail();
                } else {
                    current.previous.next = current.next;
                    current.next.previous = current.previous;
                }
            }
        }

        private Node getHead() {
            return head;
        }


        private static Node head;
        private static Node tail;

        public Iterator iterator() {
            return new Iterator(this);
        }
        public void pushHead(Cat c) {
            Node newNode = new Node(c);
            newNode.next = head;
            if (head != null) {
                head.previous = newNode;
            } else {
                tail = newNode;
            }
            head = newNode;

        }

        public void pushTail(Cat c) {
            Node newNode = new Node(c);
            newNode.previous = tail;
            if (tail != null) {
                tail.next = newNode;
            } else {
                head = newNode;
            }
            tail = newNode;
        }

        public Cat peekHead() {
            return head.c;
        }

        public Cat popHead() {
            if (head == null) {
                return null;
            }
            Node tmp = head;
            if (head.next == null) {
                tail = null;
                head = null;
            } else {
                head = head.next;
                head.previous = null;
            }
            return tmp.c;
        }

        public Cat peekTail() {
            return tail.c;
        }

        public Cat popTail() {
            if (tail == null) {
                return null;
            }
            Node tmp = tail;
            if (tail.previous == null) {
                tail = null;
                head = null;
            } else {
                tail = tail.previous;
                tail.next = null;
            }
            return tmp.c;
        }

        public void delete(Cat c) {
            Node current = head;
            while (current != null) {
                if (current.c.equals(c)) {
                    if (current.previous == null) {
                        head = current.next;
                    } else {
                        current.previous.next = current.next;
                    }
                    if (current.next == null) {
                        tail = current.previous;
                    } else {
                        current.next.previous = current.previous;
                    }
                    break;
                }
                current = current.next;
            }
        }

        public boolean isEmpty() {
            return head == null;
        }

        @Override
        public String toString() {
            Node current = head;
            StringBuilder sb = new StringBuilder("[ ");
            while (current != null) {
                sb.append(current);
                current = current.next;
                sb.append((current == null) ? "" : ", ");
            }
            sb.append(" ]");
            return sb.toString();
        }
    }

    public interface QueueInt {

        void push(Cat c);
        Cat pop();
        boolean isEmpty();
    }
    private static class Queue extends LinkedList implements QueueInt{
        @Override
        public void push(Cat c) {
            this.pushTail(c);
        }
        @Override
        public Cat pop() {
            return this.popTail();
        }
    }
}
