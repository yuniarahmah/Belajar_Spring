package com.example.demo.service;

import com.example.demo.model.SiswaModel;
import com.example.demo.repository.SiswaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.util.List;
import java.util.Optional;

@Service
public class SiswaService {
    @Autowired
    private SiswaRepository siswaRepository;
//memunculkan semua id
    public List<SiswaModel> getAllData(){
        return siswaRepository.findAll();
    }
//mengambil id yah cantumkan
    public Optional<SiswaModel> getById(Long id) {
        return siswaRepository.findById(id);
    }
//tambah data
    public SiswaModel createDate(SiswaModel siswaModel) {
        return siswaRepository.save(siswaModel);
    }

    //logika ubah data
    public SiswaModel updateData(Long id,SiswaModel updateData){
        Optional<SiswaModel> existingSiswaOptional = siswaRepository.findById(id); // untuk memanipulasi data atau mengubah data
        if (existingSiswaOptional.isPresent()) {  //mengechek data
            SiswaModel existingSiswa = existingSiswaOptional.get();
            existingSiswa.setNama_siswa(updateData.getNama_siswa());
            existingSiswa.setNISN(updateData.getNISN());
            return  siswaRepository.save(existingSiswa);
        } else {
            throw new IllegalArgumentException("id siswa " + id + " tidk ditemukan");
        }
    }

    //logika hapus data
    public void deleteData(Long id) { //    Long untuk parameter, deleteData untuk method
        Optional<SiswaModel> hapusSiswa = siswaRepository.findById(id);
        if (hapusSiswa.isPresent()) { // Exceptionnya bernama hapusSiswa
            siswaRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("siswa dengan id " + id + " tdk dtemukan");
        }
    }


}
