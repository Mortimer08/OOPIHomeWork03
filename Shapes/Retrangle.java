package Shapes;

import java.util.ArrayList;

import Shapes.Base.Polygon;

public class Retrangle extends Polygon {

    public Retrangle(Double sideA, Double sideB) throws Exception {
        super("Прямоугольник");
        if (sideA == sideB) {
            super.setShapeName("Квардат");
        }
        ArrayList<Double> sideLenghts = new ArrayList<>();
        sideLenghts.add(sideA);
        sideLenghts.add(sideB);
        sideLenghts.add(sideA);
        sideLenghts.add(sideB);
        setSideLenghts(sideLenghts);
    }

    public void setSideLenghts(ArrayList<Double> sideLenghts) throws Exception {
        if (sideLenghts.get(0) > 0 && sideLenghts.get(1) > 0) {
            super.setSideLenghts(sideLenghts);
        } else {
            throw new Exception("Длины сторон должны быть положительными числами");
        }
    }

    @Override
    public Double calculateArea() {
        return super.sideLenghts.get(0) * super.sideLenghts.get(1);
    }
}
