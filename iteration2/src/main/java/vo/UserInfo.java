package vo;

public class UserInfo{
    private String membershipId; // membership number
    private String firstName; // first name
    private String lastName; // last name
    private String email; // email
    private String mobileNumber; // mobile phone number
    private String VSNum; // the number of virtual stamps


    public void setMembershipId(String membershipId) {
        this.membershipId = membershipId;
    }

    public String getMembershipId() {
        return membershipId;
    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }


    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }


    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }


    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }


    public void setVSNum(String VSNum) {
        this.VSNum = VSNum;
    }

    public String getVSNum() {
        return VSNum;
    }
}