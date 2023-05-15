package practice.oop.module1;

import java.util.Arrays;

public class BrokenLine {
    public Dot[] dots;

    public BrokenLine() {
    }

    public BrokenLine(Dot[] dots) {
        this.dots = dots;
    }

    @Override
    public String toString() {
        return "Линия " + Arrays.toString(dots);
    }

    public Line[] getLineArray() {
        Line[] lines;
        if (dots == null) {
            return new Line[0];
        } else if (dots.length == 1) {
            return new Line[0];
        } else {
            lines = new Line[dots.length - 1];
        }
        for (int i = 0; i < lines.length; i++) {
            lines[i] = new Line(dots[i], dots[i + 1]);
        }
        return lines;
    }

    public double brokenLineLength() {
        double length = 0;
        for (int i = 0; i < dots.length - 1; i++) {
            length += Math.sqrt(
                    Math.pow((dots[i + 1].xCoord - dots[i].xCoord), 2) +
                            Math.pow((dots[i + 1].yCoord - dots[i].yCoord), 2));
        }
        return length;
    }
}
