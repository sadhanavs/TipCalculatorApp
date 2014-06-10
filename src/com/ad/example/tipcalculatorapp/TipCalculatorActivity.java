package com.ad.example.tipcalculatorapp;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.RatingBar.OnRatingBarChangeListener;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import android.widget.Toast;

public class TipCalculatorActivity extends Activity {
	private EditText etAmt;
	private TextView tvView;
	private TextView tvAmt;
	private TextView tvTotal;
	private RatingBar rbService;
	private TextView tvService;
	private TextView tvTotalTipVal;
	private SeekBar sbSplit;
	
	private TextView tvSplitVal;
	private TextView tvTipPerPersonVal;
	private TextView tvAmtVal;
	private TextView tvTotalPerPersonVal;
	private TextView tvTotalAmountVal;
	
	private TextView tvTipPer;
	
	int progressCh =0;
	int realRating =0;

	
	float curRating;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_calculator);
        etAmt = (EditText) findViewById(R.id.etAmt);
        etAmt.addTextChangedListener(new TextWatcher() {
			
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
		
			}
			
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void afterTextChanged(Editable s) {
				
				calculateTip();
			}
		});
        
        rbService = (RatingBar) findViewById(R.id.rbService);
        tvService = (TextView) findViewById(R.id.tvService);
        sbSplit = (SeekBar) findViewById(R.id.sbSplit);
        
        
        tvTipPer = (TextView) findViewById(R.id.tvTipPer);
        tvTotalTipVal = (TextView) findViewById(R.id.tvTotalTipVal);
        tvSplitVal = (TextView) findViewById(R.id.tvSplitVal);
        tvTipPerPersonVal = (TextView) findViewById(R.id.tvTipPerPersonVal);
        
        tvAmtVal =(TextView) findViewById(R.id.tvAmtVal);
        tvTotalPerPersonVal = (TextView) findViewById(R.id.tvTotalPerPersonVal);
        tvTotalAmountVal = (TextView) findViewById(R.id.tvTotalAmountVal);
        
        curRating=0;
        rbService.setRating(curRating);
        sbSplit.setMax(10);
        sbSplit.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			//int progressCh =0;
			@Override
			public void onStopTrackingTouch(SeekBar seekBar) { tvSplitVal.setText(String.valueOf(progressCh)); calculateTip(); }
			@Override
			public void onStartTrackingTouch(SeekBar seekBar) { }
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				// TODO Auto-generated method stub
				progressCh = progress;
				
				
				
			}
		});
        
        addListenerOnRatingBar();
    }
    
    private void calculateTip() {
    	String amount = etAmt.getText().toString();
    	
    	Double tipPerPerson =0.0;
    	Double amountPerPerson =0.0;
    	
    	tvAmtVal.setText("$ "+amount);
    	if(amount.isEmpty()) {
    		tvTotalTipVal.setText("$0.0"); 
    		return;
    	}

    	Double amt = Double.parseDouble(amount);
    	Double val =0.0;
    	if(amt!=0.0){
    		val= (amt * realRating) /100;
    		tvTotalTipVal.setText("$" + val.toString()); 
    		if(progressCh !=0){
    			tipPerPerson = val/progressCh;
    			amountPerPerson = amt/progressCh;
    			tvTipPerPersonVal.setText("$ "+tipPerPerson.toString());
    			tvTotalPerPersonVal.setText("$"+ (tipPerPerson+amountPerPerson));
    		}else{
    			tvTipPerPersonVal.setText("$ 0.0");
    			tvTotalPerPersonVal.setText("$ 0.0");
    		}
    		tvTotalAmountVal.setText("$"+(val+amt));
    	}
    	return ;
    }
  
    
    
    public void addListenerOnRatingBar() {
    	rbService.setOnRatingBarChangeListener(new OnRatingBarChangeListener() {
    		public void onRatingChanged(RatingBar ratingBar, float rating,  boolean fromUser) {
    			realRating = (int) rating * 5;
    			//tvService.setText(String.valueOf(realRating));
    			String val = String.valueOf(realRating)+" %";
    			tvTipPer.setText(val);
    			//rbService.setRating(rating);
    			calculateTip();
    			
    			//Toast.makeText(getApplicationContext(), val, Toast.LENGTH_SHORT).show();
    		}
    	});
    	

    
    }
 }
