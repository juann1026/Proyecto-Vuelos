package com.example.demo.service;

import com.example.demo.domain.Vuelo;

import java.util.Date;
import java.util.Optional;
import java.util.Set;

public interface VueloService {

    Set<Vuelo> findAll();
    Set<Vuelo> findByOrigen(String origen);
    Set<Vuelo> findByDestino(String destino);
    Set<Vuelo> findByCompanyia(String companyia);
    Set<Vuelo> findByPrecio(float precio);
    Optional<Vuelo> findById(long id);
    Vuelo addVuelo(Vuelo vuelo);
    Vuelo modifyVuelo(long id, Vuelo newVuelo);
    void deleteVuelo(long id);
    void deleteByDestino(String destino);
    Set<Vuelo> findByFechainicio(String fechainicio);
    Set<Vuelo> findByfechafin(String fechafin);
}

