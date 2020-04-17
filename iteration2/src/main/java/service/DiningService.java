package service;

import GUI.AddGUI;
import GUI.ConfirmGUI;
import GUI.MemberGUI;

public class DiningService {
    private String diningChoice;

    public void dining2member(String[] choices){
        String[] addChoices = getItems(choices);
        MemberGUI.main(addChoices);
    }

    public String[] getItems(String[] choices){
        String[] add = new String[choices.length+1];
        System.arraycopy(choices,0,add,0,choices.length);
        add[add.length-1] = diningChoice;
        return add;

    }

    public void setDiningChoice(String diningChoice) {
        this.diningChoice = diningChoice;
    }
}
