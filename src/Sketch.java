import processing.core.PApplet;

public class Sketch extends PApplet {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 800;
    private static final int COLS = 40;
    private static final int ROWS = 40;
    private static final float OFFSET_X = (float)WIDTH/COLS;
    private static final float OFFSET_Y = (float)HEIGHT/ROWS;

    private final World world = new World(COLS, ROWS);

    public static void main(String[] args) {
        PApplet.main("Sketch");
    }

    public void settings() {
        size(WIDTH, HEIGHT);
    }

    public void setup() {
        stroke(255);
        strokeWeight(0.5f);
        fill(255);
        frameRate(3);
    }

    public void draw() {
        background(0);

        for (int i = 0; i < COLS; i++) {
            for (int j = 0; j < ROWS; j++) {
                line(i * OFFSET_X, 0, i * OFFSET_X, HEIGHT);
                line(0, j * OFFSET_Y, WIDTH, j * OFFSET_Y);
            }
        }

        world.updateCells();

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if(world.isAlive(i, j))
                    rect(i * OFFSET_X, j * OFFSET_Y, OFFSET_X, OFFSET_Y);
            }
        }
    }
}
