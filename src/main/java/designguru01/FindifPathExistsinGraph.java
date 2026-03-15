package designguru01;

import java.util.*;

public class FindifPathExistsinGraph {
    public static class Solution {
        private boolean[] visited;
        public Map<Integer, Set<Integer>> graph;

        public void createGraph(int[][] edges) {
            graph = new HashMap<>();

            for (int i = 0; i < edges.length; i++) {
                int[] edge = edges[i];

                graph.merge(edge[0], new HashSet<>(Set.of(edge[1])), (oldSet, newSet) -> {
                    oldSet.add(edge[1]);
                    return oldSet;
                });

                graph.merge(edge[1], new HashSet<>(Set.of(edge[0])), (oldSet, newSet) -> {
                    oldSet.add(edge[0]);
                    return oldSet;
                });
            }

            System.out.println(graph);
        }

        public boolean validPath(int n, int[][] edges, int start, int end) {
            createGraph(edges);
            if(graph.isEmpty()){
                return false;
            }

            visited = new boolean[n];
            LinkedList<Integer> queue = new LinkedList<>();
            queue.add(start);
            visited[start] = true;

            while (!queue.isEmpty()) {
                int popped = queue.pop();
                for (int adj : graph.get(popped)) {
                    if (!visited[adj]) {
                        queue.add(adj);
                        visited[adj] = true;
                    }
                }
            }

            System.out.println(Arrays.toString(visited));

            return visited[end];
        }

    }


    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.validPath(4, new int[][]{
//                {0, 1},
//                {1, 2},
//                {2, 3}
//        }, 0, 3));

        System.out.println(solution.validPath(2, new int[][]{}, 0, 1));
    }
}
