package net.khe.homeWorks.homework4;
import static net.khe.util.Print.*;

import net.khe.util.CollectionData;
import net.khe.util.Factory;
import net.khe.util.Generator;
import net.khe.util.EnumRandom;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by hyc on 2016/10/16.
 */
class Animal {
    private String name;
    private int legs;
    public Animal(){
        name = "AAA";
        legs = 4;
    }
    public Animal(String name, int legs){
        this.name = name;
        this.legs = legs;
    }
    public String getName(){return name;}
    public int getLegs(){return legs;}
    public void setName(String name){this.name = name;}
    public void setLegs(int legs){this.legs = legs;}
    public void move(){println(getName()+" Moving!");}
    public void move(int time){
        for(int i=0;i<time;++i){
            move();
        }
    }
    @Override
    public String toString(){
        String message =
                getClass().getSimpleName()+
                        ": "+
                        getName()+"\n"+
                        "Leg: "+getLegs();
        return message;
    }
    public static class RandomGenerator implements Generator<Animal> {
        //Animal 生成器,生成随机名称和种类的动物
        private enum AnimalType{
            FISH(Fish.getFactory()),
            BIRD(Bird.getFactory());
            private Factory<? extends Animal> factory;
            private AnimalType(Factory<? extends Animal> factory){
                this.factory = factory;
            }
            public Animal newInstance(){
                return factory.create();
            }
        }
        //private static Random rand = new Random();
        @Override
        public Animal next(){
            Generator<String> sg = new net.khe.util.RandomGenerator.String();
            String name = sg.next();
            Animal animal = EnumRandom.random(AnimalType.class).newInstance();
            animal.setName(name);
            return animal;
        }
    }
}
class Fish extends Animal {
    public Fish(){super();setLegs(0);}
    public Fish(String name){
        super(name,0);
    }
    @Override
    public void move(){println(getName()+" Swimming!");}
    public static Factory<Fish> getFactory(){
        return new Factory<Fish>() {
            @Override
            public Fish create() {
                return new Fish();
            }
        };
    }

}
class Bird extends Animal {
    public Bird(){super();setLegs(2);}
    public Bird(String name){
        super(name,2);
    }
    @Override
    public void move(){println(getName()+" Flying!");}
    public static Factory<Bird> getFactory(){
        return new Factory<Bird>() {
            @Override
            public Bird create() {
                return new Bird();
            }
        };
    }
}
public class Zoo{
    public static void main(String[] args) {
        List<Animal> animals = new ArrayList<>(
                new CollectionData<Animal>(new Animal.RandomGenerator(),5)
        );//构造Animal数组并使用生成器填充
        Random rand = new Random();
        for(Animal animal:animals){
            println(animal);
            animal.move(rand.nextInt(3)+1);
        }
    }
}