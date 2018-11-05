package hidrosina.gshp.net.pre_alpha_hidrosina.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;

import java.util.List;
import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.ButterKnife;
import hidrosina.gshp.net.pre_alpha_hidrosina.Model.dto.DtoOption;
import hidrosina.gshp.net.pre_alpha_hidrosina.Model.dto.DtoQuestion;
import hidrosina.gshp.net.pre_alpha_hidrosina.Model.dto.DtoSimpleOption;
import hidrosina.gshp.net.pre_alpha_hidrosina.Model.dto.DtoSimpleQuestion;
import hidrosina.gshp.net.pre_alpha_hidrosina.R;

public class RVMain2 extends RecyclerView.Adapter<RecyclerView.ViewHolder>  {

    private List<DtoSimpleQuestion> dtoQuestionList;
    private int type;
    private Context context;
    private String textoSi="Yes";
    private String texxtoNo="NO";

    public List<DtoSimpleQuestion> getDtoQuestionList() {
        return dtoQuestionList;
    }

    public RVMain2(List<DtoSimpleQuestion> dtoQuestionList, int type) {
        this.dtoQuestionList = dtoQuestionList;
        this.type=type;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        RecyclerView.ViewHolder viewHolder;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        context=parent.getContext();
        switch (type){
            case 1:
                View vswitch=inflater.inflate(R.layout.row_rv_main_switch,parent,false);
                viewHolder=new ViewSwitch(vswitch);
             break;
            case 2:
                View vradio=inflater.inflate(R.layout.row_radio_button,parent,false);
                viewHolder= new ViewRadioButton(vradio);
                break;
             default:
                 View vswitch2=inflater.inflate(R.layout.row_rv_main_switch,parent,false);
                 viewHolder=new ViewSwitch(vswitch2);
                 break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final @NonNull RecyclerView.ViewHolder holder, final int position) {
        switch (type){
            case 1:
                ViewSwitch viewSwitch=(ViewSwitch) holder;
                configureVSwitch(viewSwitch,position);
                break;
            case 2:
                break;
             default:
                 break;

        }
    }

    private void configureVSwitch(final ViewSwitch holder, final int position) {

        final DtoSimpleQuestion dtoQuestion=dtoQuestionList.get(position);
       // holder.tvQuestion.setText(dtoQuestion.getDescription()+" ");
        if (position%2==0){
            holder.linearLayout.setBackgroundResource(R.drawable.border_zebra1);
            holder.nestedScrollView.setBackgroundResource(R.drawable.border_zebra1);
        }else{
            holder.linearLayout.setBackgroundResource(R.drawable.border_zebra2);
            holder.nestedScrollView.setBackgroundResource(R.drawable.border_zebra2);
        }
        if (!dtoQuestion.getId_type().equals("5") && !dtoQuestion.getId_type().equals("9") && !dtoQuestion.getId_type().equals("11")){
            holder.tvQuestion.setText(dtoQuestion.getDescription()+" ");
        }else{
            switch (dtoQuestion.getId_type()){
                case "5" :
                    holder.txtCalendar.setVisibility(View.VISIBLE);
                    holder.txtFotoWithText.setVisibility(View.GONE);
                    holder.txtFotoWithoutText.setVisibility(View.GONE);
                  break;
                case "9" :
                    holder.txtCalendar.setVisibility(View.GONE);
                    holder.txtFotoWithText.setVisibility(View.GONE);
                    holder.txtFotoWithoutText.setVisibility(View.VISIBLE);
                    break;
                case "11" :
                    holder.txtCalendar.setVisibility(View.GONE);
                    holder.txtFotoWithText.setVisibility(View.VISIBLE);
                    holder.txtFotoWithoutText.setVisibility(View.GONE);
                    if (dtoQuestion.getMax_photo()!=null){
                        if (!dtoQuestion.getMax_photo().equals("-1")){
                            holder.txtFotoWithText.setText("(/)"+dtoQuestion.getMax_photo());
                        }
                    }else {
                        holder.txtFotoWithText.setText("(/0)");
                    }
                    break;
                default:
                    holder.txtCalendar.setVisibility(View.GONE);
                    holder.txtFotoWithText.setVisibility(View.GONE);
                    holder.txtFotoWithoutText.setVisibility(View.VISIBLE);
            }

        }

        if (dtoQuestion.getOption()!=null){ // significa que no es un question tipo foto
            if (dtoQuestion.getOption().size()<2){
                final DtoSimpleOption dtoOptions;
                dtoOptions=dtoQuestion.getOption().get(0);
                String textoSwitch=dtoOptions.getValue();
                if (textoSwitch.contains("-")){
                    textoSi=textoSwitch.split(Pattern.quote("-"))[0];
                    texxtoNo=textoSwitch.split(Pattern.quote("-"))[1];
                }
                holder.aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if (isChecked){
                            holder.aSwitch.setText(textoSi+"");
                            //dtoOptions.setChecked(1);
                        }else{
                            holder.aSwitch.setText(texxtoNo+"");
                            //dtoOptions.setChecked(2);
                        }
                    }
                });
              /*  if (dtoOptions.getChecked()==1){
                    holder.aSwitch.setChecked(true);
                }else{
                    holder.aSwitch.setChecked(false);
                }*/

            }else{
                /*Como es de tipo 2, Switch, solo se puede recibir mínimo un opción y máximo 2*/
                final DtoSimpleOption dtoOptions;
                dtoOptions=dtoQuestion.getOption().get(0);
                textoSi=dtoQuestion.getOption().get(0).getValue();
                texxtoNo=dtoQuestion.getOption().get(1).getValue();
                holder.aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if (isChecked){
                            holder.aSwitch.setText(textoSi+"");
                            //dtoOptions.setChecked(1);

                        }else{
                            holder.aSwitch.setText(texxtoNo+"");
                           // dtoOptions.setChecked(2);
                        }
                    }
                });
                /*if (dtoOptions.getChecked()==1){
                    holder.aSwitch.setChecked(true);
                }else{
                    holder.aSwitch.setChecked(false);
                }*/

            }

        }




    }

    @Override
    public int getItemCount() {
        return dtoQuestionList.size();
    }


    public class ViewRadioButton extends RecyclerView.ViewHolder {

        @BindView(R.id.radioButton)
        RadioButton radioButton;
        @BindView(R.id.radioButton2)
        RadioButton radioButton2;

        public ViewRadioButton(View v) {
            super(v);
            ButterKnife.bind(this,v);

        }
    }
    public class ViewSwitch extends RecyclerView.ViewHolder {

        @BindView(R.id.switch1)
        Switch aSwitch;
        @BindView(R.id.tvQuestion)
        TextView tvQuestion;
        @BindView(R.id.lny_main)
        ConstraintLayout linearLayout;
        @BindView(R.id.nestedScrollView)
        NestedScrollView nestedScrollView;
        @BindView(R.id.txtFotoWithText)
        TextView txtFotoWithText;
        @BindView(R.id.txtFotoWithoutText)
        TextView txtFotoWithoutText;
        @BindView(R.id.txtCalendar)
        TextView txtCalendar;



        public ViewSwitch(View v) {
            super(v);
            ButterKnife.bind(this,v);

        }
    }
}
