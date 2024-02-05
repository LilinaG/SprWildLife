package com.ipartek.controller;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ipartek.model.Especie;
import com.ipartek.model.Mascota;
import com.ipartek.model.Provincia;
import com.ipartek.repository.EspecieRepository;
import com.ipartek.repository.MascotaRepository;
import com.ipartek.repository.ProvinciaRepository;

@Controller
public class AdminController {

	@Autowired
	private EspecieRepository especieRepo;

	@Autowired
	private ProvinciaRepository provinciaRepo;

	@Autowired
	private MascotaRepository mascotaRepo;

	@RequestMapping("/admin")
	public String cargarAdministracion(Model model) {
		List<Especie> listaEspecies = especieRepo.findAll();
		List<Provincia> listaProvincias = provinciaRepo.findAll();
		List<Mascota> listaMascotas = mascotaRepo.findAll();

		model.addAttribute("atr_lista_especies", listaEspecies);
		model.addAttribute("atr_lista_provincias", listaProvincias);
		model.addAttribute("atr_lista_mascotas", listaMascotas);

		model.addAttribute("objeto_entidad", new Mascota());

		return "admin";
	}

	@RequestMapping("/guardar_mascota")
	public String guardarMascota(@ModelAttribute Mascota objeto_entidad) {
		mascotaRepo.save(objeto_entidad);

		return "redirect:/admin";
	}

	@RequestMapping("/cargar_modificar/{id}")
	public String cargarModificarMascota(@PathVariable int id, Model model) {
		Optional<Mascota> mascota = mascotaRepo.findById(id);
		
		List<Especie> listaEspecies = especieRepo.findAll();
		List<Provincia> listaProvincias = provinciaRepo.findAll();
		
		model.addAttribute("atr_lista_especies", listaEspecies);
		model.addAttribute("atr_lista_provincias", listaProvincias);
		
		model.addAttribute("objeto_entidad", mascota);
		
		return "form_modificar";
	}

	@RequestMapping("/borrar_mascota/{id}")
	public String borrarMascota(@PathVariable int id) {
	    mascotaRepo.deleteById(id);
	    return "redirect:/admin";
	}

	
	@RequestMapping("/modificar_mascota")
	public String ModificarMascota(@ModelAttribute Mascota objeto_entidad) {
		mascotaRepo.save(objeto_entidad);

		return "redirect:/admin";
	}
	

}
