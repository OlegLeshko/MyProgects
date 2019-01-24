package Goods;

public abstract class Goods {
    private String name;
    private int amount;
    private double price;
    private Brand brand;

    public Goods(String name, int amount, double price, Brand brand ) {
        this.name = name;
        this.amount = amount;
        this.price = price;
        this.brand =brand;
    }


    public Goods(Goods goods ) {
        this.name = goods.getName();
        this.amount = goods.getAmount();
        this.price = goods.getPrice();
        this.brand = goods.getBrand();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

}
