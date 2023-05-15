package practice.oop.module1;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Dot[] dots = {new Dot(1, 5),
                new Dot(2, 8),
                new Dot(5, 3),
                new Dot(8, 9)};
        BrokenLine brokenLine = new BrokenLine(dots);

        double brokenLength = brokenLine.brokenLineLength();
        System.out.println(brokenLength);

        Line[] lines = brokenLine.getLineArray();
        System.out.println(Arrays.toString(lines));

        double linesLength = 0;

        for (Line line : lines) {
            linesLength += line.lineLength();
        }

        System.out.println(linesLength);
        System.out.println(brokenLength == linesLength);

        dots[1] = new Dot(12, 8);
        System.out.println(brokenLine);
        System.out.println(Arrays.toString(brokenLine.getLineArray()));
    }
}
