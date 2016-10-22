package barros.jeferson.beermanaus;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.oceanbrasil.libocean.Ocean;
import com.oceanbrasil.libocean.control.glide.GlideRequest;

import java.util.ArrayList;

/**
 * Created by Jeferson Barros (im.jbalves@gmail.com) on 10/20/16.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private final Context context;
    private ArrayList<Bar> lista;

    private AdapterListener mAdapterListener;

    public MyAdapter (Context context, ArrayList<Bar> lista) {
        this.lista = lista;
        this.context = context;
    }

    public AdapterListener getmAdapterListener() {
        return mAdapterListener;
    }

    public void setmAdapterListener(AdapterListener mAdapterListener) {
        this.mAdapterListener = mAdapterListener;
    }

    //#2 Monta o layout da lista
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_bar_list,null);
        return new ViewHolder(view);
    }

    //#3 recupera uma posição da lista no layout
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        //Recupera a referência do Bar
        Bar bar = lista.get(position);

        //Seta os valores do livro para o layout dentro do holder
        holder
                .setNome(bar.getNome())
                .setHorario(bar.getHorarioFuncionamento())
                .setFoto(bar.getFotoDivulgacao());
    }

    //#4 conta a quantidade de elementos existente na lista
    @Override
    public int getItemCount() {
        //tamanho da lista
        return lista.size();
    }

    //#1 método a ser implementado
    //mapeia os elementos de layout
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView nomeView;
        private TextView horarioFuncionamentoView;
        private ImageView fotoBarView;

        public ViewHolder(View itemView) {
            super(itemView);


            //Recuperando as referências do layout
            nomeView = (TextView) itemView.findViewById(R.id.nomeBarText);
            horarioFuncionamentoView = (TextView) itemView.findViewById(R.id.horarioText);
            fotoBarView = (ImageView) itemView.findViewById(R.id.fotoBarDivulgacaoImage);

            //Simula o click
            itemView.setOnClickListener(this);

        }

        public ViewHolder setNome(String nome) {
            if (nomeView == null) return this;
            nomeView.setText(nome);
            return this;
        }

        public ViewHolder setHorario(String horario) {
            if (horarioFuncionamentoView == null) return this;
            horarioFuncionamentoView.setText(horario);
            return this;
        }

        public ViewHolder setFoto(String foto) {
            if (fotoBarView == null) return this;

            Ocean
                    .glide(context)
                    .load(foto)
                    .build(GlideRequest.BITMAP)
                    //.resize(200,200)
                    .into(fotoBarView);

            return this;
        }

        @Override
        public void onClick(View view) {
            int position = getPosition();

            if (mAdapterListener != null) {
                mAdapterListener.onItemClick(view, position);
            }
        }
    }

    public interface AdapterListener {
        public void onItemClick (View view, int position);
    }
}
