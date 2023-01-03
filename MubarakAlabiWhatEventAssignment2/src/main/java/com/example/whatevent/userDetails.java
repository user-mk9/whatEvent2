/*
Mubarak Alabi
27/12/22
*/
package com.example.whatevent;

public class userDetails {

    private String email;
    private String password;
    private String name;
    private String confirmPaswrd;
    private String phone;
    private String website;
    boolean isEnable;

    public userDetails(String name, String password, String email, String confirmPaswrd, String phone, String website) {


        this.name = name;
        this.password = password;
        this.email = email;
        this.confirmPaswrd = confirmPaswrd;
        this.phone = phone;
        this.website = website;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getConfirmPaswrd() {
        return confirmPaswrd;
    }

    public void setConfirmPaswrd(String confirmPaswrd) {
        this.confirmPaswrd = confirmPaswrd;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public boolean getIsEnable(){

        return isEnable;
    }

    public void setIsEnable(boolean isEnable) {
        this.isEnable = isEnable;
    }

    @Override
    public String toString() {
        return "userDetails{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", confirm Password='" + confirmPaswrd + '\'' +
                ", phone='" + phone + '\'' +
                ", website='" + website + '\'' +
                '}';
    }
}
