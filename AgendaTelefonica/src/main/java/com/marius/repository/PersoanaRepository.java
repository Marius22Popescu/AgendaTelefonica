package com.marius.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.marius.model.Persoana;

//PersoanaRepository extends the JpaRepository in order to allow the PersoanaService class to use just the desired methods from the
//JpaRepository and define custom methods. Else I should implement all the methods from the JpaRrepository library if I implement directly the JpaRepository

@Repository //Allow to do CRUD operation on the entity class
public interface PersoanaRepository extends JpaRepository<Persoana, Long>{
	


}
