package Pojo.Request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LoginRequest {
    @JsonProperty("country")
    String country;
    public String getCountry() {
        return this.country; }
    public void setCountry(String country) {
        this.country = country; }

    @JsonProperty("surname")
    String surname;
    public String getSurname() {
        return this.surname; }
    public void setSurname(String surname) {
        this.surname = surname; }

    @JsonProperty("mobileNumber")
    String mobileNumber;
    public String getMobileNumber() {
        return this.mobileNumber; }
    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber; }

    @JsonProperty("smartCardNumber")
    String smartCardNumber;
    public String getSmartCardNumber() {
        return this.smartCardNumber; }
    public void setSmartCardNumber(String smartCardNumber) {
        this.smartCardNumber = smartCardNumber; }


}
