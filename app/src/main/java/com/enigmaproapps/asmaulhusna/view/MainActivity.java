package com.enigmaproapps.asmaulhusna.view;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import com.enigmaproapps.asmaulhusna.R;
import com.enigmaproapps.asmaulhusna.model.AllahName;
import com.enigmaproapps.asmaulhusna.presenter.iMainPresenter;
import com.enigmaproapps.asmaulhusna.presenter.MainPresenter;
import com.enigmaproapps.asmaulhusna.utilities.Utility;

public class MainActivity extends AppCompatActivity implements iMainView, View.OnClickListener {

    private iMainPresenter mPresenter;
    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Set the listView of GridView Whatever here.......
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview_MainActivity_NamesGrid);
        recyclerViewAdapter = new RecyclerViewAdapter(this);
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this,1));


        if (mPresenter==null)
            mPresenter = new MainPresenter(MainActivity.this);
        mPresenter.onTakeView(MainActivity.this);
    }

    @Override
    public void populateReceivedNames(List<AllahName> inList) {
        if (inList==null){
            Log.d("Manually Logged Error","MainActivity->populateReceivedNames: inList is NULL");
        }
        this.recyclerViewAdapter.setNamesList(inList);
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.btn_namePlay)
        {
            Utility helper = new Utility();
            View btn_parent = helper.getParent(v,R.id.rootView_name_design);
            AllahName taggedName = (AllahName) btn_parent.getTag();

            mPresenter.playName(taggedName);
        }
        else
        {
            Toast.makeText(MainActivity.this,"Name clicked",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this,DetailActivity.class);
            MainActivity.this.startActivity(intent);
        }

    }


    private static class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.CustomViewHolder>{

        View.OnClickListener onClickListener;
        private List<AllahName> namesList;

        public class CustomViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

            private View parent;
            private TextView tv_nameOfAllah;
            private TextView tv_nameTranslation;
            private ImageButton btn_Play;

            public CustomViewHolder(View itemView) {
                super(itemView);

                parent = itemView;
                tv_nameOfAllah = (TextView) itemView.findViewById(R.id.tv_NameInArabic);
                tv_nameTranslation = (TextView) itemView.findViewById(R.id.tv_NameTranslationText);
                btn_Play = (ImageButton) itemView.findViewById(R.id.btn_namePlay);

                btn_Play.setOnClickListener(this);
            }

            public void bind(AllahName name){
                tv_nameOfAllah.setText(name.getNameOfAllah());
                tv_nameTranslation.setText(name.getTranslation());
                parent.setTag(name);
            }

            @Override
            public void onClick(View v) {
                onClickListener.onClick(v);
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
