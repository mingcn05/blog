package Blog.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import Blog.model.Blog;



@Repository
public class BlogDaoAPI implements BlogDao {
	@Autowired
	private JdbcTemplate jdbc;

	@Override
	public void addBlog(Blog blog) {
		String sql = "insert into blog(name,content,addr,comments,views,likes,img) value(?,?,?,0,0,0,?)";
		jdbc.update(sql, blog.getName(), blog.getContent(), blog.getAddr(), blog.getImg());
	}

	@Override
	public List<Blog> getBlogByAdds(String addr) {
		String sql = "select * from blog where ((select instr(addr,?))>0)";
		return jdbc.query(sql, new BeanPropertyRowMapper<Blog>(Blog.class), addr);
	}

	@Override
	public Blog getBlog(String name) {
		String sql = "select * from blog where name = ?";
		return jdbc.query(sql, new BeanPropertyRowMapper<Blog>(Blog.class),name).get(0);
	}
}
