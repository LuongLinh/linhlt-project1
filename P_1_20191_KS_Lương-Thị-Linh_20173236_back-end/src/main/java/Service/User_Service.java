package Service;

import java.util.List;

import Model.User;

public interface User_Service {

	
	public boolean saveUser(User user);
	public List<User> getUsers();
	public boolean deleteUser(User user);
	public List<User> getUserByID(User user);
	public boolean updateUser(User user);
}
