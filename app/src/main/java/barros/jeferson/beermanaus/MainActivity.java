package barros.jeferson.beermanaus;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.Window;


import com.oceanbrasil.libocean.Ocean;
import com.oceanbrasil.libocean.control.http.Request;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements Request.RequestListener, MyAdapter.AdapterListener {

    private ArrayList<Bar> mlista = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Ocean.newRequest("https://gitlab.com/snippets/29394/raw",this).get().send();
    }

    @Override
    public void onRequestOk(String resposta, JSONObject jsonObject, int code) {
        if (code == Request.NENHUM_ERROR) {
            stringToJson (resposta);
            criarAdapter(mlista);
        }
    }

    private void stringToJson(String resposta) {
        ArrayList<Bar> lista = new ArrayList<>();

        if (resposta != null) {

            try {
                JSONObject object = new JSONObject(resposta);
                JSONArray bares = object.getJSONArray("bares");

                for (int i = 0; i< bares.length(); i++) {
                    JSONObject bar = bares.getJSONObject(i);
                    String nome = bar.getString("nome");
                    String horario = bar.getString("horarioFuncionamento");
                    String foto = bar.getString("fotoDivulgacao");

                    Bar beer = new Bar();
                    beer.setNome(nome);
                    beer.setHorarioFuncionamento(horario);
                    beer.setFotoDivulgacao(foto);

                    mlista.add(beer);

                }

                criarAdapter(mlista);

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void criarAdapter(ArrayList<Bar> lista) {
        //Cria o adapter
        MyAdapter adapter = new MyAdapter(this, lista);
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.lista_recyclerview);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter.setmAdapterListener(this);
    }

    @Override
    public void onItemClick(View view, int position) {
        //Recupera a instância do bar selecionado
        Bar bar = mlista.get(position);
        //Intent para abrir a tela de detalhes
        Intent intent = new Intent(MainActivity.this,DetailsActivity.class);
        /**
         * Passa o objeto bar inteiro via Extra transformando a classe bar em um Serializable
         * Obs: Voce precisa implementar a interface Serializable em Bar
         */
        intent.putExtra("bar",bar);
        startActivity(intent);
    }
}
