package com.qa.ali.sonia.springboot.database.hello.GarageSpringBootDatabaseApp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.ali.sonia.springboot.database.hello.GarageSpringBootDatabaseApp.exception.ResourceNotFoundException;
import com.qa.ali.sonia.springboot.database.hello.GarageSpringBootDatabaseApp.model.GarageSpringBootModel;
import com.qa.ali.sonia.springboot.database.hello.GarageSpringBootDatabaseApp.repository.GarageSpringBootRepository;

@RestController
@RequestMapping("/api")
public class GarageSpringBootController {
	
	@Autowired
	GarageSpringBootRepository myRepository;
	
	//Method to create a person
	@PostMapping("/vehicle")
	public GarageSpringBootModel createPerson(@Valid @RequestBody GarageSpringBootModel mSDM) {
		return myRepository.save(mSDM);
	}
	//Method to get a person
	@GetMapping("vehicle/{id}")
	public GarageSpringBootModel createVehiclebyID(@PathVariable(value = "id")Long vehicleID) {
		return myRepository.findById(vehicleID).orElseThrow(()-> new ResourceNotFoundException("GarageSpringBootModel", "id",vehicleID));
	}
	//Method to get all people
	@GetMapping("/vehicle")
	public List<GarageSpringBootModel>getAllVehicle(){
		return myRepository.findAll();
	}
	//Method to update a person
	@PutMapping("/vehicle/{id}")
	public GarageSpringBootModel updateVehicle(@PathVariable(value = "id")Long VehicleID, @Valid @RequestBody GarageSpringBootModel vehicleDetails) {
		
		GarageSpringBootModel mSDM = myRepository.findById(VehicleID).orElseThrow(()-> new ResourceNotFoundException("Person","id",VehicleID));
		
		mSDM.setType(vehicleDetails.getType());
		mSDM.setModel(vehicleDetails.getModel());
		mSDM.setColour(vehicleDetails.getColour());
		mSDM.setPrice(vehicleDetails.getPrice());

		
		GarageSpringBootModel updateData = myRepository.save(mSDM);
		return updateData;
	}
	//method to remove a person
	@DeleteMapping("/vehicle/{id}")
	public ResponseEntity<?> deleteVehicle(@PathVariable(value = "id")Long vehicleID){
		GarageSpringBootModel mSDM = myRepository.findById(vehicleID).orElseThrow(()->new ResourceNotFoundException("Vehicle","id",vehicleID));
		
		myRepository.delete(mSDM);
		return ResponseEntity.ok().build();
	}
}
