package com.laboratory.controller;

import java.net.URI;
import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.laboratory.DTO.SubjectDTO;
import com.laboratory.exception.ModeloNotFoundException;
import com.laboratory.model.Laboratory;
import com.laboratory.model.School;
import com.laboratory.model.Subject;
import com.laboratory.service.ISubjectService;

@RestController
@RequestMapping("/subject")
public class SubjectController {

	@Autowired
	private ISubjectService service;

	// @PreAuthorize("@authServiceImpl.tieneAcceso('listar')")
	// @CrossOrigin(origins = "http://localhost:3000", allowedHeaders =
	// "Requestor-Type", exposedHeaders = "X-Get-Header")

	/*@GetMapping
	public ResponseEntity<List<SubjectDTO>> listar(@RequestParam Integer laboratory_id, @RequestParam Integer school_id)
			throws Exception {

		List<SubjectDTO> subjectsDto = new ArrayList();

		for (Subject i : service.listarSubject(laboratory_id, school_id)) {
			SubjectDTO subjectDTO = new SubjectDTO();
			subjectDTO.setId(i.getId());
			subjectDTO.setName(i.getName());
			subjectDTO.setDescription(i.getDescription());
			subjectDTO.setSchool(i.getSchool().getId());
			//subjectDTO.setLaboratory(i.getLaboratory().getLaboratory_id());
			subjectsDto.add(subjectDTO);
		}
		return new ResponseEntity<List<SubjectDTO>>(subjectsDto, HttpStatus.OK);
	}

	@GetMapping("/{subject_id}")
	public ResponseEntity<SubjectDTO> listarPorId(@PathVariable("subject_id") Integer subject_id) throws Exception {

		Subject subject = service.listarPorId(subject_id);

		if (subject != null) {
			SubjectDTO subjectDTO = new SubjectDTO();
			subjectDTO.setId(subject.getId());
			subjectDTO.setName(subject.getName());
			subjectDTO.setDescription(subject.getDescription());
			//subjectDTO.setLaboratory(subject.getLaboratory().getLaboratory_id());
			subjectDTO.setSchool(subject.getSchool().getId());
			return new ResponseEntity<SubjectDTO>(subjectDTO, HttpStatus.OK);
		} else {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + subject_id);
		}
	}

	// @PreAuthorize("@authServiceImpl.tieneAcceso('editar')")
	@PostMapping
	public ResponseEntity<SubjectDTO> registrar(@RequestBody SubjectDTO subjectDTO) throws Exception {

		Subject subject = new Subject();
		subject.setName(subjectDTO.getName());
		subject.setDescription(subjectDTO.getDescription());

		School school = new School();
		school.setId(subjectDTO.getSchool());

		Laboratory laboratory = new Laboratory();
		laboratory.setId(subjectDTO.getLaboratory());

		subject.setSchool(school);
		//subject.setLaboratory(laboratory);

		Subject obj = service.registrar(subject);
		// localhost:8080/pacientes/2
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(location).build();

	}

	// modificar
	// @PreAuthorize("@authServiceImpl.tieneAcceso('editar')")
	@PutMapping("/{subject_id}")
	public ResponseEntity<SubjectDTO> modificar(@RequestBody SubjectDTO subjectDTO, @PathVariable("subject_id") Integer subject_id)
			throws Exception {

		Subject subject = new Subject();
		subject.setId(subject_id);
		subject.setName(subjectDTO.getName());
		subject.setDescription(subjectDTO.getDescription());

		subjectDTO.setSchool(subject_id);
		School school = new School();
		school.setId(subjectDTO.getSchool());
		subject.setSchool(school);
		Laboratory laboratory = new Laboratory();
		laboratory.setId(subjectDTO.getLaboratory());
		//subject.setLaboratory(laboratory);
			
		service.modificar(subject);
		return new ResponseEntity<SubjectDTO>(subjectDTO, HttpStatus.OK);
	}

	// @PreAuthorize("@authServiceImpl.tieneAcceso('listar')")

	// eliminar
	// @PreAuthorize("@authServiceImpl.tieneAcceso('eliminar')")
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) throws Exception {
		Subject obj = service.listarPorId(id);
		if (obj == null) {
			throw new ModeloNotFoundException("ID NO FOUND: " + id);
		}
		service.eliminar(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}*/
	

	@GetMapping
	public ResponseEntity<List<Subject>> listar(@RequestParam Integer laboratory_id, @RequestParam Integer school_id)
			throws Exception {

		List<Subject> subjects = service.listarSubject(laboratory_id, school_id);	
		return new ResponseEntity<List<Subject>>(subjects, HttpStatus.OK);
	}

	@GetMapping("/{subject_id}")
	public ResponseEntity<Subject> listarPorId(@PathVariable("subject_id") Integer subject_id) throws Exception {

		Subject subject = service.listarPorId(subject_id);

		if (subject != null) {
			return new ResponseEntity<Subject>(subject, HttpStatus.OK);
		} else {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + subject_id);
		}
	}

	// @PreAuthorize("@authServiceImpl.tieneAcceso('editar')")
	@PostMapping
	public ResponseEntity<Subject> registrar(@RequestBody Subject subject) throws Exception {
		Subject obj = service.registrar(subject);
		// localhost:8080/pacientes/2
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(location).build();
	}

	// modificar
	// @PreAuthorize("@authServiceImpl.tieneAcceso('editar')")
	@PutMapping("/{subject_id}")
	public ResponseEntity<Subject> modificar(@RequestBody Subject subject, @PathVariable("subject_id") Integer subject_id)
			throws Exception {		
			
		Subject subjectObj=service.modificar(subject);
		return new ResponseEntity<Subject>(subjectObj, HttpStatus.OK);
	}

    // eliminar
	// @PreAuthorize("@authServiceImpl.tieneAcceso('eliminar')")
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) throws Exception {
		Subject obj = service.listarPorId(id);
		if (obj == null) {
			throw new ModeloNotFoundException("ID NO FOUND: " + id);
		}
		service.eliminar(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
