import ShapesCollection.ShapesCreation;
import UserInterface.Menu;

public class Program {
    public static void main(String[] args) throws Exception {
        while (true) {
            try {
                ShapesCreation.shapesCreation();
                Menu menu = new Menu();
                menu.run(ShapesCreation.sc1);

            } catch (Exception e) {
                System.out.println(e.getMessage());
                if (e.getMessage().equals("Работа закончена"))
                    break;
            }
        }

    }
}