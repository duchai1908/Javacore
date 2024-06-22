package validate;

import feature.ICategoriesFeature;
import feature.impl.CategoriesImpl;
import model.Categories;

import java.util.Scanner;
import java.util.regex.Pattern;

public class CategoriesValidate {
    private static ICategoriesFeature cate = new CategoriesImpl();
    public static int inputCatalogId(Scanner sc) {
        while (true) {
            System.out.println("Input catalogId");
            int cataId = Integer.parseInt(sc.nextLine());
            if (cataId > 0) {
                boolean check = false;
                for (Categories categories : cate.findAll()) {
                    if (categories.getCatalogId() == cataId) {
                        check = true;
                        break;
                    }
                }
                if (!check) {
                    return cataId;
                } else {
                    System.err.println("CatalogId already exist");
                }
            } else {
                System.err.println("Catalog Id must greater than 0");
            }
        }
    }

    public static String inputCatalogName(Scanner sc) {
        String catalogNameRegex = "^.{6,30}$";
        while (true) {
            System.out.println("Input CatalogName");
            String cateName = sc.nextLine();
            if (Pattern.matches(catalogNameRegex, cateName)) {
                return cateName;
            } else {
                System.err.println("Catalog name  must be from 6 to 30 characters");
            }
        }
    }

    public static String inputCatalogDescriptions(Scanner sc) {
        while (true) {
            System.out.println("Input Catalog Description");
            String cataDescriptions = sc.nextLine();
            if (cataDescriptions.trim().isEmpty()) {
                System.err.println("Description must not be null");
            } else {
                return cataDescriptions;
            }
        }
    }

    public static boolean inputCatalogStatus(Scanner sc) {
        while (true) {
            System.out.println("Input catalog status (true | false)");
            String catalogStatus = sc.nextLine().toLowerCase();
            if (catalogStatus.equals("true") || catalogStatus.equals("false")) {
                return Boolean.parseBoolean(catalogStatus);
            } else {
                System.err.println("Catalog status must be true or false, please try again");
            }
        }
    }

    public static int inputCatalogParentId(Scanner sc) {
        while (true) {
            System.out.println("Input ParentId");
            int catalogParent = Integer.parseInt(sc.nextLine());
            if (catalogParent == 0) {
                return catalogParent;
            } else {
                boolean check = false;
                for (Categories categories : cate.findAll()) {
                    if (categories.getCatalogId() == catalogParent) {
                        check = true;
                        break;
                    }
                }
                if (check) {
                    if(checkParentId(catalogParent)){
                        return catalogParent;
                    }else{
                        System.err.println("Only manage 3 categories");
                    }
                } else {
                    System.err.println("Parent Id not found");
                }
            }
        }
    }

    private static boolean checkParentId(int catalogParent) {
        int count = 1;
        int indexCheck = cate.findIndexById(catalogParent);
        int parentId = cate.findAll().get(indexCheck).getParentId();
        boolean check = true;
       for(int i =0 ; i< cate.findAll().size(); i ++) {
            if(parentId == 0 && count< 3){
                check = true;
            }else if(count >=3){
                check =  false;
                break;
            }
            else{
                indexCheck = cate.findIndexById(parentId);
                parentId = cate.findAll().get(indexCheck).getParentId();
                count++;
            }
        }
       return check;
    }
}
