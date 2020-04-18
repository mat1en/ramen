package dao.impl;

import dao.PriceDAO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;

public class PriceDAOImpl implements PriceDAO {

    private final String fixedFile = "files/price.csv";

    @Override
    public float getPrices(String name){
        /**
         * this method is called when getting the price of an option
         * @param name name of the option
         * @author Shucen L
         */
        //String fixedFile = "files/price.csv";
        float price = 0;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fixedFile));
            reader.readLine(); //first line is the header information
            String line;
            while((line = reader.readLine()) != null){
                //NEED TO REFACTOR(this comment line is add by Yifang L)
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

    @Override
    public void setPrices( String name, float price) {
        /**
         * this method is called when changing the price of an option
         * @author Yifang L
         * @param name name of the option to change
         * @param price the price you want to set
         */
        ArrayList<String> optionList = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fixedFile));
            String line;
            while((line=reader.readLine())!=null){
                //item[0]:the option name, item[1]: the option price
                String[] item = line.split(",", 2);
                if (item[0].equals(name)) item[1] = String.valueOf(price);
                String last = item[0]+","+item[1];
                optionList.add(last);
            }
            BufferedWriter bw_na = new BufferedWriter(new FileWriter(fixedFile, false));
            BufferedWriter bw = new BufferedWriter(new FileWriter(fixedFile, true));
            bw_na.write("");
            for(String i : optionList){
                bw.write(i);
                bw.newLine();
            }
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
