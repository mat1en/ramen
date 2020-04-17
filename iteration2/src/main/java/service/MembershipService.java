package service;

import GUI.SRegistrationGUI;
import dao.MemberDAO;
import dao.impl.MemberDAOImpl;

import javax.swing.*;
import java.util.regex.Pattern;

/**
 * @program: src
 * @description: mebership
 * @create: 2020-04-07 21:29
 **/

public class MembershipService {
    private String fN;
    private String lN;
    private String email;
    private String tel;
    private String memberId;
    private String type;

    public void member2SMember(String[] choices){//read price
        double price = 9.99 + Integer.parseInt(choices[7]) + Integer.parseInt(choices[8])
                + Integer.parseInt(choices[9]) + 2*Integer.parseInt(choices[10]);
        price = (double) Math.round(price * 100) / 100;
        String[] add = new String[choices.length+2];
        System.arraycopy(choices,0,add,0,choices.length);
        String str = memberId + type;
        add[add.length-2] = str;
        add[add.length-1] = price + "";
        SRegistrationGUI.main(add);
    }

    public void register2membership() throws Exception {
        MemberDAO dao = new MemberDAOImpl();
        memberId =  dao.member2file(fN, lN, email, tel);
    }

    public boolean checkForamt(){
        String RULE_EMAIL = "^\\w+((-\\w+)|(\\.\\w+))*\\@[A-Za-z0-9]+((\\.|-)[A-Za-z0-9]+)*\\.[A-Za-z0-9]+$";
        boolean email_flag;
        if(email == null || email.length() == 0) email_flag = true;
        else email_flag = Pattern.matches(RULE_EMAIL, email);


        boolean tel_flag;
        String REGEX_MOBILE_CN ="^(\\+?0?86\\-?)?1[345789]\\d{9}$";
        String REGEX_MOBILE_EN = "^(\\\\+?44|0)7\\\\d{9}$";
        if(tel == null || tel.length() == 0) tel_flag = true;
        else{
            tel_flag = Pattern.matches(REGEX_MOBILE_CN, tel);
            if(!tel_flag) tel_flag = Pattern.matches(REGEX_MOBILE_EN, tel);
        }

        if(!email_flag && email.length() != 0){
            Object[] options = {"OK"};
            JOptionPane.showOptionDialog(null, "The Email Format Is Wrong!",
                    "WARNING", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE,
                    null, options, options[0]);
        }
        else if(!tel_flag){
            Object[] options = {"OK"};
            JOptionPane.showOptionDialog(null, "The Mobile Number Format Is Wrong!",
                    "WARNING", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE,
                    null, options, options[0]);
        }
        return email_flag & tel_flag;
    }

    public boolean checkMermeberId() throws Exception {
        MemberDAO dao = new MemberDAOImpl();
        return dao.checkMemberId(memberId);
    }

    public int getVS(String memberId){
        MemberDAO dao = new MemberDAOImpl();
        return dao.getVS(memberId);
    }

    public void setVS(String memberId){
        MemberDAO dao = new MemberDAOImpl();
        dao.setVS20(memberId);
    }

    public void addVS(String memberId, int num){
        MemberDAO dao = new MemberDAOImpl();
        dao.addVS(memberId, num);
    }

    public String[] getInfo(String memberId){
        MemberDAO dao = new MemberDAOImpl();
        return dao.getInfo(memberId);
    }

    public String[] newPrice(String[] choice){
        FixedService fix = new FixedService();
        double price = fix.getPrice("Fixed");
        price = Double.parseDouble(choice[13]) - price;
        price = (double) Math.round(price * 100) / 100;
        choice[13] = String.valueOf(price);
        return choice;

    }

    public void setfN(String fN) {
        this.fN = fN;
    }

    public void setlN(String lN) {
        this.lN = lN;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setMemberId(String memeberId) {
        this.memberId = memeberId;
    }

    public void setType(String type) {
        this.type = type;
    }
}
