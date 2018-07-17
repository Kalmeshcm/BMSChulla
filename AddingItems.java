package com.example.abc.bms_chulla;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by ABC on 06-07-2018.
 */

public class AddingItems extends AppCompatActivity {
    TextView thead, tname, ttemp, ttime;
    EditText ename, etemp, etime;

    int itemp,itime;
    Button bbtnadd;
    DatabaseHelper mydb = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        thead = (TextView) findViewById(R.id.tvhead);
        tname = (TextView) findViewById(R.id.tvname);
        ttemp = (TextView) findViewById(R.id.tvtemp);
        ttime = (TextView) findViewById(R.id.tvtime);
        ename = (EditText) findViewById(R.id.etname);
        etemp = (EditText) findViewById(R.id.ettemp);
        etime = (EditText) findViewById(R.id.ettime);
        bbtnadd = (Button) findViewById(R.id.btnadd);


        bbtnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!ename.getText().toString().equals("") && !etemp.getText().toString().equals("")&&!etime.getText().toString().equals("") ) {
                    boolean res = mydb.insertData(ename.getText().toString(), etemp.getText().toString(), etime.getText().toString());
                    if (res) {
                        Toast.makeText(AddingItems.this, ename.getText().toString() + "," + etemp.getText().toString() + "," + etime.getText().toString(), Toast.LENGTH_SHORT).show();
                        Toast.makeText(AddingItems.this, "Dish added Successfully", Toast.LENGTH_SHORT).show();
                    } else
                        Toast.makeText(AddingItems.this, "Something went wrong", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(AddingItems.this, "Parameters are Null", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}


