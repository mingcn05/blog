package Blog.api;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import Blog.dao.UserDao;
import Blog.model.User;

@Controller
@RequestMapping("/")
public class HomeController {
	@Autowired
	private UserDao uDao;
	
	@GetMapping("/index")
	public String index() {
		return "index";
	}
	@GetMapping("/contact") 
	public String contact() {
		return "contact";
	}
	@GetMapping("/single") 
	public String single() {
		return "single-page";
	}
	@GetMapping("/login") 
	public String glogin(Model model) {
		model.addAttribute(new User());
		return "login";
	}
	@GetMapping("/logup") 
	public String glogup(Model model) {
		model.addAttribute(new User());
		return "login";
	}
	@PostMapping("/logup") 
	public String glogup(User user) {
		uDao.addUser(user);
		return "login";
	}
	@PostMapping("/login") 
	public String plogin(Model model, User user,HttpSession session) {
		if(uDao.exitsUser(user.getUsername())) {
			session.setAttribute("user", user);
			user = uDao.findUser(user.getUsername());
			if(user.getDes().equals("admin")) {
				return "admin";
			}
			else {
				return "index";
			}
		}
		model.addAttribute(user);
		model.addAttribute("mess", "Thông tin tài khoản hoặc mật khẩu không chính xác");
		return "login";
	}
	
	@GetMapping("/admin") 
	public String admin() {
		return "admin";
	}
}
