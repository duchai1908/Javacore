package feature.action;

import feature.ICategoriesFeature;
import feature.impl.CategoriesImpl;
import model.Categories;

import java.util.Scanner;

public class CategoriesAction {
    private static ICategoriesFeature categories = new CategoriesImpl();

    public static void addCategories(Scanner sc) {
        System.out.println("Enter number Categories you want to add");
        int number = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < number; i++) {
            Categories cate = new Categories();
            cate.inputData();
            categories.save(cate);
        }
        System.out.println("Add " + number + " success");
    }

    public static void listCategories() {
        listTree(0,"");
    }
    private static String listTree(int parentId,String str1){
        String result = "";
        for(Categories cate: categories.findAll()){
            result = "";
            if(cate.getParentId() == parentId){
                result += str1 + cate.getCatalogName() + "\n" ;
                System.out.printf(result);
                result += listTree(cate.getCatalogId(),str1+"\t");
            }
        }
        return result;
    }
}
