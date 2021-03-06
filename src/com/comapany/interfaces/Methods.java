package com.comapany.interfaces;

import com.comapany.entities.Necklace;

import java.util.List;

public interface Methods{
    int CalculateCost(int id, int id1);
    int CalculateWeight(int weight,int weight1 );
    boolean createNecklace(Necklace necklace);
    Necklace getNecklaceById(int id);
    List<Necklace> getAllNecklace();
}
