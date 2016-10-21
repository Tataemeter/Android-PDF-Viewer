package com.iamdeveloper.androidpdfviewer;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.pdf.PdfRenderer;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.PersistableBundle;
import android.util.Log;

import com.joanzapata.pdfview.PDFView;
import com.joanzapata.pdfview.listener.OnPageChangeListener;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;


/**
 * Created by IamDeveloper on 10/18/2016.
 */


public class PdfActivity extends Activity implements OnPageChangeListener {
    private PDFView pdfView;
    private int num = 1;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf_view);
        pdfView = (PDFView) findViewById(R.id.pdf_view);

        String path = Environment.getExternalStorageDirectory() + "/download/java.pdf";

        File file = new File(path);

        Log.i("File",file.getAbsolutePath() + "");
                pdfView.fromFile(file)
                .defaultPage(num)
                .onPageChange(this)
                .load();
    }

    @Override
    public void onPageChanged(int page, int pageCount) {

        num = page;
    }

}
