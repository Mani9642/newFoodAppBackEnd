package com.cigniti.foodApp.controller;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cigniti.foodApp.entity.User;
import com.cigniti.foodApp.service.UserService;


@CrossOrigin(origins = "http://localhost:3000")
@RestController

@RequestMapping("/users")
public class UserController {
	
	

	@Autowired
	UserService userService;

	

	@GetMapping("/list")
	public List<User> getAllUsers() {
		List<User> users = userService.findAll();

		Iterator<User> it = users.iterator();
		while (it.hasNext()) {
			if (it.next().getStatus().equals("inactive")) {
				it.remove();
			}
		}
		return users;

	}

	@PostMapping("/save")
	public User saveUser(@RequestBody User user) {

		user.setStatus("active");
		userService.save(user);

		return user;
	}

	@PutMapping("/edit")
	public User updateUser(@RequestBody User user) {
		userService.save(user);

		return user;
	}

	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable int id) {

		User user = userService.findByUserId(id);
		if (user == null) {
			throw new RuntimeException("UserId not found " + id);
		}

		userService.deleteByUserId(id);
		return "Deleted UserId :" + id;
	}

}

/*
 * @GetMapping("/loginPage") public String loginPage() { return
 * "/employees/loginPage"; }
 */

/*
 * @GetMapping("/showFormForAdd") public String showFormForAdd(Model model) {
 * 
 * Employee employee = new Employee(); model.addAttribute("EMPLOYEE", employee);
 * 
 * return "employees/empForm";}
 * 
 * @GetMapping("/showFormForUpdate") public String
 * showFormForUpdate(@RequestParam("employeeId") int id, Model model) { Employee
 * employee = empService.findByEmpId(id); model.addAttribute("EMPLOYEE",
 * employee); return "employees/empForm"; }
 */
