import Goods.Goods;
import Goods.ScratchCard;
import Goods.StartupPackage;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Agent {
    private static double cash;

    public static double getCash() {
        return cash;
    }

    public static void setCash(double cash) {
        Agent.cash = cash;
    }

    public ArrayList<Goods> sale(ArrayList<Goods> goodsList, String goodsName, int amount) {
        ArrayList<Goods> tempList = new ArrayList<Goods>();
        Goods goods;
        switch (goodsName) {
            case "KS100":
            case "KS50": {
                for (Goods anArr : goodsList) {
                    if (anArr.getName().equals(goodsName)) {
                        goods = new ScratchCard(anArr);
                        tempList.add(goods);
                        tempList.get(tempList.size() - 1).setAmount(amount);
                        anArr.setAmount(anArr.getAmount() - amount);
                        timeOfSale();
                        cash += tempList.get(tempList.size() - 1).getAmount() * tempList.get(tempList.size() - 1).getPrice();
                        return tempList;
                    }
                }
            }
            break;
            case "KS Online":
            case "Vodafone Red": {
                for (Goods anArr : goodsList) {
                    if (anArr.getName().equals(goodsName)) {
                        goods = new StartupPackage(anArr);
                        tempList.add(goods);
                        tempList.get(tempList.size() - 1).setAmount(amount);
                        anArr.setAmount(anArr.getAmount() - amount);
                        timeOfSale();
                        cash += tempList.get(tempList.size() - 1).getAmount() * tempList.get(tempList.size() - 1).getPrice();
                        return tempList;
                    }
                }
            }
            break;
        }
        return null;
    }

    private String timeOfSale() {
        return LocalDateTime.now().toLocalDate().toString();
    }

    public void showClientStorage(Client client) {
        System.out.println(client.getClientName() + " have : " + client.getShopStore());
        System.out.println("Sale was at " + timeOfSale());
    }
}
