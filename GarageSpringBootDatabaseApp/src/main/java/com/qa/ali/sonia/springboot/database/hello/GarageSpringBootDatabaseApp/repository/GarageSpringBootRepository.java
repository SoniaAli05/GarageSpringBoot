package com.qa.ali.sonia.springboot.database.hello.GarageSpringBootDatabaseApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.ali.sonia.springboot.database.hello.GarageSpringBootDatabaseApp.model.GarageSpringBootModel;

@Repository
public interface GarageSpringBootRepository extends JpaRepository<GarageSpringBootModel,Long>{

}
