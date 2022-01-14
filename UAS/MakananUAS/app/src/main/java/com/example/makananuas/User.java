package com.example.makananuas;

public class User {
    private String Nama;
    private String Nomor;
    private String Password;

    public User(){

    }
    public User(String nama, String password){
        Nama = nama;
        Password = password;
    }

    public String getNama() {
        return Nama;
    }

    public void setNama(String nama) {
        Nama = nama;
    }

    public String getNomor() {
        return Nomor;
    }

    public void setNomor(String nomor) {
        Nomor = nomor;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
