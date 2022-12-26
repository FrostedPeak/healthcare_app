package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsActivity extends AppCompatActivity {
    private String[][] doctor_details1 =
            {
                    {"Doctor Name : Tunahan Kalaycı", "Hospital Address : Bursa", "Exp : 1 Day", "Mobile No:+905325748596", "600"},
                    {"Doctor Name : Bora Berk Çetintaş", "Hospital Address : İstanbul", "Exp : 251 Years", "Mobile No:+905415948678", "2600"},
                    {"Doctor Name : Mahir Arda", "Hospital Address : Antartika", "Exp : 3", "Mobile No:+905814752343", "300"},
                    {"Doctor Name : Mr. Bruh", "Hospital Address : Bruh", "Exp : 12 Years", "Mobile No:+905246387824", "500"},
                    {"Doctor Name : Andrew Tate", "Hospital Address : Eskişehir", "Exp : 20 Years", "Mobile No:+905544852351", "800"}
            };
    private String[][] doctor_details2 =
            {
                    {"Doctor Name : Binnur Ataseven", "Hospital Address : İstanbul", "Exp : 12 Years", "Mobile No:+905694402963", "550"},
                    {"Doctor Name : Tutku Ince", "Hospital Address : İstanbul", "Exp : 30 Years", "Mobile No:+905220122324", "1800"},
                    {"Doctor Name : Aral Bayraktar", "Hospital Address : İzmir", "Exp : 5 Years", "Mobile No:+905220122324", "1050"},
                    {"Doctor Name : Kudret Coskun", "Hospital Address : Ankara", "Exp : 3 Years", "Mobile No:+905929804489", "700"},
                    {"Doctor Name : Eren Özhan", "Hospital Address : Düzce", "Exp : 7 Years", "Mobile No:+905149912522", "500"}
            };
    private String[][] doctor_details3 =
            {
                    {"Doctor Name : Esmeray Sezer", "Hospital Address : Kastamonu", "Exp : 9 Years", "Mobile No:+905003624428", "1100"},
                    {"Doctor Name : Taner Korkmaz", "Hospital Address : İstanbul", "Exp : 4 Years", "Mobile No:+905194098988", "950"},
                    {"Doctor Name : Sevinç Oz", "Hospital Address : İstanbul", "Exp : 6 Years", "Mobile No:+905467767918", "900"},
                    {"Doctor Name : Akçay Bayrak", "Hospital Address : Uşak", "Exp : 5 Years", "Mobile No:+905864259536", "350"},
                    {"Doctor Name : Burcu Birsen", "Hospital Address : İstanbul", "Exp : 7 Years", "Mobile No:+905625370820", "400"}
            };
    private String[][] doctor_details4 =
            {
                    {"Doctor Name : Aydin Çakir", "Hospital Address : Van", "Exp : 5 Years", "Mobile No:+905674359664", "850"},
                    {"Doctor Name : Miray Yalçin", "Hospital Address : İstanbul", "Exp : 7 Years", "Mobile No:+905604070966", "600"},
                    {"Doctor Name : Rahmi Gürsu", "Hospital Address : Bayburt", "Exp : 17 Years", "Mobile No:+905229836728", "1100"},
                    {"Doctor Name : Ceyda Düzgün", "Hospital Address : Çanakkale", "Exp : 5 Years", "Mobile No:+905680415023", "550"},
                    {"Doctor Name : Tevrat Zengin", "Hospital Address : Gaziantep", "Exp : 14 Years", "Mobile No:+905144480716", "1250"}
            };
    private String[][] doctor_details5 =
            {
                    {"Doctor Name : Adnan Yagci", "Hospital Address : Çorum", "Exp : 3 Years", "Mobile No:+905693115586", "700"},
                    {"Doctor Name : Nurullah Güler", "Hospital Address : Niğde", "Exp : 4 Years", "Mobile No:+905951457462", "400"},
                    {"Doctor Name : Emel Kutlu", "Hospital Address : Zonguldak", "Exp : 33 Years", "Mobile No:+905531595326", "1500"},
                    {"Doctor Name : Gizem Pasa", "Hospital Address : Kocaeli", "Exp : 3 Years", "Mobile No:+905063674100", "500"},
                    {"Doctor Name : Tolunay Çakir", "Hospital Address : Kırşehir", "Exp : 22 Years", "Mobile No:+905657346836", "1200"}
            };
    TextView tv;
    Button btn;
    String[][] doctor_details = {};
    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);

        tv = findViewById(R.id.textView_logo6);
        btn = findViewById(R.id.buttonLTBack);

        Intent it = getIntent();
        String title = it.getStringExtra("title");
        tv.setText(title);

        if(title.compareTo("Family Physicians")==0)
            doctor_details = doctor_details1;
        else
        if(title.compareTo("Dietician")==0)
            doctor_details = doctor_details2;
        else
        if(title.compareTo("Surgeon")==0)
            doctor_details = doctor_details3;
        else
        if(title.compareTo("Dentist")==0)
            doctor_details = doctor_details4;
        else
            doctor_details = doctor_details5;

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DoctorDetailsActivity.this,FindDoctorActivity.class));

            }
        });

        list = new ArrayList();
        for(int i=0;i<doctor_details.length;i++){
            item = new HashMap<String,String>();
            item.put( "line1", doctor_details[i][0]);
            item.put( "line2", doctor_details[i][1]);
            item.put( "line3", doctor_details[i][2]);
            item.put( "line4", doctor_details[i][3]);
            item.put( "line5", "Cons Fees:"+doctor_details[i][4]+"₺");
            list.add( item );
        }
        sa = new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e}
                );
        ListView lst = findViewById(R.id.editTextLDTextMultiLine);
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(DoctorDetailsActivity.this,BookAppointmentActivity.class);
                it.putExtra("text1",title);
                it.putExtra("text2",doctor_details[i][0]);
                it.putExtra("text3",doctor_details[i][1]);
                it.putExtra("text4",doctor_details[i][3]);
                it.putExtra("text5",doctor_details[i][4]);
                startActivity(it);
            }
        });
    }
}