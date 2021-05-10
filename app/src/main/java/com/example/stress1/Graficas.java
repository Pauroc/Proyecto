package com.example.stress1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.data.RadarDataSet;
import com.github.mikephil.charting.data.RadarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;

import java.util.ArrayList;

public class Graficas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graficas);
        RadarChart radarChart = findViewById(R.id.Radarchat);
        ArrayList<RadarEntry> ValoresGraficas = new ArrayList<>();
        ValoresGraficas.add(new RadarEntry(100));
        ValoresGraficas.add(new RadarEntry(150));
        ValoresGraficas.add(new RadarEntry(140));
        ValoresGraficas.add(new RadarEntry(200));
        RadarDataSet Radarg = new RadarDataSet(ValoresGraficas,"Prueba Radar");
        Radarg.setColor(Color.BLUE);
        Radarg.setLineWidth(2F);
        Radarg.setValueTextColor(Color.BLUE);
        Radarg.setValueTextSize(14f);
        RadarData radarData = new RadarData();
        radarData.addDataSet(Radarg);
        String[] labels = {"2020","2019","2018","2017"};
        XAxis xAxis = radarChart.getXAxis();
        xAxis.setValueFormatter(new IndexAxisValueFormatter(labels));
        radarChart.setData(radarData);

    }
}