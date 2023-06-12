package api.payload;

public class Task {
	  String content;
	  String user_id;
	  String task_id;
	  boolean is_done = false;
	
	  public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getTask_id() {
		return task_id;
	}
	public void setTask_id(String task_id) {
		this.task_id = task_id;
	}
	public boolean isIs_done() {
		return is_done;
	}
	public void setIs_done(boolean is_done) {
		this.is_done = is_done;
	}
	  
}
