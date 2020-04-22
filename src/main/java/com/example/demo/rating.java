package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
//Controller for Review class
@Controller
public class rating {
    private HashMap<String, ArrayList> Reviews = new HashMap<>();

    //gets reviews for a game, type name of game as Catname param
    @GetMapping("Review/Get/Category")
    public ArrayList<Review> getReviewsofgames(@RequestParam(name="Catname") String name) {
        if (Reviews.containsKey(name)) {
            ArrayList<Review> game =Reviews.get(name);
            return game;
        }

        else{

            return null;
        }

    }

    @PostMapping("Review/newCategory")
    public int createnewgame(@RequestParam(name="Catname") String name){
        if (Reviews.containsKey(name)) {
            return 2;
        }

        else{
            ArrayList<Review> reviewofgames = new ArrayList<>();
            Reviews.put(name,reviewofgames);
            return 1;
        }


    }

    @PutMapping("Review/Make")
    public String createReview(@RequestParam(name ="Gamename") String name, @RequestBody Review review){

        if (Reviews.containsKey(name)) {
            ArrayList<Review> answer =Reviews.get(name);
            Reviews.remove(name);
            answer.add(review);
            Reviews.put(name,answer);
            return name;
        }

        else{
            return "Fail";
        }

    }


    @DeleteMapping("Review/Delete/Category")
    public String deleteReview(@RequestParam (name="Catname") String name){
        if (Reviews.containsKey(name)) {
            Reviews.remove(name);
            return name;
        }

        else{
            return "Fail";
        }
    }










}
