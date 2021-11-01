package learn.foraging.models;

import java.math.BigDecimal;

public class Item {

    private int id;
    private String name;
    private Category category;
    private BigDecimal dollarPerKilogram;

    public Item() {
    }

    public Item(int id, String name, Category category, BigDecimal dollarPerKilogram) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.dollarPerKilogram = dollarPerKilogram;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public BigDecimal getDollarPerKilogram() {
        return dollarPerKilogram;
    }

    public void setDollarPerKilogram(BigDecimal dollarPerKilogram) {
        this.dollarPerKilogram = dollarPerKilogram;
    }
}
