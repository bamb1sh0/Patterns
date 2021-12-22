package com.company.itStep;

//Шаблон цепочка ответственности

public class RoosterAndBeenSeed {
    public static void main(String[] args) {
        Helper hen = new Hen();
        Helper cow = new Cow();
        Helper mowers = new Mowers();
        Helper stove = new Stove();
        hen.setNextHelper(cow);
        cow.setNextHelper(mowers);
        mowers.setNextHelper(stove);
        hen.help();
    }
}
abstract class Helper{
    private Helper nextHelper;
    abstract void sendMessage();
    public void help(){
        sendMessage();
        if (nextHelper != null) nextHelper.help();
    }
    public void setNextHelper(Helper nextHelper) {
        this.nextHelper = nextHelper;
    }
}
class Hen extends Helper{
    @Override
    void sendMessage() {
        System.out.println("Курица - корове: дай маслица.");
    }
}
class Cow extends Helper{

    @Override
    void sendMessage() {
        System.out.println("Корова - косорям: дайте сена");
    }
}
class Mowers extends Helper{

    @Override
    void sendMessage() {
        System.out.println("Косари - печке: дай калачей.");
    }
}
class Stove extends Helper{

    @Override
    void sendMessage() {
        System.out.println("Печка - дровосеку: дай дров.");
    }
}
