package ShapesCollection;

import java.util.ArrayList;
import Shapes.Base.Shape;
import Shapes.Comparators.AreaComparator;
import Shapes.Interfaces.CalculateArea;
import Shapes.Interfaces.CalculateCircleLenght;
import Shapes.Interfaces.CalculatePerimeter;

public class ShapesCollection {
    private ArrayList<Shape> shapesCollection;

    public ShapesCollection() {
        shapesCollection = new ArrayList<>();
    }

    public void addShape(Shape shape) {
        this.shapesCollection.add(shape);
    }

    public void insertShape(int index, Shape shape) {
        this.shapesCollection.add(index, shape);
    }

    public void removeShape(int index) {
        if (this.shapesCollection.size() > index) {
            this.shapesCollection.remove(index);
        }
    }

    public Shape getShape(int index) {
        return shapesCollection.get(index);
    }

    public int getSize() {
        return shapesCollection.size();
    }

    public void showPerimeters() {
        for (int i = 0; i < this.shapesCollection.size(); i++) {
            if (this.shapesCollection.get(i) instanceof CalculatePerimeter) {
                System.out.printf("Периметр фигуры №%d равен: ", i);
                System.out.println(((CalculatePerimeter) this.shapesCollection.get(i)).calculatePerimeter());
            }
        }
    }

    public void showAreas() {
        for (int i = 0; i < this.shapesCollection.size(); i++) {
            if (this.shapesCollection.get(i) instanceof CalculateArea) {
                System.out.printf("Площадь фигуры №%d равна: %.1f%n", i,
                        (((CalculateArea) this.shapesCollection.get(i)).calculateArea()));
            }
        }
    }

    public void showCircleLenght() {
        for (int i = 0; i < this.shapesCollection.size(); i++) {
            if (this.shapesCollection.get(i) instanceof CalculateCircleLenght) {
                System.out.printf("Длина окружности фигуры №%d равна: %.1f%n", i,
                        (((CalculateCircleLenght) this.shapesCollection.get(i)).calculateCircleLenght()));
            }
        }
    }

    public void showAllShapes() {
        for (Shape shape : this.shapesCollection) {
            System.out.println(shape.toString());
            System.out.println("-----------------");
        }

    }

    public void sortByArea() {
        this.shapesCollection.sort(new AreaComparator());
    }
}
