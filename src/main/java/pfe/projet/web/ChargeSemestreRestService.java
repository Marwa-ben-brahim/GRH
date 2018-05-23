package pfe.projet.web;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pfe.projet.dao.ChargeSemestreRepository;
import pfe.projet.entities.ChargeSem;

@RestController
@CrossOrigin("*")
public class ChargeSemestreRestService {
	@Autowired
	private ChargeSemestreRepository chargeSemestreRepository;
	//Retourner la liste des chargesSemestre
	@RequestMapping(value="/ChargeSemestres", method=RequestMethod.GET)
	public List<ChargeSem> getconges(){
		return chargeSemestreRepository.findAll();
	}
	@RequestMapping(value="/chercherChargeSemestre", method=RequestMethod.GET)
	public Page<ChargeSem>chercher(
			@RequestParam(required = false)Date mc,
			@RequestParam(name="page",defaultValue="0") int page,
			@RequestParam(name="size",defaultValue="5")int size){
		return chargeSemestreRepository.chercher(mc,new PageRequest(page,size));
	}
	//Retourner un seul chargSemestre
	@RequestMapping(value="/ChargeSemestre/{id}", method=RequestMethod.GET)
	public ChargeSem getOneChargeSemestre(@PathVariable long id){
	return chargeSemestreRepository.findOne(id);
	}
	//Ajouter un chargeSemestre
	@RequestMapping(value="/AjouterChargeSemestre", method=RequestMethod.POST)
	public ChargeSem save(@RequestBody ChargeSem cs){
	return chargeSemestreRepository.save(cs);
	}
	//Supprimer un chargeSemestre
	@RequestMapping(value="/SupprimerChargeSemestre/{id}", method=RequestMethod.DELETE)
	public boolean supprimer(@PathVariable long id){
		chargeSemestreRepository.delete(id);
		return true;
	}
	//mettre à jour un chargeSemestre
	@RequestMapping(value="/ModifierChargeSemestre/{id}", method=RequestMethod.PUT)
	public ChargeSem save(@PathVariable  long id,@RequestBody ChargeSem cs){
	    cs.setId(id);
		return chargeSemestreRepository.save(cs);
	}

}
