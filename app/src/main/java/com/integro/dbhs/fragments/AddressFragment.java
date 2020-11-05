package com.integro.dbhs.fragments;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import com.integro.dbhs.R;

public class AddressFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_address, container, false);

        LinearLayout llCall = view.findViewById(R.id.llCall);
        LinearLayout llEmail = view.findViewById(R.id.llEmail);

        llEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendEmail();
            }
        });

        llCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "tel:+91-80-25463476";
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse(url));
                if (ActivityCompat.checkSelfPermission(getContext(), android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    return;
                }
                startActivity(intent);
            }
        });
        return view;
    }

    public void sendEmail() {
        Intent testIntent = new Intent(Intent.ACTION_VIEW);
        Uri data = Uri.parse("mailto:?subject=" + " " + "&body=" + " " + "&to=" + "dboscopanjim@yahoo.co.in");
        testIntent.setData(data);
        startActivity(testIntent);
    }
}
