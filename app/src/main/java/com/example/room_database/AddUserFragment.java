package com.example.room_database;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddUserFragment extends Fragment {

    private EditText userid,username,useremail;
    private Button bnSave;


    public AddUserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_user, container, false);
        userid = view.findViewById(R.id.txt_user_id);
        username = view.findViewById(R.id.txt_name);
        useremail = view.findViewById(R.id.txt_email);
        bnSave = view.findViewById(R.id.bn_save_user);

        bnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int userId = Integer.parseInt(userid.getText().toString());
                String userName = username.getText().toString();
                String userEmail = useremail.getText().toString();

                User user = new User();
                user.setId(userId);
                user.setName(userName);
                user.setEmail(userEmail);

                MainActivity.myAppDatabase.myDao().addUser(user);
                Toast.makeText(getActivity(),"User Added",Toast.LENGTH_SHORT).show();
                userid.setText("");
                username.setText("");
                useremail.setText("");

            }
        });


        return view;
    }

}
