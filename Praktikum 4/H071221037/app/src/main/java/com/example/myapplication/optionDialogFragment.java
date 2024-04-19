package com.example.myapplication;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class optionDialogFragment extends DialogFragment {

    private onDialogOptionSelectedListener listener;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_optioh_dialog, container, false);
        Button btnNo = view.findViewById(R.id.btnNo);
        Button btnYes = view.findViewById(R.id.btnYes);

        btnNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        btnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
                if(listener != null) {
                    listener.onOptionSelected(true);
                }
            }
        });
        return view;
    }
    public interface onDialogOptionSelectedListener{
        void onOptionSelected(boolean isDeleteSelected);
    }

    public void setOnDialogOptionSelectedListener(onDialogOptionSelectedListener listener2) {
         listener = listener2;
    }
}