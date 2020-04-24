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

    @GetMapping("chatroom/getAllChat")
    @ResponseBody
    public String getAllChat()
    {
        String returner = "";
        for(int i = 0; i< ChatRoomChat.size(); i++)
        {
            returner = returner.concat(ChatRoomChat.get(i).userMessage);
        }
        return returner;
    }

    @DeleteMapping("chatroom/deleteMessage")
    @ResponseBody
    public String deleteMessage(@RequestParam(name="id")int id)
    {
        ChatRoomChat.remove(id);
        return "Message with id " + id + " has been removed";
    }

    @PostMapping("chatroom/createMessage")
    @ResponseBody
    public String createMessage(@RequestParam (name="text")String text)
    {
        if(text=="")
        {
            return "";
        }
        else
        {
            return text;
        }
    }

    public ChatRoomController()
    {
        ChatRoom c1 = new ChatRoom("test user", "ExampleText");
        ChatRoomChat.add(c1);

    }



}
