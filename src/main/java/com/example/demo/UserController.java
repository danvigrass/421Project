package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class UserController {
    ArrayList<User> userList = new ArrayList<User>();
    ArrayList<String> friendList = new ArrayList();
    @GetMapping("/getFriends")
    @ResponseBody
    public ArrayList<String> getFriends()
    {
        return friendList;
    }

    @GetMapping("/friends")
    public String friends() {
        return "friends";
    }
    @PostMapping("/addFriend")
    @ResponseBody
    public ArrayList<String> addFriend(@RequestParam(name="name")String name)
    {
        friendList.add(name);

        return friendList;
    }
    @GetMapping("/login")
    public String login(){
        return "login";
    }
    @GetMapping("/register")
    public String register(){
        return "register";
    }
    @GetMapping("/login/send")
    @ResponseBody
    public boolean loginSend(@RequestParam(name="un") String un, @RequestParam(name="pw")String pw)
    {
        boolean returner = false;
        for(int i=0;i<userList.size();i++)
        {

            if(userList.get(i).name.equals(un)  && userList.get(i).password.equals(pw))
            {
                returner = true;
            }
        }
        return returner;
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
    public ArrayList<User> createUser(@RequestParam(name="name")String name,@RequestParam(name="email")String email, @RequestParam(name="pw")String pw)
    {
        User t = new User(name,email,pw);
        userList.add(t);
        return userList;
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
        User d1 = new User("d",  "loveyou@gmail.com", "test");
        User d2 = new User("testuser2",  "loveyou2@gmail.com", "test");
        User d3 = new User("t", "t", "t");
        userList.add(d1);
        userList.add(d2);
        userList.add(d3);

    }//curl -X POST -d '{}' -u admin:admin http://localhost:8080/changemenu
    //curl -X POST -d '{"type":"test","priceEach":6.0,"description":"test description"}' -u admin:admin https://localhost:8443/createCategory
}
