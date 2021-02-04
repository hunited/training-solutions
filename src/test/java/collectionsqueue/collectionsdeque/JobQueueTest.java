package collectionsqueue.collectionsdeque;

import org.junit.jupiter.api.Test;

import collectionsqueue.job.Job;
import collectionsqueue.job.NoJobException;

import java.util.ArrayDeque;
import java.util.Deque;

import static org.junit.jupiter.api.Assertions.*;

class JobQueueTest {

    @Test
    void emptyQueueShouldThrowException() {
        Exception ex = assertThrows(NoJobException.class, () -> {
            new JobQueue().dispatchUrgentJob(new ArrayDeque<>());
        });
        assertEquals("No job available, get a rest!", ex.getMessage());
    }

    @Test
    void urgentJobShouldComeFromHead() throws NoJobException {
        Job urgent = new Job(4, "urgent");
        Job notUrgent = new Job(5, "not urgent");
        JobQueue jobQueue = new JobQueue();
        Deque<Job> jobs = jobQueue.addJobByUrgency(urgent, notUrgent);
        Job firstJob = jobQueue.dispatchUrgentJob(jobs);
        assertEquals("urgent", firstJob.getJobDescription());
        assertTrue(firstJob.isUrgent());
    }

    @Test
    void notUrgentJobShouldComeFromTail() throws NoJobException {
        Job urgent = new Job(4, "urgent");
        Job notUrgent = new Job(5, "not urgent");
        JobQueue jobQueue = new JobQueue();
        Deque<Job> jobs = jobQueue.addJobByUrgency(urgent, notUrgent);
        Job lastJob = jobQueue.dispatchNotUrgentJob(jobs);
        assertEquals("not urgent", lastJob.getJobDescription());
        assertFalse(lastJob.isUrgent());
    }

}
