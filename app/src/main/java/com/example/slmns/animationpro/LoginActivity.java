package com.example.slmns.animationpro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Explode;
import android.transition.Slide;
import android.transition.TransitionInflater;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setupWindowAnimations();


        final ViewGroup transitionsContainer = (ViewGroup) findViewById(R.id.transitions_container);
        final TextView text = (TextView) transitionsContainer.findViewById(R.id.text);
        final Button button = (Button) transitionsContainer.findViewById(R.id.button);
        final ProgressBar progressBar = (ProgressBar) transitionsContainer.findViewById(R.id.progress);
        final EditText username = (EditText) transitionsContainer.findViewById(R.id.username_et);
        final EditText password = (EditText) transitionsContainer.findViewById(R.id.password_et);
        final Button Nextbtn = (Button) transitionsContainer.findViewById(R.id.next_btn);




        button.setOnClickListener(new View.OnClickListener() {

            boolean visible;


            @Override
            public void onClick(View v) {
                String userstring = username.getText().toString();
                String passstring = password.getText().toString();
                if (userstring.equals("Android") && passstring.equals("Studio")) {
                    TransitionManager.beginDelayedTransition(transitionsContainer);
                    visible = !visible;
                    text.setVisibility(visible ? View.VISIBLE : View.GONE);
                    progressBar.setVisibility(visible ? View.VISIBLE : View.GONE);
                    Nextbtn.setVisibility(visible ? View.VISIBLE : View.GONE);

                }

            }
        });

    }
    private void setupWindowAnimations() {
        Explode explode = (Explode) TransitionInflater.from(this).inflateTransition(R.transition.explode);
        getWindow().setExitTransition(explode);
    }

    public void Next(View view) {
        startActivity(new Intent(this,MainActivity.class));



    }
}
