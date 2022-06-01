package Blog.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import Blog.model.User;

@RestController
public class testController {

	@PostMapping("/test")
	public String index(User user) {
		return user.toString();
	}
}
