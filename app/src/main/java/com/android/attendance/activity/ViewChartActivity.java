package com.android.attendance.activity;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.androidattendancesystem.R;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ViewChartActivity extends Activity {
    private LineChart lineChart;
    private List<String> xValues;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_chart);

        lineChart=findViewById(R.id.chart);

        Description description=new Description();
        description.setText("Students Record");
        description.setPosition(150f,15f);
        lineChart.setDescription(description);
        lineChart.getAxisRight().setDrawLabels(false);

        xValues= Arrays.asList("Nadun","Kamal","Jhon","Jerry");

        XAxis xAxis=lineChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setValueFormatter(new IndexAxisValueFormatter(xValues));
        xAxis.setLabelCount(4);
        xAxis.setGranularity(1f);

        YAxis yAxis=lineChart.getAxisLeft();
        yAxis.setAxisMinimum(0f);
        yAxis.setAxisMaximum(100f);
        yAxis.setAxisLineWidth(2f);
        yAxis.setAxisLineColor(Color.BLACK);
        yAxis.setLabelCount(10);

        List<Entry> entries1=new ArrayList<>();
        entries1.add(new Entry(0,10f));
        entries1.add(new Entry(1,10f));
        entries1.add(new Entry(2,15f));
        entries1.add(new Entry(3,45f));

        List<Entry> entries2=new ArrayList<>();
        entries2.add(new Entry(0,5f));
        entries2.add(new Entry(1,15f));
        entries2.add(new Entry(2,25f));
        entries2.add(new Entry(3,30f));

        LineDataSet dataSet1=new LineDataSet(entries1,"Maths");
        dataSet1.setColor(Color.BLUE);

        LineDataSet dataSet2=new LineDataSet(entries2,"Science");
        dataSet2.setColor(Color.RED);

        LineData lineData=new LineData(dataSet1,dataSet2);

        lineChart.setData(lineData);

        lineChart.invalidate();

    }
}
