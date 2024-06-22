package model;

import feature.ICategoriesFeature;
import validate.CategoriesValidate;

import java.util.Scanner;

public class Categories implements ICategories {
    private int catalogId, parentId;
    private String catalogName, descriptions;
    private boolean catalogStatus;

    public Categories() {
    }

    public Categories(int catalogId, int parentId, String catalogName, String descriptions, boolean catalogStatus) {
        this.catalogId = catalogId;
        this.parentId = parentId;
        this.catalogName = catalogName;
        this.descriptions = descriptions;
        this.catalogStatus = catalogStatus;
    }

    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public boolean isCatalogStatus() {
        return catalogStatus;
    }

    public void setCatalogStatus(boolean catalogStatus) {
        this.catalogStatus = catalogStatus;
    }

    @Override
    public void inputData() {
        Scanner sc = new Scanner(System.in);
        this.catalogId = CategoriesValidate.inputCatalogId(sc);
        this.catalogName = CategoriesValidate.inputCatalogName(sc);
        this.descriptions = CategoriesValidate.inputCatalogDescriptions(sc);
        this.catalogStatus = CategoriesValidate.inputCatalogStatus(sc);
        this.parentId = CategoriesValidate.inputCatalogParentId(sc);
    }

    @Override
    public void displayData() {
        System.out.println("------------------------------------");
        System.out.println("Id: " + this.catalogId);
        System.out.println("Name: " + this.catalogName);
        System.out.println("Descriptions: " + this.descriptions);
        System.out.println("Status: " + (this.catalogStatus ? "Active" : "inActive"));
        System.out.println("ParentId: " + this.parentId);
    }
}
