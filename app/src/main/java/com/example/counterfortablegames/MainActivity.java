package com.example.counterfortablegames;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class MainActivity extends AppCompatActivity {
    Button button0;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button10;
    Button button11;
    Button button12;
    Button button13;
    Button button14;
    Button button15;
    Button button30;
    Button button31;
    Button button32;
    Button button33;
    Button button34;
    Button button35;
    Button buttonStart;
    Button buttonReset;
    TextView view0;
    TextView view1;
    TextView view2;
    TextView view3;
    TextView view4;
    TextView view5;
    Handler handler;
    Button buttonminus;
    Button buttonplus;

    Switch switch0;
    Boolean checkswitch0;
    Switch switch1;
    Boolean checkswitch1;
    Switch switch2;
    Boolean checkswitch2;
    Switch switch3;
    Boolean checkswitch3;
    Switch switch4;
    Boolean checkswitch4;
    Switch switch5;
    Boolean checkswitch5;
    Switch switch6;
    Boolean checkswitch6;
    int buttoncolor0;
    int buttoncolor1;
    int buttoncolor2;
    int buttoncolor3;
    int buttoncolor4;
    int buttoncolor5;

    //TextView textTimer;
        int counter0 = 0;
        int counter1 = 0;
        int counter2 = 0;
        int counter3 = 0;
        int counter4 = 0;
        int counter5 = 0;

    int [] arr = new int[11];
    //int timer =60;
    int currentColor = 0;
    //boolean timerRun = false;
    TextView textTimer;
    Integer timer =60;
    Integer time = 60;
    boolean timerRun = false;
    Thread thread;

    //Звук
    MediaPlayer mPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        //app ID
        MobileAds.initialize(getApplicationContext(), "ca-app-pub-3675146285571777~9686769595");
        final AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();

        mAdView.loadAd(adRequest);

        mAdView.setAdListener(new AdListener() {



            @Override
            public void onAdFailedToLoad(int error) {
                mAdView.setVisibility(View.GONE);
            }



            @Override
            public void onAdLoaded() {
                mAdView.setVisibility(View.VISIBLE);
            }
        });
        /*try {
            getSupportActionBar().hide();
        }
        catch (Exception e){

        }*/
        //Звук
        mPlayer=MediaPlayer.create(this,R.raw.clock);

        textTimer=(TextView) findViewById(R.id.textTimer);
        button0 = (Button) findViewById(R.id.button0);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);

        button10 = (Button) findViewById(R.id.button10);
        button11 = (Button) findViewById(R.id.button11);
        button12 = (Button) findViewById(R.id.button12);
        button13 = (Button) findViewById(R.id.button13);
        button14 = (Button) findViewById(R.id.button14);
        button15 = (Button) findViewById(R.id.button15);

        button30 = (Button) findViewById(R.id.button30);
        button31 = (Button) findViewById(R.id.button31);
        button32 = (Button) findViewById(R.id.button32);
        button33 = (Button) findViewById(R.id.button33);
        button34 = (Button) findViewById(R.id.button34);
        button35 = (Button) findViewById(R.id.button35);

        buttonStart = (Button) findViewById(R.id.buttonStart);
        buttonReset = (Button) findViewById(R.id.buttonReset);
        buttonplus = (Button) findViewById(R.id.buttonplus);
        buttonminus = (Button) findViewById(R.id.buttonminus);
        view0 =(TextView)findViewById(R.id.textView0);
        view1 =(TextView)findViewById(R.id.textView1);
        view2 =(TextView)findViewById(R.id.textView2);
        view3 =(TextView)findViewById(R.id.textView3);
        view4 =(TextView)findViewById(R.id.textView4);
        view5 =(TextView)findViewById(R.id.textView5);
        view0.setText(String.valueOf(counter0));
        view1.setText(String.valueOf(counter1));
        view2.setText(String.valueOf(counter2));
        view3.setText(String.valueOf(counter3));
        view4.setText(String.valueOf(counter4));
        view5.setText(String.valueOf(counter5));

        buttoncolor0=getResources().getColor(R.color.colorRED);
        buttoncolor1=getResources().getColor(R.color.colorBLUE);
        buttoncolor2=getResources().getColor(R.color.colorGREEN);
        buttoncolor3=getResources().getColor(R.color.colorYELLOW);
        buttoncolor4=getResources().getColor(R.color.colorPURPLE);
        buttoncolor5=getResources().getColor(R.color.colorBLACK);



        switch0 = (Switch) findViewById(R.id.switch0);
        checkswitch0 = switch0.isChecked();
        switch1 = (Switch) findViewById(R.id.switch1);
        checkswitch1 = switch1.isChecked();
        switch2 = (Switch) findViewById(R.id.switch2);
        checkswitch2 = switch2.isChecked();
        switch3 = (Switch) findViewById(R.id.switch3);
         checkswitch3 = switch3.isChecked();
        switch4 = (Switch) findViewById(R.id.switch4);
        checkswitch4 = switch4.isChecked();
        switch5 = (Switch) findViewById(R.id.switch5);
        checkswitch5 = switch5.isChecked();
        switch6 = (Switch) findViewById(R.id.switch6);
        checkswitch6 = switch6.isChecked();
        final Drawable color3= getResources().getDrawable(R.color.color3);
        final Drawable color1= getResources().getDrawable(R.color.color1);

        switch0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (switch0.isChecked()){

                    button0.setVisibility(View.VISIBLE);
                    button10.setVisibility(View.VISIBLE);
                    button30.setVisibility(View.VISIBLE);
                    view0.setVisibility(View.VISIBLE);
                }

                else {
                    button0.setVisibility(View.INVISIBLE);
                    button10.setVisibility(View.INVISIBLE);
                    button30.setVisibility(View.INVISIBLE);
                    view0.setVisibility(View.INVISIBLE);
                }
                }

        });
        switch1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (switch1.isChecked()){
                    button1.setVisibility(View.VISIBLE);
                    button11.setVisibility(View.VISIBLE);
                    button31.setVisibility(View.VISIBLE);
                    view1.setVisibility(View.VISIBLE);
                }

                else {
                    button1.setVisibility(View.INVISIBLE);
                    button11.setVisibility(View.INVISIBLE);
                    button31.setVisibility(View.INVISIBLE);
                    view1.setVisibility(View.INVISIBLE);
                }
            }

        });

        switch2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (switch2.isChecked()){
                    button2.setVisibility(View.VISIBLE);
                    button12.setVisibility(View.VISIBLE);
                    button32.setVisibility(View.VISIBLE);
                    view2.setVisibility(View.VISIBLE);
                }

                else {
                    button2.setVisibility(View.INVISIBLE);
                    button12.setVisibility(View.INVISIBLE);
                    button32.setVisibility(View.INVISIBLE);
                    view2.setVisibility(View.INVISIBLE);
                }
            }

        });
        switch3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (switch3.isChecked()){
                    button3.setVisibility(View.VISIBLE);
                    button13.setVisibility(View.VISIBLE);
                    button33.setVisibility(View.VISIBLE);
                    view3.setVisibility(View.VISIBLE);
                }

                else {
                    button3.setVisibility(View.INVISIBLE);
                    button13.setVisibility(View.INVISIBLE);
                    button33.setVisibility(View.INVISIBLE);
                    view3.setVisibility(View.INVISIBLE);
                }
            }

        });
        switch4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (switch4.isChecked()){
                    button4.setVisibility(View.VISIBLE);
                    button14.setVisibility(View.VISIBLE);
                    button34.setVisibility(View.VISIBLE);
                    view4.setVisibility(View.VISIBLE);
                }

                else {
                    button4.setVisibility(View.INVISIBLE);
                    button14.setVisibility(View.INVISIBLE);
                    button34.setVisibility(View.INVISIBLE);
                    view4.setVisibility(View.INVISIBLE);
                }
            }

        });
        switch5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (switch5.isChecked()){
                    button5.setVisibility(View.VISIBLE);
                    button15.setVisibility(View.VISIBLE);
                    button35.setVisibility(View.VISIBLE);
                    view5.setVisibility(View.VISIBLE);
                }

                else {
                    button5.setVisibility(View.INVISIBLE);
                    button15.setVisibility(View.INVISIBLE);
                    button35.setVisibility(View.INVISIBLE);
                    view5.setVisibility(View.INVISIBLE);
                }
            }

        });

        switch6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (switch6.isChecked()){
                    buttonStart.setVisibility(View.VISIBLE);
                    buttonReset.setVisibility(View.VISIBLE);
                    buttonplus.setVisibility(View.VISIBLE);
                    buttonminus.setVisibility(View.VISIBLE);
                    textTimer.setVisibility(View.VISIBLE);
                }

                else {
                    buttonStart.setVisibility(View.INVISIBLE);
                    buttonReset.setVisibility(View.INVISIBLE);
                    buttonplus.setVisibility(View.INVISIBLE);
                    buttonminus.setVisibility(View.INVISIBLE);
                    textTimer.setVisibility(View.INVISIBLE);
                }
            }

        });





        button0.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                changeColor0minus();
                return true;
            }
        });
        button1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                changeColor1minus();
                return true;
            }
        });
        button2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                changeColor2minus();
                return true;
            }
        });
        button3.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                changeColor3minus();
                return true;
            }
        });
        button4.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                changeColor4minus();
                return true;
            }
        });
        button5.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                changeColor5minus();
                return true;
            }
        });

        button10.setOnTouchListener(new RepeatListener(400, 100, new android.view.View.OnClickListener(){
            @Override
            public void onClick(View view) {
                counter0++;

                view0.setText(String.valueOf(counter0));
                // the code to execute repeatedly
            }
        }));

        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                String text = (String) msg.obj;
                textTimer.setText( text );
            }
        };
        button11.setOnTouchListener(new RepeatListener(400, 100, new android.view.View.OnClickListener(){
            @Override
            public void onClick(View view) {
                counter1++;

                view1.setText(String.valueOf(counter1));
                // the code to execute repeatedly
            }
        }));

        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                String text = (String) msg.obj;
                textTimer.setText( text );
            }
        };
        button12.setOnTouchListener(new RepeatListener(400, 100, new android.view.View.OnClickListener(){
            @Override
            public void onClick(View view) {
                counter2++;

                view2.setText(String.valueOf(counter2));
                // the code to execute repeatedly
            }
        }));

        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                String text = (String) msg.obj;
                textTimer.setText( text );
            }
        };
        button13.setOnTouchListener(new RepeatListener(400, 100, new android.view.View.OnClickListener(){
            @Override
            public void onClick(View view) {
                counter3++;

                view3.setText(String.valueOf(counter3));
                // the code to execute repeatedly
            }
        }));

        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                String text = (String) msg.obj;
                textTimer.setText( text );
            }
        };
        button14.setOnTouchListener(new RepeatListener(400, 100, new android.view.View.OnClickListener(){
            @Override
            public void onClick(View view) {
                counter4++;

                view4.setText(String.valueOf(counter4));
                // the code to execute repeatedly
            }
        }));

        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                String text = (String) msg.obj;
                textTimer.setText( text );
            }
        };
        button15.setOnTouchListener(new RepeatListener(400, 100, new android.view.View.OnClickListener(){
            @Override
            public void onClick(View view) {
                counter5++;

                view5.setText(String.valueOf(counter5));
                // the code to execute repeatedly
            }
        }));

        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                String text = (String) msg.obj;
                textTimer.setText( text );
            }
        };

        button30.setOnTouchListener(new RepeatListener(400, 100, new android.view.View.OnClickListener(){
            @Override
            public void onClick(View view) {
                counter0--;

                view0.setText(String.valueOf(counter0));
                // the code to execute repeatedly
            }
        }));

        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                String text = (String) msg.obj;
                textTimer.setText( text );
            }
        };
        button31.setOnTouchListener(new RepeatListener(400, 100, new android.view.View.OnClickListener(){
            @Override
            public void onClick(View view) {
                counter1--;

                view1.setText(String.valueOf(counter1));
                // the code to execute repeatedly
            }
        }));

        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                String text = (String) msg.obj;
                textTimer.setText( text );
            }
        };
        button32.setOnTouchListener(new RepeatListener(400, 100, new android.view.View.OnClickListener(){
            @Override
            public void onClick(View view) {
                counter2--;

                view2.setText(String.valueOf(counter2));
                // the code to execute repeatedly
            }
        }));

        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                String text = (String) msg.obj;
                textTimer.setText( text );
            }
        };
        button33.setOnTouchListener(new RepeatListener(400, 100, new android.view.View.OnClickListener(){
            @Override
            public void onClick(View view) {
                counter3--;

                view3.setText(String.valueOf(counter3));
                // the code to execute repeatedly
            }
        }));

        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                String text = (String) msg.obj;
                textTimer.setText( text );
            }
        };
        button34.setOnTouchListener(new RepeatListener(400, 100, new android.view.View.OnClickListener(){
            @Override
            public void onClick(View view) {
                counter4--;

                view4.setText(String.valueOf(counter4));
                // the code to execute repeatedly
            }
        }));

        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                String text = (String) msg.obj;
                textTimer.setText( text );
            }
        };
        button35.setOnTouchListener(new RepeatListener(400, 100, new android.view.View.OnClickListener(){
            @Override
            public void onClick(View view) {
                counter5--;

                view5.setText(String.valueOf(counter5));
                // the code to execute repeatedly
            }
        }));

        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                String text = (String) msg.obj;
                textTimer.setText( text );
            }
        };

        //textTimer=(TextView)findViewById(R.id.textTimer);
        //textTimer.setText(timer);
        /*view0.setText(counter0);
        view1.setText(counter1);
        view2.setText(counter2);
        view3.setText(counter3);
        view4.setText(counter4);
        view5.setText(counter5);*/

        arr[0]=getResources().getColor(R.color.colorGREEN);
        arr[1]=getResources().getColor(R.color.colorBLUE);
        arr[2]=getResources().getColor(R.color.colorYELLOW);
        arr[3]=getResources().getColor(R.color.colorRED);
        arr[4]=getResources().getColor(R.color.colorPURPLE);
        arr[5]=getResources().getColor(R.color.colorBLACK);
        arr[6]=getResources().getColor(R.color.colorWHITE);
        arr[7]=getResources().getColor(R.color.colorBROWN);
        arr[8]=getResources().getColor(R.color.colorGRAY);
        arr[9]=getResources().getColor(R.color.colorPINK);
        arr[10]=getResources().getColor(R.color.colorORANGE);




    }
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {

        // Save UI state changes to the savedInstanceState.
        // This bundle will be passed to onCreate if the process is
        // killed and restarted.


        savedInstanceState.putInt("ViewInt0", counter0);
        savedInstanceState.putInt("ViewInt1", counter1);
        savedInstanceState.putInt("ViewInt2", counter2);
        savedInstanceState.putInt("ViewInt3", counter3);
        savedInstanceState.putInt("ViewInt4", counter4);
        savedInstanceState.putInt("ViewInt5", counter5);
        savedInstanceState.putInt("time", time);

        savedInstanceState.putInt("buttoncolor0", buttoncolor0);
        savedInstanceState.putInt("buttoncolor1", buttoncolor1);
        savedInstanceState.putInt("buttoncolor2", buttoncolor2);
        savedInstanceState.putInt("buttoncolor3", buttoncolor3);
        savedInstanceState.putInt("buttoncolor4", buttoncolor4);
        savedInstanceState.putInt("buttoncolor5", buttoncolor5);

        savedInstanceState.putBoolean("switch0",switch0.isChecked());
        savedInstanceState.putBoolean("switch1",switch1.isChecked());
        savedInstanceState.putBoolean("switch2",switch2.isChecked());
        savedInstanceState.putBoolean("switch3",switch3.isChecked());
        savedInstanceState.putBoolean("switch4",switch4.isChecked());
        savedInstanceState.putBoolean("switch5",switch5.isChecked());



        // etc.

        super.onSaveInstanceState(savedInstanceState);
    }
    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {

        super.onRestoreInstanceState(savedInstanceState);

        // Restore UI state from the savedInstanceState.
        // This bundle has also been passed to onCreate.


        counter0 = savedInstanceState.getInt("ViewInt0");
        counter1 = savedInstanceState.getInt("ViewInt1");
        counter2 = savedInstanceState.getInt("ViewInt2");
        counter3 = savedInstanceState.getInt("ViewInt3");
        counter4 = savedInstanceState.getInt("ViewInt4");
        counter5 = savedInstanceState.getInt("ViewInt5");

        time = savedInstanceState.getInt("time");

        buttoncolor0 = savedInstanceState.getInt("buttoncolor0");
        buttoncolor1 = savedInstanceState.getInt("buttoncolor1");
        buttoncolor2 = savedInstanceState.getInt("buttoncolor2");
        buttoncolor3 = savedInstanceState.getInt("buttoncolor3");
        buttoncolor4 = savedInstanceState.getInt("buttoncolor4");
        buttoncolor5 = savedInstanceState.getInt("buttoncolor5");

        switch0.setChecked(savedInstanceState.getBoolean("switch0"));
        switch1.setChecked(savedInstanceState.getBoolean("switch1"));
        switch2.setChecked(savedInstanceState.getBoolean("switch2"));
        switch3.setChecked(savedInstanceState.getBoolean("switch3"));
        switch4.setChecked(savedInstanceState.getBoolean("switch4"));
        switch5.setChecked(savedInstanceState.getBoolean("switch5"));

        view0.setText(String.valueOf(counter0));
        view1.setText(String.valueOf(counter1));
        view2.setText(String.valueOf(counter2));
        view3.setText(String.valueOf(counter3));
        view4.setText(String.valueOf(counter4));
        view5.setText(String.valueOf(counter5));
        textTimer.setText(String.valueOf(time));

        button0.setBackgroundColor(buttoncolor0);
        button1.setBackgroundColor(buttoncolor1);
        button2.setBackgroundColor(buttoncolor2);
        button3.setBackgroundColor(buttoncolor3);
        button4.setBackgroundColor(buttoncolor4);
        button5.setBackgroundColor(buttoncolor5);

        if (switch0.isChecked()){

            button0.setVisibility(View.VISIBLE);
            button10.setVisibility(View.VISIBLE);
            button30.setVisibility(View.VISIBLE);
            view0.setVisibility(View.VISIBLE);
        }

        else {
            button0.setVisibility(View.INVISIBLE);
            button10.setVisibility(View.INVISIBLE);
            button30.setVisibility(View.INVISIBLE);
            view0.setVisibility(View.INVISIBLE);
        }


        if (switch1.isChecked()){
            button1.setVisibility(View.VISIBLE);
            button11.setVisibility(View.VISIBLE);
            button31.setVisibility(View.VISIBLE);
            view1.setVisibility(View.VISIBLE);
        }

        else {
            button1.setVisibility(View.INVISIBLE);
            button11.setVisibility(View.INVISIBLE);
            button31.setVisibility(View.INVISIBLE);
            view1.setVisibility(View.INVISIBLE);
        }



        if (switch2.isChecked()){
            button2.setVisibility(View.VISIBLE);
            button12.setVisibility(View.VISIBLE);
            button32.setVisibility(View.VISIBLE);
            view2.setVisibility(View.VISIBLE);
        }

        else {
            button2.setVisibility(View.INVISIBLE);
            button12.setVisibility(View.INVISIBLE);
            button32.setVisibility(View.INVISIBLE);
            view2.setVisibility(View.INVISIBLE);
        }


        if (switch3.isChecked()){
            button3.setVisibility(View.VISIBLE);
            button13.setVisibility(View.VISIBLE);
            button33.setVisibility(View.VISIBLE);
            view3.setVisibility(View.VISIBLE);
        }

        else {
            button3.setVisibility(View.INVISIBLE);
            button13.setVisibility(View.INVISIBLE);
            button33.setVisibility(View.INVISIBLE);
            view3.setVisibility(View.INVISIBLE);
        }


        if (switch4.isChecked()){
            button4.setVisibility(View.VISIBLE);
            button14.setVisibility(View.VISIBLE);
            button34.setVisibility(View.VISIBLE);
            view4.setVisibility(View.VISIBLE);
        }

        else {
            button4.setVisibility(View.INVISIBLE);
            button14.setVisibility(View.INVISIBLE);
            button34.setVisibility(View.INVISIBLE);
            view4.setVisibility(View.INVISIBLE);
        }


        if (switch5.isChecked()){
            button5.setVisibility(View.VISIBLE);
            button15.setVisibility(View.VISIBLE);
            button35.setVisibility(View.VISIBLE);
            view5.setVisibility(View.VISIBLE);
        }

        else {
            button5.setVisibility(View.INVISIBLE);
            button15.setVisibility(View.INVISIBLE);
            button35.setVisibility(View.INVISIBLE);
            view5.setVisibility(View.INVISIBLE);
        }


        if (switch6.isChecked()){
            buttonStart.setVisibility(View.VISIBLE);
            buttonReset.setVisibility(View.VISIBLE);
            buttonplus.setVisibility(View.VISIBLE);
            buttonminus.setVisibility(View.VISIBLE);
            textTimer.setVisibility(View.VISIBLE);
        }

        else {
            buttonStart.setVisibility(View.INVISIBLE);
            buttonReset.setVisibility(View.INVISIBLE);
            buttonplus.setVisibility(View.INVISIBLE);
            buttonminus.setVisibility(View.INVISIBLE);
            textTimer.setVisibility(View.INVISIBLE);
        }
    }


    public void changeColor0minus(){
        for (int i = 0;i<11;i++) {
            if (((ColorDrawable)button0.getBackground()).getColor() == (arr[i])){
                currentColor=i;
                String str = " currentColor = "+currentColor;

            }
        }
        if (currentColor!=0) {
            button0.setBackgroundColor((arr[currentColor-1]));
            buttoncolor0=arr[currentColor-1];
        }
        else {
            button0.setBackgroundColor(arr[10]);
            buttoncolor0=arr[10];
            currentColor=10;

        }
    }

    public void changeColor1minus(){
        for (int i = 0;i<11;i++) {
            if (((ColorDrawable)button1.getBackground()).getColor() == (arr[i])){
                currentColor=i;
                String str = " currentColor = "+currentColor;

            }
        }
        if (currentColor!=0) {
            button1.setBackgroundColor((arr[currentColor-1]));
            buttoncolor1=arr[currentColor-1];
        }
        else {
            button1.setBackgroundColor(arr[10]);
            buttoncolor1=arr[10];
            currentColor=10;

        }
    }

    public void changeColor2minus(){
        for (int i = 0;i<11;i++) {
            if (((ColorDrawable)button2.getBackground()).getColor() == (arr[i])){
                currentColor=i;
                String str = " currentColor = "+currentColor;

            }
        }
        if (currentColor!=0) {
            button2.setBackgroundColor((arr[currentColor-1]));
            buttoncolor2=arr[currentColor-1];
        }
        else {
            button2.setBackgroundColor(arr[10]);
            buttoncolor2=arr[10];
            currentColor=10;

        }
    }

    public void changeColor3minus(){
        for (int i = 0;i<11;i++) {
            if (((ColorDrawable)button3.getBackground()).getColor() == (arr[i])){
                currentColor=i;
                String str = " currentColor = "+currentColor;

            }
        }
        if (currentColor!=0) {
            button3.setBackgroundColor((arr[currentColor-1]));
            buttoncolor3=arr[currentColor-1];
        }
        else {
            button3.setBackgroundColor(arr[10]);
            buttoncolor3=arr[10];
            currentColor=10;

        }
    }

    public void changeColor4minus(){
        for (int i = 0;i<11;i++) {
            if (((ColorDrawable)button4.getBackground()).getColor() == (arr[i])){
                currentColor=i;
                String str = " currentColor = "+currentColor;

            }
        }
        if (currentColor!=0) {
            button4.setBackgroundColor((arr[currentColor-1]));
            buttoncolor4=arr[currentColor-1];
        }
        else {
            button4.setBackgroundColor(arr[10]);
            buttoncolor4=arr[10];
            currentColor=10;

        }
    }

    public void changeColor5minus(){
        for (int i = 0;i<11;i++) {
            if (((ColorDrawable)button5.getBackground()).getColor() == (arr[i])){
                currentColor=i;
                String str = " currentColor = "+currentColor;

            }
        }
        if (currentColor!=0) {
            button5.setBackgroundColor((arr[currentColor-1]));
            buttoncolor5=arr[currentColor-1];
        }
        else {
            button5.setBackgroundColor(arr[10]);
            buttoncolor5=arr[10];
            currentColor=10;

        }
    }



    public void changeColor0 (View view){
        for (int i = 0;i<11;i++) {
            if (((ColorDrawable)button0.getBackground()).getColor() == (arr[i])){
                currentColor=i;
                String str = " currentColor = "+currentColor;

            }
        }
        if (currentColor!=10) {
            button0.setBackgroundColor((arr[currentColor+1]));
            buttoncolor0=arr[currentColor+1];
        }
        else {
            button0.setBackgroundColor(arr[0]);
            buttoncolor0=arr[0];
            currentColor=0;

        }
    }
    public void changeColor1 (View view){
        for (int i = 0;i<11;i++) {
            if (((ColorDrawable)button1.getBackground()).getColor() == (arr[i])){
                currentColor=i;
                String str = " currentColor = "+currentColor;

            }
        }
        if (currentColor!=10) {
            buttoncolor1=arr[currentColor+1];
            button1.setBackgroundColor((arr[currentColor+1]));

        }
        else {
            button1.setBackgroundColor(arr[0]);
            buttoncolor1=arr[0];
            currentColor=0;

        }
    }
    public void changeColor2 (View view){
        for (int i = 0;i<11;i++) {
            if (((ColorDrawable)button2.getBackground()).getColor() == (arr[i])){
                currentColor=i;
                String str = " currentColor = "+currentColor;

            }
        }
        if (currentColor!=10) {
            button2.setBackgroundColor((arr[currentColor+1]));
            buttoncolor2=arr[currentColor+1];

        }
        else {
            button2.setBackgroundColor(arr[0]);
            currentColor=0;
            buttoncolor2=arr[0];

        }
    }
    public void changeColor3 (View view){
        for (int i = 0;i<11;i++) {
            if (((ColorDrawable)button3.getBackground()).getColor() == (arr[i])){
                currentColor=i;
                String str = " currentColor = "+currentColor;

            }
        }
        if (currentColor!=10) {
            button3.setBackgroundColor((arr[currentColor+1]));
            buttoncolor3=arr[currentColor+1];

        }
        else {
            button3.setBackgroundColor(arr[0]);
            buttoncolor3=arr[0];
            currentColor=0;

        }
    }
    public void changeColor4 (View view){
        for (int i = 0;i<11;i++) {
            if (((ColorDrawable)button4.getBackground()).getColor() == (arr[i])){
                currentColor=i;
                String str = " currentColor = "+currentColor;

            }
        }
        if (currentColor!=10) {
            button4.setBackgroundColor((arr[currentColor+1]));
            buttoncolor4=arr[currentColor+1];

        }
        else {
            button4.setBackgroundColor(arr[0]);
            buttoncolor4=arr[0];
            currentColor=0;

        }
    }
    public void changeColor5 (View view){
        for (int i = 0;i<11;i++) {
            if (((ColorDrawable)button5.getBackground()).getColor() == (arr[i])){
                currentColor=i;
                String str = " currentColor = "+currentColor;

            }
        }
        if (currentColor!=10) {
            button5.setBackgroundColor((arr[currentColor+1]));
            buttoncolor5=arr[currentColor+1];

        }
        else {
            button5.setBackgroundColor(arr[0]);
            buttoncolor5=arr[0];
            currentColor=0;

        }
    }
    public void plus0 (View view){
        counter0++;

        view0.setText(String.valueOf(counter0));
    }
    public void minus0 (View view){
        counter0--;

        view0.setText(String.valueOf(counter0));
    }
    public void plus1 (View view){
        counter1++;

        view1.setText(String.valueOf(counter1));
    }
    public void minus1 (View view){
        counter1--;

        view1.setText(String.valueOf(counter1));
    }
    public void plus2 (View view){
        counter2++;

        view2.setText(String.valueOf(counter2));
    }
    public void minus2 (View view){
        counter2--;

        view2.setText(String.valueOf(counter2));
    }
    public void plus3 (View view){
        counter3++;

        view3.setText(String.valueOf(counter3));
    }
    public void minus3 (View view){
        counter3--;

        view3.setText(String.valueOf(counter3));
    }
    public void plus4 (View view){
        counter4++;

        view4.setText(String.valueOf(counter4));
    }
    public void minus4 (View view){
        counter4--;

        view4.setText(String.valueOf(counter4));
    }
    public void plus5 (View view){
        counter5++;

        view5.setText(String.valueOf(counter5));
    }
    public void minus5 (View view){
        counter5--;

        view5.setText(String.valueOf(counter5));
    }
    public void startTimer (View view){
        if (!timerRun) {
            thread = new Thread(new timerForCounter());
            thread.start();
        }
    }
    public void resetTimer (View view){
        timerRun = false;
        timer = time;
        mPlayer.pause();
        //textTimer.setText(String.valueOf(timer));
        Message msg2 = new Message();
        msg2.obj = timer.toString();
        handler.sendMessage(msg2);
    }
    public void plus5sec (View view){
        time = time +5;
        Message msg4 = new Message();
        msg4.obj = time.toString();
        handler.sendMessage(msg4);
    }
    public void minus5sec (View view){
        time = time -5;
        Message msg5 = new Message();
        msg5.obj = time.toString();
        handler.sendMessage(msg5);
    }
    class timerForCounter implements Runnable {

        public void run() {
                try {
                    Thread.sleep(100);
                    timer = time;
                    timerRun = true;
                    Message msg = new Message();
                    msg.obj = timer.toString();
                    handler.sendMessage(msg);

                    //textTimer.setText(timer);

                    while (timerRun) {
                        if (timer == 0) {
                            mPlayer.start();
                            Thread.sleep(2500);
                            mPlayer.start();

                            timerRun = false;
                            break;
                        }
                        timer--;

                        Message msg1 = new Message();
                        msg1.obj = timer.toString();
                        handler.sendMessage(msg1);
                        //textTimer.setText(timer);

                        Thread.sleep(1000);
                        //TimeUnit.SECONDS.sleep(1);
                    }


                }

            catch(Exception e){
                textTimer.setText("Error");
            }

        }


    }
}

