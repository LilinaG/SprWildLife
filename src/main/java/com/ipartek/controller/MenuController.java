package com.ipartek.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ipartek.model.Mascota;
import com.ipartek.repository.MascotaRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class MenuController {

	@Autowired
	
	private MascotaRepository mascotaRepo;
	
	
	@RequestMapping("/menu_inicio")
	
	public String menu_inicio() {
		return "redirect:/"; 
	}
	
	@RequestMapping("/menu_perros")
	
	public String menu_perros(Model model) {
		
		List<Mascota> listaPerros=mascotaRepo.obtenerMascotasPorEspecie(1);
		for (Mascota mascota : listaPerros) {
			System.out.println(mascota);
		}
		
		model.addAttribute("atr_lista_mascotas", listaPerros);
		return "perros";
	}
	
	@RequestMapping("/menu_gatos")
	
	public String menu_gatos(Model model) {
		
		List<Mascota> listaGatos=mascotaRepo.obtenerMascotasPorEspecie(2);
		for (Mascota mascota : listaGatos) {
			System.out.println(mascota);
		}
		
		model.addAttribute("atr_lista_mascotas", listaGatos);
		return "gatos";
	}
	
	@RequestMapping("/menu_conejos")
	
	public String menu_conejos(Model model) {
		
		List<Mascota> listaConejos=mascotaRepo.obtenerMascotasPorEspecie(3);
		for (Mascota mascota : listaConejos) {
			System.out.println(mascota);
		}
		
		model.addAttribute("atr_lista_mascotas", listaConejos);
		return "conejos";
	}
	
	@RequestMapping("/menu_pajaros")
	
	public String menu_pajaros(Model model) {
		
		List<Mascota> listaPajaros =mascotaRepo.obtenerMascotasPorEspecie(4);
		for (Mascota mascota : listaPajaros) {
			System.out.println(mascota);
		}
		
		model.addAttribute("atr_lista_mascotas", listaPajaros);
		return "pajaros";
	}
		
	
	@RequestMapping("/menu_tortugas")
	
	public String menu_tortugas(Model model) {
		
		List<Mascota> listaTortugas =mascotaRepo.obtenerMascotasPorEspecie(5);
		for (Mascota mascota : listaTortugas) {
			System.out.println(mascota);
		}
		
		model.addAttribute("atr_lista_mascotas", listaTortugas);
		return "tortugas";
	}
	
	
	}
	
	
	
	

