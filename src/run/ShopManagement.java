package run;

import menu.categories.CategoriesMenu;

import java.util.Scanner;

public class ShopManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("********************MENU********************");
        System.out.println("1. Categories Management");
        System.out.println("2. Product Management");
        System.out.println("3. Exit");
        System.out.println("Enter your choice");
        byte choice = Byte.parseByte(sc.nextLine());
        switch (choice) {
            case 1:
                CategoriesMenu.showCategoriesMenu(sc);
                break;
            case 2:
                break;
            case 3:
                System.exit(0);
            default:
                System.err.println("Please input 1 to 3");
        }
    }
}
