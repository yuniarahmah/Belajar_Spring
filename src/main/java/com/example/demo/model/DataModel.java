//package com.example.demo.model;
//
//import jakarta.persistence.*;
//
//@Entity
//@Table(name = "tabel_personal")
//public class DataModel {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long Id;
//
//    @Column(name = "nama_lengkap")
//    private String nama_lengkap;
//
//    @Column(name = "umur")
//    private int umur;
//
//    @Column(name = "alamat")
//    private String alamat;
//
//    public Long getId() {
//        return Id;
//    }
//
//    public void setId(Long id) {
//        Id = id;
//    }
//
//    public String getNama_lengkap() {
//        return nama_lengkap;
//    }
//
//    public void setNama_lengkap(String nama_lengkap) {
//        this.nama_lengkap = nama_lengkap;
//    }
//
//    public int getUmur() {
//        return umur;
//    }
//
//    public void setUmur(int umur) {
//        this.umur = umur;
//    }
//
//    public String getAlamat() {
//        return alamat;
//    }
//
//    public void setAlamat(String alamat) {
//        this.alamat = alamat;
//    }
//
//    public String getStatus() {
//        return status;
//    }
//
//    public void setStatus(String status) {
//        this.status = status;
//    }
//
//    @Column(name = "status")
//    private String status;
//
//}
