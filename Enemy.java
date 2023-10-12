package com.Entitas;
import java.util.concurrent.ThreadLocalRandom;

public final class Enemy{

    private final String name;
    private final int strength;
    private int health;

    public Enemy(){
        this.name = "Musuh";
        this.strength = ThreadLocalRandom.current().nextInt(100, 199 + 1);
        this.health = ThreadLocalRandom.current().nextInt(1000, 2999 + 1);
    }

    public final void show_stats(){
        System.out.println("Nama musuh : " + this.name);
        System.out.println("Kekuatan : " + this.strength);
        System.out.println("HP : " + this.health);
    }

    public final int get_health() {
        return this.health;
    }

    public final void set_health(int health) {
        this.health = health;
    }

    public final void hitPillow(Player player){
        System.out.println("\nMusuh memukul dengan bantal...");
        int healthReduction = player.get_health() - 300 + (int)(this.strength * 0.2);
        player.set_health(healthReduction);
        if (player.get_health() < 0) {
            player.set_health(0);
        }
        System.out.println("Nyawa anda : " + player.get_health());
    }

    public final void throwPillow(Player player){
        System.out.println("Musuh melempar dengan bantal...");
        int healthReduction = player.get_health() - 450 + (int)(this.strength * 0.5);
        player.set_health(healthReduction);
        if (player.get_health() < 0) {
            player.set_health(0);
        }
        System.out.println("Nyawa anda : " + player.get_health());
    }

    public final void attacking(Player player) {

        int random = ThreadLocalRandom.current().nextInt(1, 1 + 1);

        if (random == 1) {
            this.hitPillow(player);
        }
        else if (random == 2) {
            this.throwPillow(player);
        } 
    }
    
}
