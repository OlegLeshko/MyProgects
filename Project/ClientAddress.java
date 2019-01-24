public class ClientAddress  {
    private String town;
    private String street;
    private String shopName;

    public ClientAddress(String town, String street, String shopName) {
        this.town = town;
        this.street = street;
        this.shopName = shopName;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    @Override
    public String toString() {
        return town + " " + street + ". Shop name - " + shopName;
    }
}
