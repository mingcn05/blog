package Blog.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class AdminController {
	
	@GetMapping("/addblog")
	public String addblog() {
		return "addblog";
	}
	@GetMapping("/mess") 
	public String mess() {
		return "mess";
	}
	@GetMapping("/news") 
	public String news() {
		return "news";
	}
}
