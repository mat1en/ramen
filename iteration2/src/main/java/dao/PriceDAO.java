package dao;

public interface PriceDAO {
    float getPrices(String name);
    void setPrices(String name, float price);
}
