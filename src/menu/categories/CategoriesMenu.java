package menu.categories;

import feature.action.CategoriesAction;

import java.util.Scanner;

public class CategoriesMenu {
    public static void showCategoriesMenu(Scanner sc) {
        while (true) {
            System.out.println("*******************Categories Menu*******************");
            System.out.println("1. List Categories");
            System.out.println("2. Add Categories");
            System.out.println("3. Delete Categories");
            System.out.println("4. Search Categories");
            System.out.println("5. Back");
            System.out.println("Enter your choice");
            byte choice = Byte.parseByte(sc.nextLine());
            switch (choice) {
                case 1:
                    CategoriesTree.showCategoriesTree(sc);
                    break;
                case 2:
                    CategoriesAction.addCategories(sc);
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    return;
                default:
                    System.err.println("Please enter 1 to 5");
            }
        }
    }
}
