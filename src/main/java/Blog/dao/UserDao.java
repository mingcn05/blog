package Blog.dao;


import java.util.List;

import Blog.model.User;

public interface UserDao {
	User findUser(int id);
	User findUser(String username);
	Boolean exitsUser(String username);
	void addUser(User user);
	List<User> getUsers(String text);
	Boolean checkUser(String username,String password);
}

