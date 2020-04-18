package dao;

import java.util.ArrayList;
import vo.Fixed;


public interface PriceDAO {
    float getPrices(String name);
    void setPrices(String name, float price);
}
