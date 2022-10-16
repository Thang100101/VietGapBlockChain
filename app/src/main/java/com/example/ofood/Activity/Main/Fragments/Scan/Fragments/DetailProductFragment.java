package com.example.ofood.Activity.Main.Fragments.Scan.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.ofood.Activity.Main.Fragments.Scan.ScanQrFragment;
import com.example.ofood.Activity.Main.MainActivity;
import com.example.ofood.Models.Product;
import com.example.ofood.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DetailProductFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DetailProductFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public DetailProductFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DetailProductFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DetailProductFragment newInstance(String param1, String param2) {
        DetailProductFragment fragment = new DetailProductFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    public static final String NAME = DetailProductFragment.class.getName();
    private View view;
    private MainActivity activity;
    private ScanQrFragment parentFragment;
    private ImageView imgBack;
    private TextView txtName, txtBarcode, txtVietGapCode, txtDate, txtIsExpired, txtAddress, txtPhone;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_detail_product, container, false);
        Mapping();
        eventHandler();
        Bundle bundle = getArguments();
        if(bundle != null){
            Product product = (Product) bundle.getSerializable("product");
            if(product != null){
                loadDetailProduct(product);
            }
        }
        return view;
    }

    private void Mapping(){
        activity = (MainActivity) getActivity();
        parentFragment = (ScanQrFragment) getParentFragment();
        imgBack = view.findViewById(R.id.img_back);
        txtName = view.findViewById(R.id.txt_name);
        txtBarcode = view.findViewById(R.id.txt_barcode);
        txtAddress = view.findViewById(R.id.txt_address);
        txtVietGapCode = view.findViewById(R.id.txt_vietgap_code);
        txtPhone = view.findViewById(R.id.txt_phone);
        txtIsExpired = view.findViewById(R.id.txt_is_expired);
        txtDate = view.findViewById(R.id.txt_date);

    }

    private void eventHandler(){
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                parentFragment.backToQrImageFragment();
            }
        });
    }

    private void loadDetailProduct(Product product){
        txtName.setText(product.getProductName());
        txtBarcode.setText(product.getProductCode());
        txtAddress.setText(product.getAddress());
        txtVietGapCode.setText(product.getVietgapCode());
        txtPhone.setText(product.getPhone());
        txtDate.setText(product.getCertificationDate());
        if(product.isExpỉed()){
            txtIsExpired.setText("Đã hết hạn");
        }else{
            txtIsExpired.setText("Còn hạn");
        }
    }
}