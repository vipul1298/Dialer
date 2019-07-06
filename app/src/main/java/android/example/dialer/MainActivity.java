package android.example.dialer;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button b1,b2,b3,b4,b5,b6,b7,b8,b9,bast,bzero,bhash,backs,bcall,bchat;
    TextView tv;
    String t="";
    String num="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=findViewById(R.id.one);
        b2=findViewById(R.id.two);
        b3=findViewById(R.id.three);
        b4=findViewById(R.id.four);
        b5=findViewById(R.id.five);
        b6=findViewById(R.id.six);
        b7=findViewById(R.id.seven);
        b8=findViewById(R.id.eight);
        b9=findViewById(R.id.nine);
        bast=findViewById(R.id.astc);
        bzero=findViewById(R.id.zero);
        bhash=findViewById(R.id.hash);
        tv=findViewById(R.id.text);
        backs=findViewById(R.id.backspace);
        bcall=findViewById(R.id.call);
        bchat=findViewById(R.id.msg);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tv.getText().length()>=0)
                tv.setText(tv.getText()+"1");
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tv.getText().length()>=0)
                tv.setText(tv.getText()+"2");
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tv.getText().length()>=0)
                tv.setText(tv.getText()+"3");
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tv.getText().length()>=0)
                tv.setText(tv.getText()+"4");
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tv.getText().length()>=0)
                tv.setText(tv.getText()+"5");
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tv.getText().length()>=0)
                tv.setText(tv.getText()+"6");
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tv.getText().length()>=0)
                tv.setText(tv.getText()+"7");
            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tv.getText().length()>=0)
                tv.setText(tv.getText()+"8");
            }
        });
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tv.getText().length()>=0)
                tv.setText(tv.getText()+"9");
            }
        });
        bzero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tv.getText().length()>=0)
                tv.setText(tv.getText()+"0");
            }
        });
        bast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tv.getText().length()>=0)
                tv.setText(tv.getText()+"*");
            }
        });
        bhash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tv.getText().length()>=0)
                tv.setText(tv.getText()+"#");
            }
        });

        backs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = tv.getText().toString();
                if(str.length() == 0)
                    return;
                str = str.substring(0, str.length() - 1);
                tv.setText(str);
            }
        });
        bcall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tv.getText().length()>0)
                t=tv.getText().toString();
                opencall(t);
            }
        });
        bchat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tv.getText().length()>0){
                  num=tv.getText().toString();
                openchat(num);}
            }
        });

    }
    private void opencall(String tel){
        Intent call = new Intent(Intent.ACTION_CALL);
        call.setData(Uri.parse("tel:"+tel));
        if(ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.CALL_PHONE},11);
        }
        startActivity(call);
    }
    private void openchat(String s){
        Uri uri = Uri.parse("smsto:" + s);
        Intent i = new Intent(Intent.ACTION_SENDTO, uri);
        i.putExtra(Intent.EXTRA_TEXT,"Hey There");
        startActivity(i);
    }
}



