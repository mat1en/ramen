package dao.impl;

import dao.AvailabilityDAO;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;

public class AvailabilityDAOImpl implements AvailabilityDAO {

    private final String fixedFile = "files/availability.csv";

    @Override
    public boolean getAvailabilities(String name){
        /**
         * this method is called when getting the availability of an option
         * @param name name of the option
         * @author Yifang L
         */
        boolean availability = false;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fixedFile));
            String line;

            while((line = reader.readLine()) != null){
                String[] value = line.split(",",2);
                if (value[0].equals(name))
                    availability = Boolean.parseBoolean(value[1]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return availability;
    }

    @Override
    public void setAvailabilities( String name, boolean availability) {
        /**
         * this method is called when changing the availability of an option
         * @author Yifang L
         * @param name name of the option to change
         * @param availability the availability status you want to set
         */
        ArrayList<String> optionList = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fixedFile));
            String line;
            while((line=reader.readLine())!=null){
                //item[0]:the option name, item[1]: the option availability
                String[] value = line.split(",", 2);
                if (value[0].equals(name)) value[1] = String.valueOf(availability);
                String last = value[0]+","+value[1];
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

