package hidrosina.gshp.net.pre_alpha_hidrosina.ui.adapter;

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
import hidrosina.gshp.net.pre_alpha_hidrosina.Model.dto.DtoRadioButton;
import hidrosina.gshp.net.pre_alpha_hidrosina.Presenter.ViewItem;
import hidrosina.gshp.net.pre_alpha_hidrosina.Presenter.ViewItems;
import hidrosina.gshp.net.pre_alpha_hidrosina.R;

public class RVRowMain2 extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<String> botones;
    private List<DtoRadioButton> lstRadioButton;
    private int type;


    public RVRowMain2(List<DtoRadioButton> lstRadioButton,int type) {
        this.lstRadioButton = lstRadioButton;
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
       final DtoRadioButton dto = lstRadioButton.get(position);
       if (dto.getId()==0){
           holder.radioButton.setText(dto.getName());
       }else if (dto.getId()==1){
           holder.radioButton2.setText(dto.getName());
       }

       holder.radioButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               dto.setIsCheck(1);
               holder.radioButton2.setChecked(false);
           }
       });
       holder.radioButton2.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               dto.setIsCheck(2);
               holder.radioButton.setChecked(false);
           }
       });
       if (dto.getIsCheck()==1){
           holder.radioButton.setChecked(true);
           holder.radioButton2.setChecked(false);
       }else if (dto.getIsCheck()==2){
           holder.radioButton.setChecked(false);
           holder.radioButton2.setChecked(true);
       }else {
           holder.radioButton.setChecked(false);
           holder.radioButton2.setChecked(false);
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
        return lstRadioButton.size();
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

