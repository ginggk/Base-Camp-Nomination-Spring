package com.gingerraymatthew.basecampnomination.forms;


import java.io.Serializable;
import java.net.URL;
import java.util.Date;


public class StudentForm {
    public Integer id;
    public String name;
    public String email;
    public String school;
    public Boolean eligibility;
    public Integer age;
    public String phoneNumber;
    public Date graduation;
    public String plan;
    public String aptitude;
    public String dedication;
    public  String passion;

    public StudentForm(Integer id, String name, String email, String school, Boolean eligibility, Integer age, String phoneNumber, Date graduation, String plan, String aptitude, String dedication, String passion) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.school = school;
        this.eligibility = eligibility;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.graduation = graduation;
        this.plan = plan;
        this.aptitude = aptitude;
        this.dedication = dedication;
        this.passion = passion;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getEligibility() {
        if (eligibility == true) {
            return "✔️";
        } else if (eligibility == false){
            return  "❌";
        } else {
            return "Data Error";
        }
    }

    public String getEligibilityText() {
        if (eligibility == true) {
            return "Yes";
        } else if (eligibility == false){
            return  "No";
        } else {
            return "Data Error";
        }
    }

    public void setEligibility(Boolean eligibility) {
        this.eligibility = eligibility;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getGraduation() {
        return graduation;
    }

    public void setGraduation(Date graduation) {
        this.graduation = graduation;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public String getAptitude() {
        return aptitude;
    }

    public void setAptitude(String aptitude) {
        this.aptitude = aptitude;
    }

    public String getDedication() {
        return dedication;
    }

    public void setDedication(String dedication) {
        this.dedication = dedication;
    }

    public String getPassion() {
        return passion;
    }

    public void setPassion(String passion) {
        this.passion = passion;
    }
    public boolean isValid() {
       return (name != null && email != null && school != null && eligibility != null && age != null && phoneNumber != null && graduation != null &&
               plan != null && aptitude != null && dedication != null && passion != null);
    }

    public String asString(StudentForm student) {
        return student.name;
    }
}