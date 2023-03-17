import ShapesCollection.ShapesCollection;
import ShapesCollection.ShapesCreation;
import UserInterface.Menu;

public class Program {
    public static void main(String[] args) throws Exception {
        ShapesCollection sc = new ShapesCollection();
        ShapesCreation.fillCollection(sc);
        while (true) {
            try {

                Menu menu = new Menu();
                menu.run(sc);

            } catch (Exception e) {
                if (e.getMessage().equals("Работа закончена")) {
                    break;
                } else {
                    System.out.println(e.getMessage());
                }

            }
        }

    }
}