package dao;

import vo.Fixed;

import java.util.ArrayList;

public interface MemberDAO {
    public String member2file(String fN, String lN, String email, String tel) throws Exception;
    public boolean checkMemberId(String memberId) throws Exception;
    public int getVS(String memberId);
    public void setVS20(String memberId);
    public void addVS(String memberId, int num);
    public String[] getInfo(String memberId);
}
