package dao.impl;

import dao.OrderDAO;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;


public class OrderDAOImpl implements OrderDAO {

    public void write2txt(String[] choices) throws Exception{
        String orderFile = "files/ticket.txt";
        try {
            Date date = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
            String time = formatter.format(date);
            //System.out.println(formatter.format(date));
            FileWriter writer = new FileWriter(orderFile, false);
            writer.write("\r\n");
            writer.write("\r\n");
            writer.write("************************************\r\n");
            writer.write("Fixed:\r\n");
            writer.write("Soup " + choices[0] + "\r\n");
            writer.write("Noodles " + choices[1] + "\r\n");
            writer.write("Spring onion " + choices[2] + "\r\n");
            writer.write("Nori " + choices[3] + "\r\n");
            writer.write("Chashu " + choices[4] + "\r\n");
            writer.write("Boiled egg " + choices[5] + "\r\n");
            writer.write("Spiciness " + choices[6] + "\r\n");
            writer.write("------------------------------------\r\n");
            writer.write("Add-ons:\r\n");
            writer.write("Extra Nori " + choices[7] + "\r\n");
            writer.write("Extra boiled egg " + choices[8] + "\r\n");
            writer.write("Bamboo shoots " + choices[9] + "\r\n");
            writer.write("Extra Chashu " + choices[10] + "\r\n");
            writer.write("------------------------------------\r\n");
            writer.write("Dining option: " + choices[11] + "\r\n");

            if(choices.length == 15){
                writer.write("Price: " + choices[13] + "\r\n");
                writer.write("Method of Payment: " + choices[14] + "\r\n");
                writer.write("Membership Id: " + choices[12].substring(0,8) + "\r\n");
            }
            else{
                writer.write("Price: " + choices[12] + "\r\n");
                writer.write("Method of Payment: " + choices[13] + "\r\n");
            }

            writer.write("Date: " + time + "\r\n");
            writer.write("************************************\r\n");
            writer.close();
        }catch (Exception e) {
            e.printStackTrace();
        }

    }

}
