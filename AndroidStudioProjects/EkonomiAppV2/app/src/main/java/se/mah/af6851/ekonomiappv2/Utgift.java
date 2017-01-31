package se.mah.af6851.ekonomiappv2;

import java.util.Date;

/**
 * Created by Amar on 2016-10-10.
 */
public class Utgift {
    private int _id, _pris, _datum;
    private String _titel, _kategori;

    public Utgift(String _titel, String _kategori, int _pris, int _datum) {
        this._titel = _titel;
        this._kategori = _kategori;
        this._pris = _pris;
        this._datum = _datum;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public int get_pris() {
        return _pris;
    }

    public void set_pris(int _pris) {
        this._pris = _pris;
    }

    public String get_titel() {
        return _titel;
    }

    public void set_titel(String _titel) {
        this._titel = _titel;
    }

    public String get_kategori() {
        return _kategori;
    }

    public void set_kategori(String _kategori) {
        this._kategori = _kategori;
    }

    public int get_datum() {
        return _datum;
    }

    public void set_datum(int _datum) {
        this._datum = _datum;
    }
}
