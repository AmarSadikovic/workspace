package se.mah.af6851.ekonomiapplikation;

/**
 * Created by Amar on 2016-10-07.
 */
public class Inkomst {

    private int _idInkomster;
    private String _titelInkomster;
    private String _kategoriInkomster;
    private int _beloppInkomster;
    private String _datumInkomster;


    public Inkomst(){

    }
    public Inkomst(String _titelInkomster, String _kategoriInkomster, int _beloppInkomster, String _datumInkomster){
        this._titelInkomster = _titelInkomster;
        this._kategoriInkomster = _kategoriInkomster;
        this._beloppInkomster = _beloppInkomster;
        this._datumInkomster = _datumInkomster;
    }
    public void set_idInkomster(int _idInkomster) {
        this._idInkomster = _idInkomster;
    }

    public void set_titelInkomster(String _titelInkomster) {
        this._titelInkomster = _titelInkomster;
    }

    public void set_kategoriInkomster(String _kategoriInkomster) {
        this._kategoriInkomster = _kategoriInkomster;
    }

    public void set_beloppInkomster(int _beloppInkomster) {
        this._beloppInkomster = _beloppInkomster;
    }

    public void set_datumInkomster(String _datumInkomster) {
        this._datumInkomster = _datumInkomster;
    }

    public String get_datumInkomster() {
        return _datumInkomster;
    }

    public int get_idInkomster() {
        return _idInkomster;
    }

    public String get_titelInkomster() {
        return _titelInkomster;
    }

    public String get_kategoriInkomster() {
        return _kategoriInkomster;
    }

    public int get_beloppInkomster() {
        return _beloppInkomster;
    }



}
