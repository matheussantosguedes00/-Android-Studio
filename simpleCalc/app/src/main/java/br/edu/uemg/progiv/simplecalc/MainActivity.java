package br.edu.uemg.progiv.simplecalc;

import androidx.appcompat.app.AppCompatActivity;

import android.app.backup.RestoreObserver;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int i = 0; //índice de números para operação
    int count = 0; //qte de caracteres de números. max = 7
    int[] Result; //Array dos números digitados
    int Total; //resultado
    static int INVALID = 9999999; //constante de erro
    String operacao; //variável para controle de operação

    /*
    Botões:
     */
    Button btn00, btn01, btn02, btn03, btn04, btn05, btn06, btn07, btn08, btn09;
    Button btnSoma, btnSub, btnMult, btnDiv, btnIgual, btnLimp;

    TextView RESULTSCREEN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Result = new int[2]; //Result[0] Result[1]

        //link com os componentes da tela:
        RESULTSCREEN = (TextView) findViewById(R.id.RESULTSCREEN);
        btn00 = (Button) findViewById(R.id.button0);
        btn01 = (Button) findViewById(R.id.button1);
        btn02 = (Button) findViewById(R.id.button2);
        btn03 = (Button) findViewById(R.id.button3);
        btn04 = (Button) findViewById(R.id.button4);
        btn05 = (Button) findViewById(R.id.button5);
        btn06 = (Button) findViewById(R.id.button6);
        btn07 = (Button) findViewById(R.id.button7);
        btn08 = (Button) findViewById(R.id.button8);
        btn09 = (Button) findViewById(R.id.button9);

        btnSoma = (Button) findViewById(R.id.buttonsoma);
        btnSub = (Button) findViewById(R.id.buttonsub);
        btnDiv = (Button) findViewById(R.id.buttondiv);
        btnMult = (Button) findViewById(R.id.buttonmult);
        btnLimp = (Button) findViewById(R.id.buttonLimpar);
        btnIgual = (Button) findViewById(R.id.buttonigual);

        btn00.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(count < 7){
                    Result[i] = (Result[i] * 10);
                    count++;
                }
                exibirResultado();
                Total = 0;
            }
        });

        btn01.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(count < 7){
                    Result[i] = (Result[i] * 10) + 1;
                    count++;
                }
                exibirResultado();
                Total = 0;
            }
        });

        btn02.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(count < 7){
                    Result[i] = (Result[i] * 10) + 2;
                    count++;
                }
                exibirResultado();
                Total = 0;
            }
        });

        btn03.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(count < 7){
                    Result[i] = (Result[i] * 10) + 3;
                    count++;
                }
                exibirResultado();
                Total = 0;
            }
        });

        btn04.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(count < 7){
                    Result[i] = (Result[i] * 10) + 4;
                    count++;
                }
                exibirResultado();
                Total = 0;
            }
        });

        btn05.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(count < 7){
                    Result[i] = (Result[i] * 10) + 5;
                    count++;
                }
                exibirResultado();
                Total = 0;
            }
        });

        btn06.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(count < 7){
                    Result[i] = (Result[i] * 10) + 6;
                    count++;
                }
                exibirResultado();
                Total = 0;
            }
        });

        btn07.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(count < 7){
                    Result[i] = (Result[i] * 10) + 7;
                    count++;
                }
                exibirResultado();
                Total = 0;
            }
        });

        btn08.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(count < 7){
                    Result[i] = (Result[i] * 10) + 8;
                    count++;
                }
                exibirResultado();
                Total = 0;
            }
        });

        btn09.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(count < 7){
                    Result[i] = (Result[i] * 10) + 9;
                    count++;
                }
                exibirResultado();
                Total = 0;
            }
        });

        //botões de funções:
        btnSoma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Result[0] > 0 && Result[1] >0)
                    sinalIgual();
                operacao = "soma";
                proximoNumero();
            }
        });

        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Result[0] > 0 && Result[1] >0)
                    sinalIgual();
                operacao = "sub";
                proximoNumero();
            }
        });
        //mult | div
        btnMult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Result[0] > 0 && Result[1] >0)
                    sinalIgual();
                operacao = "mult";
                proximoNumero();
            }
        });

        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Result[0] > 0 && Result[1] >0)
                    sinalIgual();
                operacao = "div";
                proximoNumero();
            }
        });


        btnIgual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sinalIgual();
            }
        });

        btnLimp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                limpar();
            }
        });
    }

    private void sinalIgual(){
        calcular();
        exibirResultado(); //Trocar o resultado na tela
        Total = 0; //Zerar o valor de total
        count = 0; //Zerar o contador
    }

    private void exibirResultado(){
        String tela = "";
        if(Total != 0 && Total < INVALID) {
            //Se o valor total for válido
            tela = String.valueOf(Total);
        }else if (Total > INVALID){
            //se o valor total for inválido
            tela = "ERROR";
        }else{
            //Se ainda não foi calculado o resultado
            tela = String.valueOf(Result[i]);
        }
        RESULTSCREEN.setText(tela);
    }

    private void proximoNumero(){
        count = 0;
        i = 1;
    }

    private void limpar(){
        i = 0;
        Result[0] = 0;
        Result[1] = 0;
        Total = 0;
        count = 0;
        exibirResultado();
    }

    private void calcular(){
        double value;
        switch (operacao){
            //Executa as operações e sai do switch
            case "soma": Total = (Result[0] + Result[1]); break;
            case "sub":  Total = (Result[0] - Result[1]); break;
            //mult | div
            case "mult": Total = (Result[0] * Result[1]); break;
            case "div":  Total = (Result[0] / Result[1]); break;
        }
        //se for um valor inválido:
        if(Total < INVALID){
            Result[0] = Total; //Para executar mais operações
            Result[1] = 0;     //Passa para o segundo valor
            i = 1;
        }
    }

}