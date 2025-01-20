    import java.util.HashMap;

    class Pair {
        int x;
            int y;
                Pair(int x, int y) {
                        this.x = x;
                                this.y = y;
                                    }
                                    }

                                    class Solution {
                                        public int firstCompleteIndex(int[] arr, int[][] mat) {
                                                HashMap<Integer, Pair> map = new HashMap<>();
                                                        int m = mat.length;
                                                                int n = mat[0].length;
                                                                        int[] row = new int[m];
                                                                                int[] col = new int[n];
                                                                                        
                                                                                                // Populate the map with positions of elements in mat
                                                                                                        for (int i = 0; i < m; i++) {
                                                                                                                    for (int j = 0; j < n; j++) {
                                                                                                                                    map.put(mat[i][j], new Pair(i, j));
                                                                                                                                                }
                                                                                                                                                        }
                                                                                                                                                                
                                                                                                                                                                        // Traverse the arr array and check if any row or column is completely filled
                                                                                                                                                                                for (int i = 0; i < arr.length; i++) {
                                                                                                                                                                                            Pair p = map.get(arr[i]);  // Get the Pair object for arr[i]
                                                                                                                                                                                                        int x = p.x;  // Row index
                                                                                                                                                                                                                    int y = p.y;  // Column index
                                                                                                                                                                                                                                
                                                                                                                                                                                                                                            row[x] += 1;
                                                                                                                                                                                                                                                        col[y] += 1;
                                                                                                                                                                                                                                                                    
                                                                                                                                                                                                                                                                                // If a row or column is complete, return the index
                                                                                                                                                                                                                                                                                            if (row[x] == n || col[y] == m) {
                                                                                                                                                                                                                                                                                                            return i;
                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                                        
                                                                                                                                                                                                                                                                                                                                                return -1;  // Return -1 if no complete row or column is found
                                                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                                                    