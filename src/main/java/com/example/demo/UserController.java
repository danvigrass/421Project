package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class UserController {
    ArrayList<User> userList = new ArrayList<User>();

    @GetMapping("/getFriends")
    @ResponseBody
    public ArrayList<User> getFriends(@RequestParam(name="id")int id)
    {
        return userList.get(id).friends;
    }

@GetMapping("/getAllUsers")//repurposed
@ResponseBody
public String getAllUsers()
{
    String returner = "";
    for(int i = 0; i< userList.size(); i++)
    {
        returner = returner.concat(userList.get(i).name) + ", ";
    }
    return returner;
}

    @GetMapping("/getUser")//repurposed
    @ResponseBody
    public User getUser(@RequestParam(name="id")int val)
    {
        return userList.get(val);
    }
//"type":"pizza","priceEach":6.0,"description":"surpreme pizza"


    @PostMapping("/createUser")//repurposed
    @ResponseBody
    public User createUser(@RequestBody User t)
    {
        userList.add(t);
        return t;
    }

    @PutMapping("/updateUser")//repurposed
    @ResponseBody
    public String updateUser(@RequestBody User detail, @RequestParam(name="id")int id)
    {
        userList.remove(id);
        userList.add(detail);
        return "Your updated category: " + detail;
    }


    @DeleteMapping("/deleteUser")//repurposed
    @ResponseBody
    public String deleteUser(@RequestParam(name="id")int id)
    {
        userList.remove(id);
        return "User with id " + id + " has been removed";
    }

    public UserController()
    {
        User d1 = new User("test user", 0, "loveyou@gmail.com");
        User d2 = new User("test user2", 1, "loveyou2@gmail.com");
        userList.add(d1);
        userList.add(d2);

    }//curl -X POST -d '{}' -u admin:admin http://localhost:8080/changemenu
    //curl -X POST -d '{"type":"test","priceEach":6.0,"description":"test description"}' -u admin:admin https://localhost:8443/createCategory
}
