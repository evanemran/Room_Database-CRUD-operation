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
public class DeleteUserFragment extends Fragment {

    private EditText DeleteId;
    private Button Delete;


    public DeleteUserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_delete_user, container, false);

        DeleteId = view.findViewById(R.id.txt_delete_id);
        Delete = view.findViewById(R.id.bn_delete);
        Delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String new_id = DeleteId.getText().toString();
                if(new_id.matches(""))
                {
                    Toast.makeText(getActivity(),"Enter ID.",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    int id = Integer.parseInt(DeleteId.getText().toString());
                    User user = new User();
                    user.setId(id);
                    MainActivity.myAppDatabase.myDao().deleteUser(user);

                    Toast.makeText(getActivity(),"User Deleted",Toast.LENGTH_SHORT).show();

                    DeleteId.setText("");
                }

            }
        });

        return view;
    }

}
