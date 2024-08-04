package setup;

import processing.core.PApplet;

public class Sketch extends PApplet {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 800;

    public static void main(String[] args) {
        PApplet.main("setup.Sketch");
    }

    public void settings() {
        size(WIDTH, HEIGHT);
    }

    public void setup() {
        background(255);
    }

    public void draw() {

    }
}
