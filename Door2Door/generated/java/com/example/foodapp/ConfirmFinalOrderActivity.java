package com.example.foodapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.foodapp.Prevalent.Prevalent;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;

import org.jetbrains.annotations.NotNull;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;

public class ConfirmFinalOrderActivity<DatabaseReference> extends AppCompatActivity
{
    private EditText nameEditText, phoneEditText, addressEditText, cityEditText;
    private Button confirmOrderBtn;
    private Button paymentBtn;

    private String totalAmount = "";


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_final_order);

        //get Data from detailed activity
        Object obj = getIntent().getSerializableExtra("item");

        totalAmount = getIntent().getStringExtra( "Total Price");
        Toast.makeText(this, "Total Price = LKR " + totalAmount, Toast.LENGTH_SHORT).show();

        confirmOrderBtn = (Button) findViewById(R.id.confirm_final_order_btn);
        nameEditText = (EditText) findViewById(R.id.shipment_name);
        phoneEditText = (EditText) findViewById(R.id.shipment_phone_number);
        addressEditText = (EditText) findViewById(R.id.shipment_address);
        cityEditText = (EditText) findViewById(R.id.shipment_city);
        paymentBtn = (Button) findViewById(R.id.payment_btn);



        paymentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                double amount = 0.0;
                if (obj instanceof OrdersActivity) {
                    OrdersActivity ordersActivity = (OrdersActivity) obj;
                    ordersActivity.getPrice();
                }
                Intent intent = new Intent(ConfirmFinalOrderActivity.this,PaymentActivity.class);
                intent.putExtra("amount",amount);
                startActivity(intent);

            }
        });
ss

        confirmOrderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Check();

            }
        });

    }

    private void Check()
    {
        if (TextUtils.isEmpty(nameEditText.getText().toString()))
        {
            Toast.makeText(this, "Please provide your full name.", Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(phoneEditText.getText().toString()))
        {
            Toast.makeText(this, "Please provide your phone number.", Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(addressEditText.getText().toString()))
        {
            Toast.makeText(this, "Please provide your address.", Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(cityEditText.getText().toString()))
        {
            Toast.makeText(this, "Please provide your city name.", Toast.LENGTH_SHORT).show();
        }
        else
        {
            ConfirmOrder();
        }

    }

    private void ConfirmOrder()
    {
        final String saveCurrentDate, saveCurrentTime;

        Calendar calForDate = Calendar.getInstance();
        SimpleDateFormat currentDate = new SimpleDateFormat("MMM dd, yyyy");
        saveCurrentDate = currentDate.format(calForDate.getTime());

        SimpleDateFormat currentTime = new SimpleDateFormat("HH:mm:ss a");
        saveCurrentTime = currentDate.format(calForDate.getTime());

       final DatabaseReference ordersRef = (DatabaseReference) FirebaseDatabase.getInstance().getReference()
               .child("Orders")
               .child(Prevalent.currentOnlineUser.getPhone());


        HashMap<String, Object> ordersMap = new HashMap<>();
        ordersMap.put("totalAmount", totalAmount);
        ordersMap.put("name", nameEditText.getText().toString());
        ordersMap.put("phone", phoneEditText.getText().toString());
        ordersMap.put("address", addressEditText.getText().toString());
        ordersMap.put("city", cityEditText.getText().toString());
        ordersMap.put("date", saveCurrentDate);
        ordersMap.put("time", saveCurrentTime);
        ordersMap.put("state", "not shipped");

        ((com.google.firebase.database.DatabaseReference) ordersRef).updateChildren(ordersMap).addOnCompleteListener(new OnCompleteListener<Void>() {
             @Override
               public void onComplete(@NonNull Task<Void> task)
          {
              if (task.isSuccessful())
              {
                  FirebaseDatabase.getInstance().getReference()
                          .child("Cart List")
                          .child("User View")
                          .child(Prevalent.currentOnlineUser.getPhone())
                          .removeValue()
                          .addOnCompleteListener(new OnCompleteListener<Void>() {
                              @Override
                              public void onComplete(@NonNull @NotNull Task<Void> task) {
                                  if (task.isSuccessful())
                                  {
                                      Toast.makeText(ConfirmFinalOrderActivity.this, "your final order has placed successfully.", Toast.LENGTH_SHORT).show();


                                      Intent intent = new Intent(ConfirmFinalOrderActivity.this, DetailsActivity.class);
                                      intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                      startActivity(intent);
                                      finish();

                                  }
                              }
                          });





              }

           }

    });


    }
}