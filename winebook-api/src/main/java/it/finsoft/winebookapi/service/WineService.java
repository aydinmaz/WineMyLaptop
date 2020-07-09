package it.finsoft.winebookapi.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import org.springframework.stereotype.Service;

import it.finsoft.winebookapi.model.Wine;

@Service
public class WineService {
	
	
    Wine w1=new Wine("1","Red",0,1000,200,800);
    Wine w2=new Wine("2","White",0,2000,300,1700);
    Wine w3=new Wine("3","Rosso",0,3000,100,2900);
    Wine w4=new Wine("4","Pink",100,30,145,240);
    Wine w5=new Wine("5","Champaine",2000,10,390,650);
    List<Wine> wines=new ArrayList<Wine>(Arrays.asList(w1,w2,w3,w4,w5));
    
	public List<Wine> getAllWines() {
	/*wines.add(w1);
	wines.add(w2);
	wines.add(w3);*///dar in ravesh ,ba har bar request az angular , hey be list ghabli ezafe mishan va list toolani mishe
	wines = Arrays.asList(w1,w2,w3);//in ravesh khoobe ba har baar request list az avval sakhte mishe va list hey ezaafe nemishe.
	
		return wines;
	}
    
	
	public Wine getWine(String id){
		return wines.stream().filter(t -> t.getId().equals(id)).findFirst().get();
	}
	
	public void addWine(Wine wine){
		wines.add(wine);
	}
	
	//dar bala az ravesh lambada estefade kardim inja for loop normal
	public void updateWine(String id,Wine wine) 
	  {
		for (int i = 0; i < wines.size(); i++) {
			Wine w=wines.get(i);
			if (w.getId().equals(id)) {
				wines.set(i, wine);
			}
		}
		
	  }
	
	public void deleteWine(String id){
		wines.removeIf(w -> w.getId().equals(id));
	}
}
