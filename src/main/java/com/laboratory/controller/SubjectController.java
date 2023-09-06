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

	@GetMapping
	public ResponseEntity<List<SubjectDTO>> listar() throws Exception {

		List<SubjectDTO> subjectsDto = new ArrayList();

		for (Subject i : service.listar()) {
			SubjectDTO subjectDTO = new SubjectDTO();
			subjectDTO.setName(i.getName());
			subjectDTO.setDescription(i.getDescription());
			subjectDTO.setSchool(i.getSchool().getSchool_id());
			subjectDTO.setLaboratory(i.getLaboratory().getIdLaboratory());
			subjectsDto.add(subjectDTO);
		}

		return new ResponseEntity<List<SubjectDTO>>(subjectsDto, HttpStatus.OK);
	}

	// @PreAuthorize("@authServiceImpl.tieneAcceso('editar')")
	@PostMapping
	public ResponseEntity<SubjectDTO> registrar(@RequestBody SubjectDTO subjectDTO) throws Exception {

		Subject subject = new Subject();
		subject.setName(subjectDTO.getName());
		subject.setDescription(subjectDTO.getDescription());

		School school = new School();
		school.setSchool_id(subjectDTO.getSchool());

		Laboratory laboratory = new Laboratory();
		laboratory.setIdLaboratory(subjectDTO.getLaboratory());

		subject.setSchool(school);
		subject.setLaboratory(laboratory);

		Subject obj = service.registrar(subject);
		// localhost:8080/pacientes/2
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getSubject_id()).toUri();
		return ResponseEntity.created(location).build();
		// return new ResponseEntity<FacultyDTO>(HttpStatus.OK);
	}

	// modificar
	// @PreAuthorize("@authServiceImpl.tieneAcceso('editar')")
	@PutMapping("/{id}")
	public ResponseEntity<SubjectDTO> modificar(@RequestBody SubjectDTO subjectDTO, @PathVariable("id") Integer id)
			throws Exception {

		Subject subject = new Subject();
		subject.setSubject_id(id);
		subject.setName(subjectDTO.getName());
		subject.setDescription(subjectDTO.getDescription());

		subjectDTO.setSchool(id);
		School school = new School();
		school.setSchool_id(subjectDTO.getSchool());
		Laboratory laboratory = new Laboratory();
		laboratory.setIdLaboratory(subjectDTO.getLaboratory());

		service.modificar(subject);
		return new ResponseEntity<SubjectDTO>(subjectDTO, HttpStatus.OK);
	}

	// @PreAuthorize("@authServiceImpl.tieneAcceso('listar')")
	/*
	 * @GetMapping("/{id}") public ResponseEntity<FacultyDTO>
	 * listarPorId(@PathVariable("id") Integer id) throws Exception {
	 * 
	 * School faculty = service.listarPorId(id);
	 * 
	 * if (faculty != null && faculty.getUniversity() != null) { FacultyDTO
	 * facultyDTO = new FacultyDTO(); facultyDTO.setId(faculty.getFaculty_id());
	 * facultyDTO.setName(faculty.getName());
	 * facultyDTO.setUniversity(faculty.getUniversity().getUniversity_id()); return
	 * new ResponseEntity<FacultyDTO>(facultyDTO, HttpStatus.OK); } else { throw new
	 * ModeloNotFoundException("ID NO ENCONTRADO " + id); } }
	 */

	// eliminar
	// @PreAuthorize("@authServiceImpl.tieneAcceso('eliminar')")
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) throws Exception {
		Subject obj = service.listarPorId(id);
		if (obj == null) {
			throw new ModeloNotFoundException("ID NO FOUND" + id);
		}
		service.eliminar(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
