package com.example.demo.repository;

import com.example.demo.model.KelasModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public  interface KelasRepository extends JpaRepository<KelasModel, Long> {
}
