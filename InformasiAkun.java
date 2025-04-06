import java.util.Scanner;//import library agar pengguna dapat menginput

public class InformasiAkun {
    private Scanner input = new Scanner(System.in);

    //Mendeklrasikan variabel
    //Menyimpan saldo awal masing masing pelanggan
    private int saldoNanda = 100000;
    private int saldoNindi = 200000;
    private int saldoNando = 300000;
    //Menyimpan nomor pelanggan yang dimasukkan nantinya, dan nama pelanggan berdasarkan nomor
    private String nomorPelanggan;
    private String nama;
    //Saldo minimal digunakan sebagai penanda apakah setelah transaksi saldo masih diatas 10.000
    private boolean saldoMinimal = true;

    //Getter digunakan untuk mengambil nilai dari variabel private
    public int getSaldoNanda() {
        return saldoNanda;
    }

    public int getSaldoNindi() {
        return saldoNindi;
    }

    public int getSaldoNando() {
        return saldoNando;
    }

    public String getNomorPelanggan() {
        return nomorPelanggan;
    }

    public String getNama() {
        return nama;
    }

    public boolean getSaldoMinimal() {
        return saldoMinimal;
    }

    //Setter digunakan untuk mengubah nilai atau memasukkan data ke variabel yang sudah ditentukan
    public void setNomorPelanggan(String nomor) {
        nomorPelanggan = nomor;
    }

    private void setNama(String n) {
        this.nama = n;
    }

    private void setSaldoNanda (int saldo) {
        this.saldoNanda = saldo;
    }

    private void setSaldoNindi (int saldo) {
        this.saldoNindi = saldo;
    }

    private void setSaldoNando (int saldo) {
        this.saldoNando = saldo;
    }
    
    private void setSaldoMinimal(boolean minimal) {
        this.saldoMinimal = minimal;
    }

    //Method cekSlado dengan 3 parameter dimana bersifat private yang hanya bisa digunakan didalam class method berada
    //Digunakan untuk mengecek apakah saldo cukup atau tidak membeli barang
    private void cekSaldo(int saldo, int hargaBarang, int no) {
        if (saldo < 10000) { //Mengeek saldo saat ini kurang dar 10.000 atau tidal jika kurang maka tidak bisa melakukan transaksi
            System.out.println("[[CARD DECLINED!!] Pastikan saldo anda lebih dari harga barang yang ingin anda beli]");
            //Menggunakan Switch Case dengan mengembalikan daldo yang sudah terpotong jika sebelumnya sudah dikurangi
            //misal Nanda ingin membeli barang dengan harga 100.000 dan saldonya sudah dikurngi jika setelah dikurangi
            //saldonya kurang dari 10.000 maka uang 100.000 tersebut akan dikembalikan
            switch (no) {
                case 1:
                    setSaldoNanda(getSaldoNanda() + hargaBarang);
                    break;
                case 2:
                    setSaldoNindi(getSaldoNindi() + hargaBarang);
                    break;
                case 3:
                    setSaldoNando(getSaldoNando() + hargaBarang);
                    break;
            }
            setSaldoMinimal(false);// Transaksi gagal dengan syarat yang tidak terpenuhi
        }
    }

    //Mengecek nomor pelanggan yang diinputkan misalkan 3812345678
    //jika cocok maka pelanggan akan dikenlai sebagai Nanda Pratama
    public void cekNomorPelanggan() {
        switch (getNomorPelanggan()) {
            case "3812345678" -> {//tanda panah -> digunakan untuk pengganti titik 2 atau simbol modern dimana tidak perlu break dan otomatis keluar
                //Mengset nama menjadi Nanda Pratama dan menampilkan Menu Pilihan yakni pembelian dan top up yang disimpan dalam variabel tujuan
                setNama("Nanda Pratama");
                System.out.println("Halo " + getNama() + " saldo pada rekening anda saat ini : Rp." + getSaldoNanda());
                System.out.println("[Apa yang ingin anda lakukan :] \n[1. Pembelian]\n[2. Top up]");
                int tujuan = input.nextInt();
                //Jika pelanggan memilih 1 maka akan lanjut ke menu pembelian barang dengan menampilkan barang yang dapat dibeli
                switch (tujuan) {
                    case 1:
                        System.out.println("[Apa yang ingin anda beli]");
                        System.out.println("[1. Handphone [Rp.5.000.000]]");
                        System.out.println("[2. Leptop [Rp.12.500.000]]");

                        int Beli = input.nextInt();
                        switch (Beli) {
                            case 1:
                                if(getSaldoNanda() >= 5000000) { //Mengecek apakah saldo cukup untuk membeli handphone
                                    setSaldoNanda(getSaldoNanda() - 5000000);//Saldo dikurangi 5 juta dan memanggil atau menjalankan cekSaldo() untuk memastikan setelah pembelian saldo tidak kurang dari 10 rb
                                    cekSaldo(getSaldoNanda(), 5000000, 1);
                                    // Jika saldo masih aman atau mengembalikan nilai true maka pembelian berhasil
                                    if (getSaldoMinimal()) {
                                        System.out.println("Handphone didapatkan");
                                    }
                                    //Menambahkan cashback sebesar 5% sebagai pelanggan jenis silver dari 5 juta lalu saldo ditambahkan dengan jumlah cashback
                                    int cashback = 5000000 * 5 / 100;
                                    setSaldoNanda(getSaldoNanda() + cashback);
                                    System.out.println("Anda juga mendapatkan cashback sebesar Rp." + cashback);
                                    setSaldoMinimal(true);//Setelah proses selesai, flag saldoMinimal diatur ke true kembali agar sistem tahu saldo dalam keadaan normal
                                    break;
                                } else {//Jika saldo kurang dari 5 juta maka akan menampilkan pesan gagal membeli
                                    System.out.println("Saldo anda tidak mencukupi");
                                    break;
                                }
                            case 2:
                            if(getSaldoNanda() >= 12500000) {
                                setSaldoNanda(getSaldoNanda() - 12500000);
                                cekSaldo(getSaldoNanda(), 12500000, 1);
                                if (getSaldoMinimal()) {
                                    System.out.println("Leptop didapatkan");
                                }
                                int cashback = 12500000 * 5 / 100;
                                setSaldoNanda(getSaldoNanda() + cashback);
                                System.out.println("Anda juga mendapatkan cashback sebesar Rp." + cashback);
                                setSaldoMinimal(true);
                                break;
                            } else {
                                System.out.println("Saldo anda tidak mencukupi");
                                break;
                            }
                        }
                        break;
                    //Jika pengguna memilih 2 maka akan masuk ke case 2
                    case 2:
                        System.out.println("Masukkan jumlah top up yang diinginkan :");
                        int topup = input.nextInt();//Memasukkan banyaknya uang yang ingin di top up
                        setSaldoNanda(getSaldoNanda() + topup); //Misal pada Nanda disini mengambil saldo Nanda(getSaldoNanda) lalu ditambahkan dengan nilai top up
                        //SetSaldoNanda akan menyimpan saldo yang sudah ditambahkan
                        System.out.println("Anda berhasil top up sebesar " + topup);
                        break;
                }
            }
            case "5612345678" -> {
                setNama("Nindi Pratiwi");
                System.out.println("Halo " + getNama() + " saldo pada rekening anda saat ini : Rp." + getSaldoNindi());
                System.out.println("Apa yang ingin anda lakukan : \n1. Pembelian\n2. Top up");
                int tujuan = input.nextInt();

                switch (tujuan) {
                    case 1:
                        System.out.println("Apa yang ingin anda beli");
                        System.out.println("1. Handphone [Rp.5.000.000]");
                        System.out.println("2. Leptop [Rp.12.500.000]");

                        int Beli = input.nextInt();
                        switch (Beli) {
                            case 1:
                                if(getSaldoNindi() >= 5000000) {
                                    setSaldoNindi(getSaldoNindi() - 5000000);
                                    cekSaldo(getSaldoNindi(), 5000000, 1);
                                    if (getSaldoMinimal()) {
                                        System.out.println("Handphone didapatkan");
                                    }
                                    int cashback = 5000000 * 7 / 100; //Mendapatkan cashback sebesar 7% sebagai pelanggan jenis gold
                                    setSaldoNindi(getSaldoNindi() + cashback);
                                    System.out.println("Anda juga mendapatkan cashback sebesar Rp." + cashback);
                                    setSaldoMinimal(true);
                                    break;
                                } else {
                                    System.out.println("Saldo anda tidak mencukupi");
                                    break;
                                }
                            case 2:
                            if(getSaldoNindi() >= 12500000) {
                                setSaldoNindi(getSaldoNindi() - 12500000);
                                cekSaldo(getSaldoNindi(), 12500000, 1);
                                if (getSaldoMinimal()) {
                                    System.out.println("Leptop didapatkan");
                                }
                                int cashback = 12500000 * 7 / 100;
                                setSaldoNindi(getSaldoNindi() + cashback);
                                System.out.println("Anda juga mendapatkan cashback sebesar Rp." + cashback);
                                setSaldoMinimal(true);
                                break;
                            } else {
                                System.out.println("Saldo anda tidak mencukupi");
                                break;
                            }
                        }
                        break;
                    case 2:
                        System.out.println("Masukkan jumlah top up yang diinginkan :");
                        int topup = input.nextInt();
                        setSaldoNindi(getSaldoNindi() + topup);
                        System.out.println("Anda berhasil top up sebesar " + topup);
                        break;
                }
            }
            case "7412345678" -> {
                setNama("Nando Prakoso");
                System.out.println("Halo " + getNama() + " saldo pada rekening anda saat ini : Rp." + getSaldoNando());
                System.out.println("Apa yang ingin anda lakukan : \n1. Pembelian\n2. Top up");
                int tujuan = input.nextInt();

                switch (tujuan) {
                    case 1:
                        System.out.println("Apa yang ingin anda beli");
                        System.out.println("1. Handphone [Rp.5.000.000]");
                        System.out.println("2. Leptop [Rp.12.500.000]");

                        int Beli = input.nextInt();
                        switch (Beli) {
                            case 1:
                                if(getSaldoNando() >= 5000000) {
                                    setSaldoNando(getSaldoNando() - 5000000);
                                    cekSaldo(getSaldoNando(), 5000000, 1);
                                    if (getSaldoMinimal()) {
                                        System.out.println("Handphone didapatkan");
                                    }
                                    int cashback = 5000000 * 10 / 100; //Mendapat cashback 10% sebagai pelanggan platinum
                                    setSaldoNando(getSaldoNando() + cashback);
                                    System.out.println("Anda juga mendapatkan cashback sebesar Rp." + cashback);
                                    setSaldoMinimal(true);
                                    break;
                                } else {
                                    System.out.println("Saldo anda tidak mencukupi");
                                    break;
                                }
                            case 2:
                            if(getSaldoNando() >= 12500000) {
                                setSaldoNando(getSaldoNando() - 12500000);
                                cekSaldo(getSaldoNando(), 12500000, 1);
                                if (getSaldoMinimal()) {
                                    System.out.println("Leptop didapatkan");
                                }
                                int cashback = 12500000 * 10 / 100;
                                setSaldoNando(getSaldoNando() + cashback);
                                System.out.println("Anda juga mendapatkan cashback sebesar Rp." + cashback);
                                setSaldoMinimal(true);
                                break;
                            } else {
                                System.out.println("Saldo anda tidak mencukupi");
                                break;
                            }
                        }
                        break;
                    case 2:
                        System.out.println("Masukkan jumlah top up yang diinginkan :");
                        int topup = input.nextInt();
                        setSaldoNando(getSaldoNando() + topup);
                        System.out.println("Anda berhasil top up sebesar " + topup);
                        break;
                }
            }
            //Default merupakan struktur dari switch dimana berfungsi jika tidak ada case yang cocok maka default akan dijalankan
            default -> System.out.println("Nomor anda tidak terdaftar");
        }
    }
}


