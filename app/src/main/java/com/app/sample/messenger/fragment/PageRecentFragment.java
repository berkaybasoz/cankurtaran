package com.app.sample.messenger.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.app.sample.messenger.ActivityChatDetails;
import com.app.sample.messenger.ActivityMain;
import com.app.sample.messenger.MapActivity;
import com.app.sample.messenger.R;
import com.app.sample.messenger.adapter.ChatsListAdapter;
import com.app.sample.messenger.data.Constant;
import com.app.sample.messenger.model.Chat;
import com.app.sample.messenger.model.Item;

import java.util.ArrayList;
import java.util.List;

public class PageRecentFragment extends Fragment {

    private View view;

    private RecyclerView recyclerView;
    private List<Chat> items = new ArrayList<>();
    private ChatsListAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.page_fragment_recent, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);

        // use a linear layout manager
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);

        items = Constant.getChatsData(getActivity());

        // specify an adapter (see also next example)
        mAdapter = new ChatsListAdapter(getActivity(), items);
        recyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(new ChatsListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, Chat obj, int position) {
                //ActivityChatDetails.navigate((ActivityMain) getActivity(), v.findViewById(R.id.lyt_parent), obj.getFriend(), obj.getSnippet());
                MapActivity.itemDetails=new Item();
                MapActivity.itemDetails.setTitle(obj.getFriend().getName());
                startActivity(new Intent(getActivity(), MapActivity.class));
            }
        });

        return view;
    }
}
