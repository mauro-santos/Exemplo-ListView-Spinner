package br.com.maurosantos.android.exlistviewspinner;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edtValor;
    private Spinner spnOpcoes;
    private Button btnAdicionar;
    private Button btnExcuir;
    private ListView lstDados;

    private ArrayAdapter<String> adpOpcoes;
    private ArrayAdapter<String> adpDados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtValor = (EditText) findViewById(R.id.edtValor);
        spnOpcoes = (Spinner) findViewById(R.id.spnOpcoes);
        btnAdicionar = (Button) findViewById(R.id.btnAdicionar);
        btnExcuir = (Button) findViewById(R.id.btnExcluir);
        lstDados = (ListView) findViewById(R.id.lstDados);

        btnAdicionar.setOnClickListener(this);
        btnExcuir.setOnClickListener(this);

        adpOpcoes = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item);
        adpOpcoes.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnOpcoes.setAdapter(adpOpcoes);

        adpOpcoes.add("Opção 1");
        adpOpcoes.add("Opção 2");
        adpOpcoes.add("Opção 3");
        adpOpcoes.add("Opção 4");

        adpDados = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        lstDados.setAdapter(adpDados);
    }

    @Override
    public void onClick(View v) {
        if (v == btnAdicionar) {
            String item = edtValor.getText().toString().trim();

            if (item.isEmpty()) {
                AlertDialog.Builder dlg = new AlertDialog.Builder(this);
                dlg.setMessage("Informe o valor!");
                dlg.setNeutralButton("OK", null);
                dlg.show();
            } else {
                item += " - " + spnOpcoes.getSelectedItem();
                adpDados.add(item);
            }

        } else if (v == btnExcuir) {

            if (adpDados.getCount() > 0) {
                adpDados.remove(adpDados.getItem((adpDados.getCount() - 1)));
            } else {
                AlertDialog.Builder dlg = new AlertDialog.Builder(this);
                dlg.setMessage("Não há item na lista!");
                dlg.setNeutralButton("OK", null);
                dlg.show();
            }
        }
    }
}
