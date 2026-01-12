class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image[sr][sc] == color) return image;
        int originalColor = image[sr][sc];
        colorFill(image, sr, sc, originalColor, color);
        return image;
    }

    private void colorFill(int[][] image, int i, int j, int originalColor, int color) {
        if (i < 0 || i >= image.length || j < 0 || j >= image[0].length || image[i][j] != originalColor) {
            return;
        }
        image[i][j] = color;
        colorFill(image, i + 1, j, originalColor, color);
        colorFill(image, i - 1, j, originalColor, color);
        colorFill(image, i, j + 1, originalColor, color);
        colorFill(image, i, j - 1, originalColor, color);
    }
}