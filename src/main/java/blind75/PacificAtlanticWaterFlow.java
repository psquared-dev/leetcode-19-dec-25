package blind75;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class PacificAtlanticWaterFlow {
    public static List<List<Integer>> getAdjacents(int row, int col, int[][] heights) {
        int MAX_COL = heights[0].length;
        int MAX_ROW = heights.length;

        List<List<Integer>> result = new ArrayList<>();

        if (row > 0) {
            // up
            result.add(List.of(row - 1, col));
        }

        if (row < MAX_ROW - 1) {
            // down
            result.add(List.of(row + 1, col));
        }

        if (col > 0) {
            // left
            result.add(List.of(row, col - 1));
        }

        if (col < MAX_COL - 1) {
            // right
            result.add(List.of(row, col + 1));
        }

        return result;
    }

    private static void bfs(int row, int col, HashSet<List<Integer>> visited, int[][] heights) {
        LinkedList<List<Integer>> queue = new LinkedList<>();

        queue.add(List.of(row, col));
        visited.add(List.of(row, col));

        while (!queue.isEmpty()) {
            List<Integer> polled = queue.poll();
            for (List<Integer> adj : getAdjacents(polled.get(0), polled.get(1), heights)) {
                int polledHeight = heights[polled.get(0)][polled.get(1)];
                int adjHeight = heights[adj.get(0)][adj.get(1)];

                if (!visited.contains(adj) && polledHeight <= adjHeight ) {
                    queue.add(List.of(adj.get(0), adj.get(1)));
                    visited.add(List.of(adj.get(0), adj.get(1)));
                }
            }
        }
    }

    public static List<List<Integer>> pacificAtlantic(int[][] heights) {
        int MAX_ROW = heights.length;
        int MAX_COL = heights[0].length;
        HashSet<List<Integer>> atlanticVisited = new HashSet<>();
        HashSet<List<Integer>> pacificVisited = new HashSet<>();
        List<List<Integer>> result = new ArrayList<>();

        // atlantic row
        for (int col = 0; col < MAX_COL; col++) {
            if (!atlanticVisited.contains(List.of(MAX_ROW - 1, col))) {
                bfs(MAX_ROW - 1, col, atlanticVisited, heights);
            }
        }

        // atlantic col
        for (int row = 0; row < MAX_ROW; row++) {
            if (!atlanticVisited.contains(List.of(row, MAX_COL - 1))) {
                bfs(row, MAX_COL - 1, atlanticVisited, heights);
            }
        }

        // pacific row
        for (int col = 0; col < MAX_COL; col++) {
            if (!pacificVisited.contains(List.of(0, col))) {
                bfs(0, col, pacificVisited, heights);
            }
        }

        // pacific col
        for (int row = 0; row < MAX_ROW; row++) {
            if (!pacificVisited.contains(List.of(row, 0))) {
                bfs(row, 0, pacificVisited, heights);
            }
        }

//        System.out.println(atlanticVisited);
//        System.out.println(pacificVisited);

        for (int row = 0; row < MAX_ROW; row++) {
            for (int col = 0; col < MAX_COL; col++) {
                if(pacificVisited.contains(List.of(row, col)) &&
                        atlanticVisited.contains(List.of(row, col))){
                    result.add(List.of(row, col));
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(pacificAtlantic(new int[][]{
                {1, 2, 2, 3, 5},
                {3, 2, 3, 4, 4},
                {2, 4, 5, 3, 1},
                {6, 7, 1, 4, 5},
                {5, 1, 1, 2, 4}
        }));

//        System.out.println(pacificAtlantic(new int[][]{
//                {1}
//        }));
    }
}
