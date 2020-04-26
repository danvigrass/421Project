package com.example.demo;

import com.sun.org.apache.xml.internal.security.algorithms.SignatureAlgorithm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import java.util.ArrayList;
import java.util.Date;

@Controller
public class UserController {
    ArrayList<User> userList = new ArrayList<User>();
    ArrayList<User> friendList = new ArrayList();
    @GetMapping("/getFriends")
    @ResponseBody
    public ArrayList<User> getFriends()
    {
        return friendList;
    }
    @GetMapping("/menu")
    public String mainmenu(){
        return "menu";
    }
    @GetMapping("/friends")
    public String friends() {
        return "friends";
    }
    @PostMapping("/addFriend")
    @ResponseBody
    public ArrayList<User> addFriend(@RequestParam(name="name")String name)
    {
        for(int i=0;i<userList.size();i++)
        {
            if(userList.get(i).name.equals(name));
            {
                friendList.add(userList.get(i));
            }
        }
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

    public User findByName(String n)
    {
        User s = new User(null,null,null);
        for(int i=0;i<userList.size();i++)
        {
            if(userList.get(i).name.equals(n));
            {
                return userList.get(i);
            }
        }
        return s;
    }

    @PostMapping("/login/send")
    @ResponseBody
    public String loginSend(@RequestParam(name="un") String un, @RequestParam(name="pw")String pw)
    {
        String returner = "Invalid username and or password please try again.";
        for(int i=0;i<userList.size();i++)
        {

            if(userList.get(i).name.equals(un)  && userList.get(i).password.equals(pw))
            {
                 returner = "Login Successful click Ok to continue";
            }
        }
        return returner;
    }

    /*@RequestMapping(value ="/login/send", method = RequestMethod.POST)
    @ResponseBody
    public String loginSend(@RequestBody User login) throws ServletException
    {
        String jwtToken = "";
        if(login.getName() == null || login.getPassword() == null)
        {
            throw new ServletException("Please fill in username and password");
        }
        String name = login.getName();
        String password = login.getPassword();

        User user = findByName(name);

        if(user == null){
            throw new ServletException("User not found");
        }

        String pwd = user.getPassword();

        if(!password.equals(pwd)){
            throw new ServletException("Invalid login. Please check credentials and try again");
        }

        jwtToken = Jwts.builder().setSubject(name).claim("roles", "user").setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, "secretkey").compact();

        return jwtToken;
    }*/

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


/*
    @DeleteMapping("/deleteUser")//repurposed
    @ResponseBody
    public String deleteUser(@RequestParam(name="id")int id)
    {
        userList.remove(id);
        return "User with id " + id + " has been removed";
    }*/


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
