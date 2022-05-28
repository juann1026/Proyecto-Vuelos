package com.example.demo.repository;

import com.example.demo.domain.Vuelo;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.Optional;
import java.util.Set;

public interface VueloRepository  extends CrudRepository<Vuelo, Long> {

    Set<Vuelo> findAll();
    Set<Vuelo> findByOrigen(String origen);
    Set<Vuelo> findByDestino(String destino);
    Optional<Vuelo> findById(long id);
    Set<Vuelo> findByCompanyia(String companyia);
    void deleteByDestino(String destino);
    Set<Vuelo> findByPrecio(float precio);
    Set<Vuelo> findByFechainicio(String fechainicio);
    Set<Vuelo> findByfechafin(String fechafin);

}
