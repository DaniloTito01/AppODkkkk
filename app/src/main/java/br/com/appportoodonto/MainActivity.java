package br.com.appportoodonto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText txtCep;
    Button btnCalculo;
    int cep1;
    String IdTipo;

    String IdCep;
    String IdPorte;
    String IdPlano;
    String IdFinal;


    RadioButton TipoMax;
    RadioButton TipoMin;
    RadioButton PlanoSim;
    RadioButton PlaNao;
    EditText txtVidas;
    int QdtVidas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//Começo do Cep
     ///   txtCep = (EditText) findViewById(R.id.txtCepN);
        btnCalculo = (Button) findViewById(R.id.btnCalcular);
        TipoMax = (RadioButton) findViewById(R.id.rbnTipoMax);
        TipoMin = (RadioButton) findViewById(R.id.rbnTipoMin);
        PlanoSim = (RadioButton) findViewById(R.id.rbnPlanoSim);
        PlaNao = (RadioButton) findViewById(R.id.rbnPlanoNao);
      ///  txtVidas = (EditText) findViewById(R.id.TxtQdtVidas);


        btnCalculo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ValidacaoCep();






            }
        });
// Fim do Cep

    }



    public void ValidacaoCep(){


        if (!"".equals(txtCep.getText().toString())) {
            cep1 = Integer.parseInt(txtCep.getText().toString());

            Cep cep = new Cep();
            cep.setCep(cep1);
            cep.ValidaCep();

            IdCep = cep.IdCep;

            ValidacaoTip();

         //  Toast.makeText(getApplicationContext(), "Ok" + cep.getUf() + cep.getCep() , Toast.LENGTH_SHORT).show();

        } else {
            Toast.makeText(getApplicationContext(), "Cep Invalido", Toast.LENGTH_SHORT).show();
        }


    }

        //Começo Tipo Contratação


    public void ValidacaoTip() {


        if (TipoMax.isChecked() || TipoMin.isChecked()) {

            if (TipoMax.isChecked()) {

              IdTipo ="1";

               // Toast.makeText(getApplicationContext(), "100%", Toast.LENGTH_SHORT).show();
                ValidacaoPlano();
            } else {
                IdTipo ="2";

              //  Toast.makeText(getApplicationContext(), "30%", Toast.LENGTH_SHORT).show();
                ValidacaoPlano();
            }

        } else {
            Toast.makeText(getApplicationContext(), "Selecione um Tipo de Contratação ", Toast.LENGTH_SHORT).show();
        }

//Fim Tipo Contratação
    }


//Começo Plano


    public void ValidacaoPlano() {

        if (PlanoSim.isChecked() || PlaNao.isChecked()) {

            if (PlanoSim.isChecked()) {

                IdPlano ="1";


               // Toast.makeText(getApplicationContext(), "Sim", Toast.LENGTH_SHORT).show();

                ValidacaoVidas();

            } else {

                IdPlano ="2";
               // Toast.makeText(getApplicationContext(), "Nao", Toast.LENGTH_SHORT).show();

                ValidacaoVidas();
            }

        } else {
            Toast.makeText(getApplicationContext(), "Possui outro plano não informado", Toast.LENGTH_SHORT).show();
        }
//Fim Plano
    }
    //Começo Vidas


    public void ValidacaoVidas(){

    if (!"".equals(txtVidas.getText().toString())) {
            QdtVidas = Integer.parseInt(txtVidas.getText().toString());

            PorteProduto porte = new PorteProduto();
            porte.setVidas(QdtVidas);
            porte.ValidacaoVidas();


            IdPorte = porte.getId();


            Id();


        } else {Toast.makeText(getApplicationContext(), "Digite a qdt de Vidas" , Toast.LENGTH_SHORT).show();

        }


    }

    //Começo Tipo Contratação

    public void Id(){



        IdFinal = IdCep + IdTipo + IdPlano + IdPorte;

      //  Toast.makeText(getApplicationContext(), "Id :" + IdFinal, Toast.LENGTH_SHORT).show();

if(IdCep!=null && "V10".equals(IdPorte)){
    Ok();

}else { Toast.makeText(getApplicationContext(), " Não implementado", Toast.LENGTH_SHORT).show();}



    }



    public void Ok() {


        Intent intent = new Intent(getApplicationContext(), PlanosActivity.class);


      // Bundle bundle = new Bundle();
        String IdCepOk = "" + IdCep;
        String IdTipoOk = "" + IdTipo;
        String IdPlanoOk = "" +IdPlano ;
        String IdQtdVidasOk = "" + QdtVidas ;
        String IdFinalOk =""+  IdFinal ;


        intent.putExtra("IdCepOk", IdCepOk);
        intent.putExtra("IdTipoOk", IdTipoOk);
        intent.putExtra("IdPlanoOk", IdPlanoOk);
        intent.putExtra("IdQtdVidasOk", IdQtdVidasOk);
        intent.putExtra("IdFinalOk", IdFinalOk);


        startActivity(intent);





    }
}
