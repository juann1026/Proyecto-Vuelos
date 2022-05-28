package com.example.demo.service;


import com.example.demo.domain.Vuelo;
import com.example.demo.exception.VueloNotFoundException;
import com.example.demo.repository.VueloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
public class VueloServiceImpl implements VueloService {

    @Autowired
    private VueloRepository vueloRepository;


    @Override
    public Set<Vuelo> findAll() {
        return vueloRepository.findAll();
    }

    @Override
    public Set<Vuelo> findByOrigen(String origen) {
        return vueloRepository.findByOrigen(origen);
    }
    @Override
    public Set<Vuelo> findByDestino(String destino) {
        return vueloRepository.findByDestino(destino);
    }
    @Override
    public Set<Vuelo> findByCompanyia(String companyia) {
        return vueloRepository.findByCompanyia(companyia);
    }
    @Override
    public Set<Vuelo> findByPrecio(float precio) {
        return vueloRepository.findByPrecio(precio);
    }

    @Override
    public Set<Vuelo> findByFechainicio(String fechainicio) {
        return vueloRepository.findByFechainicio(fechainicio);
    }

    @Override
    public Set<Vuelo> findByfechafin(String fechafin) {
        return vueloRepository.findByfechafin(fechafin);
    }

    @Override
    public Optional<Vuelo> findById(long id) {
        return vueloRepository.findById(id);
    }

    @Override
    public Vuelo addVuelo(Vuelo vuelo) {
        return vueloRepository.save(vuelo);
    }

    @Override
    public Vuelo modifyVuelo(long id, Vuelo newProduct) {
        Vuelo product = vueloRepository.findById(id)
                .orElseThrow(() -> new VueloNotFoundException(id));
        newProduct.setId(product.getId());
        return vueloRepository.save(newProduct);
    }

    @Override
    public void deleteVuelo(long id) {
        vueloRepository.findById(id)
                .orElseThrow(() -> new VueloNotFoundException(id));
        vueloRepository.deleteById(id);
    }

    @Override
    public void deleteByDestino(String destino) {
        vueloRepository.findByDestino(destino);
        vueloRepository.deleteByDestino(destino);
    }

}

