import Goods.*;

import java.util.ArrayList;


public class Controler {
    private static final String KS_100 = "KS100";
    private static final String KS_50 = "KS50";
    private static final String ONLINE = "KS Online";
    private static final String VODAFONE_RED = "Vodafone Red";

    public static AgentStorage setAgentStorage() {
        ArrayList<Goods> arrayList = new ArrayList<Goods>();
        arrayList.add(new ScratchCard(KS_100, 100, 102, Brand.KYIVSTAR, CardValueEnum.CARD_VALUE_100));
        arrayList.add(new ScratchCard(KS_50, 600, 52, Brand.KYIVSTAR, CardValueEnum.CARD_VALUE_50));
        arrayList.add(new StartupPackage(ONLINE, 120, 17, Brand.KYIVSTAR));
        arrayList.add(new StartupPackage(VODAFONE_RED, 40, 50, Brand.VODAFONE));

        AgentStorage agentStorage = new AgentStorage();
        agentStorage.putGoodsOnStorage(arrayList);
        return agentStorage;
    }

    public static ArrayList<Client> createClients() {
        ArrayList<Client> clients = new ArrayList<>();
        ClientStorage clientStorage1 = new ClientStorage();
        ClientStorage clientStorage2 = new ClientStorage();
        clients.add(new Client("Vasja", new ClientAddress("Lviv", "Sadova", "Magazine"), clientStorage1));
        clients.add(new Client("Igor", new ClientAddress("Stryj", "Shevchenka", "Tip-Top"), clientStorage2));
        for (int i = 0; i < clients.size(); i++) {
            System.out.printf("%n%s %s", i + 1, clients.get(i));
        }
        return clients;
    }

}
