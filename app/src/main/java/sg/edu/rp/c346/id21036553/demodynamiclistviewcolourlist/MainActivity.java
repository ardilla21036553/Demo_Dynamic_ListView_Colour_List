package sg.edu.rp.c346.id21036553.demodynamiclistviewcolourlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> alColours;
    ArrayAdapter<String> aaColours;
    EditText etElement, etIndexElement;
    Button btnAdd, btnRemove, btnUpdate;
    ListView lvColour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etElement = findViewById(R.id.editTextColour);
        etIndexElement = findViewById(R.id.etIndexElement);
        btnAdd = findViewById(R.id.buttonAddItem);
        btnRemove = findViewById(R.id.buttonRemove);
        btnUpdate = findViewById(R.id.buttonUpdate);
        lvColour = findViewById(R.id.listViewColour);

        alColours = new ArrayList<>();
        alColours.add("Red");
        alColours.add("Orange");

        //array adapters
        aaColours = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,alColours);
        lvColour.setAdapter(aaColours);

        //button add
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              String colour = etElement.getText().toString();
          //    aaColours.add(colour);
                int pos = Integer.parseInt(etIndexElement.getText().toString());
                alColours.add(pos,colour);
              aaColours.notifyDataSetChanged();
            }
        });

        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = Integer.parseInt(etIndexElement.getText().toString());
                alColours.remove(pos);
                aaColours.notifyDataSetChanged();
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String colour = etElement.getText().toString();
                int pos = Integer.parseInt(etIndexElement.getText().toString());
                alColours.set(pos, colour);
                aaColours.notifyDataSetChanged();
            }
        });


        lvColour.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String colour = alColours.get(position);
                Toast.makeText(MainActivity.this, colour, Toast.LENGTH_LONG).show();
            }
        });



    }
}