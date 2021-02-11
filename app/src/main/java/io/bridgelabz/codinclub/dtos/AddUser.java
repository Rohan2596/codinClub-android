package io.bridgelabz.codinclub.dtos;


public class AddUser {

    public String mobileNumber;
    public String sourceId;
    public String enrollmentConfigCode;
    public String councillorCode;

    public AddUser(String mobileNumber, String sourceId, String enrollmentConfigCode, String councillorCode) {
        this.mobileNumber = mobileNumber;
        this.sourceId = sourceId;
        this.enrollmentConfigCode = enrollmentConfigCode;
        this.councillorCode = councillorCode;
    }
}
