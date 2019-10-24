package com.example.theourgifts.Admin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.theourgifts.MainActivity;
import com.example.theourgifts.NewUserActivity;
import com.example.theourgifts.R;

public class AdminCategoryActivity extends AppCompatActivity {

    private ImageView chocolate, bag, perfume, glasses;
    private ImageView mug, diary, candy, watch;
    private ImageView wallet, hat, flower,toy;
    private ImageView jigsaw, img_Frame, teddy, ring;

    private Button logoutBtn, checkOrderBtn,maintainProductsBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_category);

        logoutBtn = (Button) findViewById(R.id.admin_logout_btn);
        checkOrderBtn = (Button) findViewById(R.id.check_Order_btn);

        chocolate = (ImageView) findViewById(R.id.chocolate);
        bag = (ImageView) findViewById(R.id.purse);
        perfume= (ImageView) findViewById(R.id.perfume);
        glasses = (ImageView) findViewById(R.id.glases);
        mug = (ImageView) findViewById(R.id.mug);
        toy = (ImageView) findViewById(R.id.toy);
        diary= (ImageView) findViewById(R.id.diary);
        candy = (ImageView) findViewById(R.id.candy1);
        watch = (ImageView) findViewById(R.id.watch);
        wallet = (ImageView) findViewById(R.id.wallet);
        hat= (ImageView) findViewById(R.id.hat);
        flower= (ImageView) findViewById(R.id.flower);

        jigsaw = (ImageView) findViewById(R.id.jigsaw);
        img_Frame = (ImageView) findViewById(R.id.image_frame);
        teddy= (ImageView) findViewById(R.id.teddy);
        ring= (ImageView) findViewById(R.id.ring);


        maintainProductsBtn = (Button) findViewById(R.id.maintain_Btn);

        maintainProductsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminCategoryActivity.this, MainActivity.class);
                intent.putExtra("Admin", "Admin");
                startActivity(intent);



            }
        });


        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(AdminCategoryActivity.this, NewUserActivity.class);

                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                finish();
            }
        });


        checkOrderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(AdminCategoryActivity.this, AdminAddNewOrdersActivity.class);
                startActivity(intent);

            }
        });

        chocolate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i  = new Intent(AdminCategoryActivity.this, AdminAddNewProductsActivity.class);
                i.putExtra("category", "chocolate");
                startActivity(i);
            }
        });

        bag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i  = new Intent(AdminCategoryActivity.this, AdminAddNewProductsActivity.class);
                i.putExtra("category", "bag");
                startActivity(i);

            }
        });

        perfume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i  = new Intent(AdminCategoryActivity.this, AdminAddNewProductsActivity.class);
                i.putExtra("category", "perfume");
                startActivity(i);
            }
        });

        glasses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i  = new Intent(AdminCategoryActivity.this, AdminAddNewProductsActivity.class);
                i.putExtra("category", "glasses");
                startActivity(i);
            }
        });

        mug.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i  = new Intent(AdminCategoryActivity.this, AdminAddNewProductsActivity.class);
                i.putExtra("category", "mug");
                startActivity(i);
            }
        });

        diary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i  = new Intent(AdminCategoryActivity.this, AdminAddNewProductsActivity.class);
                i.putExtra("category", "diary");
                startActivity(i);
            }
        });

        candy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i  = new Intent(AdminCategoryActivity.this, AdminAddNewProductsActivity.class);
                i.putExtra("category", "candy");
                startActivity(i);
            }
        });

        watch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i  = new Intent(AdminCategoryActivity.this, AdminAddNewProductsActivity.class);
                i.putExtra("category", "watch");
                startActivity(i);
            }
        });

        wallet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i  = new Intent(AdminCategoryActivity.this, AdminAddNewProductsActivity.class);
                i.putExtra("category", "wallet");
                startActivity(i);
            }
        });

        hat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i  = new Intent(AdminCategoryActivity.this, AdminAddNewProductsActivity.class);
                i.putExtra("category", "hat");
                startActivity(i);
            }
        });

        flower.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i  = new Intent(AdminCategoryActivity.this, AdminAddNewProductsActivity.class);
                i.putExtra("category", "flower");
                startActivity(i);
            }
        });

        toy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i  = new Intent(AdminCategoryActivity.this, AdminAddNewProductsActivity.class);
                i.putExtra("category", "toy");
                startActivity(i);
            }
        });

        jigsaw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i  = new Intent(AdminCategoryActivity.this, AdminAddNewProductsActivity.class);
                i.putExtra("category", "jigsaw");
                startActivity(i);
            }
        });

        img_Frame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i  = new Intent(AdminCategoryActivity.this, AdminAddNewProductsActivity.class);
                i.putExtra("category", "img_frame");
                startActivity(i);
            }
        });

        teddy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i  = new Intent(AdminCategoryActivity.this, AdminAddNewProductsActivity.class);
                i.putExtra("category", "teddy");
                startActivity(i);
            }
        });

        ring.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i  = new Intent(AdminCategoryActivity.this, AdminAddNewProductsActivity.class);
                i.putExtra("category", "ring");
                startActivity(i);
            }
        });











    }
}
