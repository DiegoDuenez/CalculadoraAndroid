package com.example.calculadoramac;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

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
    TextView pantalla;
    TextView pantallaHistorico;

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

        pantalla=(TextView)findViewById(R.id.screen);
        pantallaHistorico=(TextView)findViewById(R.id.screenhistorico);
    }
    @Override
    public void onClick(View v) {
        int seleccion=v.getId();
        String p = pantalla.getText().toString();
        String pHistorico = pantallaHistorico.getText().toString();
        String cadena = "";

        try {
            switch (seleccion){
                case R.id.num0:
                    pantalla.setText(p+"0");
                    cadena+="0";
                    break;
                case R.id.num1:
                    pantalla.setText(p+"1");
                    cadena+="1";
                    break;
                case R.id.num2:
                    pantalla.setText(p+"2");
                    cadena+="2";
                    break;
                case R.id.num3:
                    pantalla.setText(p+"3");
                    cadena+="3";
                    break;
                case R.id.num4:
                    pantalla.setText(p+"4");
                    cadena+="4";
                    break;
                case R.id.num5:
                    pantalla.setText(p+"5");
                    cadena+="5";
                    break;
                case R.id.num6:
                    pantalla.setText(p+"6");
                    cadena+="6";
                    break;
                case R.id.num7:
                    pantalla.setText(p+"7");
                    cadena+="7";
                    break;
                case R.id.num8:
                    pantalla.setText(p+"8");
                    cadena+="8";
                    break;
                case R.id.num9:
                    pantalla.setText(p+"9");
                    cadena+="9";
                    break;
                case R.id.btnDec:
                    if(decimal==false){
                        pantalla.setText(p+".");
                        decimal =true;
                        cadena+=".";
                    }else{return;}
                    break;
                case R.id.btnPorc:
                    porcent=true;
                    numeros[0]=Double.parseDouble(p);
                    pantalla.setText("");
                    resultado=numeros[0]/100;
                    cadena+="%";
                    pantalla.setText(String.valueOf(resultado));
                    decimal=false;
                    break;
                case R.id.btnRest:
                    resta=true;
                    numeros[0]=Double.parseDouble(p);
                    pantalla.setText("");
                    cadena+="-";
                    decimal=false;
                    porcent=false;
                    break;
                case R.id.btnSum:
                    suma=true;
                    cadena+="+";
                    numeros[0]=Double.parseDouble(p);
                    pantalla.setText("");
                    decimal=false;
                    porcent=false;
                    break;
                case R.id.btnDiv:
                    div=true;
                    numeros[0]=Double.parseDouble(p);
                    pantalla.setText("");
                    cadena+="/";
                    decimal=false;
                    porcent=false;
                    break;
                case R.id.btnMult:
                    mult=true;
                    numeros[0]=Double.parseDouble(p);
                    pantalla.setText("");
                    cadena+="*";
                    decimal=false;
                    porcent=false;
                    break;
                case R.id.btnIgual:
                    numeros[1]=Double.parseDouble(p);
                    obternerResultado(pHistorico);
                    /*if(resta==true){
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
                    }*/
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
                    cadena="";
                    pHistorico="";
                    decimal=false;
                    porcent=false;
                    break;
            }
            pantallaHistorico.setText(pHistorico+cadena);
        }catch (Exception e){
            pantalla.setText("ERROR");
        }

    }
    public void obternerResultado(String cadena){
        String historico = cadena;
        //obternerResultado("89.9*86.0+85.02/26");
        String[] numeros = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9","."};
        ArrayList<String> cifras = new ArrayList<String>(), operaciones = new ArrayList<String>();
        String verificaCaracter="";
        Boolean encontro=false;
        Integer posicion = 1;
        Log.d("Aviso", "obternerResultado: "+cadena);
        while (cadena.length() > 0)
        {
            verificaCaracter=cadena.substring(posicion - 1, posicion);
            encontro=false;
            for (int avance = 0; avance < numeros.length; avance++) {
                if (verificaCaracter.equals(numeros[avance])) {
                    encontro=true;
                    break;
                }
            }
            if(!encontro){
                cifras.add(cadena.substring(0,posicion - 1));
                operaciones.add(cadena.substring(posicion -1,posicion));
                cadena=cadena.substring(posicion);
                posicion=0 ;
                Log.d("Aviso", "obternerResultado: "+cadena);
            }
            posicion++;
            if( posicion >= cadena.length()){
                cifras.add(cadena);
                operaciones.add("=");
                cadena="";
            }
        }
        if(cifras.size() > 0){
            String resultado="";
            for (int avance = 0; avance < operaciones.size(); avance++) {
                if (operaciones.get(avance).equals("=")){
                    Log.d("Aviso", "obternerResultado: "+ resultado);
                    String pHistorico = historico+" = " + resultado;
                    pantallaHistorico.setText(historico+" = "+resultado);
                    pantalla.setText(resultado);
                    break;
                }
                float operacion=0;
                if( cifras.size() > avance ) {
                    switch (operaciones.get(avance)) {
                        case "+":
                            operacion = (Float.parseFloat(cifras.get(avance)) + Float.parseFloat(cifras.get(avance + 1)));
                            Log.d("Aviso", "obternerResultado: " + cifras.get(avance) + " + " + cifras.get(avance + 1) + " = " + Float.toString(operacion));
                            break;
                        case "-":
                            operacion = (Float.parseFloat(cifras.get(avance)) - Float.parseFloat(cifras.get(avance + 1)));
                            Log.d("Aviso", "obternerResultado: "+ cifras.get(avance) + " - " + cifras.get(avance + 1) + " = " + Float.toString(operacion));
                            break;
                        case "*":
                            operacion = (Float.parseFloat(cifras.get(avance)) * Float.parseFloat(cifras.get(avance + 1)));
                            Log.d("Aviso", "obternerResultado: "+ cifras.get(avance) + " * " + cifras.get(avance + 1) + " = " + Float.toString(operacion));
                            break;
                        case "/":
                            operacion = (Float.parseFloat(cifras.get(avance)) / Float.parseFloat(cifras.get(avance + 1)));
                            Log.d("Aviso", "obternerResultado: "+ cifras.get(avance) + " / " + cifras.get(avance + 1) + " = " + Float.toString(operacion));
                            break;
                    }
                    cifras.set(avance + 1, Float.toString(operacion));
                    resultado = Float.toString(operacion);
                }
            }
        }
    }
}