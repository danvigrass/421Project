package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class ChatRoomController {
    ArrayList<ChatRoom> ChatRoomChat = new ArrayList<ChatRoom>();
    ArrayList<String> userList = new ArrayList<>();


    @GetMapping("/chatroom")
    public String openChat() {
        return "Chatroom";
    }

    @PostMapping("chatroom/newUser")
    @ResponseBody
    public ArrayList<String> NewUser(@RequestParam(name="name")String name)
    {
        for(int i =0;i<userList.size();i++)
        {
            if(userList.get(i).equals(name))
            {
                return userList;
            }
        }
        userList.add(name);
        return userList;
    }

    @GetMapping("chatroom/getChatUsers")
    @ResponseBody
    public ArrayList<String> getChatUsers()
    {
        return userList;
    }

    @GetMapping("chatroom/getChatUser")
    @ResponseBody
    public String getChatUser(@RequestParam(name="id")int id)
    {

        return userList.get(id);
    }



    @DeleteMapping("chatroom/removeUser")
    @ResponseBody
    public String deleteMessage(@RequestParam(name="name")String name)
    {
        int x = 0;
        for(int i =0;i<userList.size();i++)
        {
            if (userList.get(i).equals(name)) {
                userList.remove(i);
                x=i;
            }
        }
        return "Message with id " + x + " has been removed";
    }


    public ChatRoomController()
    {
        ChatRoom c1 = new ChatRoom("test user", "ExampleText");
        ChatRoomChat.add(c1);

    }



}
