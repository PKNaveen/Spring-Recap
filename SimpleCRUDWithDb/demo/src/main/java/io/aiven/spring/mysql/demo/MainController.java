package io.aiven.spring.mysql.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController

@RequestMapping(path ="/demo")
public class MainController {
    @Autowired
    private UserRepo userRepo;

    @PostMapping(path = "/add")

    public @ResponseBody User addUser(@RequestParam String name, @RequestParam String email){
        User SpringUser = new User();
        SpringUser.setName(name);
        SpringUser.setEmail(email);
        userRepo.save(SpringUser);
        return SpringUser;
    }

    @GetMapping(path = "all")
    public @ResponseBody Iterable<User> getAllUsers(){
        return userRepo.findAll();
    }
}
