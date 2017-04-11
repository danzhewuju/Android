package usst.sqlite;

import android.Manifest;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements LocationListener {
    static final String db_name = "testDB";
    static final String tb_name = "GPS";
    String latitude,longtitude, altitude;
     EditText editText;
    TextView txv,txv1;
    SQLiteDatabase db;


    static final int MIN_TIME = 5000;
    static final int MIN_DIST = 50;
    LocationManager mgr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txv = (TextView) findViewById(R.id.textView2);
        txv1 = (TextView) findViewById(R.id.txv1);
        mgr = (LocationManager) getSystemService(LOCATION_SERVICE);
        editText= (EditText) findViewById(R.id.editText2);

    }

    @Override
    public void onResume() {
        super.onResume();
        String best = mgr.getBestProvider(new Criteria(), true);
        if (best != null) {
            txv.setText("正在获取定位信息......");

            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return;
            }
            mgr.requestLocationUpdates(best, MIN_TIME, MIN_DIST, this);//注册位置更新事件
        }
        else{
            txv.setText("请开启定位功能！");
        }
    }


    @Override
    public void onLocationChanged(Location location) {//位置更新
        String str="定位提供者:"+location.getProvider();
        str+="\n"+"纬度："+location.getLatitude()+"\n经度："+location.getLongitude()+"\n高度："+location.getAltitude()+"米\n";
        txv.setText(str);
        latitude= String.valueOf(location.getLatitude()) ;
        longtitude= String.valueOf(location.getLongitude()) ;
        altitude=String.valueOf(location.getAltitude()) ;


    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }


    public void open_DB()
    {
        db=openOrCreateDatabase(db_name,Context.MODE_PRIVATE,null);
    }


public void Createdatabase(View v)
{
    open_DB();
String name=editText.getText().toString();
    String Createtable="create table IF NOT EXISTS "+tb_name+" (id integer primary key AUTOINCREMENT not null ,location varchar,longtitude varchar,latitude varchar,altitude varchar)";
    db.execSQL(Createtable);
    ContentValues cv=new ContentValues();
    cv.put("location",name);
    cv.put("latitude",latitude);
    cv.put("longtitude",longtitude);
    cv.put("altitude",altitude);

    long l=db.insert(tb_name,null,cv);
    Toast.makeText(MainActivity.this,"定位成功"+l,Toast.LENGTH_LONG).show();
    db.close();
    editText.setText("");
    onResume();

}
public void loadoutdata(View v)
{open_DB();

    Cursor c=db.rawQuery("select * from "+tb_name,null);
    String str=null;

    if(c.getCount()==0)
    {
        Toast.makeText(this,"当前没有数据",Toast.LENGTH_LONG).show();
    }
    else
    {
        if(c.moveToFirst())
        {
            do {
                str+="地点："+c.getString(1)+"\n";
                str+="纬度："+c.getString(3)+"\n";
                str+="经度："+c.getString(2)+"\n";
                str+="海拔："+c.getString(4)+"\n";
            }while(c.moveToNext());
        }
        txv1.setText(str);
    }

    db.close();
}
public  void deleteTable(View v)
{
    open_DB();
    String str="delete from "+tb_name;
    db.execSQL(str);
    Toast.makeText(this,"数据已经删除！",Toast.LENGTH_LONG).show();
    txv1.setText("");
}


}

