package com.comapany.entities;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Stone<T> {
    private int id;
    private String name;
    private int cost;
    private int weight;

    private List<T> stones=new ArrayList<>();

    public void addStones(T stone){
        stones.add(stone);
    }

//    public void sortStones(){
//        for(int i=0;i<stones.size();i++){
//            if(stones.get(i)>2){
//
//            }
//        }
//    }

    public Stone(){}

    public Stone(int id, String name, int cost, int weight) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.weight = weight;
    }

    public Stone(int id, String name, int cost, int weight,  List<T> stones) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.weight = weight;

        this.stones = stones;
    }



    public void printNumbers(){
        for(T stone : stones){

            System.out.println(stone);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<T> getStones() {
        return stones;
    }


    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }


    public void setId(int id) {
        this.id = id;
    }

    public int getWeight() {
        return weight;
    }

    public int getId() {
        return id;
    }

    public void setStones(List<T> stones) {
        this.stones = stones;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Stone{" +'\''+
                "id=" + id + '\''+
                ", name=" + name + '\'' +
                ", cost=" + cost +'\''+
                ", weight=" + weight +'\''+
                '}';
    }
}
