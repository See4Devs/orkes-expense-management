package io.orkes.samples.workers;

import com.netflix.conductor.client.worker.Worker;
import com.netflix.conductor.common.metadata.tasks.Task;
import com.netflix.conductor.common.metadata.tasks.TaskResult;
import org.springframework.stereotype.Component;


@Component
public class SendBankTransfer implements Worker {
    @Override
    public String getTaskDefName() {
        return "initiate_bank_transfer_orkes";
    }

    @Override
    public TaskResult execute(Task task) {

        TaskResult result = new TaskResult(task);
        try {
            result.setStatus(TaskResult.Status.COMPLETED);
            result.addOutputData("emailTransferContent", "Dear Sir/Mme, the reimbursement of your expense request has been initiated.");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }
}
