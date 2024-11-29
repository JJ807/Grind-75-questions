import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Coord {
    private int x;
    private int y;

    public Coord(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

public class FloodFill {
    public static void main(String[] args) {
        // iterative
        int[][] image = { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } };
        System.out.println("Before: " + Arrays.deepToString(image));
        System.out.println("After: " + Arrays.deepToString(floodFill(image, 1, 1, 2)));
        int[][] image2 = { { 0, 0, 0 }, { 0, 0, 0 } };
        System.out.println("Before: " + Arrays.deepToString(image2));
        System.out.println("After: " + Arrays.deepToString(floodFill(image2, 0, 0, 0)));

        // recursive
        int[][] image3 = { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } };
        System.out.println("Before: " + Arrays.deepToString(image3));
        System.out.println("After: " + Arrays.deepToString(floodFillDFS(image3, 1, 1, 2)));
        int[][] image4 = { { 0, 0, 0 }, { 0, 0, 0 } };
        System.out.println("Before: " + Arrays.deepToString(image4));
        System.out.println("After: " + Arrays.deepToString(floodFillDFS(image4, 0, 0, 0)));
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int initialColor = image[sr][sc];
        if (image == null || image.length == 0 || initialColor == color) return image;
        
        Queue<Coord> q = new LinkedList<Coord>();
        q.add(new Coord(sr, sc));
        while (!q.isEmpty()) {
            Coord coord = q.poll();
            int x = coord.getX();
            int y = coord.getY();
            image[x][y] = color;
            addToQueue(q, x-1, y, image, initialColor);
            addToQueue(q, x+1, y, image, initialColor);
            addToQueue(q, x, y-1, image, initialColor);
            addToQueue(q, x, y+1, image, initialColor);
        }
        return image;
    }

    private static void addToQueue(Queue<Coord> q, int coordX, int coordY, int[][] image, int initialColor) {
        if(coordX >= 0 && coordY >= 0 && coordX < image.length && coordY < image[0].length && image[coordX][coordY] == initialColor) {
            q.add(new Coord(coordX, coordY));
        }
    }

    public static int[][] floodFillDFS(int[][] image, int sr, int sc, int color) {
        int originalColor = image[sr][sc];
        if (originalColor != color) {
            dfs(image, sr, sc, originalColor, color);
        }
        return image;
    }
    
    private static void dfs(int[][] image, int r, int c, int originalColor, int color) {
        if (r < 0 || r >= image.length || c < 0 || c >= image[0].length || image[r][c] != originalColor) {
            return;
        }
        image[r][c] = color;
        dfs(image, r - 1, c, originalColor, color);
        dfs(image, r + 1, c, originalColor, color);
        dfs(image, r, c - 1, originalColor, color);
        dfs(image, r, c + 1, originalColor, color);
    }
}
