package com;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;

import com.Entitas.Enemy;
import com.Entitas.Player;

public class Main {
    public static void main(String[] args) throws Exception {
        
        ArrayList<String> bantal = new ArrayList<String>();

        bantal.add("merah");
        bantal.add("kuning");

        Scanner inputUser = new Scanner(System.in);

        show_list(bantal);

        System.out.print("Masukkan nama pemain : ");
        String name = inputUser.next();
        System.out.print("Masukkan kekuatan player : ");
        int strength = inputUser.nextInt();
        System.out.print("Masukkan nyawa player : ");
        int health = inputUser.nextInt();

        Player player1 = new Player(name, strength, health);

        while (true) {

            System.out.println("1. Masukkan warna bantal");
            System.out.println("2. Hapus warna bantal");
            System.out.println("3. Update warna bantal");
            System.out.println("4. Lanjut bertarung");
            System.out.print("Pilih salah satu : ");
            int userChoice = inputUser.nextInt();

            if (userChoice == 1) {

                show_list(bantal);
                System.out.println("Masukkan warna bantal : ");
                String colourInput = inputUser.next();
                bantal.add(colourInput);
                show_list(bantal);
                
            }
            else if (userChoice == 2) {

                show_list(bantal);
                System.out.print("Masukkan warna bantal yang ingin dihapus : ");
                String colourInput = inputUser.next();

                bantal.remove(colourInput);
                show_list(bantal);
            
            }

            else if(userChoice == 3) {
                
                show_list(bantal);
                System.out.print("Masukkan warna bantal yang ingin diubah : ");
                String colourToUpdate = inputUser.next();

                System.out.print("Masukkan warna yang baru : ");
                String colourInput = inputUser.next();

                ListIterator<String> iterator = bantal.listIterator();
                while (iterator.hasNext()) {
                    String next = iterator.next();
                    if (next.equals(colourToUpdate)) {
                        //Replace element
                        iterator.set(colourInput);
                    }
                show_list(bantal);
        }
            }
            else if (userChoice == 4) {

                System.out.println("Generating enemy...");
                Thread.sleep(2000);

                Enemy enemy1 = new Enemy();

                enemy1.show_stats();
                
                while (true) {

                    System.out.println("\n1. Pukul");
                    System.out.println("2. Lempar");
                    System.out.print("Pilih serangan : ");
                    int attack = inputUser.nextInt();
                    if (attack == 1) {
                        player1.hitPillow(enemy1);
                    }
                    else if (attack == 2) {
                        player1.throwPillow(enemy1);
                    }

                    enemy1.attacking(player1);

                    if (player1.get_health() == 0 && enemy1.get_health() == 0 ) {
                        System.out.println("Seri..");
                        break;
                    }
                    if (player1.get_health() == 0) {
                        System.out.println("Anda telah kalah");
                        break;
                    }
                    else if (enemy1.get_health() == 0) {
                        System.out.println("Anda menang!");
                        break;
                    }
                }
                
            }

            System.out.print("Lagi ? (y/n) : ");
            String again = inputUser.next();
            if (again.equals("n")) {
                break;
            }
        }

    }

    public static final void show_list(ArrayList<String> list){
        
        for (String item : list) {
            System.out.println("Warna bantal : " + item);
        }
    }
}
