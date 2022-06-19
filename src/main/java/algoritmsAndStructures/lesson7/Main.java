package algoritmsAndStructures.lesson7;

import algoritmsAndStructures.lesson3.Queue;
import algoritmsAndStructures.lesson3.Stack;

import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Graph gr = new Graph();
        gr.addVertex('A'); //0
        gr.addVertex('B'); //1
        gr.addVertex('C'); //2
        gr.addVertex('D'); //3
        gr.addVertex('E'); //4
        gr.addVertex('F'); //5
        gr.addVertex('G'); //6
        gr.addVertex('H'); //7
        gr.addVertex('I'); //8
        gr.addVertex('J'); //9

        gr.addEdge(0, 1);
        gr.addEdge(0, 2);
        gr.addEdge(0, 3);
        gr.addEdge(1, 4);
        gr.addEdge(4, 7);
        gr.addEdge(7, 9);
        gr.addEdge(2, 5);
        gr.addEdge(5, 8);
        gr.addEdge(8, 9);
        gr.addEdge(3, 6);
        gr.addEdge(6, 9);

        //gr.depthTraverse(0);
        List<Integer> routes = gr.getOptimalRoute(0, 9);
        System.out.println(routes);
    }
    public static class Graph {

        class Vertex {
            public char label;
            public boolean isVisited;

            public Vertex(char label) {
                this.label = label;
                this.isVisited = false;
            }

            @Override
            public String toString() {
                return "Vertex{" +
                        "label=" + label +
                        ", wasVisited=" + isVisited +
                        '}';
            }
        }

        private final int MAX_VERTICES = 32;
        private Vertex[] vertices;
        private int[][] adjacency;
        private int size;

        public Graph() {
            vertices = new Vertex[MAX_VERTICES];
            adjacency = new int[MAX_VERTICES][MAX_VERTICES];
            size = 0;
        }

        public void addVertex(char label) {
            vertices[size++] = new Vertex(label);
        }

        public void addEdge(int start, int end) {
            adjacency[start][end] = 1;
            adjacency[end][start] = 1;
        }

        public void displayVertex(int ver) {
            System.out.println(vertices[ver]);
        }

        private int getUnvisited(int ver) {
            for (int i = 0; i < size; i++) {
                if (adjacency[ver][i] == 1 &&
                    !vertices[i].isVisited) {
                    return i;
                }
            }
            return -1;
        }

        public void depthTraverse(int ver) {
            Stack stack = new Stack(size);
            vertices[ver].isVisited = true;
            displayVertex(ver);
            stack.push(ver);
            while (!stack.isEmpty()) {
                int v = getUnvisited(stack.peek());
                if (v == -1) {
                    stack.pop();
                } else {
                    vertices[v].isVisited = true;
                    displayVertex(v);
                    stack.push(v);
                }
            }
            for (int i = 0; i < size; i++) {
                vertices[i].isVisited = false;
            }
        }

        public void widthTraverse() {
            Queue queue = new Queue(size);
            vertices[0].isVisited = true;
            displayVertex(0);
            queue.insert(0);
            int v2;
            while (!queue.isEmpty()) {
                int v1 = queue.remove();
                while ((v2 = getUnvisited(v1)) != -1) {
                    vertices[v2].isVisited = true;
                    displayVertex(v2);
                    queue.insert(v2);
                }
            }
            for (int i = 0; i < size; i++) {
                vertices[i].isVisited = false;
            }
        }
        public List<Integer> getOptimalRoute(int start, int finish) {
            Queue queue = new Queue(size);
            List<Integer>[] routes = new LinkedList[size];
            List<Integer> route = null;
            vertices[start].isVisited = true;
            queue.insert(start);
            routes[0] = new LinkedList<>();
            routes[0].add(start);
            int v2;
            while (!queue.isEmpty()) {
                int v1 = queue.remove();
                while ((v2 = getUnvisited(v1)) != -1) {
                    for (int i = 0; i < size; i++) {
                        if (routes[i] == null) {
                            routes[i] = new LinkedList<>();
                            for (int j = 0; j < routes[i - 1].size() - 1; j++) {
                                routes[i].add(routes[i - 1].get(j));
                            }
                            routes[i].add(v2);
                            if (v2 == finish) {
                                route = routes[i];
                            }
                            break;
                        } else if (routes[i].size() > 0 && routes[i].get(routes[i].size() - 1) == v1) {
                            routes[i].add(v2);
                            if (v2 == finish) {
                                route = routes[i];
                            }
                            break;
                        }
                    }
                    vertices[v2].isVisited = true;
                    queue.insert(v2);
                    if (v2 == finish) {
                        break;
                    }
                }
            }
            for (int i = 0; i < size; i++) {
                vertices[i].isVisited = false;
            }
            return route;
        }
    }
}