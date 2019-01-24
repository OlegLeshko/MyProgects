package Goods;

public class StartupPackage extends Goods {

    public StartupPackage(String name, int amount, double price, Brand brand) {
        super(name, amount, price, brand);
    }

    public StartupPackage(Goods g) {
        super(g);
    }

    @Override
    public String toString() {
        return super.getName() + " " + super.getAmount() + " " + super.getPrice();
    }
}
