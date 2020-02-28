package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class ChatRoomController {
    ArrayList<ChatRoom> ChatRoomChat = new ArrayList<ChatRoom>();



    @GetMapping("/getAllChat")
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
    public String deleteUser(@RequestParam(name="id")int id)
    {
        ChatRoomChat.remove(id);
        return "Message with id " + id + " has been removed";
    }

    @PostMapping("/createMessage")
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
