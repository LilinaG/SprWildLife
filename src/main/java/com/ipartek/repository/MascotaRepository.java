package com.ipartek.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ipartek.model.Mascota;

@Repository
public interface MascotaRepository extends JpaRepository <Mascota, Integer> {

	@Query(value = "SELECT * FROM mascotas where especie_id= :valor", nativeQuery = true)
	List<Mascota> obtenerMascotasPorEspecie(@Param("valor") int valor);

	@Query(value = "SELECT * FROM mascotas where provincia_id= :valor", nativeQuery = true)
	List<Mascota> obtenerMascotasPorProvincia(@Param("valor") int valor);

	
}
