package service;

import dao.impl.StatisticsDAOImpl;

public class StatisticsService {
    public void setStatistics(String[] choices){
        StatisticsDAOImpl stat = new StatisticsDAOImpl();
        stat.updateStatistics(choices);
        stat.writeStatistics();
    }
}
