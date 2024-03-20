package com.example.demo.service;

import com.example.demo.model.KelasModel;
import com.example.demo.model.SiswaModel;
import com.example.demo.repository.KelasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KelasService {
    private final KelasRepository kelasRepository;

    @Autowired
    public KelasService(KelasRepository kelasRepository) {
        this.kelasRepository = kelasRepository;
    }

    public List<KelasModel> getAllData() {
        return kelasRepository.findAll();
    }

    public Optional<KelasModel> getById(Long id) {
        return kelasRepository.findById(id);
    }

    //tambah data
    public KelasModel createDate(KelasModel kelasModel) {
        return kelasRepository.save(kelasModel);
    }

    //logika ubah data
    public KelasModel updateData(Long id,KelasModel updateData){
        Optional<KelasModel> existingKelasOptional = kelasRepository.findById(id); // untuk memanipulasi data atau mengubah data
        if (existingKelasOptional.isPresent()) {  //mengechek data
            KelasModel existingSiswa = existingKelasOptional.get();
            existingSiswa.setNama_Kelas(updateData.getNama_Kelas());
            existingSiswa.setNama_jurusan(updateData.getNama_jurusan());
            return kelasRepository.save(existingSiswa);
        } else {
            throw new IllegalArgumentException("id siswa " + id + " tidk ditemukan");
        }
    }

    //logika hapus data
    public void deleteData(Long id) { //    Long untuk parameter, deleteData untuk method
        Optional<KelasModel> hapusSiswa = kelasRepository.findById(id);
        if (hapusSiswa.isPresent()) { // Exceptionnya bernama hapusSiswa
            kelasRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("siswa dengan id " + id + " tdk dtemukan");
        }
    }
}
