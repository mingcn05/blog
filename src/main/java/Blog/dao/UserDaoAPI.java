package Blog.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import Blog.model.User;

@Repository
public class UserDaoAPI implements UserDao {
	@Autowired
	private JdbcTemplate jdbc;

	@Override
	public User findUser(int id) {
		String sql = "select * from user where id = ?";
		return jdbc.query(sql, new BeanPropertyRowMapper<User>(User.class),id).get(0);
	}

	@Override
	public void addUser(User user) {
		String sql = "insert into user(name,username,password,des) value(?,?,?,'user')";
		jdbc.update(sql,user.getName(),user.getUsername(),user.getPassword());
	}

	@Override
	public Boolean exitsUser(String username) {
		String sql = "select * from user where username = ? LIMIT 1";
		if(jdbc.query(sql, new BeanPropertyRowMapper<User>(User.class),username).size()>0) {
			return true;
		}
		return false;
	}

	@Override
	public List<User> getUsers(String text) {
		String sql = "select * from user where (select instr(name,?)>0)";
		return jdbc.query(sql, new BeanPropertyRowMapper<User>(User.class),text);
	}

	@Override
	public Boolean checkUser(String username, String password) {
		String sql = "select * from user where username = ? and password = ? LIMIT 1";
		if(jdbc.query(sql, new BeanPropertyRowMapper<User>(User.class),username,password).size()>0) {
			return true;
		}
		return false;
	}

	@Override
	public User findUser(String username) {
		String sql = "select * from user where username = ?";
		return jdbc.query(sql, new BeanPropertyRowMapper<User>(User.class),username).get(0);
	}
	
	
	
}
