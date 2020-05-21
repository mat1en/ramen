package service;

import dao.StatisticsDAO;
import dao.impl.StatisticsDAOImpl;

public class StatisticsService {
    private StatisticsDAO stat;

    public StatisticsService() {
        stat = new StatisticsDAOImpl();
    }

    public String getStatistics(String name){
        if (!name.equals("Sales")) return (String.valueOf((int)stat.getStatistics(name)));
        else return String.valueOf(stat.getStatistics(name));
    }

    public void setStatistics(String[] choices){
        stat.updateStatistics(choices);
        stat.writeStatistics();
    }
}
