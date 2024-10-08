package com.example.tasks_general_tree.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class Task {
    private String name;
    private LocalDateTime creation;

}
