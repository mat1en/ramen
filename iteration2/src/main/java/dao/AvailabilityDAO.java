package dao;

public interface AvailabilityDAO {
    boolean getAvailabilities(String name);
    void setAvailabilities(String name, boolean availability);
}
