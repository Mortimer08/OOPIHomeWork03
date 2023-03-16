package ShapesCollection;

import Shapes.Circle;
import Shapes.Retrangle;
import Shapes.Square;
import Shapes.Triangle;
import Shapes.Base.Shape;

public class ShapesCreation {
public static ShapesCollection sc1;
    public static void shapesCreation() throws Exception {
        Shape triangle = new Triangle(3.0, 4.0, 5.0);
        Shape sq = new Square(5.0);
        Shape circle = new Circle(7.0);
        Shape retrangle = new Retrangle(5.0, 7.0);
        sc1 = new ShapesCollection();
        sc1.addShape(triangle);
        sc1.addShape(circle);
        sc1.addShape(sq);
        sc1.addShape(retrangle);
    }
}
