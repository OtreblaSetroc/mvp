package hidrosina.gshp.net.pre_alpha_hidrosina.ui.adapter;

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

    public  RVMain(List<String> questions, RVRowMain rvRowMain, Context context){
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
        rvRowMain.setPlace(position);
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
