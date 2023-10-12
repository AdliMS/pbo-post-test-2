package com.Entitas;

public final class Player {
    
    private final String name;
    private final int strength;
    private int health;

    public Player(String name, int strength, int health){
        this.name = name;
        this.strength = strength;
        this.health = health;
    }

    public final void show_stats(){
        System.err.println("Nama pemain : " + this.name);
        System.out.println("Kekuatan : " + this.strength);
        System.out.println("HP : " + this.health);
    }

    public final int get_health() {
        return this.health;
    }

    public final void set_health(int health) {
        this.health = health;
    }

    public final void hitPillow(Enemy enemy){
        System.out.println("Anda memukul dengan bantal...");
        int healthReduction = enemy.get_health() - 100 + (int)(this.strength * 0.65);
        enemy.set_health(healthReduction);
        if (enemy.get_health() < 0) {
            enemy.set_health(0);
        }
        System.out.println("Nyawa musuh : " + enemy.get_health());
    }

    public final void throwPillow(Enemy enemy){
        System.out.println("Anda melempar dengan bantal...");
        int healthReduction = enemy.get_health() - 300 + (int)(this.strength * 0.75);
        enemy.set_health(healthReduction);
        if (enemy.get_health() < 0) {
            enemy.set_health(0);
        }
        System.out.println("Nyawa musuh : " + enemy.get_health());
    }
}
