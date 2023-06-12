package api.endpoints;

public class Routes {
	public static String base_url = "https://todo.pixegami.io";
	
	//User Module
	public static String create_task_url = base_url + "/create-task";
	public static String get_task_url = base_url + "/get-task/{task_id}";
	public static String list_task_url = base_url + "/list-tasks/{user_id}";
	public static String update_task_url = base_url + "/update-task";
	public static String delete_task_url = base_url + "/delete-task/{task_id}";
}
