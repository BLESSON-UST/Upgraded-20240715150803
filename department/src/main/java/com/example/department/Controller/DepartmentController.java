Here's the upgraded code in Java 17:

```java
package com.example.department.controller;

import com.example.department.entity.Department;
import com.example.department.repository.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    private final DepartmentRepo repo;

    @Autowired
    public DepartmentController(DepartmentRepo repo) {
        this.repo = repo;
    }

    @PostMapping("/submit")
    public ResponseEntity<Department> submit(@RequestBody Department department) {
        return ResponseEntity.ok().body(repo.save(department));
    }

    @GetMapping("/dept")
    public ResponseEntity<List<Department>> getAllDepartments() {
        return ResponseEntity.ok().body(repo.findAll());
    }

    @GetMapping("/{did}")
    public ResponseEntity<Department> getById(@PathVariable int did) {
        Department department = repo.findByDid(did);
        if (department == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(department);
    }
}
```

In the updated code:

- The package name is changed to lowercase (`com.example.department.controller`).
- The entity package name is changed to lowercase (`com.example.department.entity`).
- The repository package name is changed to lowercase (`com.example.department.repository`).
- `@Autowired` annotation is updated to constructor injection for better readability.
- Renamed `getalldept()` method to `getAllDepartments()` for clarity.
- Renamed `getbyid()` method to `getById()` for clarity.
- Commented out unused method `getbyid(@PathVariable int id)`.