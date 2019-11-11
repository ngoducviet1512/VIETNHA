package com.example.testduan1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    ImageView img_cauhoi;
    Button btn_traloi;
    private int indexdadung = 0;
    public int[] cauhoiList = {R.drawable.baocao ,R.drawable.cadao,R.drawable.neodon,R.drawable.bahoa,R.drawable.canbang,R.drawable.matma};
    public String[] dapanList = {"BAOCAO","CADAO","NEODON","BAHOA","CANBANG","MATMA"};
    private Random random = new Random();
    int[] listIndexdadung = new int[cauhoiList.length];
    private int rd;
    int dem=0;
    int i=0;
    private Button[] buttons;
    private LinearLayout ll;
    private LinearLayout llgoiy;
    private LinearLayout llgoiy2;
    private LinearLayout linerimg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rd = random();
        ll = (LinearLayout)findViewById(R.id.linerdapan);
        goiydapan();
        creatImage();
        creatButton();
    }
    public void creatImage() {
        linerimg = (LinearLayout) findViewById(R.id.linerimg);
        ImageView[]iv = new ImageView[cauhoiList.length];
        iv[rd]=new ImageView(this);
        iv[rd].setImageResource(cauhoiList[rd]);
        linerimg.addView(iv[rd]);
    }
    public void goiydapan(){

        llgoiy = (LinearLayout)findViewById(R.id.linerdoiydapan);
        llgoiy2 = (LinearLayout)findViewById(R.id.linerdoiydapan2);
        ArrayList<Integer> arrSo=new ArrayList<>();
        for (int i=0;i<8;i++){
            Button btn= new Button(this);
            btn.setLayoutParams(new LinearLayout.LayoutParams(80,80));
            while (btn.getText()=="") {
                int tmp=random.nextInt(16);
                if (check(arrSo, tmp)) {
                    btn.setText((CharSequence) randomQuestions().get(tmp));
                    randomQuestions().remove(tmp);
                    arrSo.add(tmp);
                }
            }
            llgoiy.addView(btn);
        }
        for (int i=0;i<8;i++){
            Button btn= new Button(this);
            btn.setLayoutParams(new LinearLayout.LayoutParams(80,80));
            while (btn.getText()=="") {
                int tmp=random.nextInt(16);
                if (check(arrSo, tmp)) {
                    btn.setText((CharSequence) randomQuestions().get(tmp));
                    randomQuestions().remove(tmp);
                    arrSo.add(tmp);
                }
            }
            llgoiy2.addView(btn);
        }

    }
    public ArrayList randomQuestions(){
        ArrayList<String> arrS =new ArrayList<>();
        int tm=random.nextInt(25)+65;
        for (int i=0;i<dapanList[rd].length();i++){
            arrS.add(dapanList[rd].charAt(i)+"");
        }
        for (int i=0;i<16-dapanList[rd].length();i++){
            arrS.add((char)tm+"");
        }
        return arrS;
    }
    public boolean check(ArrayList<Integer> arrSo,int n){
        for (int i=0;i<arrSo.size();i++){
            if (n==arrSo.get(i)){
                return false;
            }
        }
        return true;
    }
    public int random(){
        ArrayList<Integer> arrRD=new ArrayList<>();
        int rdNumber=0;
        while (check(arrRD, rdNumber)) {
            rdNumber= random.nextInt(cauhoiList.length);
            arrRD.add(rdNumber);
        }
        return rdNumber;
    }

    public void creatButton() {
        ll = (LinearLayout) findViewById(R.id.linerdapan);
        buttons= new Button[dapanList[rd].length()];
        for (int i = 0; i < dapanList[rd].length(); i++) {
            Button btn = new Button(this);
            btn.setLayoutParams(new LinearLayout.LayoutParams(80,80));
            btn.setId(i);
            ll.addView(btn);
            buttons[i] = (Button) findViewById(btn.getId());
        }
    }
    @Override
    public void onClick(View v) {
        Button button = (Button) v;
        buttons[i].setText("O");
        i++;
        v.setEnabled(false);
        v.setBackgroundColor(601800);
        ((Button) v).setText("");
        dem++;
        }

}
