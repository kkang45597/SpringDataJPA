package com.mingi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mingi.dto.UserDTO;
import com.mingi.entity.User;
import com.mingi.service.UserService;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
    private UserService userService;

    @PostMapping
    public UserDTO createUser(@RequestBody UserDTO userDTO) {
        User user = new User(userDTO.getFirstname(), 
        		userDTO.getLastname(),
        		userDTO.getAge(),
        		userDTO.getActive());
        return userService.saveUser(user);
        
    }

    // 모든 유저 조회
    @GetMapping
    public List<UserDTO> getAllUsers() {
        return userService.findAll();
    }

    /*
    // 유저 조회 by ID : /users/by-id?id=1
    @GetMapping("/by-id")
    public UserDTO getUserById(@RequestParam Long id) {
        return userService.findById(id);
    }
    

    // 특정 성을 가진 유저 수 카운트
    @GetMapping("/count/{lastname}")
    public long countUsersByLastname(@PathVariable String lastname) {
        return userService.countByLastname(lastname);
    }

    // 특정 email을 가진 유저 삭제
    @DeleteMapping("/delete/{email}")
    public long deleteUsersByLastname(@PathVariable String email) {
        return userService.deleteByEmail(email);
    }

    // 특정 email을 가진 유저 삭제 후 목록 반환
    @DeleteMapping("/remove/{email}")
    public List<UserDTO> removeUsersByEmail(@PathVariable String email) {
        return userService.removeByEmail(email);
    }

    // 유저 업데이트
    @PutMapping("/{id}")
    public void updateUser(@RequestBody UserDTO userDTO) {
        userService.updateUser(userDTO.getFirstname(), 
        		userDTO.getLastname(),
        		userDTO.getAge(),
        		userDTO.getActive());
    }
    
    // FirstName이 특정 prefix로 시작하는 유저 조회
    @GetMapping("/search/firstname")
    public List<UserDTO> getUsersByFirstNameStartingWith(@RequestParam String prefix) {
        return userService.findByFirstNameStartingWith(prefix);
    }

    // LastName이 특정 문자열을 포함하는 유저 조회
    @GetMapping("/search/lastname")
    public List<UserDTO> getUsersByLastNameContaining(@RequestParam String substring) {
        return userService.findByLastNameContaining(substring);
    }

    // Email에 특정 문자열이 없는 유저 조회
    @GetMapping("/search/email-not-containing")
    public List<UserDTO> getUsersByEmailNotContaining(@RequestParam String substring) {
        return userService.findByEmailNotContaining(substring);
    }
    
    // 이메일과 성으로 사용자 검색
    @GetMapping("/search")
    public ResponseEntity<List<UserDTO>> searchUsers(@RequestParam String emailAddress, @RequestParam String lastname) {
        List<UserDTO> users = userService.findByEmailAndLastname(emailAddress, lastname);
        return ResponseEntity.ok(users);
    }

    // 성 또는 이름으로 중복 제거된 사용자 검색
    @GetMapping("/distinct")
    public ResponseEntity<List<UserDTO>> findDistinctUsers(@RequestParam String lastname, @RequestParam String firstname) {
        List<UserDTO> users = userService.findDistinctPeopleByLastnameOrFirstname(lastname, firstname);
        return ResponseEntity.ok(users);
    }

    // 성을 기준으로 대소문자를 무시하고 사용자 검색
    @GetMapping("/lastname/ignore-case")
    public ResponseEntity<List<UserDTO>> findByLastnameIgnoreCase(@RequestParam String lastname) {
        List<UserDTO> users = userService.findByLastnameIgnoreCase(lastname);
        return ResponseEntity.ok(users);
    }

    // 성과 이름을 기준으로 대소문자를 무시하고 사용자 검색
    @GetMapping("/fullname/ignore-case")
    public ResponseEntity<List<UserDTO>> findByLastnameAndFirstnameIgnoreCase(@RequestParam String lastname, @RequestParam String firstname) {
        List<UserDTO> users = userService.findByLastnameAndFirstnameAllIgnoreCase(lastname, firstname);
        return ResponseEntity.ok(users);
    }

    // 성을 기준으로 이름을 오름차순으로 정렬하여 사용자 검색
    @GetMapping("/lastname/asc")
    public ResponseEntity<List<UserDTO>> findByLastnameOrderByFirstnameAsc(@RequestParam String lastname) {
        List<UserDTO> users = userService.findByLastnameOrderByFirstnameAsc(lastname);
        return ResponseEntity.ok(users);
    }

    // 성을 기준으로 이름을 내림차순으로 정렬하여 사용자 검색
    @GetMapping("/lastname/desc")
    public ResponseEntity<List<UserDTO>> findByLastnameOrderByFirstnameDesc(@RequestParam String lastname) {
        List<UserDTO> users = userService.findByLastnameOrderByFirstnameDesc(lastname);
        return ResponseEntity.ok(users);
    }
    
    // 특정 범위 내의 사용자 검색
    // Key: startDate, Value: 2024-01-01T00:00:00 (예시, 원하는 시작 날짜로 변경 가능)
    // Key: endDate, Value: 2024-12-31T23:59:59 (예시, 원하는 종료 날짜로 변경 가능)
    @GetMapping("/creation-date/between")
    public ResponseEntity<List<UserDTO>> getUsersByCreationDateBetween(@RequestParam String startDate, @RequestParam String endDate) {
        LocalDateTime start = LocalDateTime.parse(startDate);
        LocalDateTime end = LocalDateTime.parse(endDate);
        List<UserDTO> users = userService.findUsersByCreationDateBetween(start, end);
        return ResponseEntity.ok(users);
    }

    // 특정 날짜 이전의 사용자 검색
    @GetMapping("/creation-date/less-than")
    public ResponseEntity<List<UserDTO>> getUsersByCreationDateLessThan(@RequestParam String date) {
    	LocalDateTime localDate = LocalDateTime.parse(date);
        List<UserDTO> users = userService.findUsersByCreationDateLessThan(localDate);
        return ResponseEntity.ok(users);
    }

    // 이메일에 특정 문자열이 포함된 사용자 검색
    @GetMapping("/email/contains")
    public ResponseEntity<List<UserDTO>> getUsersByEmailContaining(@RequestParam String keyword) {
        List<UserDTO> users = userService.findUsersByEmailContaining(keyword);
        return ResponseEntity.ok(users);
    }
    
    ////////////////////////////////////////////////////////////////////////////////////////////////////
    @GetMapping("lastname/findLimit")
    public ResponseEntity<List<UserDTO>> findByLastnameThroughSortedAndLimited(@RequestParam String lastname,
    		Sort sort, int limit) {
    	List<UserDTO> users = userService.findByLastnameThroughSortedAndLimited(lastname, sort, limit);
		return (ResponseEntity<List<UserDTO>>) users;
    }
    */
}