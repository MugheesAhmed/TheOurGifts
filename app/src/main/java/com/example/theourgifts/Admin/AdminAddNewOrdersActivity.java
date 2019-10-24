package com.example.theourgifts.Admin;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.theourgifts.Model.AdminOrders;
import com.example.theourgifts.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AdminAddNewOrdersActivity extends AppCompatActivity {

    private RecyclerView ordersList;
    private DatabaseReference ordersRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_add_new_orders);

        ordersRef = FirebaseDatabase.getInstance().getReference().child("Orders");

        ordersList = findViewById(R.id.orders_list_products);
        ordersList.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    protected void onStart() {
        super.onStart();


        FirebaseRecyclerOptions<AdminOrders> options = new FirebaseRecyclerOptions.Builder<AdminOrders>()
                .setQuery(ordersRef, AdminOrders.class)
                .build();

        FirebaseRecyclerAdapter <AdminOrders, AdminOrdersViewHolder > adapter  =
                new FirebaseRecyclerAdapter<AdminOrders, AdminOrdersViewHolder>(options) {
                    @Override
                    protected void onBindViewHolder(@NonNull AdminOrdersViewHolder holder, final int position, @NonNull final AdminOrders model) {

                        holder.userName.setText("Name: "+ model.getName());
                        holder.userPhone.setText("Phone: "+ model.getPhone());
                        holder.userShippingAddress.setText("Shipping Address: "+ model.getAddress() + " , " + model.getCity());
                        holder.userDateTime.setText("Order at: "+ model.getDate()+" "+model.getTime());
                        holder.userTotalPrice.setText("Total Price ="+ model.getTotalAmount()+"$");

                        holder.showOrdersBtn.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                String uID = getRef(position).getKey();

                                Intent intent = new Intent(AdminAddNewOrdersActivity.this, AdminUserProductsActivity.class);
                                intent.putExtra("uid" , uID);
                                startActivity(intent);
                            }
                        });


                        holder.itemView.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                CharSequence option[] = new CharSequence[]
                                        {
                                                "Yes",
                                                "No"
                                        };
                                AlertDialog.Builder builder = new AlertDialog.Builder(AdminAddNewOrdersActivity.this);
                                builder.setTitle("Have You shipped this order products ?");

                                builder.setItems(option, new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {

                                        if( i == 0 )
                                        {
                                            String uID = getRef(position).getKey();

                                            RemoveOrder(uID);
                                        }

                                        else
                                        {
                                            finish();
                                        }

                                    }
                                });
                                builder.show();

                            }
                        });


                    }

                    @NonNull
                    @Override
                    public AdminOrdersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.orders_layout, parent,false);
                        return new AdminOrdersViewHolder(view);
                    }

                };
        ordersList.setAdapter(adapter);
        adapter.startListening();
    }

    private void RemoveOrder(String uID)
    {
        ordersRef.child(uID).removeValue();
    }

    public static class AdminOrdersViewHolder extends RecyclerView.ViewHolder
    {
        public TextView userName,userPhone,userShippingAddress,userDateTime,userTotalPrice;
        public Button showOrdersBtn;

        public AdminOrdersViewHolder(@NonNull View itemView) {
            super(itemView);

            userName = itemView.findViewById(R.id.order_User_name);
            userPhone = itemView.findViewById(R.id.order_phone_number);
            userShippingAddress = itemView.findViewById(R.id.order_address);
            userDateTime = itemView.findViewById(R.id.order_date_time);
            userTotalPrice = itemView.findViewById(R.id.order_Total_Price);
            showOrdersBtn = itemView.findViewById(R.id.show_Order_product_btn);
        }
    }
}
