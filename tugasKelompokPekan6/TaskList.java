package tugasKelompokPekan6;

import java.util.LinkedList;

public class TaskList {
    private LinkedList<Task> tasks;

    public TaskList() {
        tasks = new LinkedList<>();
    }

    public void tambahTask(Task task) {
        tasks.add(task);
    }

    public void hapusTask(int index) {
        tasks.remove(index);
    }

    public void tampilkanTask() {
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
    }

    public int jumlahTask() {
        return tasks.size();
    }
}

