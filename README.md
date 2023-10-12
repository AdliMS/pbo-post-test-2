# pbo-post-test-2
project ini adalah project untuk tugas posttest 2 pbo.

Nama		: Adli Imam Suryadin
NIM		: 2209116096
Kelas		: Sistem Informasi B 22

# Post Test 2 PBO
Penjelasan Kode:

## 1) Player.java

        **class Player {}**
Pembuatan kelas pemain dengan nama Player.

        **private final String name;
        private final int strength;
        private int health;**
Memberi atribut untuk kelas Player, yaitu name (nama player), strength (kekuatan player) dan health (nyawa player). Keyword private digunakan agar kedua atribut tidak dapat diakses atau diubah secara langsung. Sedangkan keyword final digunakan agar atribut tersebut tidak bisa diubah dan di-override lagi selanjutnya (health tidak menggunakan final karena health akan berkurang saat nanti diserang, sehingga penggunaan keyword final tidak valid untuk atribut health).

        **public Player(String name, int strength, int health){}**
Membuat method constructor agar kita dapat langsung memberi nilai pada atribut name, strength dan health saat pembuatan (instantiating) objek.

        **public final void show_stats(){}**
Membuat method untuk menampilkan status dari player yang telah dibuat menjadi objek.

        public final int get_health(){}
Membuat method untuk mengakses atribut kelas. Method ini jika dipanggil akan mengembalikan nilai health yang bersifat private di dalam kelas.

        **public final void set_health(int health) {)**
Membuat method untuk mengubah nilai health pada objek. Method ini jika dipanggil akan menetapkan this.health (di objek) menjadi health (dari argumen pada method).

        **public final void hitPillow(Enemy enemy){}**
Membuat method untuk melakukan serangan pukulan kepada musuh. Method ini jika dipanggil akan mengurangi health musuh berdasarkan strength dari player ( enemy.get_health() - 100 + (int)(this.strength * 0.65)
). Lalu kita memanggil method set_health() di dalamnya agar health musuh tidak sampai bernilai minus dengan mengubah nilainya ke 0.

        **public final void throwPillow(Enemy enemy){}**
Membuat method untuk melakukan serangan pukulan kepada musuh. Method ini jika dipanggil akan mengurangi health musuh berdasarkan strength dari player ( enemy.get_health() - 300 + (int)(this.strength * 0.75)
). Lalu kita memanggil method set_health() di dalamnya agar health musuh tidak sampai bernilai minus dengan mengubah nilainya ke 0.

 
**## 2) Enemy.java**

Untuk file Enemy. java, atribut - atribut dan method - methodnya memiliki isi dan perilaku yang sama dengan yang ada di file Player.java sebelumnya, kecuali : 

        **public Enemy(){
        this.name = "Musuh";
        this.strength = ThreadLocalRandom.current().nextInt(100, 199 + 1);
        this.health = ThreadLocalRandom.current().nextInt(1000, 2999 + 1);
        }**
Karena kita ingin agar saat pertarungan dimulai, musuh akan memiliki atribut otomatis tanpa dimasukkan secara manual. Maka kita mengubah isi konstruktornya disini, dimana name musuh akan diinisialisasi dengan “Musuh”. Lalu strength dan health-nya kita atur agar menjadi nilai random (strength dari 100 - 200, health dari 1000 - 3000).

         **public final void hitPillow(Enemy enemy){}**
Membuat method untuk melakukan serangan pukulan kepada player. Method ini jika dipanggil akan mengurangi health player berdasarkan strength dari musuh( player.get_health() - 300 + (int)(this.strength * 0.2;
). Lalu kita memanggil method set_health() di dalamnya agar health player tidak sampai bernilai minus dengan mengubah nilainya ke 0.

        **public final void throwPillow(Player player){}**
Membuat method untuk melakukan serangan pukulan kepada player. Method ini jika dipanggil akan mengurangi health player berdasarkan strength dari musuh( player.get_health() - 450 + (int)(this.strength * 0.5)
). Lalu kita memanggil method set_health() di dalamnya agar health player tidak sampai bernilai minus dengan mengubah nilainya ke 0.

        **public final void attacking(Player player) {}**
Agar musuh bisa secara random memukul atau melempar bantal, maka kita buatkan fungsi khusus agar saat menyerang, serangannya bisa bervariasi secara otomatis. (int random = ThreadLocalRandom.current().nextInt(1, 1 + 1);)


## 3) Main.java

        **ArrayList<String> bantal = new ArrayList<String>();**
Membuat arraylist bertipe String dengan nama “bantal”.

        **bantal.add("merah");
        bantal.add("kuning");**
Agar arraylist memiliki beberapa isi, kita tambahkan warna “merah” dan “kuning” menggunakan .add().

        **Scanner inputUser = new Scanner(System.in);**
Membuat objek input agar pengguna bisa melakukan input nantinya.

        **show_list(bantal);**
Menampilkan list warna dalam arraylist bantal yang telah kita buat dan tambahkan tadi.

        **System.out.print("Masukkan nama pemain : ");
            String name = inputUser.next();
            System.out.print("Masukkan kekuatan player : ");
            int strength = inputUser.nextInt();
            System.out.print("Masukkan nyawa player : ");
            int health = inputUser.nextInt();
        Player player1 = new Player(name, strength, health);**
Meminta input name, strength, dan health dari pengguna sebagai atribut untuk objek player, lalu menginisialisasikan objek player1 dengan name, strength, dan health yang telah dimasukkan tadi.
 
        **while (true) {

            System.out.println("1. Masukkan warna bantal");
            System.out.println("2. Hapus warna bantal");
            System.out.println("3. Update warna bantal");
            System.out.println("4. Lanjut bertarung");
            System.out.print("Pilih salah satu : ");
            int userChoice = inputUser.nextInt();**
Memasuki perulangan, dan meminta input dari pengguna.

         **if (userChoice == 1) {

            show_list(bantal);
            System.out.println("Masukkan warna bantal : ");
            String colourInput = inputUser.next();
            bantal.add(colourInput);
            show_list(bantal);
              
          }**
Jika sebelumnya pengguna memasukkan nomor 1, maka pengguna akan diminta memasukkan warna bantal yang nanti akan ditambahkan ke dalam arraylist bantal.

         **else if (userChoice == 2) {

            show_list(bantal);
            System.out.print("Masukkan warna bantal yang ingin dihapus : ");
            String colourInput = inputUser.next();

            bantal.remove(colourInput);
            show_list(bantal);
        
        }**
Jika pengguna memasukkan angka 2, pengguna akan diminta memasukkan warna bantal yang ingin dihapus dari arraylist bantal. Lalu program akan menghapus bantal tersebut dari arraylistnya.

          **else if(userChoice == 3) {
              
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
              show_list(bantal);**
Jika pengguna memasukkan angka 3, maka pengguna akan diminta memasukkan warna bantal yang ingin diubah. Lalu pengguna akan diminta untuk mengubah ke warna apa. Selanjutnya program akan mengiterasi ke arraylist, menemukan warna sesuai yang pengguna mau, lalu mengubah warna tersebut dengan inputan dari pengguna.

           **else if (userChoice == 4) {

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
              
          }**

Jika pengguna memasukkan angka 4, maka pengguna bersiap bertarung sebagai player1. Program akan membuat musuh secara random dan menampilkan status musuh tersebut. Lalu akan memasuki perulangan, dimana pengguna akan diminta memilih serangan bantal, yaitu memukul atau dilempar. Jika pilih memukul, maka akan menjalankan method hitPillow() dengan enemy1 sebagai argumennya. Jika pilih dilempar, maka akan menjalankan method throwPillow() dengan enemy1 sebagai argumennya. Karena memiliki argumen enemy1, maka musuh sudah pasti akan menerima serangan dan health-nya akan berkurang. Setelah itu, musuh akan otomatis lngsung menyerang pengguna secara otomatis. Tidak lupa kita memberi pengkondisian, dimana jika health musuh mencapai 0, maka program akan mengeluarkan output “Anda menang!”. Lalu sebaliknya, jika health player mencapai 0, maka program akan mengeluarkan output “Anda kalah”. Dan jika health dari kedua sisi adalah 0 secara bersamaan, maka pertandingan berujung “Seri”.

            **System.out.print("Lagi ? (y/n) : ");
              String again = inputUser.next();
              if (again.equals("n")) {
                  break;
              }**
  Blok kode ini adalah lanjutan dari perulangan di awal. Jika ingin lanjut lagi, maka program akan mengulang dari proses CRUD bantal. Jika tidak, program akan berhenti.
public static final void show_list(ArrayList<String> list){
        
            **for (String item : list) {
              System.out.println("Warna bantal : " + item);
                }
              }**
  Lalu di akhir program adalah pendeklarasian dari fungsi untuk menampilkan isi dari arraylist (show_list()). Fungsi ini akan menerima argumen arraylist bertipe string, lalu mengiterasi dan menampilkan item - item yang ada di dalam arraylist tersebut.
