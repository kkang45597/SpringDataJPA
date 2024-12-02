package com.mingi.controller;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mingi.dto.NamesOnlyDTO;
import com.mingi.entity.Person;
import com.mingi.repository.PersonRepository.NamesOnly;
import com.mingi.repository.PersonRepository.PersonSummary;
import com.mingi.service.PersonService;

@RestController
@RequestMapping("/person")
public class PersonController {
	
	@Autowired
	private PersonService personService;
	
	// person 생성
	@PostMapping
	public Person createPerson(@RequestBody Person person) {
		Person personCreate = new Person(person.getFirstname(),
				person.getLastname(), person.getAddress());
		return personService.save(personCreate);
	}
	
	// 모든 perosn 검색
	@GetMapping
	public List<Person> searchAllPerson() {
		return (List<Person>) personService.findAll();
	}
	
	// id로 person 검색
	@GetMapping("/search/id")
	public Person serachPersonByID(@RequestParam UUID id) {
		return personService.findById(id);
		
	}
	
	// 업데이트
	@PutMapping("/update")
	public void updatePerson(@RequestBody Person person) {
		Person personUpdate = new Person(person.getFirstname(), 
				person.getLastname(), 
				person.getAddress());
		personService.update(personUpdate);
	}
	
	// id로 person 삭제
	@DeleteMapping("/delete/{id}")
	public void deletePersonByID(@PathVariable UUID id) {
		personService.deleteById(id);
	}
	
	// 성으로 person 검색
	@GetMapping("/search/lastname")
	public Collection<NamesOnly> searchPersonByLastName(@RequestParam String lastname) {
		return personService.findByLastname(lastname);
	}
	
	// 이름으로 person 검색
	@GetMapping("/search/firstname")
	public Collection<PersonSummary> searchPersonByFirstName(@RequestParam String firstname) {
		return personService.findByFirstname(firstname);
	}
	
	// 성에 특정 글자가 들어가는 person 검색
	@GetMapping("/search/lastname/prefix")
	public Collection<NamesOnlyDTO> searchPersonByLastNameprefix(@RequestParam String lastname) {
		return personService.findByLastnameStartingWith(lastname);
	}
	
	// 성으로 person을 검색하고 반환 받을 형식을 지정한다. "type: com.mingi.dto.NamesOnlyDTO"
	@GetMapping("/search/lastname/dynamic")
	public Collection<?> searchPersonByLastNameDynamic(@RequestParam String lastname, Class<?> type) {
		return personService.findByLastname(lastname, type);
	}

}
