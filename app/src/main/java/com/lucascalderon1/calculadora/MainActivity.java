package com.lucascalderon1.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button numeroZero, numeroUm, numeroDois, numeroTres, numeroQuatro, numeroCinco, numeroSeis,
    numeroSete, numeroOito, numeroNove, ponto, soma, subtracao, multiplicacao, divisao, igual, botao_limpar;
    private TextView txtExpressao, txtResultado;
    private ImageView backspace;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        IniciarComponentes();
        getSupportActionBar().hide();

        numeroZero.setOnClickListener(this);
        numeroUm.setOnClickListener(this);
        numeroDois.setOnClickListener(this);
        numeroTres.setOnClickListener(this);
        numeroQuatro.setOnClickListener(this);
        numeroCinco.setOnClickListener(this);
        numeroSeis.setOnClickListener(this);
        numeroSete.setOnClickListener(this);
        numeroOito.setOnClickListener(this);
        numeroNove.setOnClickListener(this);
        ponto.setOnClickListener(this);
        divisao.setOnClickListener(this);
        multiplicacao.setOnClickListener(this);
        subtracao.setOnClickListener(this);
        soma.setOnClickListener(this);
        igual.setOnClickListener(this);


        botao_limpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtExpressao.setText("");
                txtResultado.setText("");
            }
        });

        backspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView expressao = findViewById(R.id.txt_expressao);
                String string = expressao.getText().toString();

                if (!string.isEmpty()){
                    byte var0 = 0;
                    int var1 = string.length()-1;
                    String txtExpressao = string.substring(var0, var1);
                    expressao.setText(txtExpressao);
                }

                txtResultado.setText("");
            }
        });

        igual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

                    Expression expressao = new ExpressionBuilder(txtExpressao.getText().toString()).build();
                    double resultado = expressao.evaluate();
                    long longResult = (long) resultado;

                    if (resultado ==(double) longResult) {
                        txtResultado.setText((CharSequence) String.valueOf(longResult));
                    }else {
                        txtResultado.setText((CharSequence) String.valueOf(resultado));
                    }

                }catch (Exception e){

                }


                }
        });

    }

    private void IniciarComponentes(){
        numeroZero = findViewById(R.id.numero_zero);
        numeroUm = findViewById(R.id.numero_um);
        numeroDois = findViewById(R.id.numero_2);
        numeroTres = findViewById(R.id.numero_3);
        numeroQuatro = findViewById(R.id.numero_4);
        numeroCinco = findViewById(R.id.numero_5);
        numeroSeis = findViewById(R.id.numero_6);
        numeroSete = findViewById(R.id.numero_7);
        numeroOito = findViewById(R.id.numero_8);
        numeroNove = findViewById(R.id.numero_9);
        ponto = findViewById(R.id.ponto);
        soma = findViewById(R.id.numero_soma);
        subtracao = findViewById(R.id.subtracao);
        multiplicacao = findViewById(R.id.multiplicacao);
        divisao = findViewById(R.id.bt_divisao);
        igual = findViewById(R.id.igual);
        botao_limpar = findViewById(R.id.bt_limpar);
        backspace = findViewById(R.id.backspace);
        txtExpressao = findViewById(R.id.txt_expressao);
        txtResultado = findViewById(R.id.txt_resultado);
    }


public void AcrescentarUmaExpressao(String string, boolean limpar_dados){
        if (txtResultado.getText().equals("")){
            txtExpressao.setText(" ");

        }

        if (limpar_dados){
            txtResultado.setText(" ");
            txtExpressao.append(string);

        }else {
            txtExpressao.append(txtResultado.getText());
            txtExpressao.append(string);
            txtResultado.setText(" ");
        }

}

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.numero_zero:
                AcrescentarUmaExpressao("0", true);
                break;

            case R.id.numero_um:
                AcrescentarUmaExpressao("1", true);
                break;

            case R.id.numero_2:
                AcrescentarUmaExpressao("2", true);
                break;

            case R.id.numero_3:
                AcrescentarUmaExpressao("3", true);
                break;


            case R.id.numero_4:
                AcrescentarUmaExpressao("4", true);
                break;

            case R.id.numero_5:
                AcrescentarUmaExpressao("5", true);
                break;

            case R.id.numero_6:
                AcrescentarUmaExpressao("6", true);
                break;

            case R.id.numero_7:
                AcrescentarUmaExpressao("7", true);
                break;

            case R.id.numero_8:
                AcrescentarUmaExpressao("8", true);
                break;

            case R.id.numero_9:
                AcrescentarUmaExpressao("9", true);
                break;

            case R.id.ponto:
                AcrescentarUmaExpressao(".", true);
                break;

            case R.id.numero_soma:
                AcrescentarUmaExpressao("+", true);
                break;


            case R.id.igual:
                AcrescentarUmaExpressao("", false);
                break;

            case R.id.subtracao:
                AcrescentarUmaExpressao("-", false);
                break;

            case R.id.multiplicacao:
                AcrescentarUmaExpressao("*", false);
                break;

            case R.id.bt_divisao:
                AcrescentarUmaExpressao("/", false);
                break;




        }
    }
}