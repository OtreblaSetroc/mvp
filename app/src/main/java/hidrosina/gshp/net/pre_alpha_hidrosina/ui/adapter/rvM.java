package hidrosina.gshp.net.pre_alpha_hidrosina.ui.adapter;

public class rvM {

    /*
    * package hidrosina.gshp.net.pre_alpha_hidrosina.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import hidrosina.gshp.net.pre_alpha_hidrosina.R;

public class RVMain extends RecyclerView.Adapter<RVMain.ViewHolder> {
    private List<String> questions;
    private RVRowMain rvRowMain;
    private LinearLayoutManager lmy;
    private Context context;

    public RVMain(List<String> questions) {
        this.questions = questions;
    }

    public  RVMain(List<String> questions, RVRowMain rvRowMain, LinearLayoutManager lmy, Context context){
        this.questions=questions;
        this.rvRowMain=rvRowMain;
        this.context=context;
    }

    @NonNull
    @Override


    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_rv_main, viewGroup, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        final String question =questions.get(position);
        Log.e("sergioqRV ",questions.get(position)+"");
        holder.tvQuestion.setText(question+" ");
        if (position%2==0){
            holder.linearLayout.setBackgroundResource(R.drawable.border_zebra1);
        }else{
            holder.linearLayout.setBackgroundResource(R.drawable.border_zebra2);

        }
        lmy=new CustomLinearLayoutManager(context);
        holder.recyclerView.setLayoutManager(lmy);
        holder.recyclerView.setAdapter(rvRowMain);

    }

    @Override
    public int getItemCount() {
        return questions.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tvQuestion)
        TextView tvQuestion;
        @BindView(R.id.lny_main)
        LinearLayout linearLayout;
        @BindView(R.id.rvRowMain)
        RecyclerView recyclerView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);

        }
    }
}

    * package hidrosina.gshp.net.pre_alpha_hidrosina.ui.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.Switch;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Optional;
import hidrosina.gshp.net.pre_alpha_hidrosina.Presenter.ViewItem;
import hidrosina.gshp.net.pre_alpha_hidrosina.Presenter.ViewItems;
import hidrosina.gshp.net.pre_alpha_hidrosina.R;

public class RVRowMain extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<String> botones;
    private List<ViewItems> lstViewItems;
    private int type;


    public RVRowMain(List<ViewItems> lstViewItems,int type) {
        this.lstViewItems = lstViewItems;
        this.type=type;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        RecyclerView.ViewHolder viewHolder;
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        switch (type) {
            case 0:
                View v1 = inflater.inflate(R.layout.row_radio_button, viewGroup, false);
                viewHolder = new ViewHolder1(v1);
                break;
            case 1:
                View v2 = inflater.inflate(R.layout.row_switch, viewGroup, false);
                viewHolder = new ViewHolder2(v2);
                break;
            default:
                View v3 = inflater.inflate(R.layout.row_radio_button, viewGroup, false);
                viewHolder = new ViewHolder1(v3);
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final @NonNull RecyclerView.ViewHolder holder,final int position) {

        switch (type) {
            case 0:
               final ViewHolder1 vh1 = (ViewHolder1) holder;
                configureViewHolder1(vh1, position);
                break;
            case 1:
               final ViewHolder2 vh2 = (ViewHolder2) holder;
                configureViewHolder2(vh2, position);
                break;
            default:

                break;
        }

    }

    private void configureViewHolder1( final ViewHolder1 holder, final int position) {
        final ViewItems dto=lstViewItems.get(position);
        final List<ViewItem> lst=dto.getViewItems();
        for (int i=0;i<lst.size();i++){
            if (i==0){
                holder.radioButton.setText(lst.get(i).getDescrip());
            }else{
                holder.radioButton2.setText(lst.get(i).getDescrip());
            }

        }
        holder.radioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lst.get(position).setIsCheck(1);

                holder.radioButton.setChecked(true);
                holder.radioButton2.setChecked(false);
            }
        });

        holder.radioButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lst.get(position).setIsCheck(2);
                holder.radioButton2.setChecked(true);
                holder.radioButton.setChecked(false);
            }
        });



        if (lst.get(position).getIsCheck()==1 ){
            holder.radioButton.setChecked(true);
            holder.radioButton2.setChecked(false);
        }else if(lst.get(position).getIsCheck()==2){
            holder.radioButton2.setChecked(true);
            holder.radioButton.setChecked(false);
        }else{
            holder.radioButton2.setChecked(false);
            holder.radioButton.setChecked(false);
        }

    }
    private void configureViewHolder2(final ViewHolder2 holder2,final int position) {
        if (holder2.aSwitch.isChecked()){
            holder2.aSwitch.setTextOn("Sí");
        }else{
            holder2.aSwitch.setTextOn("No");
        }
        holder2.aSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder2.aSwitch.setTextOn("Sí");
            }
        });
    }

    @Override
    public int getItemCount() {
        return lstViewItems.size();
    }

    public class ViewHolder1 extends RecyclerView.ViewHolder {

        @BindView(R.id.radioButton)
        RadioButton radioButton;
        @BindView(R.id.radioButton2)
        RadioButton radioButton2;

        public ViewHolder1(View v) {
            super(v);
            ButterKnife.bind(this,v);

        }
    }

    public class ViewHolder2 extends RecyclerView.ViewHolder {

        @BindView(R.id.switch1)
        Switch aSwitch;


        public ViewHolder2(View v) {
            super(v);
            ButterKnife.bind(this,v);

        }
    }



}


    *
    *
    *
    * */

}
