package qa.andrew.springboot.blockbuster.myBlockbusterApp.controller;

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

import qa.andrew.springboot.blockbuster.myBlockbusterApp.exception.ResourceNotFoundException;
import qa.andrew.springboot.blockbuster.myBlockbusterApp.model.MyBlockbusterAppDataModel;
import qa.andrew.springboot.blockbuster.myBlockbusterApp.repository.MyBlockbusterAppRepository;


@RestController
@RequestMapping("/api")
public class MyBlockbusterAppController {  
	
	@Autowired
	MyBlockbusterAppRepository myRepository;
	
	@PostMapping("/dvd")
	public MyBlockbusterAppDataModel createDvd(@Valid @RequestBody MyBlockbusterAppDataModel mBADM) {
		return myRepository.save(mBADM);
	}
	
	@PostMapping("/user")
	public MyBlockbusterAppDataMode createDvd(@Valid @RequestBody MyBlockbusterAppDataModel mBADM) {
		return myRepository.save(mBADM);
	}
	
	@GetMapping("dvd/{id}")
	public MyBlockbusterAppDataModel getDvdById(@PathVariable(value = "id")Long dvdID) {
		return myRepository.findById(dvdID).orElseThrow(()-> new ResourceNotFoundException("MyBlockbusterAppDataModel","id",dvdID));
	}
	
	@GetMapping("dvd/")
	public List<MyBlockbusterAppDataModel> getAllDvds(){
		return myRepository.findAll();
	}
	
	@PutMapping("/dvd/{id}")
	public MyBlockbusterAppDataModel updateDvd(@PathVariable(value = "id") Long dvdID, 
			@Valid @RequestBody MyBlockbusterAppDataModel dvdDetails) {
		
		MyBlockbusterAppDataModel mBADM = myRepository.findById(dvdID).orElseThrow(()-> new ResourceNotFoundException("MyBlockbusterAppDataModel","id",dvdID));
		
		mBADM.setDvd_name(dvdDetails.getDvd_name());
		mBADM.setAvaliable(dvdDetails.getAvaliable());
		
		MyBlockbusterAppDataModel updateData = myRepository.save(mBADM);
		return updateData;
	}
	
	@DeleteMapping("/dvd/{id}")
	public ResponseEntity<?> deleteDvd(@PathVariable(value = "id") Long dvdID) {
		MyBlockbusterAppDataModel mBADM = myRepository.findById(dvdID).orElseThrow(()-> new ResourceNotFoundException("MyBlockbusterAppDataModel","id",dvdID));
		
		myRepository.delete(mBADM);
		return ResponseEntity.ok().build();
	}
}
