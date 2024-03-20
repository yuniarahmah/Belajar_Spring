package com.example.demo.controller;

import com.example.demo.model.SiswaModel;
import com.example.demo.service.SiswaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/data_siswa")
public class SiswaController {
    @Autowired
    private SiswaService siswaService;

//    get semua id
    @GetMapping
    public ResponseEntity<List<SiswaModel>> getAllData() {
        List<SiswaModel> siswaModels = siswaService.getAllData();
        return new ResponseEntity<>(siswaModels, HttpStatus.OK);
    }

//    get 1 id
    @GetMapping("/{id}")

    public ResponseEntity<SiswaModel> getById(@PathVariable Long id) {
        Optional<SiswaModel> siswaModels = siswaService.getById(id);
        return siswaModels.map(value -> new ResponseEntity<>(value,HttpStatus.OK))
                .orElseGet(()-> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

//    Tambah Data
    @PostMapping //    method postmen
    public ResponseEntity<SiswaModel> createData(@RequestBody SiswaModel siswaModel) {
        SiswaModel newData = siswaService.createDate(siswaModel);
        return new ResponseEntity<>(newData,HttpStatus.OK);
    }

//    ubah Data
    @PutMapping("/{id}")
    public ResponseEntity<SiswaModel> updateData(@PathVariable Long id, @RequestBody SiswaModel ubahSiswa) {
        SiswaModel putSiswa = siswaService.updateData(id, ubahSiswa);
        return new ResponseEntity<>(putSiswa, HttpStatus.OK);
    }

//    Hapus Data
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteData(@PathVariable Long id) {
    siswaService.deleteData(id);
    return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
