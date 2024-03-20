package com.example.demo.controller;

import com.example.demo.model.SekolahModel;
import com.example.demo.service.SekolahService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sekolah")
public class SekolahController {
    private final SekolahService sekolahService;

    @Autowired
    public SekolahController(SekolahService sekolahService) {
        this.sekolahService = sekolahService;
    }

    @GetMapping
    public ResponseEntity<List<SekolahModel>> getAllData() {
        List<SekolahModel> sekolahModels = sekolahService.getAllData();
        return new ResponseEntity<>(sekolahModels, HttpStatus.OK);
    }
    //    Tambah Data
    @PostMapping //    method postmen
    public ResponseEntity<SekolahModel> createData(@RequestBody SekolahModel sekolahModel) {
        SekolahModel newData = sekolahService.createDate(sekolahModel);
        return new ResponseEntity<>(newData,HttpStatus.OK);
    }

    //    ubah Data
    @PutMapping("/{id}")
    public ResponseEntity<SekolahModel> updateData(@PathVariable Long id, @RequestBody SekolahModel ubahSiswa) {
        SekolahModel putSiswa = sekolahService.updateData(id, ubahSiswa);
        return new ResponseEntity<>(putSiswa, HttpStatus.OK);
    }

    //    Hapus Data
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteData(@PathVariable Long id) {
        sekolahService.deleteData(id);
        return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
