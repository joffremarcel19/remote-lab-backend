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
import com.laboratory.model.ScheduleTemplate;
import com.laboratory.service.IScheduleTemplateService;

@RestController
@RequestMapping("/scheduletemplate")
public class ScheduleTemplateController {

	@Autowired
	private IScheduleTemplateService service;

	// Listar todos los equipos por laboratorio
	// @PreAuthorize("@authServiceImpl.tieneAcceso('listar')")
	@GetMapping("/listbyequipment/{idEquipment}")
	public ResponseEntity<List<ScheduleTemplate>> listbyfaculty(@PathVariable("idEquipment") Integer idEquipment)
			throws Exception {
		List<ScheduleTemplate> ScheduleTemplates = new ArrayList<>();
		ScheduleTemplates = service.listbyequipment(idEquipment);
		return new ResponseEntity<List<ScheduleTemplate>>(ScheduleTemplates, HttpStatus.OK);
	}

	// @PreAuthorize("@authServiceImpl.tieneAcceso('listar')")
	@GetMapping("/{idScheduleTemplate}")
	public ResponseEntity<ScheduleTemplate> listarPorId(@PathVariable("idScheduleTemplate") Integer idScheduleTemplate)
			throws Exception {
		ScheduleTemplate obj = service.listarPorId(idScheduleTemplate);

		if (obj == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + idScheduleTemplate);
		}
		return new ResponseEntity<ScheduleTemplate>(obj, HttpStatus.OK);
	}

	// @PreAuthorize("@authServiceImpl.tieneAcceso('editar')")
	@PostMapping
	public ResponseEntity<ScheduleTemplate> registrar(@RequestBody ScheduleTemplate c) throws Exception {

		ScheduleTemplate obj = service.registrar(c);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{idScheduleTemplate}")
				.buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(location).build();
	}

	// modificar
	// @PreAuthorize("@authServiceImpl.tieneAcceso('editar')")
	@PutMapping
	public ResponseEntity<ScheduleTemplate> modificar(@RequestBody ScheduleTemplate c) throws Exception {

		ScheduleTemplate obj = service.modificar(c);
		return new ResponseEntity<ScheduleTemplate>(obj, HttpStatus.OK);
	}

	// eliminar
	// @PreAuthorize("@authServiceImpl.tieneAcceso('eliminar')")
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable("idSubmenu") Integer id) throws Exception {
		ScheduleTemplate obj = service.listarPorId(id);
		if (obj == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO" + id);
		}
		service.eliminar(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
