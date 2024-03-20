package com.example.demo.service;

import com.example.demo.model.SekolahModel;
import com.example.demo.repository.SekolahRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SekolahService {
    @Autowired
    private SekolahRepository sekolahrepository;

    public List<SekolahModel> getAllData(){
        return sekolahrepository.findAll();
    }

    //mengambil id yah cantumkan
    public Optional<SekolahModel> getById(Long id) {
        return sekolahrepository.findById(id);
    }

    //tambah data
    public SekolahModel createDate(SekolahModel sekolahmodel) {
        return sekolahrepository.save(sekolahmodel);
    }

    //logika ubah data
    public SekolahModel updateData(Long id,SekolahModel updateData){
        Optional<SekolahModel> existingSiswaOptional = sekolahrepository.findById(id); // untuk memanipulasi data atau mengubah data
        if (existingSiswaOptional.isPresent()) {  //mengechek data
            SekolahModel existingSiswa = existingSiswaOptional.get();
            existingSiswa.setNama_sekolah(updateData.getNama_sekolah());
            existingSiswa.setAlamat_sekolah(updateData.getAlamat_sekolah());
            return sekolahrepository.save(existingSiswa);
        } else {
            throw new IllegalArgumentException("id siswa " + id + " tidk ditemukan");
        }
    }

    //logika hapus data
    public void deleteData(Long id) { //    Long untuk parameter, deleteData untuk method
        Optional<SekolahModel> hapusSiswa = sekolahrepository.findById(id);
        if (hapusSiswa.isPresent()) { // Exceptionnya bernama hapusSiswa
            sekolahrepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("siswa dengan id " + id + " tdk dtemukan");
        }
    }
}
