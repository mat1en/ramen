package dao;

public interface StatisticsDAO {
    void readStatistics();
    void writeStatistics();
    void updateStatistics(String[] choices);
}
