package com.example.app2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnActivityToActivity = findViewById(R.id.btn_activity_to_activity);
        Button btnActivityToService = findViewById(R.id.btn_activity_to_service);
        Button btnActivityToSystemApp = findViewById(R.id.btn_activity_to_system_app);
        Button btnActivityToOtherApp = findViewById(R.id.btn_activity_to_other_app);
        Button btnActivityToBroadcast = findViewById(R.id.btn_activity_to_broadcast);

        btnActivityToActivity.setOnClickListener(this);
        btnActivityToService.setOnClickListener(this);
        btnActivityToSystemApp.setOnClickListener(this);
        btnActivityToOtherApp.setOnClickListener(this);
        btnActivityToBroadcast.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        final int viewId = v.getId();
        if (viewId == R.id.btn_activity_to_activity) {
            Intent intent = new Intent(this, SecondActivity.class);
            intent.putExtra("message", "Hello from MainActivity!");
            startActivity(intent);
        } else if (viewId == R.id.btn_activity_to_system_app) {
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:1234567890"));
            startActivity(intent);
        } else if (viewId == R.id.btn_activity_to_other_app) {
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            intent.putExtra(Intent.EXTRA_TEXT, "Hello from my app!");
            intent.setPackage("com.whatsapp");
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            } else {
                Toast.makeText(this, "WhatsApp not installed.", Toast.LENGTH_SHORT).show();
            }
        } else if (viewId == R.id.btn_activity_to_service) {
            Intent intent = new Intent(this, MyService.class);
            startService(intent);
            Toast.makeText(this, "Service started", Toast.LENGTH_SHORT).show();
        } else if (viewId == R.id.btn_activity_to_broadcast) {
            Intent intent = new Intent("com.example.app2.MY_BROADCAST");
            sendBroadcast(intent);
            Toast.makeText(this, "Broadcast sent", Toast.LENGTH_SHORT).show();
        }
    }
}