package com.company.itStep;
//Шаблон проектирования Адаптер

public class Adapter {
    public static void main(String[] args) {
        Well well = new DogWell();
        well.makeEcho("Hey");
        System.out.println("Water: "+well.getWater());
        well = new VeilWisBucket();
        well.makeEcho("Uu");
        System.out.println("Water: "+well.getWater());

    }
}

interface Well {
    public double getWater();
    void makeEcho(String call);
}

class DogWell implements Well{

    @Override
    public double getWater() {
        return 0;
    }

    @Override
    public void makeEcho(String call) {
        System.out.println(call+"-"+call+call);
    }

    private double vote = 1000;
}
class Bucket{
    public double value = 10;
    public void feel(){
        System.out.println("Filling the bucket with water");
    }
    public void emptying(){
        System.out.println("Pouring water");
    }
}

class VeilWisBucket implements Well{

    private Bucket bucket = new Bucket();


    @Override
    public double getWater() {
        bucket.feel();
        bucket.emptying();
        return bucket.value;
    }

    @Override
    public void makeEcho(String call) {
        System.out.println(call+"-"+call+call);
    }
}
