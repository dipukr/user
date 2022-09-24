package com.user;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/test")
	public Map<String, Integer> testHandler() throws Exception {
		var map = new HashMap<String, Integer>();
		map.put("India", 100);
		map.put("Pakistan", 200);
		map.put("England", 300);
		return map;
	}
	
	@GetMapping("/users")
	public Set<User> getAllUsers() throws Exception {
		List<User> users = userRepository.findAll();
		Set<User> set = new HashSet<>();
		set.addAll(users);
		return set;
	}
	
	@PostMapping("/users/add")
	public ResponseEntity<String> addUser(@RequestBody User user) {
		userRepository.save(user);
		log.info("User record is saved");
		return ResponseEntity.ok()
				.body("Data added successfully");
	}
	
	@PostMapping("/users/adds")
	public ResponseEntity<String> addUsers(@RequestBody List<User> users) {
		users.forEach(userRepository::save);
		return ResponseEntity.ok("Data(s) added successfully");
	}
}
