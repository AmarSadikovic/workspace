package se.mah.af6851.ekonomiappv2;

/**
 * Created by Amar on 2016-10-11.
 */
public class Inkomst {

    private int _inkomster_id, _inkomster_belopp, _inkomster_datum;;
    private String _inkomster_titel, _inkomster_kategori;

    public Inkomst(String _inkomster_titel, String _inkomster_kategori, int _inkomster_belopp, int _inkomster_datum){
        this._inkomster_titel = _inkomster_titel;
        this._inkomster_kategori = _inkomster_kategori;
        this._inkomster_belopp = _inkomster_belopp;
        this._inkomster_datum = _inkomster_datum;
    }

    public int get_inkomster_id() {
        return _inkomster_id;
    }

    public void set_inkomster_id(int _inkomster_id) {
        this._inkomster_id = _inkomster_id;
    }

    public int get_inkomster_belopp() {
        return _inkomster_belopp;
    }

    public void set_inkomster_belopp(int _inkomster_belopp) {
        this._inkomster_belopp = _inkomster_belopp;
    }

    public String get_inkomster_titel() {
        return _inkomster_titel;
    }

    public void set_inkomster_titel(String _inkomster_titel) {
        this._inkomster_titel = _inkomster_titel;
    }

    public String get_inkomster_kategori() {
        return _inkomster_kategori;
    }

    public void set_inkomster_kategori(String _inkomster_kategori) {
        this._inkomster_kategori = _inkomster_kategori;
    }

    public int get_inkomster_datum() {
        return _inkomster_datum;
    }

    public void set_inkomster_datum(int _inkomster_datum) {
        this._inkomster_datum = _inkomster_datum;
    }
}
