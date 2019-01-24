import Goods.*;

import java.util.ArrayList;

public class ClientStorage implements Storage {
    private ArrayList<Goods> clientList = new ArrayList<Goods>();

    public ArrayList<Goods> getClientList() {
        return clientList;
    }

    public void setClientList(Goods clientList) {
        this.clientList.add(clientList);
    }

    @Override
    public void putGoodsOnStorage (ArrayList<Goods> goodsList) {
        if (clientList.isEmpty()) {
            clientList.addAll(goodsList);
        }else {
            setClientList(goodsList.get(0));
        }
    }

    @Override
    public String toString() {
        return clientList.toString();
    }

    public  void showClientStorage() {
        System.out.println(clientList);
    }
}
