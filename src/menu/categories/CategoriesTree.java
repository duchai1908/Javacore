package menu.categories;

import feature.action.CategoriesAction;

import java.util.Scanner;

public class CategoriesTree {
    public static void showCategoriesTree(Scanner sc) {
        while (true) {
            System.out.println("*****************List Categories*****************");
            System.out.println("1. List tree categories");
            System.out.println("2. Information categories");
            System.out.println("3. Back");
            System.out.println("Enter your choice");
            Byte choice = Byte.parseByte(sc.nextLine());
            switch (choice) {
                case 1:
                    CategoriesAction.listCategories();
                    break;
                case 2:
                    break;
                case 3:
                    return;
                default:
                    System.err.println("Please input 1 to 3");
            }
        }
    }
}
