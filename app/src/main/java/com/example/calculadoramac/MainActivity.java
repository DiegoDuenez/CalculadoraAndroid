package com.example.calculadoramac;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    boolean decimal = false;
    boolean ac = false;
    boolean porcent = false;
    boolean resta = false;
    boolean div= false;
    boolean suma = false;
    boolean mult = false;

    double[] numeros = new double[20];
    double resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    Button cero=(Button)findViewById(R.id.num0);
    cero.setOnClickListener(this);

    Button uno=(Button)findViewById(R.id.num1);
    uno.setOnClickListener(this);

    Button dos=(Button)findViewById(R.id.num2);
    dos.setOnClickListener(this);

    Button tres=(Button)findViewById(R.id.num3);
    tres.setOnClickListener(this);

    Button cuatro=(Button)findViewById(R.id.num4);
    cuatro.setOnClickListener(this);

    Button cinco=(Button)findViewById(R.id.num5);
    cinco.setOnClickListener(this);

    Button seis=(Button)findViewById(R.id.num6);
    seis.setOnClickListener(this);

    Button siete=(Button)findViewById(R.id.num7);
    siete.setOnClickListener(this);

    Button ocho=(Button)findViewById(R.id.num8);
    ocho.setOnClickListener(this);

    Button nueve=(Button)findViewById(R.id.num9);
    nueve.setOnClickListener(this);

    Button resta=(Button)findViewById(R.id.btnRest);
    resta.setOnClickListener(this);

    Button suma=(Button)findViewById(R.id.btnSum);
    suma.setOnClickListener(this);

    Button mult=(Button)findViewById(R.id.btnMult);
    mult.setOnClickListener(this);

    Button div=(Button)findViewById(R.id.btnDiv);
    div.setOnClickListener(this);

    Button igual=(Button)findViewById(R.id.btnIgual);
    igual.setOnClickListener(this);

    Button borrar=(Button)findViewById(R.id.btnAC);
    borrar.setOnClickListener(this);

    Button porcentaje=(Button)findViewById(R.id.btnPorc);
    porcentaje.setOnClickListener(this);

    Button decimal=(Button)findViewById(R.id.btnDec);
    decimal.setOnClickListener(this);




    }

    @Override
    public void onClick(View v) {
        TextView pantalla=(TextView)findViewById(R.id.screen);
        int seleccion=v.getId();
        String p = pantalla.getText().toString();
        try {
            switch (seleccion){
                case R.id.num0:
                    pantalla.setText(p+"0");
                    break;
                case R.id.num1:
                    pantalla.setText(p+"1");
                    break;
                case R.id.num2:
                    pantalla.setText(p+"2");
                    break;
                case R.id.num3:
                    pantalla.setText(p+"3");
                    break;
                case R.id.num4:
                    pantalla.setText(p+"4");
                    break;
                case R.id.num5:
                    pantalla.setText(p+"5");
                    break;
                case R.id.num6:
                    pantalla.setText(p+"6");
                    break;
                case R.id.num7:
                    pantalla.setText(p+"7");
                    break;
                case R.id.num8:
                    pantalla.setText(p+"8");
                    break;
                case R.id.num9:
                    pantalla.setText(p+"9");
                    break;
                case R.id.btnDec:
                    if(decimal==false){
                        pantalla.setText(p+".");
                        decimal =true;
                    }else{return;}
                    break;
                case R.id.btnPorc:
                    porcent=true;
                    numeros[0]=Double.parseDouble(p);
                    pantalla.setText("");
                    resultado=numeros[0]/100;
                    pantalla.setText(String.valueOf(resultado));
                    decimal=false;
                    break;
                case R.id.btnRest:
                    resta=true;
                    numeros[0]=Double.parseDouble(p);
                    pantalla.setText("");
                    decimal=false;
                    porcent=false;
                    break;
                case R.id.btnSum:
                    suma=true;
                    numeros[0]=Double.parseDouble(p);
                    pantalla.setText("");
                    decimal=false;
                    porcent=false;
                    break;
                case R.id.btnDiv:
                    div=true;
                    numeros[0]=Double.parseDouble(p);
                    pantalla.setText("");
                    decimal=false;
                    porcent=false;
                    break;
                case R.id.btnMult:
                    mult=true;
                    numeros[0]=Double.parseDouble(p);
                    pantalla.setText("");
                    decimal=false;
                    porcent=false;
                    break;
                case R.id.btnIgual:
                    numeros[1]=Double.parseDouble(p);
                    if(resta==true){
                        resultado=numeros[0]-numeros[1];
                        pantalla.setText(String.valueOf(resultado));
                    }
                    else if(suma==true){
                        resultado=numeros[0]+numeros[1];
                        pantalla.setText(String.valueOf(resultado));
                    }
                    else if(mult==true){
                        resultado=numeros[0]*numeros[1];
                        pantalla.setText(String.valueOf(resultado));
                    }
                    else if(div==true){
                        resultado=numeros[0]/numeros[1];
                        pantalla.setText(String.valueOf(resultado));
                    }
                    decimal=false;
                    porcent=false;
                    mult=false;
                    suma=false;
                    resta=false;
                    div=false;
                    ac=false;
                    break;
                case R.id.btnAC:
                    pantalla.setText("");
                    decimal=false;
                    porcent=false;
                    break;
            }
        }catch (Exception e){
            pantalla.setText("ERROR");
        }

    }
}