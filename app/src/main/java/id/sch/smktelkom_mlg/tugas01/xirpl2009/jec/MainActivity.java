package id.sch.smktelkom_mlg.tugas01.xirpl2009.jec;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText etNama, etUsia;
    TextView tvhasil, tvhasil2, tvhasil3, tvhasil4, tvhasil5;
    Button bOK;
    RadioButton laki, perem;
    Spinner spkota;
    CheckBox pemweb, pemjav, dabes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        laki = (RadioButton) findViewById(R.id.lk);
        perem = (RadioButton) findViewById(R.id.pr);
        pemweb = (CheckBox) findViewById(R.id.pemweb);
        pemjav = (CheckBox) findViewById(R.id.pemjav);
        dabes = (CheckBox) findViewById(R.id.dabes);
        etNama = (EditText) findViewById(R.id.editTextNama);
        etUsia = (EditText) findViewById(R.id.editTextUsia);
        spkota = (Spinner) findViewById(R.id.kota);
        bOK = (Button) findViewById(R.id.buttonOK);
        tvhasil = (TextView) findViewById(R.id.hasil);
        tvhasil2 = (TextView) findViewById(R.id.hasil2);
        tvhasil3 = (TextView) findViewById(R.id.hasil3);
        tvhasil4 = (TextView) findViewById(R.id.hasil4);
        tvhasil5 = (TextView) findViewById(R.id.hasil5);
        
        bOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doProcess();
                doClick();
            }
        });
    }

    private void doClick() {
            String hasil5="Keahlian :\n ";
            int startln = hasil5.length();

            if (pemweb.isChecked()) hasil5+=pemweb.getText();
            if (pemjav.isChecked()) hasil5+=pemjav.getText();
            if (dabes.isChecked()) hasil5+=dabes.getText();

            if (hasil5.length()==startln) hasil5+="GAGAL";
            tvhasil5.setText(hasil5);

            String hasil3 = null;
        if (laki.isChecked()) {
            hasil3 = laki.getText().toString();
        } else if (perem.isChecked()) {
            hasil3 = perem.getText().toString();
        }
            if (hasil3 == null)
            {
                tvhasil3.setText("Anda belum memilih Gender");
            }
            else {
                tvhasil3.setText("Gender : "+ hasil3);
            }

            tvhasil4.setText("Asal : "+ spkota.getSelectedItem().toString());
    }

    private void doProcess() {
        if (isValid())
        {
            String nama = etNama.getText().toString();
            tvhasil.setText("Nama : " + nama);
            String usia = etUsia.getText().toString();
            tvhasil2.setText("Usia : " + usia);
        }
    }

    private boolean isValid() {
        boolean valid = true;
        String nama = etNama.getText().toString();

        if (nama.isEmpty())
        {
            etNama.setError("Nama belum diisi");
            valid = false;
        }
        else {
            etNama.setError(null);
        }

        String usia = etUsia.getText().toString();

        if (usia.isEmpty())
        {
            etUsia.setError("Umur belum diisi");
            valid = false;
        }
        else
        {
            etUsia.setError(null);
        }
        return valid;
    }
}
