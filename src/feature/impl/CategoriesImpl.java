package feature.impl;

import feature.ICategoriesFeature;
import model.Categories;

import java.util.ArrayList;

import java.util.List;

public class CategoriesImpl implements ICategoriesFeature{
    private static ArrayList<Categories> categories = new ArrayList<>();
    static {
        Categories categories1 = new Categories(1,0,"Quan ao","hay",true);
        Categories categories2 = new Categories(2,1,"Quan ao nam","hay",true);
        Categories categories3 = new Categories(3,2,"Ao so mi","hay",true);
        Categories categories4 = new Categories(4,2,"Quan au","hay",true);
        Categories categories5 = new Categories(5,1,"Quan dai","hay",true);
        Categories categories6 = new Categories(6,0,"Giay dep","hay",true);
        Categories categories7 = new Categories(7,6,"Nike","hay",true);
        Categories categories8 = new Categories(8,7,"Adidas","hay",true);
        categories.add(categories1);
        categories.add(categories2);
        categories.add(categories3);
        categories.add(categories4);
        categories.add(categories5);
        categories.add(categories6);
        categories.add(categories7);
        categories.add(categories8);
    }
    @Override
    public List findAll() {
        return categories;
    }

    @Override
    public void save(Categories categories) {
        int check = findIndexById(categories.getCatalogId());
        if(check<0){
            this.categories.add(categories);
        }else{
            this.categories.set(check,categories);
        }

    }
    @Override
    public void deleteById(Integer id) {
        int indexDelete = findIndexById(id);
        if(indexDelete>= 0){
            categories.remove(indexDelete);
            System.out.println("Delete success");
        }else{
            System.err.println("Id not found");
        }
    }
    @Override
    public Integer findIndexById(Integer id) {
        for(int i =0; i< categories.size();i++){
            if(categories.get(i).getCatalogId() == id){
                return i;
            }
        }
        return -1;
    }
}
