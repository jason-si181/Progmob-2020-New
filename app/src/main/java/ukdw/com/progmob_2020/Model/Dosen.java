package ukdw.com.progmob_2020.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Dosen {
    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("nama")
    @Expose
    private String nama;

    @SerializedName("nik")
    @Expose
    private String nik;

    private String notelp;

    @SerializedName("alamat")
    @Expose
    private String alamat;

    @SerializedName("email")
    @Expose
    private String email;

    @SerializedName("foto")
    @Expose
    private String foto;

    @SerializedName("nik_progmob")
    @Expose
    private String nik_progmob;

    public Dosen(String nama, String nik, String notelp) {
        this.nama = nama;
        this.nik = nik;
        this.notelp = notelp;
    }

    public Dosen(String id, String nama, String nik, String notelp, String alamat, String email, String foto, String nik_progmob) {
        this.id = id;
        this.nama = nama;
        this.nik = nik;
        this.notelp = notelp;
        this.alamat = alamat;
        this.email = email;
        this.foto = foto;
        this.nik_progmob = nik_progmob;
    }

    public Dosen(String nama, String nik, String notelp, String alamat, String email, String foto, String nik_progmob) {
        this.nama = nama;
        this.nik = nik;
        this.notelp = notelp;
        this.alamat = alamat;
        this.email = email;
        this.foto = foto;
        this.nik_progmob = nik_progmob;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getNotelp() {
        return notelp;
    }

    public void setNotelp(String notelp) {
        this.notelp = notelp;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getNik_progmob() {
        return nik_progmob;
    }

    public void setNik_progmob(String nik_progmob) {
        this.nik_progmob = nik_progmob;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
