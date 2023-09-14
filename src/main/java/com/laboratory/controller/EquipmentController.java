package com.laboratory.controller;

import java.net.URI;
import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
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
import com.laboratory.model.Equipment;
import com.laboratory.service.ILaboratoryEquipmentService;

@RestController
@RequestMapping("/equipment")
public class EquipmentController {

	@Autowired
	private ILaboratoryEquipmentService service;

	//Listar todos los equipos por laboratorio
	//@PreAuthorize("@authServiceImpl.tieneAcceso('listar')")	
	@GetMapping("/listbylaboratory/{idLaboratory}")
	public ResponseEntity<List<Equipment>> listbyfaculty(@PathVariable("idLaboratory") Integer idLaboratory) throws Exception {
		List<Equipment> LaboratoryEquipments = new ArrayList<>();
		System.out.print(idLaboratory);
		LaboratoryEquipments = service.listbylaboratory(idLaboratory);
		return new ResponseEntity<List<Equipment>>(LaboratoryEquipments, HttpStatus.OK);
	}
	
	//@PreAuthorize("@authServiceImpl.tieneAcceso('editar')")
	@PostMapping
	public ResponseEntity<Equipment> registrar(@RequestBody Equipment c) throws Exception {

		Equipment obj = service.registrar(c);

		// localhost:8080/pacientes/2
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{idLaboratoryEquipment}")
				.buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(location).build();
	}

	// modificar
	//@PreAuthorize("@authServiceImpl.tieneAcceso('editar')")
	@PutMapping
	public ResponseEntity<Equipment> modificar(@RequestBody Equipment c) throws Exception {

		Equipment obj = service.modificar(c);
		return new ResponseEntity<Equipment>(obj, HttpStatus.OK);
	}
	
	//@PreAuthorize("@authServiceImpl.tieneAcceso('listar')")
	@GetMapping("/{idLaboratoryEquipment}")
	public ResponseEntity<Equipment> listarPorId(@PathVariable("idLaboratoryEquipment") Integer idLaboratoryEquipment) throws Exception {
		Equipment obj = service.listarPorId(idLaboratoryEquipment);

		if (obj == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + idLaboratoryEquipment);
		}
		return new ResponseEntity<Equipment>(obj, HttpStatus.OK);
	}

	// eliminar
	//@PreAuthorize("@authServiceImpl.tieneAcceso('eliminar')")
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable("idSubmenu") Integer id) throws Exception {
		Equipment obj = service.listarPorId(id);
		if (obj == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO" + id);
		}
		service.eliminar(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
