package af6851.mah.se.sqlitesample;

/**
 * Created by Amar on 2016-09-22.
 */
public class Products {

    private int _id;
    private String _productname;
    public Products(){

    }

    public Products(String productname, String productage){
        this._productname = productname;
    }

    public void set_productname(String _productname) {
        this._productname = _productname;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public int get_id() {
        return _id;
    }

    public String get_productname() {
        return _productname;
    }
}
