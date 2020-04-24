package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class ChatRoomController {
    ArrayList<ChatRoom> ChatRoomChat = new ArrayList<ChatRoom>();


    @GetMapping("/chatroom")
    public String openChat() {
        return "Chatroom";
    }

    @GetMapping("/getChatUsers")
    @ResponseBody
    public ArrayList<User> getChatUsers(@RequestParam(name="id")int id)
    {
        return ChatRoomChat.get(id).chatters;
    }
    @GetMapping("/getAllChat")
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

    @DeleteMapping("/deleteMessage")
    @ResponseBody
    public String deleteMessage(@RequestParam(name="id")int id)
    {
        ChatRoomChat.remove(id);
        return "Message with id " + id + " has been removed";
    }

    @PostMapping("/createMessage")
    @ResponseBody
    public ChatRoom createMessage(@RequestBody ChatRoom t)
    {
        ChatRoomChat.add(t);
        return t;
    }

    public ChatRoomController()
    {
        ChatRoom c1 = new ChatRoom("test user", "ExampleText");
        ChatRoomChat.add(c1);

    }



}
