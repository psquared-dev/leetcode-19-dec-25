package blind75;

import java.util.*;

public class NumberOfIslands {
    public static ArrayList<List<Integer>> getAdjacentCoord(int row, int col, char[][] coord) {
        int MAX_COL = coord[0].length;
        int MAX_ROW = coord.length;
        ArrayList<List<Integer>> result = new ArrayList<>();

        if (row > 0) {
            //  up
            result.add(List.of(row - 1, col));
        }

        if (row < MAX_ROW - 1) {
            //  down
            result.add(List.of(row + 1, col));
        }

        if (col > 0) {
            //  left
            result.add(List.of(row, col - 1));
        }

        if (col < MAX_COL - 1) {
            // right
            result.add(List.of(row, col + 1));
        }

        return result;
    }

    public static void bfs(int row, int col, HashSet<List<Integer>> visited, char[][] grid) {
        LinkedList<List<Integer>> queue = new LinkedList<>();
        queue.offer(List.of(row, col));
        visited.add(List.of(row, col));

        while (!queue.isEmpty()) {
            List<Integer> polled = queue.poll();
            for (List<Integer> adj : getAdjacentCoord(polled.get(0), polled.get(1), grid)) {
                if (!visited.contains(adj) && grid[adj.get(0)][adj.get(1)] == '1') {
                    queue.offer(adj);
                    visited.add(adj);
                }
            }
        }
    }

    public static int numIslands(char[][] grid) {
        HashSet<List<Integer>> visited = new HashSet<>();
        int count = 0;

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (!visited.contains(List.of(row, col)) && grid[row][col] == '1') {
                    bfs(row, col, visited, grid);
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(numIslands(new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        }));

        System.out.println(numIslands(new char[][]{
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        }));
    }
}
