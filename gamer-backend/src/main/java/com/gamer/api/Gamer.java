package com.gamer.api;

import java.util.Date;

public class Gamer {

    private String id;
    private String displayName;
    private Date dateOfBirth;
    private String emailAddress;
    private String telephoneNumber;
    private String introductionText;

    public Gamer() {
        super();
    }

    public Gamer(String id, String displayName, Date dateOfBirth, String emailAddress, String telephoneNumber, String introductionText) {
        this.id = id;
        this.displayName = displayName;
        this.dateOfBirth = dateOfBirth;
        this.emailAddress = emailAddress;
        this.telephoneNumber = telephoneNumber;
        this.introductionText = introductionText;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getIntroductionText() {
        return introductionText;
    }

    public void setIntroductionText(String introductionText) {
        this.introductionText = introductionText;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return "Gamer{" +
                "id='" + id + '\'' +
                ", displayName='" + displayName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", emailAddress='" + emailAddress + '\'' +
                ", telephoneNumber='" + telephoneNumber + '\'' +
                ", introductionText='" + introductionText + '\'' +
                '}';
    }
}
