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
import com.laboratory.model.Reservation;
import com.laboratory.service.IReservationService;


@RestController
@RequestMapping("/reservation")
public class ReservationController {

	@Autowired
	private IReservationService service;

	@PreAuthorize("@authServiceImpl.tieneAcceso('listar')")
	@GetMapping
	public ResponseEntity<List<Reservation>> listar() throws Exception {
		List<Reservation> Reservations = new ArrayList<>();
		Reservations = service.listar();
		return new ResponseEntity<List<Reservation>>(Reservations, HttpStatus.OK);
	}
	
	/*@PreAuthorize("@authServiceImpl.tieneAcceso('listar')")
	@GetMapping("/listbyfaculty/{idFaculty}")
	public ResponseEntity<List<Reservation>> listbyfaculty(@PathVariable("idFaculty") Integer idFaculty) throws Exception {
		List<Reservation> Reservations = new ArrayList<>();
		System.out.print(idFaculty);
		Reservations = service.listarPorId(idFaculty);
		return new ResponseEntity<List<Reservation>>(Reservations, HttpStatus.OK);
	}*/
	
	@PreAuthorize("@authServiceImpl.tieneAcceso('editar')")
	@PostMapping
	public ResponseEntity<Reservation> registrar(@RequestBody Reservation c) throws Exception {

		Reservation obj = service.registrar(c);

		// localhost:8080/pacientes/2
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{idReservation}")
				.buildAndExpand(obj.getIdReservation()).toUri();
		return ResponseEntity.created(location).build();
	}

	// modificar
	@PreAuthorize("@authServiceImpl.tieneAcceso('editar')")
	@PutMapping
	public ResponseEntity<Reservation> modificar(@RequestBody Reservation c) throws Exception {

		Reservation obj = service.modificar(c);
		return new ResponseEntity<Reservation>(obj, HttpStatus.OK);
	}
	
	@PreAuthorize("@authServiceImpl.tieneAcceso('listar')")
	@GetMapping("/{idReservation}")
	public ResponseEntity<Reservation> listarPorId(@PathVariable("idReservation") Integer idReservation) throws Exception {
		Reservation obj = service.listarPorId(idReservation);

		if (obj == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + idReservation);
		}
		return new ResponseEntity<Reservation>(obj, HttpStatus.OK);
	}

	// eliminar
	@PreAuthorize("@authServiceImpl.tieneAcceso('eliminar')")
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable("idSubmenu") Integer id) throws Exception {
		Reservation obj = service.listarPorId(id);
		if (obj == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO" + id);
		}
		service.eliminar(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
