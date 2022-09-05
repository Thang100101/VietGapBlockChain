package com.example.ofood.Activity.Main.Fragments.Scan;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.fragment.app.Fragment;

import com.example.ofood.Activity.Capture.CaptureA;
import com.example.ofood.Activity.Main.MainActivity;
import com.example.ofood.R;
import com.journeyapps.barcodescanner.ScanContract;
import com.journeyapps.barcodescanner.ScanIntentResult;
import com.journeyapps.barcodescanner.ScanOptions;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ScanQrFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ScanQrFragment extends Fragment implements ScanQrView{

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ScanQrFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ScanQrFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ScanQrFragment newInstance(String param1, String param2) {
        ScanQrFragment fragment = new ScanQrFragment();
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

    private View view;
    private MainActivity activity;
    private Button btnScan;
    private ScanQrPresenter scanQrPresenter;

    private ActivityResultLauncher<ScanOptions> launcher = registerForActivityResult(new ScanContract(),
            new ActivityResultCallback<ScanIntentResult>() {
                @Override
                public void onActivityResult(ScanIntentResult result) {
                    if(result.getContents() != null){
                        Toast.makeText(activity, result.getContents(), Toast.LENGTH_SHORT).show();
                    }
                }
            });

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_scan_qr, container, false);
        Mapping();
        eventHandler();
        return view;
    }

    private void Mapping(){
        activity = (MainActivity) getActivity();
        btnScan = view.findViewById(R.id.btn_scan);
        scanQrPresenter = new ScanQrPresenter(this, activity);
    }

    private void eventHandler(){
        btnScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openScanActivity();
            }
        });
    }

    private void openScanActivity(){
        ScanOptions options = new ScanOptions();
        options.setOrientationLocked(true);
        options.setBeepEnabled(true);
        options.setPrompt("Scan Product");
        options.setCaptureActivity(CaptureA.class);
        scanQrPresenter.scanQrCode(launcher, options);
    }
}