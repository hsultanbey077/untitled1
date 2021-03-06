package com.comapany.controller;

import com.comapany.entities.Stone;
import com.comapany.interfaces.IStone;

import java.util.List;

public class StoneController {
    private final IStone repo;

    public StoneController(IStone repo) {
        this.repo = repo;
    }
    public String createStone(int id,String name,int cost,int weight){
        Stone stone =new Stone(id,name,cost,weight);
        boolean created= repo.createStone(stone);
        return (created ? "Stone was created!" : "Stone creation was failed!");
    }
    public int getStoneById(int id){//get user by id method
        Stone stone= repo.getStoneById(id);
        return Integer.parseInt((stone == null ? "User was not found!" : stone.toString()));
    }
    public String getAllStones(){//get all users method
        List<Stone> employee = repo.getAllStones();

        return employee.toString();
    }
}
