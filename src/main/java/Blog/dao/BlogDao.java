package Blog.dao;


import java.util.List;

import Blog.model.Blog;

public interface BlogDao {
	Blog getBlog(String name);
	void addBlog(Blog blog);
	List<Blog> getBlogByAdds(String addr);
}