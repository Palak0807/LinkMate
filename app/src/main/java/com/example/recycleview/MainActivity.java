package com.example.recycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
ArrayList<ContactModel> arrContacts=new ArrayList<>();
    RecyclerContactAdapter adapter;
    RecyclerView recyclerView;
    FloatingActionButton btnOpenDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recycleContact);
        btnOpenDialog=findViewById(R.id.btnOpenDialog);

        btnOpenDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog=new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.add_update_lay);
                EditText edtName=dialog.findViewById(R.id.edtName);
                EditText edtNumber=dialog.findViewById(R.id.edtNumber);
                Button btnAction=dialog.findViewById(R.id.btnAction);
                btnAction.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String name="",number="";
                        if(!edtName.getText().toString().equals(" ")){
                         name=edtName.getText().toString();}
                        else{
                            Toast.makeText(MainActivity.this, "Please Enter contact name", Toast.LENGTH_SHORT).show();
                        }
                        if(!edtNumber.getText().toString().equals(" ")){
                        number=edtNumber.getText().toString();}
                        else{
                            Toast.makeText(MainActivity.this, "Please Enter contact number", Toast.LENGTH_SHORT).show();
                        }
                        arrContacts.add(new ContactModel(R.drawable.a,name,number));
                        adapter.notifyItemInserted(arrContacts.size()-1);
                        recyclerView.scrollToPosition(arrContacts.size()-1);
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });



        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        arrContacts.add(new ContactModel(R.drawable.a,"A","9587548610"));
        arrContacts.add(new ContactModel(R.drawable.b,"B","9587548610"));
        arrContacts.add(new ContactModel(R.drawable.c,"C","9587548610"));
        arrContacts.add(new ContactModel(R.drawable.d,"D","9587548610"));
        arrContacts.add(new ContactModel(R.drawable.e,"E","9587548610"));
        arrContacts.add(new ContactModel(R.drawable.f,"F","9587548610"));
        arrContacts.add(new ContactModel(R.drawable.g,"G","9587548610"));
        arrContacts.add(new ContactModel(R.drawable.h,"H","9587548610"));
        arrContacts.add(new ContactModel(R.drawable.i,"I","9587548610"));
        arrContacts.add(new ContactModel(R.drawable.a,"J","9587548610"));
        arrContacts.add(new ContactModel(R.drawable.b,"K","9587548610"));
        arrContacts.add(new ContactModel(R.drawable.c,"L","9587548610"));
        arrContacts.add(new ContactModel(R.drawable.d,"M","9587548610"));
        arrContacts.add(new ContactModel(R.drawable.e,"N","9587548610"));
        arrContacts.add(new ContactModel(R.drawable.f,"O","9587548610"));
        arrContacts.add(new ContactModel(R.drawable.g,"P","9587548610"));
        arrContacts.add(new ContactModel(R.drawable.h,"Q","9587548610"));
       adapter=new RecyclerContactAdapter(this,arrContacts);
        recyclerView.setAdapter(adapter);


    }
}