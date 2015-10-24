package com.ekiras.demo;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.AbsListView;
import android.widget.ListView;

import com.ekiras.demo.adapter.PersonAdapter;
import com.ekiras.demo.model.Person;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private SwipeRefreshLayout refreshLayout;
    private PersonAdapter personAdapter;
    private ListView listView;
    private int bootCounter=0;
    private int maxRecords = 400;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        personAdapter = new PersonAdapter(this,bootData());
        listView = (ListView) findViewById(R.id.person_list);
        refreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh_layout);
        listView.setAdapter(personAdapter);

        onScrollListener();
        onRefreshListener();
    }

    private void onRefreshListener(){
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshLayout.setRefreshing(true);
                bootCounter=0;
                personAdapter.refresh(bootData());
                personAdapter.notifyDataSetChanged();
                refreshLayout.setRefreshing(false);
            }
        });
    }

    private void onScrollListener(){
        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView absListView, int i) {

            }
            @Override
            public void onScroll(AbsListView absListView, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                if (firstVisibleItem + visibleItemCount > totalItemCount - 2 && totalItemCount < maxRecords) {
                    personAdapter.add(bootData());
                    personAdapter.notifyDataSetChanged();
                }
            }
        });
    }

    private List<Person> bootData(){
        List<Person> persons = new ArrayList<Person>();
        for(int i=bootCounter;i<bootCounter+20;i++){
            Person person = new Person();
            person.setName("person-" + i);
            person.setDesc("description :" + i);
            person.setEmail("person" + i + "@ekiras.com");
            person.setImage(R.drawable.user);
            persons.add(person);
        }
        bootCounter+=20;
        return persons;
    }
}
