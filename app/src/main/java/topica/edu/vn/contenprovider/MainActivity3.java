package topica.edu.vn.contenprovider;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity3 extends AppCompatActivity {
    ListView lvTinNhan;
   ArrayList<String>dsTinNhan;
   ArrayAdapter<String>adapterTinNhan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        addcontrols();
        addEvents();
        showallSmsFromDevice();
    }

    private void showallSmsFromDevice() {
        Uri uri= Uri.parse("content://sms//inbox");
        Cursor cursor=getContentResolver().query(uri,null,null,null,null);
        dsTinNhan.clear();
        while (cursor.moveToNext())
        {
            int vtPhone=cursor.getColumnIndex("address");
            int vtDate=cursor.getColumnIndex("date");
            int indexBody=cursor.getColumnIndex("body");


            String phoneNumBer=cursor.getString(vtPhone);
            String time=cursor.getColumnName(vtDate);
            String body=cursor.getString(indexBody);

            dsTinNhan.add(phoneNumBer+"\n"+time+"\n"+body);
        }
        adapterTinNhan.notifyDataSetChanged();
    }

    private void addEvents() {

    }

    private void addcontrols() {
        lvTinNhan=findViewById(R.id.lvTinNhan);
        dsTinNhan=new ArrayList<>();
        adapterTinNhan=new ArrayAdapter<>(MainActivity3.this, android.R.layout.simple_list_item_1,dsTinNhan);
        lvTinNhan.setAdapter(adapterTinNhan);
    }
}