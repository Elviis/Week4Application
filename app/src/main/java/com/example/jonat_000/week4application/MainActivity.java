package com.example.jonat_000.week4application;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    //create variables
    EditText number1;
    EditText number2;
    TextView result;
    Button submitBtn;
    Spinner spinner;
    String mode;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);




        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        //link variables to xml
        number1 = (EditText)findViewById(R.id.editText_TextNum1);
        number2 = (EditText)findViewById(R.id.editTextTextNum2);
        submitBtn = (Button)findViewById(R.id.button);
        result = (TextView)findViewById(R.id.textView);
        listView = (ListView)findViewById(R.id.listView);
        String[]cities = new String[] {"Toronto", "Mississauga", "Brampton" };
        ArrayAdapter listAdapter = new ArrayAdapter<String>(this, android.R.Layout.simple_list_item_1, cities);



        spinner = (Spinner)findViewById(R.id.spinner2);
//we can now read the values from the above items


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.mode,android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        //click listener added here
        submitBtn.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){

        String num1 = number1.getText().toString();
                String num2 = number2.getText().toString();
                int total=0;

                if (mode.equals("addition")){
                    total = Integer.valueOf(num1) + Integer.valueOf(num2);
                }else{
                    total = Integer.valueOf(num1) * Integer.valueOf(num2);
                }
                result.setText("Total = " + total );
            }

        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        //give selected item
        String item = parent.getItemAtPosition(position).toString();
        Toast.makeText(this,"Select Item ="+item, Toast.LENGTH_LONG);
        if(item.equals("Addition")){
            mode = "Addition";
        }else{
            mode="Multiplication";
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
