package com.sample.user.controller;

import java.util.List;

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

import com.sample.user.entity.UserEntity;
import com.sample.user.model.ResponseModel;
import com.sample.user.model.UserModel;
import com.sample.user.service.UserManagementService;

/**
 * @author Sneha John Choondal
 *
 */
@RestController
@RequestMapping("/user")
public class UserManagementController {

	@Autowired
	UserManagementService userManagementService;

	/**
	 * method to create a user
	 * 
	 * @param userModel : user object details 
	 * @return
	 */
	@PostMapping("/addUser")
	public ResponseModel createUser(@RequestBody UserModel userModel) {
		return userManagementService.addUser(userModel);
	}

	/**
	 * method to list all users 
	 * @return
	 */
	@GetMapping("/listUsers")
	public List<UserEntity> getUsers() {
		return userManagementService.getUsers();
	}

	/**
	 *  method to update the user details
	 * @param id
	 * @param userModel
	 * @return
	 */
	@PutMapping("/updateUser/{id}")
	public ResponseModel updateUser(@PathVariable(value = "id") int id, @RequestBody UserModel userModel) {
		return userManagementService.updateUser(id,userModel);

	}

	/** method to delete the user details
	 * @param id
	 * @return
	 */
	@DeleteMapping("/deleteUser/{id}")
	public ResponseModel deleteUser(@PathVariable(value = "id") int id) {
		return userManagementService.deleteUser(id);
	}

	 /** method to login using email and password
	 * @param email
	 * @param password
	 * @return
	 */
	@GetMapping("/login")
	public ResponseModel login(@RequestParam String email, @RequestParam String password) {
		return userManagementService.validateUser(email, password);
	}
}
