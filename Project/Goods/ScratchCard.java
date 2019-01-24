package Goods;

public class ScratchCard extends Goods {
    private CardValueEnum cardValue;

    public ScratchCard(String name, int amount, double price, Brand brand, CardValueEnum cardValue) {
        super(name, amount, price, brand);
        this.cardValue = cardValue;
    }

    public ScratchCard(Goods g){
        super(g);
    }

    @Override
    public String toString() {
        return super.getName() + " " + super.getAmount() + " " + super.getPrice();
    }

}
