package it.finsoft.winebookapi.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.finsoft.winebookapi.model.Wine;
import it.finsoft.winebookapi.service.WineService;



@RestController
@RequestMapping("/api")
public class WineController {
	
	@Autowired
	WineService wineservice;
	
@GetMapping("/wines")
public List<Wine> getAllWines(){
	return wineservice.getAllWines();
}

@GetMapping("/wines{id}")
public Wine getWine(@PathVariable String id){
	return wineservice.getWine(id);
}

@PostMapping("/winesAdd")
public void addWine(@RequestBody Wine wine){
  wineservice.addWine(wine);
}
	

@PutMapping("/winesEdit/{id}")
public void updateWine(@RequestBody Wine wine,@PathVariable String id){
	wineservice.updateWine(id, wine);
}

@DeleteMapping("/winesDelete/{id}")
public void deleteWine(@PathVariable String id) {
	wineservice.deleteWine(id);
    }

}
