package com.cookandroid.project10_implicitintent;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;

import java.io.File;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("암시적 인텐트 예제");

        Button btnDial = (Button) findViewById(R.id.btnDial);
        Button btnWeb = (Button) findViewById(R.id.btnWeb);
        Button btnGoogle = (Button) findViewById(R.id.btnGoogle);
        Button btnSearch = (Button) findViewById(R.id.btnSearch);
        Button btnSms = (Button) findViewById(R.id.btnSms);
        Button btnPhoto = (Button) findViewById(R.id.btnPhoto);

        btnDial.setOnClickListener(new View.OnClickListener(){
            @Override public void onClick(View view) {
                Uri uri = Uri.parse("tel: 010-1234-5678");
                Intent intent = new Intent(Intent.ACTION_DIAL, uri);
                startActivity(intent); } });

        btnWeb.setOnClickListener(new View.OnClickListener(){
            @Override public void onClick(View view) {
                Uri uri = Uri.parse("http://www.naver.com");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent); } });

        btnGoogle.setOnClickListener(new View.OnClickListener(){
            @Override public void onClick(View view) {
                Uri uri = Uri.parse("geo:37.5543,126.9135");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent); } });

        btnSearch.setOnClickListener(new View.OnClickListener(){
            @Override public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
                intent.putExtra(SearchManager.QUERY, "안드로이드");
                startActivity(intent); } });

        btnSms.setOnClickListener(new View.OnClickListener(){
            @Override public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.putExtra("sms_body", "안녕하세요?");
                intent.setData((Uri.parse("smsto:"+Uri.encode("010-1234-4567"))));
                startActivity(intent); } });

        btnPhoto.setOnClickListener(new View.OnClickListener(){
            @Override public void onClick(View view) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(intent); } });

    }
}
