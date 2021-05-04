package com.krishna_londhe.ast_lab_exp_7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText phoneno,dob,name;
    RadioGroup gender;
    CheckBox aadharcard,rashancard,pancard;
    Button submit;
    String str_gender;
    TextView message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name=(EditText)findViewById(R.id.etname);
        dob=(EditText)findViewById(R.id.etdob);
        phoneno=(EditText)findViewById(R.id.etphone);
        gender=(RadioGroup) findViewById(R.id.rgbtn);
         aadharcard=(CheckBox)findViewById(R.id.cbaadhar);
         rashancard=(CheckBox)findViewById(R.id.cbrashan);
         pancard=(CheckBox)findViewById(R.id.cbpan);
         submit=(Button)findViewById(R.id.btsubmit);
         message=(TextView)findViewById(R.id.tvmsg);


         gender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
             @Override
             public void onCheckedChanged(RadioGroup group, int checkedId) {
                 if(checkedId==R.id.rbmale)
                 {
                     str_gender="Male";
                 }
                 if(checkedId==R.id.rbfemale)
                 {
                     str_gender="Female";
                 }
             }
         });

         submit.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

                 String sname,sdob,sphoneno,available_doc="";

                 sname=name.getText().toString();
                 sdob=dob.getText().toString();
                 sphoneno=phoneno.getText().toString();

                 if(aadharcard.isChecked())
                 {
                     available_doc+="Aadhar Card ";
                 }
                 else if(rashancard.isChecked())
                 {
                     available_doc+="PAN Card ";
                 }
                 else if(rashancard.isChecked())
                 {
                     available_doc+="Rashan Card ";
                 }


                 if(sname.isEmpty())
                 {
                     Toast.makeText(MainActivity.this,"Enter Name",Toast.LENGTH_LONG).show();
                 }
                 else if(sdob.isEmpty())
                 {
                     Toast.makeText(MainActivity.this,"Enter DOB",Toast.LENGTH_LONG).show();
                 }
                 else if(sphoneno.isEmpty())
                 {
                     Toast.makeText(MainActivity.this,"Enter Phone no",Toast.LENGTH_LONG).show();
                 }
                 else if(available_doc.isEmpty())
                 {
                     Toast.makeText(MainActivity.this,"Select Available Document",Toast.LENGTH_LONG).show();
                 }
                 else if(str_gender.isEmpty())
                 {
                     Toast.makeText(MainActivity.this,"Select Gender",Toast.LENGTH_LONG).show();
                 }

                 if(!sname.isEmpty() && !sdob.isEmpty() && !sphoneno.isEmpty() && !available_doc.isEmpty())
                 {
                     Toast.makeText(MainActivity.this,"Success",Toast.LENGTH_LONG).show();
                     String message="Name: "+sname+"\n"+str_gender+"\n"+"DOB: "+sdob+"\n"+"Phone NO: "+sphoneno+"\n"+available_doc;
                     Intent user=new Intent(MainActivity.this,UserInfo.class);
                     user.putExtra("message",message);
                     startActivity(user);
                 }


             }
         });
    }
}