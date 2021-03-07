package com.comapany;

import com.comapany.DATA.Postgre;
import com.comapany.DATA.interfaces.IDB;
//import com.comapany.repositories.interfaces.Methods;
import com.comapany.controller.NecklaceController;
import com.comapany.controller.StoneController;
import com.comapany.entities.Stone;
import com.comapany.repositories.interfaces.IStone;
import com.comapany.repositories.interfaces.Methods;
import com.comapany.repositories.NecklaceRepo;
import com.comapany.repositories.StoneRepo;

public class main {
    public static void main(String[] args) {

        /*It is some examples for generics*/
        Stone<Integer> stones=new Stone<>();
        stones.addStones(5);
        stones.printNumbers();
        Stone<String> stone1=new Stone<>();
        stone1.hello("almaz");



        IDB db = new Postgre();
        Methods repo=new NecklaceRepo(db);
        IStone repo1=new StoneRepo(db);
        StoneController controller1=new StoneController(repo1);
        NecklaceController controller =new NecklaceController(repo);
        MyApplication app = new MyApplication(controller,controller1);
        app.start();
}
}
