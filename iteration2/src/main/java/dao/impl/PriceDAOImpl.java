package dao.impl;


import dao.PriceDAO;


import java.io.BufferedReader;
import java.io.FileReader;


public class PriceDAOImpl implements PriceDAO {

    public float getPrices(String name){
        String fixedFile = "files/price.csv";
        float price = 0;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fixedFile));
            reader.readLine(); //first line is the header information
            String line = null;
            while((line = reader.readLine()) != null){
                String[] value = line.split(",");
                if (value[0].equals(name))
                    price = Float.parseFloat(value[1]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //price = (float) ((double) Math.round(price * 100) / 100);
        return price;
    }




}
