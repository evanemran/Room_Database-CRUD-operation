package com.example.room_database;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ReadUserFragment extends Fragment {

    private TextView UserInfo;
    private EditText SearchName;
    private Button SearchButton;


    public ReadUserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_read_user, container, false);
        UserInfo = view.findViewById(R.id.txt_display_info);
        SearchName = view.findViewById(R.id.txt_search_name);
        SearchButton = view.findViewById(R.id.bn_search_name);

        List<User> users = MainActivity.myAppDatabase.myDao().getUsers();
        String info = "";

        for (User usr : users)
        {
            int id = usr.getId();
            String name = usr.getName();
            String email = usr.getEmail();

            info = info+"ID :"+id+"\nName: "+name+"\nE-mail: "+email+"\n\n";
        }
         UserInfo.setText(info);


        SearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String searchedname = SearchName.getText().toString();
                User user = new User();

                List<User> users = MainActivity.myAppDatabase.myDao().getUsers();
                String info = "";

                for (User usr : users)
                {
                    if (usr.getName().matches(searchedname))
                    {
                        int id = usr.getId();
                        String name = usr.getName();
                        String email = usr.getEmail();

                        info = info+"ID :"+id+"\nName: "+name+"\nE-mail: "+email+"\n\n";
                        UserInfo.setText(info);
                    }
                }


            }
        });


        return view;
    }

}
