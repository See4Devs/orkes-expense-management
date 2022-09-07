package io.orkes.samples.workers;
import com.netflix.conductor.client.worker.Worker;
import com.netflix.conductor.common.metadata.tasks.Task;
import com.netflix.conductor.common.metadata.tasks.TaskResult;
import org.springframework.stereotype.Component;

@Component
public class ExpenseRequest implements Worker {
    @Override
    public String getTaskDefName() {
        return "expense_request_approval";
    }

    @Override
    public TaskResult execute(Task task) {

        TaskResult result = new TaskResult(task);
        String firstname = (String) task.getInputData().get("firstname");
        String lastname = (String) task.getInputData().get("lastname");
        String description = (String) task.getInputData().get("description");
        int amount = (int) task.getInputData().get("amount");

        try {
            boolean approved = amount < 500;
            result.setStatus(TaskResult.Status.COMPLETED);
            result.addOutputData("approved", approved);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }
}
