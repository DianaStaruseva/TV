package com.example.tv;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.FragmentActivity;

import java.text.MessageFormat;

/*
 * Main Activity class that loads {@link MainFragment}.
 */
public class MainActivity extends FragmentActivity {
    ListView list;
    String[] devices = {"Планшеты", "Телефоны", "Компьютеры", "Ноутбуки"};
    String buffer  = "";


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = findViewById(R.id.listView);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_multiple_choice,
                devices
        );
        list.setAdapter(adapter);

        list.setOnItemClickListener((adapterView, view, i, l) -> {
           /* Toast.makeText(this,
                    ((TextView) view).getText().toString()
                    , Toast.LENGTH_SHORT).show();*/
        });

    }
    public void onClick(View arg0) {
        //обнуляем буфер
        buffer = "";
        //вытаскиваем из листа нажатые элементы
        SparseBooleanArray sbArray = list.getCheckedItemPositions();
        //проходимся циклом по этим элементам
        for (int i = 0; i < sbArray.size(); i++) {
            //вытаскиваем ключ очередного элемента
            int key = sbArray.keyAt(i);
            //проверка ключа
            if (sbArray.get(key))
                //если ключ есть прибавляем к буферу текст элемента
                buffer += devices[key] + " ";
        }
        //выводим результат
        Toast.makeText(this, buffer, Toast.LENGTH_SHORT).show();
    }
}