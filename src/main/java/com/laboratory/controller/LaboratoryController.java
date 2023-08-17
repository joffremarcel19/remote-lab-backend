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
import com.laboratory.model.Laboratory;
import com.laboratory.model.Submenu;
import com.laboratory.service.ILaboratoryService;

@RestController
@RequestMapping("/laboratory")
public class LaboratoryController {

	@Autowired
	private ILaboratoryService service;

	@PreAuthorize("@authServiceImpl.tieneAcceso('listar')")
	@GetMapping
	public ResponseEntity<List<Laboratory>> listar() throws Exception {
		List<Laboratory> laboratorys = new ArrayList<>();
		laboratorys = service.listar();
		return new ResponseEntity<List<Laboratory>>(laboratorys, HttpStatus.OK);
	}
	
	@PreAuthorize("@authServiceImpl.tieneAcceso('listar')")
	@GetMapping("/listbyfaculty/{idFaculty}")
	public ResponseEntity<List<Laboratory>> listbyfaculty(@PathVariable("idFaculty") Integer idFaculty) throws Exception {
		List<Laboratory> laboratorys = new ArrayList<>();
		System.out.print(idFaculty);
		laboratorys = service.listbyfaculty(idFaculty);
		return new ResponseEntity<List<Laboratory>>(laboratorys, HttpStatus.OK);
	}
	
	@PreAuthorize("@authServiceImpl.tieneAcceso('editar')")
	@PostMapping
	public ResponseEntity<Laboratory> registrar(@RequestBody Laboratory c) throws Exception {

		Laboratory obj = service.registrar(c);

		// localhost:8080/pacientes/2
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{idLaboratory}")
				.buildAndExpand(obj.getIdLaboratory()).toUri();
		return ResponseEntity.created(location).build();
	}

	// modificar
	@PreAuthorize("@authServiceImpl.tieneAcceso('editar')")
	@PutMapping
	public ResponseEntity<Laboratory> modificar(@RequestBody Laboratory c) throws Exception {

		Laboratory obj = service.modificar(c);
		return new ResponseEntity<Laboratory>(obj, HttpStatus.OK);
	}
	
	@PreAuthorize("@authServiceImpl.tieneAcceso('listar')")
	@GetMapping("/{idLaboratory}")
	public ResponseEntity<Laboratory> listarPorId(@PathVariable("idLaboratory") Integer idLaboratory) throws Exception {
		Laboratory obj = service.listarPorId(idLaboratory);

		if (obj == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + idLaboratory);
		}
		return new ResponseEntity<Laboratory>(obj, HttpStatus.OK);
	}

	// eliminar
	@PreAuthorize("@authServiceImpl.tieneAcceso('eliminar')")
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable("idSubmenu") Integer id) throws Exception {
		Laboratory obj = service.listarPorId(id);
		if (obj == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO" + id);
		}
		service.eliminar(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
