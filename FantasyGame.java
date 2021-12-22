package com.company.itStep;

//Абстрактная фабрика

public class FantasyGame {
    public static void main(String[] args) {
        Barracks humanBarracks = new HumanBarracks();
        Warrior warrior = humanBarracks.createWarrior();
        warrior.attack();
    }
}

abstract class Barracks {
    public abstract Warrior createWarrior();

    public abstract Mage createMage();

    public abstract Archer createArcher();
}

interface Warrior {
    public void attack();
}

interface Mage {
    public void casting();
}

interface Archer {
    public void shot();
}

class HumanBarracks extends Barracks {

    @Override
    public Warrior createWarrior() {
        return new HumanWarrior();
    }

    @Override
    public Mage createMage() {
        return new HumanMage();
    }

    @Override
    public Archer createArcher() {
        return new HumanArcher();
    }
}

class HumanWarrior implements Warrior {
    @Override
    public void attack() {
        System.out.println("The human warrior is attacking with sword");
    }
}

class HumanMage implements Mage {

    @Override
    public void casting() {
        System.out.println("The human mage is casting a spell");
    }
}

class HumanArcher implements Archer {

    @Override
    public void shot() {
        System.out.println("The human archer is shooting");
    }
}
