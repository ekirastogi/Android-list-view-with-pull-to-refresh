package com.ekiras.demo.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ekiras.demo.R;
import com.ekiras.demo.model.Person;

import java.util.List;

/**
 * Created by ekansh on 20/10/15.
 */
public class PersonAdapter extends BaseAdapter{

    private List<Person> personList;
    private Activity activity;
    private LayoutInflater layoutInflater;
    private ViewHolder viewHolder;

    public PersonAdapter(Activity activity,List<Person> personList) {
        this.personList = personList;
        this.activity = activity;
    }

    public void add(List<Person> persons){
        this.personList.addAll(persons);
    }
    public void refresh(List<Person> persons) { this.personList = persons;}

    @Override
    public int getCount() {
        return personList.size();
    }

    @Override
    public Person getItem(int i) {
        return personList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if(view ==null){
            layoutInflater = LayoutInflater.from(activity);
            view = layoutInflater.inflate(R.layout.list_item_person, viewGroup, false);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        }
        else
            viewHolder = (ViewHolder) view.getTag();

        Person person = getItem(i);
        viewHolder.setValues(person);

        return view;
    }


    private class ViewHolder {
        private TextView name;
        private TextView email;
        private TextView desc;

        public ViewHolder(View view) {
            name = (TextView) view.findViewById(R.id.text_view_name);
            email = (TextView) view.findViewById(R.id.text_view_email);
            desc = (TextView) view.findViewById(R.id.text_view_desc);
        }

        public void setValues(Person person) {
            name.setText(person.getName());
            email.setText(person.getEmail());
            desc.setText(person.getDesc());
        }
    }

}
