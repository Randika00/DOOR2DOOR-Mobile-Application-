package com.example.foodapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.foodapp.Model.Details;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class DetailsActivity extends AppCompatActivity {

    EditText txtAccount, txtBankName, txtType;
    Button btnSave, btnShow, btnUpdate, btnDelete;

    DatabaseReference dbRef;
     Details dtl;

    public void clearControls(){
        txtAccount.setText("");
        txtBankName.setText("");
        txtType.setText("");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail);

        txtAccount = findViewById(R.id.txtAccount);
        txtBankName = findViewById(R.id.txtBankName);
        txtType = findViewById(R.id.txtType);

        btnSave = findViewById(R.id.btnSave);
        btnShow = findViewById(R.id.btnShow);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnDelete = findViewById(R.id.btnDelete);

        dtl = new Details  ();

    }

    public void Save(View view) {

        dbRef = FirebaseDatabase.getInstance().getReference().child("Details");

        try{
            if (TextUtils.isEmpty(txtAccount.getText().toString()))
                Toast.makeText(getApplicationContext(), "Please Enter Account Number", Toast.LENGTH_SHORT).show();
            else if (TextUtils.isEmpty(txtBankName.getText().toString()))
                Toast.makeText(getApplicationContext(), "Please Enter Bank Name", Toast.LENGTH_SHORT).show();
            else if (TextUtils.isEmpty(txtType.getText().toString()))
                Toast.makeText(getApplicationContext(), "Please Enter Account Type", Toast.LENGTH_SHORT).show();
            else{
                dtl.setAccount(txtAccount.getText().toString().trim());
                dtl.setBankName(txtBankName.getText().toString().trim());
                dtl.setType(txtType.getText().toString().trim());

                //dbRef.push().setValue(dtl);
                dbRef.child("dtl1").setValue(dtl);

                Toast.makeText(getApplicationContext(), "Data Saved Successfully", Toast.LENGTH_SHORT).show();
                clearControls();
            }
        } catch (NumberFormatException e) {
            Toast.makeText(getApplicationContext(), "Invalid Account Number", Toast.LENGTH_SHORT).show();
        }
    }

    public void Show(View view) {

        DatabaseReference readRef = FirebaseDatabase.getInstance().getReference().child("Details").child("dtl1");
        readRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.hasChildren()) {
                    txtAccount.setText(dataSnapshot.child("account").getValue().toString());
                    txtBankName.setText(dataSnapshot.child("bankName").getValue().toString());
                    txtType.setText(dataSnapshot.child("type").getValue().toString());
                }
                else
                    Toast.makeText(getApplicationContext(), "No Source to Display", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    public void Update(View view) {
        DatabaseReference updRef = FirebaseDatabase.getInstance().getReference().child("Details");
        updRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.hasChild("dtl1")){
                    try{
                        dtl.setAccount(txtAccount.getText().toString().trim());
                        dtl.setBankName(txtBankName.getText().toString().trim());
                        dtl.setType(txtType.getText().toString().trim());

                        dbRef = FirebaseDatabase.getInstance().getReference().child("Details").child("dtl1");
                        dbRef.setValue(dtl);
                        clearControls();

                        Toast.makeText(getApplicationContext(), "Data Updated Successfully", Toast.LENGTH_SHORT).show();

                    }catch (NumberFormatException e) {
                        Toast.makeText(getApplicationContext(), "Invalid Account Number", Toast.LENGTH_SHORT).show();
                    }
                }else
                    Toast.makeText(getApplicationContext(), "No Source to Update", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    public void Delete(View view) {
        DatabaseReference delRef = FirebaseDatabase.getInstance().getReference().child("Details");
        delRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.hasChild("dtl1")) {
                    dbRef = FirebaseDatabase.getInstance().getReference().child("Details").child("dtl1");
                    dbRef.removeValue();
                    clearControls();
                    Toast.makeText(getApplicationContext(), "Data Deleted Successfully", Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(getApplicationContext(), "No Source to Delete", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }




}

