package api.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.TaskEndPoints;
import api.payload.Task;
import io.restassured.response.Response;

public class TaskTests {
	Faker faker;
	Task taskPayload;
	public Logger logger;
	
	@BeforeClass
	public void setupData()
	{
		faker = new Faker();
		taskPayload = new Task();
		
		taskPayload.setContent(faker.job().title());
		taskPayload.setUser_id(Integer.toString(faker.idNumber().hashCode()));
		taskPayload.setTask_id(Integer.toString(faker.idNumber().hashCode()));
		
		//logs
		logger = LogManager.getLogger(this.getClass());
	}
	
	@Test(priority=1)
	public void testCreateTask()
	{
		logger.info("*** Creating Task ***");
		Response response = TaskEndPoints.createTask(taskPayload);
		logger.info(response.then().log().all());
		
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("*** Task created ***");
	}
	

	@Test(priority=2)
	public void testGetTaskByUserId()
	{
		logger.info("*** Reading Task Info by User Id ***");

		Response response = TaskEndPoints.listTasks(this.taskPayload.getUser_id());
		logger.info(response.then().log().all());
		
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("*** Task Info by User Id is displayed ***");
	}

	@Test(priority=3)
	public void testDeleteTaskById()
	{
		logger.info("*** Deleting Task ***");

		Response response =
				TaskEndPoints.deleteTask(this.taskPayload.getTask_id());
		logger.info(response.then().log().all());
		
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("*** Task deleted ***");

	}

	
}
