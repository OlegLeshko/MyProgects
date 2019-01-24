import Goods.Goods;
import Goods.Storage;
import java.util.ArrayList;

public class AgentStorage implements Storage{
    private static ArrayList<Goods> agentList = new ArrayList<>();

    @Override
    public void putGoodsOnStorage(ArrayList<Goods> goodsList) {
        agentList.addAll(goodsList);
    }

    public  ArrayList<Goods> getAgentList() {
        return agentList;
    }

    public void setAgentList(ArrayList<Goods> agentList) {
        AgentStorage.agentList = agentList;
    }

    public void showAgentStorage() {
        System.out.println("Agent storage : " + agentList);
    }
}
