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
import com.laboratory.model.Faculty;
import com.laboratory.service.IFacultyService;


@RestController
@RequestMapping("/faculty")
public class FacultyController {

	@Autowired
	private IFacultyService service;

	@PreAuthorize("@authServiceImpl.tieneAcceso('listar')")
	@GetMapping
	public ResponseEntity<List<Faculty>> listar() throws Exception {
		List<Faculty> Facultys = new ArrayList<>();
		Facultys = service.listar();
		return new ResponseEntity<List<Faculty>>(Facultys, HttpStatus.OK);
	}
	
	@PreAuthorize("@authServiceImpl.tieneAcceso('editar')")
	@PostMapping
	public ResponseEntity<Faculty> registrar(@RequestBody Faculty c) throws Exception {

		Faculty obj = service.registrar(c);

		// localhost:8080/pacientes/2
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{idFaculty}")
				.buildAndExpand(obj.getIdFaculty()).toUri();
		return ResponseEntity.created(location).build();
	}

	// modificar
	@PreAuthorize("@authServiceImpl.tieneAcceso('editar')")
	@PutMapping
	public ResponseEntity<Faculty> modificar(@RequestBody Faculty c) throws Exception {

		Faculty obj = service.modificar(c);
		return new ResponseEntity<Faculty>(obj, HttpStatus.OK);
	}
	
	@PreAuthorize("@authServiceImpl.tieneAcceso('listar')")
	@GetMapping("/{idFaculty}")
	public ResponseEntity<Faculty> listarPorId(@PathVariable("idFaculty") Integer idFaculty) throws Exception {
		Faculty obj = service.listarPorId(idFaculty);

		if (obj == null) {
			throw new ModeloNotFoundException("ID NO FOUND" + idFaculty);
		}
		return new ResponseEntity<Faculty>(obj, HttpStatus.OK);
	}

	// eliminar
	@PreAuthorize("@authServiceImpl.tieneAcceso('eliminar')")
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable("idSubmenu") Integer id) throws Exception {
		Faculty obj = service.listarPorId(id);
		if (obj == null) {
			throw new ModeloNotFoundException("ID NO FOUND" + id);
		}
		service.eliminar(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
