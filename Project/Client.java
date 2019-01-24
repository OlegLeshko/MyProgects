
public class Client {
    private String clientName;
    private ClientAddress address;
    private ClientStorage shopStore;

    public Client(String clientName, ClientAddress address, ClientStorage shopeStore) {
        this.clientName = clientName;
        this.address = address;
        this.shopStore = shopeStore;
    }

    public Client() {
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public ClientAddress getAddress() {
        return address;
    }

    public void setAddress(ClientAddress address) {
        this.address = address;
    }

    public ClientStorage getShopStore() {
        return shopStore;
    }

    public void setShopStore(ClientStorage shopStore) {
        this.shopStore = shopStore;
    }

    @Override
    public String toString() {
        return clientName + ". Adress - " + address;
    }
}
