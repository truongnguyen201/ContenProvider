package topica.edu.vn.contenprovider;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import topica.edu.vn.model.Contact;

public class MainActivity2 extends AppCompatActivity {
    ListView lvDanhba;
    ArrayList<Contact> dsContact;
    ArrayAdapter<Contact> adapterContat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        addControls();
        addEvents();
        showAllContactfromDevice();
    }

    private void showAllContactfromDevice() {
        Uri uri= ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
        Cursor cursor=getContentResolver().query(uri,null,null,null,null);
        while (cursor.moveToNext())
        {
            String tenCotName=ContactsContract.Contacts.DISPLAY_NAME;
            String tenCotPhone=ContactsContract.CommonDataKinds.Phone.NUMBER;
            int vttenCotname=cursor.getColumnIndex(tenCotName);
            int vttencotPhone=cursor.getColumnIndex(tenCotPhone);
            String ten=cursor.getString(vttenCotname);
            String phone=cursor.getString(vttencotPhone);
            Contact contact=new Contact(ten,phone);
            dsContact.add(contact);
        }
        adapterContat.notifyDataSetChanged();
    }

    private void addEvents() {

    }

    private void addControls() {
        lvDanhba=findViewById(R.id.lvDanhBa);
        dsContact=new ArrayList();
        adapterContat=new ArrayAdapter(MainActivity2.this, android.R.layout.simple_list_item_1,dsContact);
        lvDanhba.setAdapter(adapterContat);
    }
}