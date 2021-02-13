package io.bridgelabz.codinclub.dtos;

public class EditUser {


    public String emailId;
    public String name;
    public String stream;
    public String monthOfExperience;
    public String yearOfPassing;
    public String experienceNote;

    public EditUser(String emailId, String name, String stream, String monthOfExperience, String yearOfPassing, String experienceNote) {
        this.emailId = emailId;
        this.name = name;
        this.stream = stream;
        this.monthOfExperience = monthOfExperience;
        this.yearOfPassing = yearOfPassing;
        this.experienceNote = experienceNote;
    }
}
