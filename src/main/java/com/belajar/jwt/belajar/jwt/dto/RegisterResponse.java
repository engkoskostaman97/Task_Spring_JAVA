package com.belajar.jwt.belajar.jwt.dto;

import com.belajar.jwt.belajar.jwt.model.User;

import lombok.Data;

@Data
public class RegisterResponse {
  private Long userid;
  private String namadepan;
  private String namabelakang;
  private String nomortelephone;
  private String email;
  private String password;
  private String konfirmasipassword;

  public RegisterResponse( Long userid,String namadepan, String namabelakang, String nomortelephone,String email, String password,String konfirmasipassword) {
      this.userid = userid;
      this.namadepan = namadepan;
      this.namabelakang = namabelakang;
      this.nomortelephone = nomortelephone;
      this.email = email;
      this.password = password;
      this.konfirmasipassword = konfirmasipassword;
  }


}
