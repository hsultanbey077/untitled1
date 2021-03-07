package com.comapany.entities;

public class Necklace {
    private int necklace_id;
    private int weight;
    private String name;
    private int stones;
    private int cost1;


    public Necklace() {

    }

    public Necklace(int necklace_id, String name, int cost1, int weight, int stones) {
        this.necklace_id=necklace_id;
        this.name=name;
        this.cost1=cost1;
        this.weight=weight;
        this.stones=stones;
    }


    public int getNecklace_id() {
        return necklace_id;
    }

    public void setNecklace_id(int necklace_id) {
        this.necklace_id = necklace_id;
    }

    public int getCost1() {
        return cost1;
    }

    public void setCost1(int cost1) {
        this.cost1 = cost1;
    }

    public int getStones() {
        return stones;
    }

    public void setStones(int stones) {
        this.stones = stones;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Necklace{" +
                "weight=" + weight +
                ", name=" + name  +
                ", stones=" + stones +
                ", cost=" + cost1 +
                '}';
    }
}
