package com.ad.example.tipcalculatorapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class TipCalculatorActivity extends Activity {
	private EditText etAmt;
	private TextView tvView;
	private TextView tvAmt;
	private TextView tvTotal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_calculator);
        etAmt = (EditText) findViewById(R.id.etAmt);
        tvView = (TextView) findViewById(R.id.tvTip);
        tvAmt = (TextView) findViewById(R.id.tvAmt);
        tvTotal = (TextView) findViewById(R.id.tvTotal);
    }
    
    private Long calculateTip(Long amount, Long i) {
    	return (amount * i) /100;
    }
    public void onClickTen(View v) {
    	String amt = etAmt.getText().toString();
    	Long tip = calculateTip(Long.parseLong(amt),10L);
    	tvView.setText("$ "+String.format("%s",tip));
    	tvAmt.setText("$ " +amt);
    	tvTotal.setText("$ "+ (Long.parseLong(amt)+tip));
    	
    }
    public void onClickFifteen(View v) {
    	String amt = etAmt.getText().toString();
    	Long tip = calculateTip(Long.parseLong(amt),15L);
    	System.out.println("What is the tip --->"+tip);
    	tvView.setText("$ "+String.format("%s",tip));
    	tvAmt.setText("$ " +amt);
    	tvTotal.setText("$ "+ (Long.parseLong(amt)+tip));
    }
    public void onClickTwenty(View v) {
    	String amt = etAmt.getText().toString();
    	Long tip = calculateTip(Long.parseLong(amt),20L);
    	tvView.setText("$ "+String.format("%s",tip));
    	tvAmt.setText("$ " +amt);
    	tvTotal.setText("$ "+ (Long.parseLong(amt)+tip));
    }
 }
