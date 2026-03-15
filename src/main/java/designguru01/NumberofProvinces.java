package designguru01;

import java.util.*;

public class NumberofProvinces {
    public static class Solution {
        private boolean[] visited;
        private Map<Integer, Set<Integer>> graph;

        public void createGraph(int[][] isConnected) {
            System.out.println();
            graph = new HashMap<>();
            for (int i = 0; i < isConnected.length; i++) {
                Set<Integer> adj1 = graph.computeIfAbsent(i, k -> new HashSet<>());

                for (int j = i + 1; j < isConnected.length; j++) {
                    System.out.println("i: " + i + " j = " + j);

                    Set<Integer> adj2 = graph.computeIfAbsent(j, k -> new HashSet<>());

                    if (isConnected[i][j] == 1) {
                        adj1.add(j);
                        adj2.add(i);
                    }
                }
            }
            System.out.println(graph);
        }

        public void bfs(int node) {
            LinkedList<Integer> queue = new LinkedList<>();
            queue.add(node);
            visited[node] = true;

            while (!queue.isEmpty()) {
                int polled = queue.poll();
                for (int adj : graph.get(polled)) {
                    if (!visited[adj]) {
                        queue.add(adj);
                        visited[adj] = true;
                    }
                }
            }
        }

        public int findProvinces(int[][] isConnected) {
            createGraph(isConnected);
            visited = new boolean[isConnected.length];
            int provinceCount = 0;

            for (int i : graph.keySet()) {
                if (!visited[i]) {
                    bfs(i);
                    provinceCount++;
                }
            }


            return provinceCount;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.findProvinces(new int[][]{
//                {1, 1, 0},
//                {1, 1, 0},
//                {0, 0, 1}
//        }));

//        System.out.println(solution.findProvinces(new int[][]{
//                {1, 0, 0},
//                {0, 1, 0},
//                {0, 0, 1}
//        }));

//        System.out.println(solution.findProvinces(new int[][]{
//                {1, 0, 0, 1},
//                {0, 1, 1, 0},
//                {0, 1, 1, 0},
//                {1, 0, 0, 1},
//        }));

        System.out.println(solution.findProvinces(new int[][]{
                {1},
        }));


//        System.out.println(solution.findProvinces(new int[][]{
//                {1, 0, 0, 1},
//                {0, 1, 0, 0},
//                {0, 0, 1, 1},
//                {1, 0, 1, 1},
//        }));
    }
}
