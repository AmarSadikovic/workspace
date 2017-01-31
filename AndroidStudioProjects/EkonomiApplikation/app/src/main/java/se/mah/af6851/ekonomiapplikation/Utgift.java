package se.mah.af6851.ekonomiapplikation;

import android.text.Editable;

/**
 * Created by Amar on 2016-09-30.
 */
public class Utgift {

    private int _id;
    private String _titel;
    private String _kategori;
    private String _pris;
    private String _datum;

    public Utgift(){

    }

    public Utgift(String _titel, String _kategori, String _pris, String _datum){
        this._titel = _titel;
        this._kategori = _kategori;
        this._pris = _pris;
        this._datum = _datum;
    }

    public void set_id(int _id){
        this._id = _id;
    }
    public int get_id(){
        return _id;
    }

    public void set_titel(String _titel){
        this._titel = _titel;
    }

    public void set_kategori(String _kategori){
        this._kategori = _kategori;
    }

    public void set_pris(String _pris){
        this._pris = _pris;
    }

    public void set_datum(String _datum){
        this._datum = _datum;
    }

    public String get_titel(){
        return _titel;
    }

    public String get_kategori(){
        return _kategori;
    }

    public String get_pris(){
        return _pris;
    }

    public String get_datum(){
        return _datum;
    }


}
