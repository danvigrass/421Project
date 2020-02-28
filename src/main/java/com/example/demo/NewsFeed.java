package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
//Controller for NewsHolder class
@RestController
public class NewsFeed {
    private ArrayList<NewsHolder> postings;

    public NewsFeed() {
        postings = new ArrayList<>();
        NewsHolder item0 = new NewsHolder(0, "John", "I am John and I made this post");
        NewsHolder item1 = new NewsHolder(1, "John", "I am also John and I posted this");
        NewsHolder item2 = new NewsHolder(2, "Smith", "I am Smith, I am not John");
        NewsHolder item3 = new NewsHolder(3, "What", "I have no clue what I am but I exist");

        postings.add(item0);
        postings.add(item1);
        postings.add(item2);
        postings.add(item3);
    }

    @RequestMapping("/getAll")
    public ArrayList<NewsHolder> getAllPostings() {
        return postings;
    }

    @RequestMapping("getPostsFromUser")
    public ArrayList<NewsHolder> getPostsFromUser(@RequestParam(name="userName") String userName) {
        ArrayList<NewsHolder> result = new ArrayList<>();
        for (NewsHolder item : postings) {
            if (item.getUserName().equals(userName)) {
                result.add(item);
            }
        }
        if (result.isEmpty()) {
            return null;
        }
        else {
            return result;
        }
    }

    @RequestMapping("/newPost")
    public String newPost(@RequestBody NewsHolder item) {
        postings.add(item);
        return "Your post has been added";
    }

    @RequestMapping("/updatePost")
    public String updatePost(@RequestParam(name="index") int index, @RequestParam(name="newText") String newText) {
        postings.get(index).setMessageBody(newText);
        return "Your post has been updated";
    }

    @RequestMapping("/deletePost")
    public String deletePost(@RequestParam(name="index") int index) {
        postings.remove(index);
        return "Your post has been deleted";
    }

}
