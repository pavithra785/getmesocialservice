package com.example.getmesocialservice.resource;

import com.example.getmesocialservice.exception.RestrictedInfoException;
import com.example.getmesocialservice.model.User;
import com.example.getmesocialservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/users")
public class UserResource {
    @Autowired
    private UserService userService;

    @PostMapping
    public User saveUser(@RequestBody @Valid User user){
        return  userService.saveUser(user);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }


    @GetMapping("/find")
    public List<User> getByName(@RequestParam(name = "name") String name) throws RestrictedInfoException {
        if (name.equalsIgnoreCase("root")) {
            throw new RestrictedInfoException();
        }
        return userService.getByName(name);
    }
    @PutMapping
    public User updateUser(@RequestBody @Valid User user ){
        return userService.updateUser(user);
    }

    @DeleteMapping
    public void deleteUser( @RequestParam (name = "userId") String userId ){
         userService.deleteUser(userId);
    }

//    @GetMapping("/user")
//    public User getUser(){
//       return userService.getUser();
//    }
//
//
//    @GetMapping("/allUsers")
//    public List<User> getAllUsers(){
//        return userService.getAllUsers();
//    }
//
//    @GetMapping("/user/{userId}")
//    public User getUserById( @PathVariable ("userId") int userId ){
//        return userService.getUserById(userId);
//    }
//

//
    //    @GetMapping("/find")
//    public Optional<User> getById(@RequestParam(name = "userId") String userId) {
//        return userService.getById(userId);
//    }

}
