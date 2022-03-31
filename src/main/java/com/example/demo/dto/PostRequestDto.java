package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PostRequestDto {
    private String account;
    private String email;
    private String address;
    private String password;

    //멤버변수의 이름과 json객체의 key값이 동일 해야한다고 하는데
    //변수를 작성을 할때 카멜표기법과 스네이크 표기법을 동시에 보내줄때가 있다.(기본은 카멜표기법을 사용한다.)
    //이것을 한 변수라고 알려주는 annotation이 있는데 이것이 JsonProperty이다.
    //하지만 JsonProperty는 모든 변수에 작성을 해주어야하기 때문에 잘 사용하지 않는다.
    @JsonProperty("phone_number")
    private String phoneNumber; //phone_number라는 json객체와 매핑을 시켜줘 똑같은 객체로 인식시켜준다

    @JsonProperty("OTP")
    private String OTP;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "PostRequestDto{" +
                "account='" + account + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", password='" + password + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", OTP='" + OTP + '\'' +
                '}';
    }
}
