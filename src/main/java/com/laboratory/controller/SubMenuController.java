package com.laboratory.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.laboratory.exception.ModeloNotFoundException;
import com.laboratory.model.Submenu;
import com.laboratory.service.ISubMenuService;

@RestController
@RequestMapping("/submenu")
public class SubMenuController {

	@Autowired
	private ISubMenuService service;

	@GetMapping
	public ResponseEntity<List<Submenu>> listar() throws Exception {
		List<Submenu> submenus = new ArrayList<>();
		submenus = service.listar();
		return new ResponseEntity<List<Submenu>>(submenus, HttpStatus.OK);
	}

	@PreAuthorize("@authServiceImpl.tieneAcceso('listarId')")
	@GetMapping("/{idSubmenu}")
	public ResponseEntity<Submenu> listarPorId(@PathVariable("idSubmenu") Integer idSubmenu) throws Exception {
		Submenu obj = service.listarPorId(idSubmenu);

		if (obj == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + idSubmenu);
		}
		return new ResponseEntity<Submenu>(obj, HttpStatus.OK);
	}

	@GetMapping("/listado/{nombre}/{idMenu}")
	public ResponseEntity<List<Submenu>> listarSubmenuporUsuario(@PathVariable("nombre") String nombre,
			@PathVariable("idMenu") Integer idMenu) throws Exception {
		System.out.print(nombre + idMenu);
		List<Submenu> submenu = new ArrayList<>();

		submenu = service.listarSubmenuPorUsuario(nombre, idMenu);

		if (submenu == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + idMenu);
		}
		return new ResponseEntity<List<Submenu>>(submenu, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Submenu> registrar(@RequestBody Submenu c) throws Exception {

		Submenu obj = service.registrar(c);
		// localhost:8080/pacientes/2
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{idSubmenu}")
				.buildAndExpand(obj.getIdSubmenu()).toUri();
		return ResponseEntity.created(location).build();
	}

	// modificar
	@PutMapping
	public ResponseEntity<Submenu> modificar(@RequestBody Submenu c) throws Exception {
		Submenu obj = service.modificar(c);
		return new ResponseEntity<Submenu>(obj, HttpStatus.OK);
	}

	// eliminar
	@PreAuthorize("@authServiceImpl.tieneAcceso('eliminar')")
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable("idSubmenu") Integer id) throws Exception {
		Submenu obj = service.listarPorId(id);
		if (obj == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO" + id);
		}
		service.eliminar(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
