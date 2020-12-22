package com.example.tdee_check;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edtH, edtW ,edta;
    TextView txvR, txvBMI ,txvG ,txvBMRB,txvBMRG,TDES,TDEL,TDEM,TDEV,TDEE;
    Button button,Reset;
    RadioGroup sex;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtH = findViewById(R.id.edtH);
        edtW = findViewById(R.id.edtW);
        edta = findViewById(R.id.edta);
        sex = findViewById(R.id.sex);
        txvBMI = findViewById(R.id.txvBMI);
        txvBMRB = findViewById(R.id.txvBMRB);
        txvBMRG = findViewById(R.id.txvBMRG);
        TDES = findViewById(R.id.TDES);
        TDEL = findViewById(R.id.TDEL);
        TDEM = findViewById(R.id.TDEM);
        TDEV = findViewById(R.id.TDEV);
        TDEE = findViewById(R.id.TDEE);
        Reset = findViewById(R.id.Reset);
        Reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txvBMRB.setText("");
                txvBMRG.setText("");
                txvBMI.setText("");
                edtH.setText("");
                edtW.setText("");
                edta.setText("");
                TDES.setText("");
                TDEL.setText("");
                TDEM.setText("");
                TDEV.setText("");
                TDEE.setText("");
            }
        });

    }

    public void calculate(View v) {
        if (edtH.getText().toString().length()!=0 && edtW.getText().toString().length()!= 0 && edta.getText().toString().length()!= 0){
            double h,h1,h2, w, bmi ,bmrB ,bmrG,a,S,L,M,V,E,txdeeBS,txdeeBL,txdeeBM,txdeeBV,txdeeBE,txdeeGS,txdeeGL,txdeeGM,txdeeGV,txdeeGE;
            h = Double.parseDouble(edtH.getText().toString());
            w = Double.parseDouble(edtW.getText().toString());
            a = Double.parseDouble(edta.getText().toString());
            S = 1.2;
            L =1.375;
            M =1.55;
            V =1.729;
            E =1.9;
            h1 =h/100;
            h2 =h1*h1;
            bmi = w/h2;
            bmrB = (13.7*w)+(5.0*h)-(6.8*a)+66;
            bmrG = (9.6*w)+(1.8*h)-(4.7*a)+655;
            txdeeBS = bmrB*S;
            txdeeBL = bmrB*L;
            txdeeBM = bmrB*M;
            txdeeBV = bmrB*V;
            txdeeBE = bmrB*E;
            txdeeGS = bmrG*S;
            txdeeGL = bmrG*L;
            txdeeGM = bmrG*M;
            txdeeGV = bmrG*V;
            txdeeGE = bmrG*E;
            txvBMI.setText(String.format("%.1f",bmi));
            if (sex.getCheckedRadioButtonId() == R.id.rdbM) {
                txvBMRB.setText(String.format("%.2f", bmrB));
                TDES.setText(String.format("%.3f",txdeeBS));
                TDEL.setText(String.format("%.3f",txdeeBL));
                TDEM.setText(String.format("%.3f",txdeeBM));
                TDEV.setText(String.format("%.3f",txdeeBV));
                TDEE.setText(String.format("%.3f",txdeeBE));
            }
            if (sex.getCheckedRadioButtonId() ==R.id.rdbF) {
                txvBMRG.setText(String.format("%.3f",bmrG));
                TDES.setText(String.format("%.3f", txdeeGS));
                TDEL.setText(String.format("%.3f", txdeeGL));
                TDEM.setText(String.format("%.3f", txdeeGM));
                TDEV.setText(String.format("%.3f", txdeeGV));
                TDEE.setText(String.format("%.3f", txdeeGE));
            }


        } else {
            Toast toast = Toast.makeText(MainActivity.this, "身高體重不得空白!!", Toast.LENGTH_LONG);
            toast.show();


        }
    }
}