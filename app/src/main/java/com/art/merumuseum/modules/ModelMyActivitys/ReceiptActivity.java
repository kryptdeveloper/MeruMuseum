package com.art.merumuseum.modules.ModelMyActivitys;

import static android.service.controls.ControlsProviderService.TAG;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.art.merumuseum.Finance.modules.toBeprinted;
import com.art.merumuseum.Main;
import com.art.merumuseum.modules.Home;
import com.art.merumuseum1.R;
import com.gkemon.XMLtoPDF.PdfGenerator;
import com.gkemon.XMLtoPDF.PdfGeneratorListener;
import com.gkemon.XMLtoPDF.model.FailureResponse;
import com.gkemon.XMLtoPDF.model.SuccessResponse;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReceiptActivity extends AppCompatActivity {
    Button btn;
    View v;
    ImageView imageView;
    TextView email, amount, date,timndate;
    TextView getEmail,getAmount,getDate;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.receipt);
        DateTimeFormatter dateTimeFormatter=DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDateTime now=LocalDateTime.now();
        Bundle extras = getIntent().getExtras();
        v=getLayoutInflater().inflate(R.layout.ticketlayout,null);

       // v = getLayoutInflater().inflate(R.layout.ticketlayout, (ViewGroup) findViewById(R.id.receiptTicket));
        amount = v.findViewById(R.id.amountRe);
        date = v.findViewById(R.id.dateRe);
        email = v.findViewById(R.id.emailRe);
        timndate=v.findViewById(R.id.printdnt);
       // printdnt
        timndate.setText("printed on: "+dateTimeFormatter.format(now));
        email.setText("Hi @" + extras.getString("email"));
        amount.setText("Amount:" + extras.getString("amount"));
        date.setText("Date:" + extras.getString("date"));
        printReport();
        getSupportFragmentManager().beginTransaction().replace(R.id.vvv,new MyActivitys())
                .addToBackStack(" ")
                .commit();
finish();

//        Fragment fag;
//        fag=new MyActivitys();
//        loadFragment(fag);

//        btn.setOnClickListener(new View.OnClickListener() {
//
//
//                                   @Override
//                                   public void onClick(View view) {
//
//                                   }
//                               }
//        );

    }
    private void printReport() {

        PdfGenerator.getBuilder()
                .setContext(ReceiptActivity.this)
                .fromViewSource()
                .fromView(v)

                .setFileName("report")

                .setFolderName("demo-invoice-folder/")

                .openPDFafterGeneration(true)

                .build(new PdfGeneratorListener() {
                    @Override
                    public void onFailure(FailureResponse failureResponse) {
                        super.onFailure(failureResponse);
                        Log.d(TAG, "onFailure: " + failureResponse.getErrorMessage());

                        Toast.makeText(ReceiptActivity.this, "" + failureResponse.getErrorMessage(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void showLog(String log) {
                        super.showLog(log);
                        Log.d(TAG, "log: " + log);

                    }

                    @Override
                    public void onStartPDFGeneration() {

                    }

                    @Override
                    public void onFinishPDFGeneration() {

                    }

                    @Override
                    public void onSuccess(SuccessResponse response) {
                        super.onSuccess(response);
                        /* If PDF is generated successfully then you will find SuccessResponse
                         * which holds the PdfDocument,File and path (where generated pdf is stored)*/
                        //Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_SHORT).show();
                        Log.d(TAG, "Success: " + response.getPath());

                    }
                });


    }
    private void loadFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.content, fragment).addToBackStack("").commit();
       // drawerLayout.closeDrawer(GravityCompat.START);
        fragmentTransaction.addToBackStack(null);
    }
}
