package com.example.application.fragment;

import android.content.ContentResolver;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.application.Adapter.ContactsAdapter;
import com.example.application.Objects.contactObject;
import com.example.application.R;
import com.example.application.app.Application;
import com.example.application.interfaces.IContactPermissionLister;

import java.util.ArrayList;
import java.util.List;

public class contactsFragment extends Fragment {

    RecyclerView rclContact;
    List<contactObject> list;
    ContactsAdapter adapter;
    TextView txtNoContact;
    public static IContactPermissionLister lister;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.layout_contact_fragment, container, false);
        rclContact = view.findViewById(R.id.rclContact);
        txtNoContact = view.findViewById(R.id.txtNoContact);
        txtNoContact = view.findViewById(R.id.txtNoContact);
        list = new ArrayList<>();
        adapter = new ContactsAdapter(list);
        rclContact.setAdapter(adapter);
        rclContact.setLayoutAnimation(new LayoutAnimationController(AnimationUtils.loadAnimation(Application.getContext(), android.R.anim.fade_out)));
        rclContact.setLayoutManager(new LinearLayoutManager(Application.getContext()));
        lister = new IContactPermissionLister() {
            @Override
            public void onPermissionChange(boolean granted) {
                if (granted) {
                    prepareData();
                }
            }
        };
        return view;
    }

    public void prepareData() {
        txtNoContact.setVisibility(View.GONE);
        list.clear();
        ContentResolver cr = getActivity().getContentResolver();
        Cursor cursor = cr.query(ContactsContract.Contacts.CONTENT_URI, null, null, null, ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME + " ASC");
        if ((cursor != null ? cursor.getCount() : 0) > 0) {
            while (cursor != null && cursor.moveToNext()) {
                String id = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID));
                String name = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
                String tell = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER));
                if (!TextUtils.isEmpty(name)) {
                    list.add(new contactObject(name, tell));
                }
            }
            cursor.close();
            adapter.notifyDataSetChanged();
            if (list.size() == 0) {
                txtNoContact.setVisibility(View.VISIBLE);
            }

        }
    }
}
