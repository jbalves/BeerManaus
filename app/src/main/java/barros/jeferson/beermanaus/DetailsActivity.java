package barros.jeferson.beermanaus;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.oceanbrasil.libocean.Ocean;
import com.oceanbrasil.libocean.control.glide.GlideRequest;

/**
 * Created by Jeferson Barros on 21/10/2016.
 */

public class DetailsActivity extends AppCompatActivity {

    private TextView mNomeTextView;
    private TextView mHorarioTextView;
    private TextView mAtrativosTextView;
    private TextView mEnderecoTextView;
    private ImageView mFotoImageView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.datails_activity);

        //Informacoes do bar passado via Extra
        Bar bar = recuperarBar();
        //Recuperando views do layout para acessar o layout
        recuperarViews();
        //Setando os valores do bar para o layout
        setBar(bar);
    }

    private void setBar(Bar bar) {
        mNomeTextView.setText(bar.getNome());
        mHorarioTextView.setText(bar.getHorarioFuncionamento());
        mAtrativosTextView.setText(bar.getHorarioFuncionamento());
        mEnderecoTextView.setText(bar.getEndereco());
        Ocean
                .glide(this)
                .load(bar.getFotoDivulgacao())
                .build(GlideRequest.BITMAP)
                .resize(200,200)
                .into(mFotoImageView);
    }

    /**
     * Recuperando as referencias do layout
     */
    private void recuperarViews() {
        //Recuperando as view do layout
        mNomeTextView = (TextView) findViewById(R.id.nomeDetails);
        mHorarioTextView = (TextView) findViewById(R.id.horarioDetails);
        mAtrativosTextView = (TextView) findViewById(R.id.atrativosDetails);
        mEnderecoTextView = (TextView) findViewById(R.id.enderecoDetails);
        mFotoImageView = (ImageView) findViewById(R.id.fotoDetails);
    }

    /**
     * Recuperando todas as informacoes do livro
     * @return Bar
     */
    private Bar recuperarBar() {
        Bar bar = new Bar();
        bar = (Bar) getIntent().getSerializableExtra("bar");
        return bar;
    }

}
