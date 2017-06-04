package com.enigmaproapps.asmaulhusna;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import com.enigmaproapps.asmaulhusna.model.AllahName;
import com.enigmaproapps.asmaulhusna.IMainActivity_to_Presenter;
import com.enigmaproapps.asmaulhusna.presenter.IPresenter_MainActivity;
import com.enigmaproapps.asmaulhusna.presenter.Presenter_MainActivity;

public class MainActivity extends AppCompatActivity implements IMainActivity_to_Presenter {

    private IPresenter_MainActivity mPresenter;
    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Set the listView of GridView Whatever here.......
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview_MainActivity_NamesGrid);
        recyclerViewAdapter = new RecyclerViewAdapter(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"Name clicked",Toast.LENGTH_SHORT).show();

            }
        });
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));


        if (mPresenter==null)
            mPresenter = new Presenter_MainActivity(MainActivity.this);
        mPresenter.onTakeView(MainActivity.this);
    }

    @Override
    public void populateReceivedNames(List<AllahName> inList) {
        if (inList==null){
            Log.d("Manually Logged Error","MainActivity->populateReceivedNames: inList is NULL");
        }
        this.recyclerViewAdapter.setNamesList(inList);
    }


    private static class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.CustomViewHolder>{

        View.OnClickListener onClickListener;
        private List<AllahName> namesList;

        public class CustomViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

            private View parent;
            private TextView tv_nameOfAllah;
            private TextView tv_nameTranslation;

            public CustomViewHolder(View itemView) {
                super(itemView);

                parent = itemView;
                tv_nameOfAllah = (TextView) itemView.findViewById(R.id.tv_NameInArabic);
                tv_nameTranslation = (TextView) itemView.findViewById(R.id.tv_NameTranslationText);
            }

            public void bind(AllahName name){
                tv_nameOfAllah.setText(name.getNameOfAllah());
                tv_nameTranslation.setText(name.getTranslation());
                parent.setTag(name);
            }

            @Override
            public void onClick(View v) {
                onClickListener.onClick(parent);
            }
        }



        public RecyclerViewAdapter(){

        }

        public RecyclerViewAdapter(View.OnClickListener onClickListener){
            this.onClickListener = onClickListener;
        }

        public void setNamesList(List<AllahName> gNamesList){
            this.namesList= gNamesList;
            this.notifyDataSetChanged();
        }

        @Override
        public RecyclerViewAdapter.CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            Context context = parent.getContext();
            LayoutInflater layoutInflater = LayoutInflater.from(context);

            View gridViewSingleComp = layoutInflater.inflate(R.layout.name_design_grid,parent,false);
            RecyclerViewAdapter.CustomViewHolder customViewHolder = new CustomViewHolder(gridViewSingleComp);

            return customViewHolder;
        }



        @Override
        public void onBindViewHolder(RecyclerViewAdapter.CustomViewHolder holder, int position) {

            holder.itemView.setOnClickListener(holder);
            holder.bind(this.namesList.get(position));
        }

        @Override
        public int getItemCount() {
            return this.namesList.size();
        }
    }

}
