package com.example.mentalhealthsupport;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class PerQuoteView extends AppCompatActivity {
    int author_pos;
    TextView txtQuote, txtPersonName, txtDate2;
    ImageView imgPerson;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_per_quote_view);

        author_pos = getIntent().getIntExtra("author_pos", 0);

        txtPersonName = findViewById(R.id.txtPersonName);
        txtQuote = findViewById(R.id.txtQuote);
        imgPerson = findViewById(R.id.imgPerson);
        txtDate2 = findViewById(R.id.txtDate2);
        txtDate2.setText(getMonth());

        updateView();

    }

    public void next(View view){
        if(author_pos == Quotes.authors.length-1)
            author_pos = 0;
        else author_pos++;
        updateView();
    }

    public void previous(View view){
        if(author_pos == 0) author_pos = Quotes.authors.length-1;
        else author_pos--;
        updateView();
    }

    public void updateView(){
        txtPersonName.setText("Message from\n" + Quotes.authors[author_pos]);
        imgPerson.setImageResource(Quotes.imageId[author_pos]);
        txtQuote.setText(Quotes.quotes[author_pos]);
    }

    private static String getMonth(String date) throws ParseException {
        Date d = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH).parse(date);
        Calendar cal = Calendar.getInstance();
        cal.setTime(d);
        String monthName = new SimpleDateFormat("MMMM").format(cal.getTime());
        return monthName;
    }

    private String getMonth(){
        String date;
        SimpleDateFormat dateTimeInGMT = new SimpleDateFormat("yyyy-MMM-dd hh:mm:ss aa");
        dateTimeInGMT.setTimeZone(TimeZone.getTimeZone("GMT"));
        date = dateTimeInGMT.format(new Date());
        return date;
    }
}