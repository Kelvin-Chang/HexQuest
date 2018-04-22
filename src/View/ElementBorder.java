package View;

public class ElementBorder {
    private int left, right, top, bottom;
    private int width, height;

    public ElementBorder(int left, int right, int top, int bottom) {
        this.left = left;
        this.right = right;
        this.top = top;
        this.bottom = bottom;
        width = right-left;
        height = bottom-top;
    }

    public int getLeft() {
        return left;
    }
    public int getRight() {
        return right;
    }
    public int getTop() {
        return top;
    }
    public int getBottom() {
        return bottom;
    }
    public int returnWidth() {
        return width;
    }
    public int returnHeight() {
        return height;
    }

}
