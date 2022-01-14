package com.example.makananuas;

import com.example.makananuas.Database.Order;

import java.util.List;

public class Request {
    private String nomor;
    private String nama;
    private String alamat;
    private String total;
    private String status;
    private List<Order> makanan;

    public Request() {
    }

    public Request(String nomor, String nama, String alamat, String total, List<Order> makanan) {
        this.nomor = nomor;
        this.nama = nama;
        this.alamat = alamat;
        this.total = total;
        this.makanan = makanan;
        this.status = "0";
    }

    public String getNomor() {
        return nomor;
    }

    public void setNomor(String nomor) {
        this.nomor = nomor;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Order> getMakanan() {
        return makanan;
    }

    public void setMakanan(List<Order> makanan) {
        this.makanan = makanan;
    }
}
