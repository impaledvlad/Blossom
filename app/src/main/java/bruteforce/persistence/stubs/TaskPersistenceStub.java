package bruteforce.persistence.stubs;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import bruteforce.persistence.TaskPersistence;
import bruteforce.objects.Task;
public class TaskPersistenceStub implements TaskPersistence {

	private List<Task> tasks;

	public TaskPersistenceStub() {
		this.tasks = new ArrayList<>();
		
		tasks.add(new Task("Task1", "username1", new Date("2019/08/20"), false, 1));
		tasks.add(new Task("Task2", "username1", new Date("2019/7/20"), true, 2));
		tasks.add(new Task("Task3", "username2", new Date("2020/8/20"), false, 1));
		tasks.add(new Task("Task4", "username2", new Date("2019/10/20"), false, 2));
		tasks.add(new Task("Task5", "username3", new Date("2019/07/20"), false, 1));
		tasks.add(new Task("Task6", "username3", new Date("2019/8/20"), false, 2));
	}

	/**
	insertTask

	Purpose: insert a new task to our task list
	Parameters: Task currentTask
	Returns: None
	*/
	@Override
	public void insertTask(Task currentTask) {
		tasks.add(currentTask);
	}

	/**
	updateTask

	Purpose: update a task in our task list
	Parameters: Task currentTask
	Returns: boolean true if success, false if not
	*/
	@Override
    public boolean updateTask(Task currentTask) {
//		Task task;
//		int index = -1;
//		for(int counter = 0; counter<tasks.size();counter++){
//			task = tasks.get(counter);
//			if(task.getUsername().equals(currentTask.getUsername()) && task.getTaskID() == currentTask.getTaskID()){
//				index = tasks.indexOf(task);
//			}
//		}
		/**
		 If the test fail, use the code above
		 */
		int index = tasks.indexOf(currentTask);
		if(index >=0 ) {
			tasks.set(index,currentTask);
			return true;
		}
		return false;
    }

	/**
	deleteTask

	Purpose: delete a task in our task list
	Parameters: Task currentTask
	Returns: boolean true if success, false if not
	*/
    @Override
    public boolean deleteTask(Task currentTask) {
//		Task task;
//		int index = -1;
//		for(int counter = 0; counter<tasks.size();counter++)
//		{
//			task = tasks.get(counter);
//			if(task.getUsername().equals(currentTask.getUsername()) && task.getTaskID() == currentTask.getTaskID())
//			{
//				index = tasks.indexOf(task);
//			}
//		}
		/**
		 If the test fail, use the code above
		 */
		int index = tasks.indexOf(currentTask);
		if(index >=0 ) {
			tasks.remove(index);
			return true;
		}
		return false;
	}

	/**
	getTasks

	Purpose: get a list of task from that user
	Parameters: String accountName
	Returns: List<Task>
	*/
	@Override
    public List<Task> getTasks(String accountName)
	{
		List<Task> newTasks = new ArrayList<>();
		Task currentTask;
		for(int counter = 0; counter<tasks.size();counter++) {
			currentTask = tasks.get(counter);
			if(currentTask.getUsername().equals(accountName)) {
				newTasks.add(currentTask);
			}
		}
		return newTasks;
	}
}