package com.quickbites.pos_system.service;

import com.quickbites.pos_system.model.Order;
import com.quickbites.pos_system.model.RawMaterial;
import com.quickbites.pos_system.repository.OrderRepository;
import com.quickbites.pos_system.repository.RawMaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RawMateriaService {
    @Autowired
    private RawMaterialRepository rawMaterialRepository;

    public List<RawMaterial> getAllMaterials(){
        return rawMaterialRepository.findAll();
    }
    public Optional<RawMaterial> getRawMaterialById(Long id){
        return rawMaterialRepository.findById(id);
    }

    public RawMaterial saveRawMaterial(RawMaterial rawMaterial){
        return rawMaterialRepository.save(rawMaterial);
    }

    public void deleteRawMaterial(Long id){
        rawMaterialRepository.deleteById(id);
    }
}
