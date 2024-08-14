package com.example.popupmenu;

import android.os.Bundle;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button showPopupMenuButton = findViewById(R.id.show_popup_menu_button);
        showPopupMenuButton.setOnClickListener(this::showPopupMenu);
    }

    private void showPopupMenu(View view) {
        PopupMenu popupMenu = new PopupMenu(this, view);
        MenuInflater inflater = popupMenu.getMenuInflater();
        inflater.inflate(R.menu.popupmenu, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(item -> {
            int id=item.getItemId();
            if(id==R.id.action_edit){
                Toast.makeText(this, "Edit action selected", Toast.LENGTH_SHORT).show();
                return true;
            } else if (id==R.id.action_delete) {
                Toast.makeText(this, "Delete Action selected", Toast.LENGTH_SHORT).show();
                return true;

            } else {
                Toast.makeText(this,"Share action selected",Toast.LENGTH_SHORT).show();
                return true;
            }

        });
        popupMenu.show();
    }
}
