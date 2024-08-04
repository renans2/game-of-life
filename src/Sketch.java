import processing.core.PApplet;

public class Sketch extends PApplet {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 800;
    private static final int COLS = 40;
    private static final int ROWS = 40;
    private static final float OFFSET_X = (float)WIDTH/COLS;
    private static final float OFFSET_Y = (float)HEIGHT/COLS;

    public static void main(String[] args) {
        PApplet.main("Sketch");
    }

    public void settings() {
        size(WIDTH, HEIGHT);
    }

    public void setup() {
        stroke(255);
        fill(0);
        strokeWeight(0.5f);
        noFill();
    }

    public void draw() {
        background(0);

        for (int i = 0; i < COLS + 1; i++) {

            line(i * OFFSET_X, 0, i * OFFSET_X, HEIGHT);
            line(0, i * OFFSET_Y, WIDTH, i * OFFSET_Y);
        }
    }
}
