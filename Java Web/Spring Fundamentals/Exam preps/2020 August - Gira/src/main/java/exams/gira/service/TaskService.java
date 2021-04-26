package exams.gira.service;

import exams.gira.model.service.TaskServiceModel;
import exams.gira.model.service.UserServiceModel;
import exams.gira.model.view.TaskViewModel;

import java.util.List;

public interface TaskService {

    void addTask(TaskServiceModel taskServiceModel, UserServiceModel userServiceModel);
    List<TaskViewModel> getAllTasks();

    void progress(String id);
}
