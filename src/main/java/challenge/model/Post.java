package challenge.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Post {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private Date date = new Date();
	
	@NotBlank(message = "Título é obrigatório")
	private String title;
	
	@NotBlank(message = "Texto é obrigatório")
	private String text;

	@JsonIgnore
	@ManyToOne
    @JoinColumn(name="user_id", nullable=false)
	private User user;
	
	public Post() {
	
	}

	public Post(Long id, Date date, @NotBlank String title, @NotBlank String text, User user) {
		super();
		this.id = id;
		this.date = date;
		this.title = title;
		this.text = text;
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", date=" + date + ", title=" + title + ", text=" + text + ", user=" + user + "]";
	}

}
