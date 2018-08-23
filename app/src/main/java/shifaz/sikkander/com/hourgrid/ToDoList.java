package shifaz.sikkander.com.hourgrid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class ToDoList extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener{

    private EditText itemET;
    private Button btn;
    private ListView itemsList;

    private String tempString = "";
    private int pos;

    private ArrayList<String> items;                                                                // arraylist for items
    private ArrayAdapter<String> adapter;                                                           // help fill in lists

    RadioGroup radioGroup;
    RadioButton radioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_do_list);

        itemET = (EditText)findViewById(R.id.item_edit_text);
        btn = (Button)findViewById(R.id.add_btn);
        itemsList = (ListView)findViewById(R.id.items_list);

        items = FileHelper.readData(this);                                                   // get items from file
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items);      // get all data from above list
        itemsList.setAdapter(adapter);                                                              // display in list

        radioGroup = (RadioGroup)findViewById(R.id.radioGroup);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.add_btn:
                        if (tempString != "") {                                                     // check for editing item
                            String itemEntered = itemET.getText().toString();

                            String priorityEntered = radioButton.getText().toString();

                            adapter.add(itemEntered + " ->> " + priorityEntered.toUpperCase());
                            itemET.setText("");

                            items.remove(pos);                                                      // delete old item (at that position)
                            adapter.notifyDataSetChanged();

                            FileHelper.writeData(items, ToDoList.this);                  // write the data to file once clicked
                            Toast.makeText(ToDoList.this, "Item Added", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            String itemEntered = itemET.getText().toString();

                            String priorityEntered = radioButton.getText().toString();

                            adapter.add(itemEntered + " ->> " + priorityEntered.toUpperCase());
                            itemET.setText("");                                                     // clear entry field after added item
                            FileHelper.writeData(items, ToDoList.this);
                            Toast.makeText(ToDoList.this, "Item Added", Toast.LENGTH_SHORT).show();
                            break;
                        }
                }
            }
        });

        itemsList.setOnItemClickListener(this);
        itemsList.setOnItemLongClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {         // EDIT items
        itemET.setText(items.get(position));                                                        // set edit text to item
        itemET.setSelection(itemET.getText().length());                                             // set cursor to end of word, get the text length in the text edit

        tempString = items.get(position);                                                           // where within the list
        pos = position;                                                                             // set variable to that position
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long id) {  // DELETE items
        items.remove(position);                                                                     // remove item from where clicked
        adapter.notifyDataSetChanged();                                                             // update adapter
        FileHelper.writeData(items, this);                                                   // updates list when items are deleted
        Toast.makeText(this, "Delete", Toast.LENGTH_SHORT).show();
        return false;
    }

    public void checkButton(View view) {                                                            // for radio buttons
        int radioId = radioGroup.getCheckedRadioButtonId();                                         // ID of radio button checked
        radioButton = findViewById(radioId);
        Toast.makeText(ToDoList.this, "Selected: " + radioButton.getText(), Toast.LENGTH_SHORT).show();
    }
}
