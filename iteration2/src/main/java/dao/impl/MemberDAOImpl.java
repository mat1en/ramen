package dao.impl;

import dao.MemberDAO;
import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/**
 * @program: src
 * @description:
 * @create: 2020-04-07 21:33
 **/

public class MemberDAOImpl implements MemberDAO {
    public String member2file(String fN, String lN, String email, String tel) throws Exception{
        String filepath = "files/userInfo.csv";
        String memberId = generateMemberId();
        int flag = 0;
        try {
            do {
                BufferedReader reader = new BufferedReader(new FileReader(filepath));
                reader.readLine();
                String line;
                flag = 0;
                memberId = generateMemberId();
                while ((line = reader.readLine()) != null) {
                    String[] item = line.split(",");
                    if (item[0].equals(memberId)) {
                        flag = 1;
                        break;
                    }
                }
            } while (flag != 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            File csv = new File(filepath); // CSV数据文件

            BufferedWriter bw = new BufferedWriter(new FileWriter(csv, true)); // 附加
            bw.write(memberId + "," + fN + "," + lN + "," + email + "," + tel + "," + 0);
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return memberId;
    }

    public String generateMemberId(){
        Random random = new Random();
        int length = 8;
        String memberId = "";
        for (int i = 0; i < length; i++) {
            // 输出字母还是数字
            String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
            // 字符串
            if ("char".equalsIgnoreCase(charOrNum)) {
                // 取得大写字母还是小写字母
                int choice = random.nextInt(2) % 2 == 0 ? 65 : 97;
                memberId += (char) (choice + random.nextInt(26));
            }
            else { // 数字
                memberId += String.valueOf(random.nextInt(10));
            }
        }
        return memberId;
    }

    public boolean checkMemberId(String memberId) throws Exception{
        String filepath = "files/userInfo.csv";
        boolean flag = false;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filepath));
            reader.readLine();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] item = line.split(",");
                if (item[0].equals(memberId)) {
                    flag = true;
                    break;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    public int getVS(String memberId){
        String fixedFile = "files/userInfo.csv";
        int VSnum = 0;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fixedFile));
            reader.readLine(); //first line is the header information
            String line = null;
            while((line = reader.readLine()) != null){
                String[] value = line.split(",");
                if (value[0].equals(memberId))
                    VSnum = Integer.parseInt(value[5]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return VSnum;
    }

    public void setVS20(String memberId){
        String filepath = "files/userInfo.csv";
        int row = 0;
        int nowNum = 0;
        String modifyValue = null;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filepath));
            reader.readLine(); //first line is the header information
            String line = null;
            while((line = reader.readLine()) != null){
                String[] value = line.split(",");
                row ++;
                if (value[0].equals(memberId)){
                    nowNum = Integer.parseInt(value[5]);
                    break;
                }
            }
            modifyValue = String.valueOf(nowNum - 10);
            writeExcel(filepath,row,5,modifyValue,filepath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addVS(String memberId, int num){
        String filepath = "files/userInfo.csv";
        int row = 0;
        int nowNum = 0;
        String modifyValue = null;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filepath));
            reader.readLine(); //first line is the header information
            String line = null;
            while((line = reader.readLine()) != null){
                String[] value = line.split(",");
                row ++;
                if (value[0].equals(memberId)){
                    nowNum = Integer.parseInt(value[5]);
                    break;
                }
            }
            modifyValue = String.valueOf(nowNum + num);
            writeExcel(filepath,row,5,modifyValue,filepath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void writeExcel(String path,int row,int column,String modifyValue,String savePath){    //修改csv 内值得数据
        try {
            //System.out.println("Storing....");
            CsvReader csvReader = new CsvReader(path,',', StandardCharsets.UTF_8);
            List<String[]> list = new ArrayList<String[]>();
            while(csvReader.readRecord()) {
                list.add(csvReader.getValues());
            }
            csvReader.close();
            for(int rowNum = 0; rowNum < list.size(); rowNum++){
                //String  cell = list.get(rowNum)[0]; //取得第row行第0列的数据
                //System.out.println(cell);
                if(rowNum == row) {
                    list.get(rowNum)[column]=modifyValue;
                }
            }

            File file = new File(path);
            file.delete();
            writeCsv(savePath,"utf-8",list);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeCsv(String path,String unicode,List<String[]> list) {
        CsvWriter csvWriter = new CsvWriter(path,',',Charset.forName(unicode));
        try {
            //System.out.println("Writing...");
            for (String[] strings : list) {
                csvWriter.writeRecord(strings);
            }
            csvWriter.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String[] getInfo(String memberId){
        String filepath = "files/userInfo.csv";
        String fN = null;
        String lN = null;
        String email = "";
        String tel = "";
        String stamps = null;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filepath));
            reader.readLine();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] item = line.split(",");
                if (item[0].equals(memberId)) {
                    fN = item[1];
                    lN = item[2];
                    email = item[3];
                    tel = item[4];
                    stamps = item[5];
                    break;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return new String[]{fN, lN, email, tel, memberId, stamps};
    }
}
