package com.comapany.interfaces;

import com.comapany.entities.Stone;

import java.util.List;

public interface IStone {
    boolean createStone(Stone stone);
    Stone getStoneById(int id);
    List<Stone> getAllStones();
}
