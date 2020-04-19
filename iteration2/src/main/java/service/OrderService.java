package service;

import GUI.ConfirmGUI;
import dao.OrderDAO;
import dao.impl.OrderDAOImpl;
import service.StatisticsService;

import java.util.Arrays;

public class OrderService {
    private String methods;// Method of payment

    public void skip2confirm(String[] choices){
        double price = 9.99 + Integer.parseInt(choices[7]) + Integer.parseInt(choices[8])
                + Integer.parseInt(choices[9]) + 2 * Integer.parseInt(choices[10]);
        price = (double) Math.round(price * 100) / 100;
        String[] add = new String[choices.length+1];
        System.arraycopy(choices,0,add,0,choices.length);
        add[add.length-1] = price+"";
        ConfirmGUI.main(add);
    }

    public void setOrder(String[] choices) throws Exception {
        String[] add = new String[choices.length+1];
        System.arraycopy(choices,0,add,0,choices.length);
        add[add.length-1] = methods;
        OrderDAO dao = new OrderDAOImpl();
        StatisticsService stat = new StatisticsService();
        stat.setStatistics(add);
        dao.write2txt(add);
    }

    public void setMethods(String methods) {
        this.methods = methods;
    }

    public String getMethods() {
        return methods;
    }
}
