package Blog.model;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Blog {
	private int id;
	private String name;
	private String content;
	private String addr;
	private int comments;
	private int views;
	private int likes;
	private String img;
	
	
	public List<String> getContents(){
		StringTokenizer tk = new StringTokenizer(this.content,"[.–]");
		List<String> list = new ArrayList<>();
		while(tk.hasMoreTokens()) {
			String s = tk.nextToken();
			list.add(s);
		}
		return list;
	}
}
