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
        recyclerViewAdapter = new RecyclerViewAdapter();
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
        this.recyclerViewAdapter.updateAdapterListNotified(inList);
    }


    private static class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.CustomViewHolder>{

        //Keep child classes static in normal case, declare them otherwise only if needed ..........
        public static class CustomViewHolder extends RecyclerView.ViewHolder{

            public TextView tv_nameOfAllah;
            public TextView tv_nameTranslation;

            public CustomViewHolder(View itemView) {
                super(itemView);

                tv_nameOfAllah = (TextView) itemView.findViewById(R.id.tv_NameInArabic);
                tv_nameTranslation = (TextView) itemView.findViewById(R.id.tv_NameTranslationText);
            }
        }

        //Adapter class starts here properly ......
        private List<AllahName> namesList;
        private Context mContext;

        public RecyclerViewAdapter(){

        }

        public RecyclerViewAdapter(List<AllahName> gNamesList,Context gContext){
            this.namesList = new ArrayList<>(gNamesList);
            this.mContext = gContext;
        }

        public void updateAdapterListNotified(List<AllahName> gNameList){
            if (this.namesList==null)
                this.namesList=new ArrayList<>();
            this.namesList.clear();
            this.namesList.addAll(gNameList);
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
            AllahName nameAtCurrentIndex = this.namesList.get(position);

            //Setting values for Views.......
            holder.tv_nameOfAllah.setText(nameAtCurrentIndex.getNameOfAllah());
            holder.tv_nameTranslation.setText(nameAtCurrentIndex.getTranslation());
        }

        @Override
        public int getItemCount() {
            return this.namesList.size();
        }
    }

}
