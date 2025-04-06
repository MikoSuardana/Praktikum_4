import java.util.Scanner;

public class Swalayan {
    public static void main(String[] args) {

    Scanner input = new Scanner(System.in);
    InformasiAkun info = new InformasiAkun();//Mmebuat objek baru dengan nama info yang dapat memanggil method yang ada di kelas InformasiAkun
    //Mendeklarasikan variabel
    String nomorATM;
    //3 Variabel yang awalnya di set false atau belum diblokir
    boolean NandaBlokir = false;
    boolean NindiBlokir = false;
    boolean NandoBlokir = false;
        
        //Perupalangan tanapa henti (infinite loop) akan terus berjalan selama belum dihentikan
        while(true){
            System.out.println("[Masukkan nomor ATM anda:]");
            nomorATM = input.nextLine(); //Memasukkan no atm dan menyimpan inputan ke variabel nomorATM

            switch (nomorATM) {//Mengecek apakah nomor atm sesuai dengan apa yang diinputkan user
                case "3812345678":
                {
                    //Mengecek apakah akun Nanda sudah diblokir Jika NandaBlokir bernilai true, maka tampilkan pesan bahwa nomor diblokir
                    // dan di break untuk keluar dari case dan kembali ke perulangan awal
                    if(NandaBlokir){
                        System.out.println("[Maaf nomor ini sedang terblokir!!]\n");
                        break;
                    }
                    System.out.println("[Masukkan PIN anda] ");
                    String pin;
                    byte cekKesalahan = 0;//dibuat untuk menghitung berapa kali user salah memasukkan PIN
                    //Perulangan kedua, untuk memberi kesempatan berulang kali memasukkan PIN hingga benar atau salah 3 kali
                    while(true){
                        pin = input.nextLine();
                        if (pin.equals("11111")){//jika pin dimasukkan sesuai pin milik Nanda yakni 1111 makan akan set nomonor pelanggan pada objek info
                            info.setNomorPelanggan("3812345678");
                            info.cekNomorPelanggan();
                            break;
                        } else {
                            System.out.println("[pin salah!!!!]");
                            cekKesalahan++;//Jika pin salah makan akan bertambah 1 pada cekKesalahan
                            if(cekKesalahan >= 3){//Jika salah 3 kali maka nilai NandaBlokir akan berubah menjadi true yang artinya diblokir
                                System.out.println("[Nomor anda telah di blokir]");
                                NandaBlokir = true;
                                break;//Keluar dari perulangan pin
                            }
                        }
                    }
                } break;
                case "5612345678":
                {
                    if(NindiBlokir){
                        System.out.println("[Maaf nomor ini sedang terblokir!!]\n");
                        break;
                    }
                    System.out.println("[Masukkan PIN anda] ");
                    String pin;
                    byte cekKesalahan = 0;
                    while(true){
                        pin = input.nextLine();
                        if (pin.equals("22222")){
                            info.setNomorPelanggan("5612345678");
                            info.cekNomorPelanggan();
                            break;
                        } else {
                            System.out.println("[pin salah!!!!]");
                            cekKesalahan++;
                            if(cekKesalahan >= 3){
                                System.out.println("[Nomor anda telah di blokir]");
                                NandaBlokir = true;
                                break;
                            }
                        }
                    }
                } break;
                case "7412345678":
                {
                    if(NandoBlokir){
                        System.out.println("[Maaf nomor ini sedang terblokir!!]\n");
                        break;
                    }
                    System.out.println("[Masukkan PIN anda] ");
                    String pin;
                    byte cekKesalahan = 0;
                    while(true){
                        pin = input.nextLine();
                        if (pin.equals("33333")){
                            info.setNomorPelanggan("7412345678");
                            info.cekNomorPelanggan();
                            break;
                        } else {
                            System.out.println("[pin salah!!!!]");
                            cekKesalahan++;
                            if(cekKesalahan >= 3){
                                System.out.println("[Nomor anda telah di blokir]");
                                NandaBlokir = true;
                                break;
                            }
                        }
                    }
                } break;
                //Jika mengetikkan exit maka program akan keluar secara total dan berhenti bekerja
                case "exit":
                    System.exit(0);
                    default:
                    System.out.println("[Nomor anda tidak terdaftar]");
            }
        }
    }
}