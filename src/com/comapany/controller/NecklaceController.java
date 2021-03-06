package com.comapany.controller;

import com.comapany.entities.Necklace;
import com.comapany.repositories.interfaces.Methods;

import java.util.List;

public class NecklaceController {
    private final Methods method;

    public NecklaceController(Methods method) {
        this.method = method;
    }
    public int CalculateCost(int id, int id1){

       int response= method.CalculateCost(id, id1);
       return response;
    }


    public int CalculateWeight(int weight, int weight1){

        int response= method.CalculateWeight(weight,weight1);
        return response;
    }
    public String createNecklace(int necklace_id, String name, int cost1, int weight, int stones){
        Necklace necklace =new Necklace(necklace_id,name,cost1,weight,stones);
        boolean created= method.createNecklace(necklace);
        return (created ? "Necklace was created!" : "Necklace creation was failed!");
    }
    public int getNecklaceById(int id){//get user by id method
        Necklace necklace= method.getNecklaceById(id);
        return Integer.parseInt((necklace == null ? "User was not found!" : necklace.toString()));
    }
    public String getAllNecklaces(){//get all users method
        List<Necklace> necklace = method.getAllNecklace();

        return necklace.toString();
    }
}
