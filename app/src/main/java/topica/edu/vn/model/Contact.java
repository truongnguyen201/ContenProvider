package topica.edu.vn.model;

import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.Serializable;
import java.util.ArrayList;

public class Contact implements Serializable {
   private String ten;
   private  String phone;

    public Contact(String ten, String phone) {
        this.ten = ten;
        this.phone = phone;
    }

    public Contact() {
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return this.ten+"-"+this.phone;
    }
}
