package dao.impl;

import dao.StatisticsDAO;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Objects;

public class StatisticsDAOImpl implements StatisticsDAO {
    private final String statFile = "files/statistics.csv";
    private LinkedHashMap<String, Float> map = new LinkedHashMap<>();

    public StatisticsDAOImpl(){
        readStatistics();
    }

    public float getStatistics(String name){
        return map.get(name);
    }

    @Override
    public void readStatistics() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(statFile));
            String line;
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                //item[0]:the option name, item[1]: the option price
                String[] item = line.split(",", 2);
                map.put(item[0], Float.parseFloat(item[1]));
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void writeStatistics() {
        try {
            BufferedWriter bw_na = new BufferedWriter(new FileWriter(statFile, false));
            BufferedWriter bw = new BufferedWriter(new FileWriter(statFile, true));
            String line;
            bw_na.write("");
            bw.write("name,statistic");
            bw.newLine();
            map.forEach((name, stat) -> {
                String last = name + "," + stat;
                try {
                    bw.write(last);
                    bw.newLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            bw_na.close();
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateStatistics(String[] choices) {
//        for(String i : choices){
//            map.put(i,map.get(i)+1);
//        }
        int i;
        for (i=0;i<3;i++){
            map.put(choices[i],map.get(choices[i])+1);
        }
        String[] j={"Nori","Chasu","Egg"};
        for (i=3;i<6;i++){
            switch (choices[i]) {
                // no need for break statement. case "No" do nothing.
                case "Yes":map.put(j[i-3],map.get(j[i-3])+1);
                case "No":
            }
        }
        map.put("Spiciness"+choices[6],map.get("Spiciness"+choices[6])+1);
        j= new String[]{"AddNori", "AddEgg", "AddBamboo", "AddChasu"};
        for (i=0;i<4;i++){
            map.put(j[i],map.get(j[i])+Integer.parseInt(choices[i+7]));
        }
        map.put(choices[11],map.get(choices[11])+1);
        map.put("Sales",map.get("Sales")+Float.parseFloat(choices[12]));
        map.put(choices[13],map.get(choices[13])+1);
        map.put("Total",map.get("Total")+1);
    }
}

