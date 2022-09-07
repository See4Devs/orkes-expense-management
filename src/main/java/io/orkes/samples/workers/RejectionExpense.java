package io.orkes.samples.workers;

        import com.netflix.conductor.client.worker.Worker;
        import com.netflix.conductor.common.metadata.tasks.Task;
        import com.netflix.conductor.common.metadata.tasks.TaskResult;
        import org.springframework.stereotype.Component;


@Component
public class RejectionExpense implements Worker {
    @Override
    public String getTaskDefName() {
        return "rejection_expenses_orkes";
    }

    @Override
    public TaskResult execute(Task task) {

        TaskResult result = new TaskResult(task);
        try {
            result.setStatus(TaskResult.Status.COMPLETED);
            result.addOutputData("emailContent", "Dear Sir/Mme, we are sorry to inform you that your request of reimbursement was rejected.");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }
}
