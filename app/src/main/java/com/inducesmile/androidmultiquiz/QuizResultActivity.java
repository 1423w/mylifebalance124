package com.inducesmile.androidmultiquiz;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.github.pavlospt.CircleView;

import org.w3c.dom.Text;

public class QuizResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_result);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(getString(R.string.quiz_result));
        //setTitle(getString(R.string.quiz_result));

        final String resultString = getIntent().getExtras().getString("RESULT_OBJECT");
        String userScore = getIntent().getExtras().getString("TOTAL_SCORE");

        double passResult = Double.parseDouble(userScore);
        int userPassMark = new Double(passResult).intValue();

        //CircleView userPassScore = (CircleView)findViewById(R.id.pass);

        //userPassScore.setTitleText(String.valueOf(userPassMark) + "%");

        if(passResult < 25 && passResult >= 0) {
            TextView result = (TextView) findViewById(R.id.resultText);
            result.setText(getString(R.string.less_than_25));
        } else if (passResult >= 25 && passResult <= 49){
            TextView result = (TextView) findViewById(R.id.resultText);
            result.setText(getString(R.string.less_than_50));
        } else if (passResult >= 50 && passResult <= 74) {
            TextView result = (TextView) findViewById(R.id.resultText);
            result.setText(getString(R.string.less_than_75));
        }  else if (passResult >= 75 ) {
            TextView result = (TextView) findViewById(R.id.resultText);
            result.setText(getString(R.string.less_than_100));
        } else {TextView result = (TextView) findViewById(R.id.resultText);
            result.setText("There has been a mistake");
        }

        Button retakeQuizButton = (Button)findViewById(R.id.retake_quiz);
        assert retakeQuizButton != null;
        retakeQuizButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent retakeQuizIntent = new Intent(QuizResultActivity.this, QuizCategoryActivity.class);
                startActivity(retakeQuizIntent);
            }
        });

        Button viewQuizResultButton = (Button)findViewById(R.id.view_result);
        assert viewQuizResultButton != null;
        viewQuizResultButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent resultIntent = new Intent(QuizResultActivity.this, ResultAnalysisActivity.class);
                resultIntent.putExtra("RESULT", resultString);
                startActivity(resultIntent);
            }
        });
        Button btnBrowse = (Button) findViewById(R.id.btnBrowser);
        btnBrowse.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Uri webpage = Uri.parse("http://zephyr.it5a.com.au/");
                Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });
        Button facebook = (Button) findViewById(R.id.facebook);
        facebook.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Uri webpage = Uri.parse("https://www.facebook.com/My-Life-Balance-214948952375543/");
                Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
    }
}
