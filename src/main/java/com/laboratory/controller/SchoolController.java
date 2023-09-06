package com.laboratory.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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

import com.laboratory.DTO.SchoolDTO;
import com.laboratory.exception.ModeloNotFoundException;
import com.laboratory.model.School;
import com.laboratory.model.Laboratory;
import com.laboratory.model.University;
import com.laboratory.service.ISchoolService;


@RestController
@RequestMapping("/school")
public class SchoolController {

	@Autowired
	private ISchoolService service;

	//@PreAuthorize("@authServiceImpl.tieneAcceso('listar')")
	//@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "Requestor-Type", exposedHeaders = "X-Get-Header")
	@GetMapping
	public ResponseEntity<List<SchoolDTO>> listar() throws Exception {		
		
		List<SchoolDTO> facultysDto = new ArrayList<>();		
			
		for(School i:service.listar()) {
			SchoolDTO facultyDTO = new SchoolDTO();
			facultyDTO.setSchool_id(i.getSchool_id());
			facultyDTO.setName(i.getName());
			facultyDTO.setUniversity(i.getUniversity().getUniversity_id());
			facultysDto.add(facultyDTO);
		}

		return new ResponseEntity<List<SchoolDTO>>(facultysDto, HttpStatus.OK);
	}
	
	/*@GetMapping
	public ResponseEntity<List<SchoolDTO>> listar() throws Exception {
		List<SchoolDTO> schools = new ArrayList<>();
		schools = service.listarSchool();
		return new ResponseEntity<List<SchoolDTO>>(schools, HttpStatus.OK);
	}*/
	
	//@PreAuthorize("@authServiceImpl.tieneAcceso('editar')")
	@PostMapping
	public ResponseEntity<SchoolDTO> registrar(@RequestBody SchoolDTO facultyDTO) throws Exception {
	
		School faculty = new School();		
		faculty.setSchool_id(facultyDTO.getSchool_id());
		faculty.setName(facultyDTO.getName());		
		University university = new University();
		university.setUniversity_id(facultyDTO.getUniversity());		
		faculty.setUniversity(university);
		School obj = service.registrar(faculty);		
		// localhost:8080/pacientes/2
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getSchool_id()).toUri();		
		return ResponseEntity.created(location).build();
		//return new ResponseEntity<FacultyDTO>(HttpStatus.OK);
	}

	// modificar
	//@PreAuthorize("@authServiceImpl.tieneAcceso('editar')")
	@PutMapping("/{id}")
	public ResponseEntity<SchoolDTO> modificar(@RequestBody SchoolDTO facultyDTO, @PathVariable("id") Integer id) throws Exception {
		
		School school = new School();		
		school.setSchool_id(id);
		facultyDTO.setSchool_id(id);
		
		school.setName(facultyDTO.getName());
		
		University university = new University();
		university.setUniversity_id(facultyDTO.getUniversity());
		
		school.setUniversity(university);
		
		service.modificar(school);
		return new ResponseEntity<SchoolDTO>(facultyDTO,HttpStatus.OK);
	}
	
	//@PreAuthorize("@authServiceImpl.tieneAcceso('listar')")
	@GetMapping("/{id}")
	public ResponseEntity<SchoolDTO> listarPorId(@PathVariable("id") Integer id) throws Exception {
		
		School faculty = service.listarPorId(id);		
				
		if(faculty!=null && faculty.getUniversity()!=null) {
			SchoolDTO facultyDTO = new SchoolDTO();
			facultyDTO.setSchool_id(faculty.getSchool_id());
			facultyDTO.setName(faculty.getName());
			facultyDTO.setUniversity(faculty.getUniversity().getUniversity_id());
			return new ResponseEntity<SchoolDTO>(facultyDTO, HttpStatus.OK);
		}else {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);					
		}
	}

	// eliminar
	//@PreAuthorize("@authServiceImpl.tieneAcceso('eliminar')")
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) throws Exception {
		School obj = service.listarPorId(id);
		if (obj == null) {
			throw new ModeloNotFoundException("ID NO FOUND" + id);
		}
		service.eliminar(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
