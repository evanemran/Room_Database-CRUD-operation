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
public class UpdateUserFragment extends Fragment {
    private Button BnUpdate;
    private EditText updateName,upDateEmail,updateId;


    public UpdateUserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_update_user, container, false);


        updateId = view.findViewById(R.id.txt_updateid);
        updateName = view.findViewById(R.id.txt_updatename);
        upDateEmail = view.findViewById(R.id.txt_updateemail);
        BnUpdate = view.findViewById(R.id.bn_update);
        BnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String update_id = updateId.getText().toString();
                String name = updateName.getText().toString();
                String email = upDateEmail.getText().toString();

                if(update_id.matches("")||name.matches("")||email.matches(""))
                {
                    Toast.makeText(getActivity(),"Enter all credentials",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    User user = new User();
                    int id = Integer.parseInt(updateId.getText().toString());

                    user.setId(id);
                    user.setName(name);
                    user.setEmail(email);

                    MainActivity.myAppDatabase.myDao().updateUser(user);
                    Toast.makeText(getActivity(),"User info Updated",Toast.LENGTH_SHORT).show();

                    updateId.setText("");
                    updateName.setText("");
                    upDateEmail.setText("");
                }

            }
        });

        return view;
    }

}
