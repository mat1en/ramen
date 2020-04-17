package service;

import GUI.DiningGUI;

public class AddService {
    private int noriNum;
    private int eggNum;
    private int bambooNum;
    private int chasuNum;


    public void add2dining(String[] choices){
        String[] addChoices = getItems(choices);
        DiningGUI.main(addChoices);
    }


    public String[] getItems(String[] choices){
        String[] add = new String[choices.length+4];
        System.arraycopy(choices,0,add,0,choices.length);
        add[add.length-4] = noriNum+"";
        add[add.length-3] = eggNum+"";
        add[add.length-2] = bambooNum+"";
        add[add.length-1] = chasuNum+"";

        return add;
    }


    public void setNoriNum(int noriNum) {
        this.noriNum = noriNum;
    }


    public void setEggNum(int eggNum) {
        this.eggNum = eggNum;
    }


    public void setBambooNum(int bambooNum) {
        this.bambooNum = bambooNum;
    }


    public void setChasuNum(int chasuNum) {
        this.chasuNum = chasuNum;
    }
}
