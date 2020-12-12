package interfaces.simplethread;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SimpleThread implements Runnable {

    private List<String> tasks;

    public SimpleThread(List<String> tasks) {
        this.tasks = tasks;
    }

    public List<String> getTasks() {
        return tasks;
    }

    private boolean nextStep() {
        if (tasks != null && !tasks.isEmpty()) {
            tasks.remove(tasks.size() - 1);
            return true;
        }
        return false;
    }

    @Override
    public void run() {
        while (nextStep()) {
            nextStep();
        }
    }

}
