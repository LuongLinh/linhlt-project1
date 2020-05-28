package Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Model.User;
import Service.User_Service;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping(value="/api")
public class ControllerUser {
	
	@Autowired
	private User_Service userservice;
	
	
	@PostMapping("save-user")
	public boolean saveUser(@RequestBody User user) {
		 return userservice.saveUser(user);
		
	}
	
	@GetMapping("users-list")
	public List<User> allusers() {
		 return userservice.getUsers();
	}
	
	
	@DeleteMapping("delete-user/{user_id}")
	public boolean deleteUser(@PathVariable("user_id") int user_id,User user) {
		user.setUser_id(user_id);
		return userservice.deleteUser(user);
	}

	@GetMapping("user/{user_id}")
	public List<User> alluserByID(@PathVariable("user_id") int user_id,User user) {
		 user.setUser_id(user_id);
		 return userservice.getUserByID(user);
		
	}
	
	@PostMapping("update-user/{user_id}")
	public boolean updateUser(@RequestBody User user,@PathVariable("user_id") int user_id) {
		user.setUser_id(user_id);
		return userservice.updateUser(user);
	}

}
