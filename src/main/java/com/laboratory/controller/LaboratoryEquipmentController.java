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
import com.laboratory.model.LaboratoryEquipment;
import com.laboratory.service.ILaboratoryEquipmentService;

@RestController
@RequestMapping("/equipment")
public class LaboratoryEquipmentController {

	@Autowired
	private ILaboratoryEquipmentService service;

	@PreAuthorize("@authServiceImpl.tieneAcceso('listar')")
	@GetMapping
	public ResponseEntity<List<LaboratoryEquipment>> listar() throws Exception {
		List<LaboratoryEquipment> LaboratoryEquipments = new ArrayList<>();
		LaboratoryEquipments = service.listar();
		return new ResponseEntity<List<LaboratoryEquipment>>(LaboratoryEquipments, HttpStatus.OK);
	}
	
	@PreAuthorize("@authServiceImpl.tieneAcceso('listar')")
	@GetMapping("/listbylaboratory/{idLaboratory}")
	public ResponseEntity<List<LaboratoryEquipment>> listbyfaculty(@PathVariable("idLaboratory") Integer idLaboratory) throws Exception {
		List<LaboratoryEquipment> LaboratoryEquipments = new ArrayList<>();
		System.out.print(idLaboratory);
		LaboratoryEquipments = service.listbylaboratory(idLaboratory);
		return new ResponseEntity<List<LaboratoryEquipment>>(LaboratoryEquipments, HttpStatus.OK);
	}
	
	@PreAuthorize("@authServiceImpl.tieneAcceso('editar')")
	@PostMapping
	public ResponseEntity<LaboratoryEquipment> registrar(@RequestBody LaboratoryEquipment c) throws Exception {

		LaboratoryEquipment obj = service.registrar(c);

		// localhost:8080/pacientes/2
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{idLaboratoryEquipment}")
				.buildAndExpand(obj.getIdEquipment()).toUri();
		return ResponseEntity.created(location).build();
	}

	// modificar
	@PreAuthorize("@authServiceImpl.tieneAcceso('editar')")
	@PutMapping
	public ResponseEntity<LaboratoryEquipment> modificar(@RequestBody LaboratoryEquipment c) throws Exception {

		LaboratoryEquipment obj = service.modificar(c);
		return new ResponseEntity<LaboratoryEquipment>(obj, HttpStatus.OK);
	}
	
	@PreAuthorize("@authServiceImpl.tieneAcceso('listar')")
	@GetMapping("/{idLaboratoryEquipment}")
	public ResponseEntity<LaboratoryEquipment> listarPorId(@PathVariable("idLaboratoryEquipment") Integer idLaboratoryEquipment) throws Exception {
		LaboratoryEquipment obj = service.listarPorId(idLaboratoryEquipment);

		if (obj == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + idLaboratoryEquipment);
		}
		return new ResponseEntity<LaboratoryEquipment>(obj, HttpStatus.OK);
	}

	// eliminar
	@PreAuthorize("@authServiceImpl.tieneAcceso('eliminar')")
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable("idSubmenu") Integer id) throws Exception {
		LaboratoryEquipment obj = service.listarPorId(id);
		if (obj == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO" + id);
		}
		service.eliminar(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
