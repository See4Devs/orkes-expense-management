package io.orkes.samples.workers;

import com.netflix.conductor.client.worker.Worker;
import com.netflix.conductor.common.metadata.tasks.Task;
import com.netflix.conductor.common.metadata.tasks.TaskResult;
import org.springframework.stereotype.Component;


@Component
public class ManagerApproval implements Worker {
    @Override
    public String getTaskDefName() {
        return "expense_request_manager_approval";
    }

    @Override
    public TaskResult execute(Task task) {

        TaskResult result = new TaskResult(task);
        try {
            boolean approved = Math.random() < 0.3;
            result.setStatus(TaskResult.Status.COMPLETED);
            result.addOutputData("approved", approved);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }
}
