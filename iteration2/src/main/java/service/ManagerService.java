package service;

import dao.AvailabilityDAO;
import dao.impl.AvailabilityDAOImpl;
import dao.impl.PriceDAOImpl;

public class ManagerService {
    //this is almost a stub, using hard-code of low quality, and could be refactored and enhanced.
    //due to some issues, I have insufficient time to do this, so if any member do, it's recommended to refactor this.
    public boolean managerLogIn(String name, String password){
        return name.equals("miyazaki") && password.equals("miyazakiramen");
    }

    public float readPrices(String name){
//        PriceDAOImpl priceDAO= new PriceDAOImpl();
        return new PriceDAOImpl().getPrices(name);
    }

    public void setPrices(String name, float prices){
        new PriceDAOImpl().setPrices(name,prices);
    }

    public boolean readAvailability(String name){
        return new AvailabilityDAOImpl().getAvailabilities(name);
    }

    public void setAvailability(String name, boolean availability) {
        new AvailabilityDAOImpl().setAvailabilities(name,availability);
    }
}
