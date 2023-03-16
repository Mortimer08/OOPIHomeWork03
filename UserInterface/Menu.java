package UserInterface;

import java.util.Scanner;

import Shapes.Circle;
import Shapes.Retrangle;
import Shapes.Square;
import Shapes.Triangle;
import Shapes.Base.Shape;
import ShapesCollection.ShapesCollection;

public class Menu {
    Scanner scanner;
    String userChoice;
    Double inputValue;
    int menuItem;
    Boolean keepRun;
    Double sideA;
    Double sideB;
    Double sideC;
    Double radius;
    Double[] sides;
    ShapesCollection shapesCollection;

    public Menu() {
        scanner = new Scanner(System.in);
        sides = new Double[3];
    }

    public void run(ShapesCollection shapesCollection) throws Exception {
        this.shapesCollection = shapesCollection;

        keepRun = true;

        while (keepRun) {
            showMenu(this.shapesCollection.getSize());
            menuItem = userChoice(scanner);
            switch (menuItem) {
                case 1:
                    shapesCollection.showAllShapes();
                    break;
                case 2:
                    shapesCollection.showPerimeters();
                    break;
                case 3:
                    shapesCollection.showAreas();
                    break;
                case 4:
                    shapesCollection.showCircleLenght();
                    break;
                case 5:
                    shapesCollection.sortByArea();
                    break;
                case 6:
                    addShape();
                    // keepRun = true;
                    break;
                case 7:
                    removeShape();
                    // keepRun = true;
                    break;
                case 8:
                    changeShapeMenu();
                    // keepRun = true;
                    break;
                case 9:
                    throw new Exception("Работа закончена");

            }

        }
        scanner.close();
    }

    public void addShape() throws Exception {
        showAddShapeMenu();
        menuItem = userChoice(scanner);
        keepRun = true;
        switch (menuItem) {
            case 1:
                sides = inputTriangleData();
                sideA = sides[0];
                sideB = sides[1];
                sideC = sides[2];
                shapesCollection.addShape(new Triangle(sideA, sideB, sideC));

                break;
            case 2:
                sideA = inputSquareData();
                shapesCollection.addShape(new Square(sideA));
                break;
            case 3:
                sides = inputRetrangleData();
                sideA = sides[0];
                sideB = sides[1];
                shapesCollection.addShape(new Retrangle(sideA, sideB));
                break;
            case 4:
                radius = inputCircleData();
                shapesCollection.addShape(new Circle(radius));
                break;
            case 5:
                keepRun = false;
                break;
            default:
                break;
        }
    }

    public void removeShape() {
        keepRun = true;
        System.out.println("Выберите номер фигуры для удаления (нумерация от 0): ");
        menuItem = userChoice(scanner);
        if (menuItem >= 0 && menuItem < shapesCollection.getSize()) {
            shapesCollection.removeShape(menuItem);
        }
    }

    public void changeShapeMenu() throws Exception {
        keepRun = true;
        System.out.println("Выберите номер фигуры для изменения (нумерация от 0): ");
        menuItem = userChoice(scanner);
        if (menuItem >= 0 && menuItem < shapesCollection.getSize()) {
            Shape shape = shapesCollection.getShape(menuItem);
            System.out.println("Выбранная фигура:");
            System.out.println(shape.toString());
            if (shape.getClass().getSimpleName().equals("Triangle")) {
                sides = inputTriangleData();
                shapesCollection.removeShape(menuItem);
                shapesCollection.insertShape(menuItem, new Triangle(sides[0], sides[1], sides[2]));
            }
            if (shape.getClass().getSimpleName().equals("Circle")) {
                radius = inputCircleData();
                shapesCollection.removeShape(menuItem);
                shapesCollection.insertShape(menuItem, new Circle(radius));
            }
            if (shape.getClass().getSimpleName().equals("Retrangle")) {
                sides = inputRetrangleData();
                shapesCollection.removeShape(menuItem);
                shapesCollection.insertShape(menuItem, new Retrangle(sides[0], sides[1]));
            }
            if (shape.getClass().getSimpleName().equals("Square")) {
                sideA = inputSquareData();
                shapesCollection.removeShape(menuItem);
                shapesCollection.insertShape(menuItem, new Square(sideA));
            }
        }
    }

    private Double[] inputRetrangleData() {
        System.out.println("Введите длины сторон:");

        sides[0] = userInput(scanner);
        sides[1] = userInput(scanner);
        return sides;
    }

    private Double[] inputTriangleData() {
        System.out.println("Введите длины сторон:");

        sides[0] = userInput(scanner);
        sides[1] = userInput(scanner);
        sides[2] = userInput(scanner);
        return sides;
    }

    private Double inputCircleData() {
        System.out.println("Введите радиус:");
        radius = userInput(scanner);
        return radius;
    }

    private Double inputSquareData() {
        System.out.println("Введите длину стороны:");
        sideA = userInput(scanner);
        return sideA;
    }

    private void showMenu(int shapesCollectionSize) {
        System.out.printf("В коллекции %d фигур%n", shapesCollectionSize);
        System.out.println("\t1. Вывести информацию о всех фигурах");
        System.out.println("\t2. Вывести информацию о периметрах фигур");
        System.out.println("\t3. Вывести информацию о площадях фигур");
        System.out.println("\t4. Вывести информацию о длинах окружностей фигур");
        System.out.println("\t5. Отсортировать коллекцию по площади");
        System.out.println("\t6. Добавить фигуру");
        System.out.println("\t7. Удалить фигуру");
        System.out.println("\t8. Изменить фигуру");
        System.out.println("\t9. Выход");
        System.out.println("Введите выбранный пункт: ");
    }

    private void showAddShapeMenu() {
        System.out.printf("Возможные типы фигур:%n");
        System.out.println("\t1. Треугольник");
        System.out.println("\t2. Квадрат");
        System.out.println("\t3. Прямоугольник");
        System.out.println("\t4. Круг");
        System.out.println("\t5. Выход");
        System.out.println("Введите выбранный пункт: ");
    }

    public int userChoice(Scanner scanner) {
        while (keepRun) {
            try {
                userChoice = scanner.nextLine();
                menuItem = Integer.parseInt(userChoice);
                keepRun = false;
            } catch (Exception e) {
                System.out.println("Некорретное значение");
            }

        }
        keepRun = true;
        return menuItem;
    }

    public Double userInput(Scanner scanner) {
        while (keepRun) {
            try {
                userChoice = scanner.nextLine();
                inputValue = Double.parseDouble(userChoice);
                keepRun = false;
            } catch (Exception e) {
                System.out.println("Некорретное значение");
            }

        }
        keepRun = true;
        return inputValue;
    }
}
