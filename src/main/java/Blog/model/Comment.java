package Blog.model;

import lombok.Data;

@Data
public class Comment {
	private int id;
	private int iduser;
	private int idblog;
	private String noidung;
}
