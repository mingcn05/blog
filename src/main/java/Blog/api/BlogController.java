package Blog.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import Blog.dao.BlogDao;
import Blog.model.Blog;

@Controller
@RequestMapping("/")
public class BlogController {
	@Autowired
	private BlogDao bDao;

	@GetMapping("/blog")
	public String blog(Model model,@ModelAttribute("name")String name) {
		Blog blog=bDao.getBlog(name);
		model.addAttribute("blog", blog);
		return "blog";
	}

	@PostMapping("/addblog")
	public String add(Blog blog) {
		bDao.addBlog(blog);
		return "admin";
	}
	
	@GetMapping("/list")
	public String indexBlog(Model model, Blog blog) {
		List<Blog> blogs = bDao.getBlogByAdds(blog.getAddr());
		model.addAttribute("blog", blogs);
		return "blog";
	}
	@GetMapping("/ablog")
	public String aBlog(Model model,@ModelAttribute("address") String addr) {
		List<Blog> blogs = bDao.getBlogByAdds(addr);
		model.addAttribute("blog", blogs);
		return "ablog";
	}
	
}
