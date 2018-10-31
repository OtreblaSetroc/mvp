package hidrosina.gshp.net.pre_alpha_hidrosina.ui.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.Switch;

import butterknife.BindView;
import butterknife.ButterKnife;
import hidrosina.gshp.net.pre_alpha_hidrosina.R;

public class RVMain2 extends RecyclerView.Adapter<RecyclerView.ViewHolder>  {
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
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
