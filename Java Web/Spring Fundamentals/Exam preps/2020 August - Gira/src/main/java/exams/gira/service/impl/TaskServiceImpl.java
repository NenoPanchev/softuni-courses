package exams.gira.service.impl;

import exams.gira.model.entity.Classification;
import exams.gira.model.entity.Progress;
import exams.gira.model.entity.Task;
import exams.gira.model.entity.User;
import exams.gira.model.service.ClassificationServiceModel;
import exams.gira.model.service.TaskServiceModel;
import exams.gira.model.service.UserServiceModel;
import exams.gira.model.view.TaskViewModel;
import exams.gira.repository.TaskRepository;
import exams.gira.service.ClassificationService;
import exams.gira.service.TaskService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;
    private final ModelMapper modelMapper;
    private final ClassificationService classificationService;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository, ModelMapper modelMapper, ClassificationService classificationService) {
        this.taskRepository = taskRepository;
        this.modelMapper = modelMapper;
        this.classificationService = classificationService;
    }

    @Override
    public void addTask(TaskServiceModel taskServiceModel, UserServiceModel userServiceModel) {
        Task task = this.modelMapper.map(taskServiceModel, Task.class);
        User user = this.modelMapper.map(userServiceModel, User.class);
        ClassificationServiceModel csm = this.classificationService.getClassificationByName(taskServiceModel.getClassification().getClassificationName());
        Classification classification = this.modelMapper.map(csm, Classification.class);
        task.setUser(user);
        task.setClassification(classification);
        task.setProgress(Progress.OPEN);
        this.taskRepository.saveAndFlush(task);
    }

    @Override
    public List<TaskViewModel> getAllTasks() {

        return this.taskRepository.findAll()
                .stream()
                .map(task -> {
                    TaskViewModel view = this.modelMapper.map(task, TaskViewModel.class);
                    view.setAssignedTo(task.getUser().getUsername());
                    view.setClassificationName(task.getClassification().getClassificationName());
                    return view;
                }).collect(Collectors.toList());
    }

    @Override
    public void progress(String id) {
        Task task = this.taskRepository.findById(id).orElse(null);
        switch (task.getProgress()) {
            case OPEN -> {
                task.setProgress(Progress.IN_PROGRESS);
                this.taskRepository.saveAndFlush(task);
            }
            case IN_PROGRESS -> {
                task.setProgress(Progress.COMPLETED);
                this.taskRepository.saveAndFlush(task);
            }
            case COMPLETED -> {
                this.taskRepository.delete(task);
            }
            case OTHER -> {
            }
        }

    }
}
