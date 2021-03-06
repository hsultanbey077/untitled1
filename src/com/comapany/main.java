package com.comapany;

import com.comapany.DATA.Postgre;
import com.comapany.DATA.interfaces.IDB;
//import com.comapany.interfaces.Methods;
import com.comapany.controller.NecklaceController;
import com.comapany.controller.StoneController;
import com.comapany.interfaces.IStone;
import com.comapany.interfaces.Methods;
import com.comapany.repositories.NecklaceRepo;
import com.comapany.repositories.StoneRepo;

public class main {
    public static void main(String[] args) {
//        Scanner scanner=new Scanner(System.in);
//        Necklace necklace = new Necklace(20,"Sultan",5,215000);
//        System.out.println("Input the weight: ");
//        necklace.setWeight(scanner.nextInt());
//
//        System.out.println("Input the name: ");
//        necklace.setName(scanner.next());
//
//        System.out.println("Input the stones: ");
//        necklace.setStones(necklace.getStones());
//
//        System.out.println("Input the cost: ");
//        necklace.setCost(scanner.nextInt());

//        Necklace[] necklaces=new Necklace[5];

//        Stone<Integer> stones=new Stone<>();
//        stones.addStones(5);
//
//        stones.printNumbers();


//        Methods method =(int x)->x*5;
//        Outputmethod out=(String message)->message;
//        System.out.println("Total weight in carats: "+method.CalculateWeight(necklace.getWeight()));
//        System.out.println(out.message(necklace.toString()));
//
        IDB db = new Postgre();
        Methods repo=new NecklaceRepo(db);
        IStone repo1=new StoneRepo(db);
        StoneController controller1=new StoneController(repo1);
        NecklaceController controller =new NecklaceController(repo);
        MyApplication app = new MyApplication(controller,controller1);
        app.start();
}
}
