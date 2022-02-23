package com.sample.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.user.entity.UserEntity;
import com.sample.user.model.ResponseModel;
import com.sample.user.model.UserModel;
import com.sample.user.repository.UserManagementRepository;

@Service
public class UserManagementService {

	@Autowired
	UserManagementRepository userManagementRepository;

	/**
	 * Method to list all the users
	 * 
	 * @return
	 */
	public List<UserEntity> getUsers() {
		return userManagementRepository.findAll();
	}

	/**
	 * Method to add user details to db. Since email should be unique, the same
	 * email id is not added again
	 * 
	 * @param userModel
	 * @return
	 */
	public ResponseModel addUser(UserModel userModel) {
		ResponseModel responseModel = new ResponseModel();
		if (null != userManagementRepository.findByEmail(userModel.getEmail())) {
			responseModel.setResponseMessage("User Already exists with the given email id");
			return responseModel;
		}
		UserEntity userEntity = new UserEntity();
		saveDetails(userEntity, userModel);
		responseModel.setResponseMessage("User added successfully");
		return responseModel;
	}

	/** method to delete user details
	 * @param id
	 * @return
	 */
	public ResponseModel deleteUser(int id) {
		ResponseModel responseModel = new ResponseModel();
		UserEntity userEntity = userManagementRepository.findById(id);
		if (null != userEntity) {
			userManagementRepository.delete(userEntity);
			responseModel.setResponseMessage("User Record deleted successfully");
			return responseModel;
		} else {
			responseModel.setResponseMessage("The user details are not valid");
			return responseModel;
		}

	}

	/** method to update user details
	 * @param id
	 * @param userModel
	 * @return
	 */
	public ResponseModel updateUser(int id, UserModel userModel) {
		ResponseModel responseModel = new ResponseModel();
		UserEntity userEntity = userManagementRepository.findById(id);
		if (null != userEntity) {
			saveDetails(userEntity, userModel);
			responseModel.setResponseMessage("Updated successfully");
			return responseModel;
		} else {
			responseModel.setResponseMessage("The user details are not valid");
			return responseModel;
		}
	}

	/**
	 * Method to validate user details. the email and password are validated.
	 * @param email
	 * @param password
	 * @return
	 */
	public ResponseModel validateUser(String email, String password) {
		ResponseModel responseModel = new ResponseModel();
		UserEntity userEntity = userManagementRepository.findByEmail(email);
		if (null != userEntity) {
			if (userEntity.getPassword().equals(password)) {
				responseModel.setResponseMessage("The login is successful");
				return responseModel;
			} else {
				responseModel.setResponseMessage("Credentials are incorrect");
				return responseModel;
			}
		} else {
			responseModel.setResponseMessage("The user details are not valid");
			return responseModel;
		}
	}

	/** common method used in add user and update user methods to save to db.
	 * 
	 * @param userEntity
	 * @param userModel
	 */
	private void saveDetails(UserEntity userEntity, UserModel userModel) {
		userEntity.setName(userModel.getName());
		userEntity.setEmail(userModel.getEmail());
		userEntity.setPassword(userModel.getPassword());
		userEntity.setLoginDate(userModel.getLoginDate());
		userManagementRepository.save(userEntity);
	}
}
