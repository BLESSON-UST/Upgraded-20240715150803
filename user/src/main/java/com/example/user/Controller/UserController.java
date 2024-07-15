To upgrade the Java code to version 17, you can follow these steps:

1. Update the package declaration to use the new syntax:
```java
package com.example.user.controller;
```

2. Ensure you have Java 17 installed on your system and configure your IDE or build tool to use Java 17.

3. Replace the import statements with the updated versions:
```java
import com.example.user.model.User;
import com.example.user.repository.UserRepo;
import com.example.user.vo.Department;
import com.example.user.vo.ResponseTemplateVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
```

4. Replace the `@RestController` and `@RequestMapping` annotations with the updated ones:
```java
@RestController
@RequestMapping("/user")
public class UserController {
    // ...
}
```

5. Update the autowiring annotation:
```java
@Autowired
private UserRepo repo;

@Autowired
private RestTemplate restTemplate;
```

6. Replace the method parameters and return types with the updated versions:
```java
@PostMapping("/save")
public ResponseEntity<User> submitUser(@RequestBody User user) {
    return ResponseEntity.ok(repo.save(user));
}

@GetMapping("/usr")
public ResponseEntity<List<User>> getAllUsers() {
    return ResponseEntity.ok(repo.findAll());
}

@GetMapping("/{uid}")
public ResponseEntity<ResponseTemplateVO> findUserWithDept(@PathVariable int uid) {
    ResponseTemplateVO op = new ResponseTemplateVO();
    User user = repo.findByUid(uid);
    if (user == null) {
        return ResponseEntity.notFound().build();
    }
    Department department = restTemplate.getForObject("http://DEPARTMENT/department/" + user.getDid(), Department.class);
    op.setUser(user);
    op.setDepartment(department);
    return ResponseEntity.ok(op);
}
```

7. Save the updated code and recompile it with Java 17.

Note: The code assumes that you have already updated any other dependencies to their compatible versions for Java 17.