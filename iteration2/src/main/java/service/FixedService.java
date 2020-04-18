package service;

import GUI.AddGUI;
import dao.PriceDAO;
import dao.impl.PriceDAOImpl;

public class FixedService {
   private String soupChoice;
   private String noodleChoice;
   private String onionChoice;
   private String noriChoice;
   private String chasuChoice;
   private String eggChoice;
   private String spicinessChoice;

   public void fixed2add(){
       String[] Choices = getItems();
       AddGUI.main(Choices);
    }

    public String[] getItems(){
       String[] Choices = {soupChoice,noodleChoice,
               onionChoice,noriChoice, chasuChoice,eggChoice,
               spicinessChoice};
       return Choices;
    }

    public void setPrices(String name, float price){
       PriceDAO dao =new PriceDAOImpl();
       dao.setPrices(name, price);
    }

    public float getPrice(String name){
       PriceDAO dao =new PriceDAOImpl();
       return dao.getPrices(name);
    }

   public void setSoupChoice(String soupChoice) {
      this.soupChoice = soupChoice;
   }

   public void setNoodleChoice(String noodleChoice) {
      this.noodleChoice = noodleChoice;
   }

   public void setOnionChoice(String onionChoice) {
      this.onionChoice = onionChoice;
   }

   public void setNoriChoice(String noriChoice) {
      this.noriChoice = noriChoice;
   }

   public void setChasuChoice(String chasuChoice) {
      this.chasuChoice = chasuChoice;
   }

   public void setEggChoice(String eggChoice) {
      this.eggChoice = eggChoice;
   }

   public void setSpicinessChoice(String spicinessChoice) {
      this.spicinessChoice = spicinessChoice;
   }

}
