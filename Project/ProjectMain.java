import java.util.ArrayList;
import java.util.Scanner;

public class ProjectMain {

    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        String c;
        boolean check = true;


        AgentStorage agentStorage = Controler.setAgentStorage();
        agentStorage.showAgentStorage();

        ArrayList<Client> clients = Controler.createClients();
        Agent agent = new Agent();
        System.out.println("\nSelect client or 0 to exit: ");
        while (check) {
            switch (c = s.next()) {
                case "0":
                    check = false;
                    break;
                case "1":
                    System.out.println("what to sale");
                    ClientStorage clientStorage = clients.get(Integer.parseInt(c)-1).getShopStore();
                    clientStorage.putGoodsOnStorage(agent.sale(agentStorage.getAgentList(), "KS100", 60));
                    agent.showClientStorage(clients.get(0));
                    agentStorage.showAgentStorage();
                    break;
                case "2":
                    ClientStorage clientStorage1 = clients.get(Integer.parseInt(c)-1).getShopStore();
                    clientStorage1.putGoodsOnStorage(agent.sale(agentStorage.getAgentList(), "KS Online", 10));
                    agent.showClientStorage(clients.get(1));
                    agentStorage.showAgentStorage();
                    break;
                default:
                    System.out.println("Wrong input");
            }
        }
        System.out.println("Total cash - " + Agent.getCash());

    }
}
