package com.example.tasks_general_tree.api;

import com.example.tasks_general_tree.model.Task;
import com.example.tasks_general_tree.service.TaskManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/tasks")
@Slf4j
public class TaskController {



    private TaskManager taskManager;

    @Autowired
    public TaskController(TaskManager taskManager){
        this.taskManager=taskManager;
    }

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody String name) {
        try {
            Task task = taskManager.addTask(name);
            return ResponseEntity.status(201).body(task);
        } catch (Exception e) {
            log.error("Failed to add new Task");
            return ResponseEntity.status(500).build();
        }
    }



    @PostMapping("/add")
    public ResponseEntity<String> addSubTask(@RequestParam String parentName, @RequestParam String name) {
        try {
               Task newSubTask = taskManager.addSubTask(parentName,name);
               return ResponseEntity.status(201).body("SubTask created successfully : " + newSubTask.toString());

        } catch (IllegalAccessException e) {
            return ResponseEntity.status(400).body("Bad request name already exist of parent not exists");
        }
        catch (Exception e) {
            return ResponseEntity.status(500).body("An error occurred while adding the subtask.");
        }
    }



    @DeleteMapping("/{name}")
    public ResponseEntity<String> deleteTask(@PathVariable String name) {
        try {
            taskManager.removeTask(name);
            return ResponseEntity.status(200).body("Task has been removed successfully ");

        } catch (IllegalAccessException e) {
            return ResponseEntity.status(400).body("Bad request name not exists");
        }
        catch (Exception e) {
            return ResponseEntity.status(500).body("An error occurred while removing the task");
        }
    }


    @GetMapping("/print")
    public ResponseEntity<String> printTaskTree() {
        String tree = taskManager.printTreeToString();
        return ResponseEntity.ok(tree);
    }


}



