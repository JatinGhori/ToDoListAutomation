package api.endpoints;

import static io.restassured.RestAssured.given;

import api.payload.Task;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class TaskEndPoints {
	
	public static Response createTask(Task payload)
	{
		Response response = given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(payload)
			.when()
			.put(Routes.create_task_url);
		
		return response;
	}
	
	public static Response listTasks(String user_id)
	{
		Response response = given()
			.pathParam("user_id", user_id)
			.when()
			.get(Routes.list_task_url);
		
		return response;
	}
	
	public static Response deleteTask(String task_id)
	{
		Response response = given()
			.pathParam("task_id", task_id)
			.when()
			.delete(Routes.delete_task_url);
		
		return response;
	}
}
