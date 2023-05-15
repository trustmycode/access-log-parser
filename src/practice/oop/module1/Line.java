package practice.oop.module1;

public class Line {
    public Dot beginCoord;
    public Dot endCoord;

    public Line(Dot beginCoord, Dot endCoord) {
        this.beginCoord = beginCoord;
        this.endCoord = endCoord;
    }

    public Line(int xCoordBegin, int yCoordBegin, int xCoordEnd, int yCoordEnd) {
        beginCoord = new Dot(xCoordBegin, yCoordBegin);
        endCoord= new Dot(xCoordEnd, yCoordEnd);
    }

    @Override
    public String toString() {
        return "Линия от {" +
                beginCoord.xCoord +
                ";" +
                beginCoord.yCoord +
                "} до {" +
                endCoord.xCoord +
                ";" +
                endCoord.yCoord +
                "}";
    }

    public double lineLength() {
        return Math.sqrt(
                Math.pow((endCoord.xCoord - beginCoord.xCoord), 2) +
                        Math.pow((endCoord.yCoord - beginCoord.yCoord), 2));
    }
}
