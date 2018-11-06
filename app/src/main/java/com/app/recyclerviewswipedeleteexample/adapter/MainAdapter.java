package com.app.recyclerviewswipedeleteexample.adapter;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.app.recyclerviewswipedeleteexample.R;
import com.app.recyclerviewswipedeleteexample.listener.OnItemClickIdListener;
import com.app.recyclerviewswipedeleteexample.utils.SwipeRevealLayout;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    private static final String TAG = MainAdapter.class.getSimpleName();
    private int lastClicked;
    private AppCompatActivity mContext;
    private List<String> mList;
    private OnItemClickIdListener onItemClickListener;

    public MainAdapter(AppCompatActivity activity, List<String> mList, OnItemClickIdListener onItemClickListener) {
        this.mContext = activity;
        this.mList = mList;
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public MainAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.raw_item, parent, false);
        return new MainAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MainAdapter.ViewHolder holder, final int position) {
        holder.tvItem.setText(mList.get(position));
        holder.imgSwipeDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lastClicked = position;
                holder.swipereveallayout.close(false);
                onItemClickListener.itemClickItem(lastClicked);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private CardView mCardAddressItem;
        private RelativeLayout mRltAddressItem;
        private TextView tvItem;
        private ImageView imgSwipeDelete;
        private SwipeRevealLayout swipereveallayout;

        /**
         * @param
         * @return
         * @throws
         * @purpose to initialize views
         */
        private void findViews(View itemView) {
            //mCardAddressItem = (CardView) itemView.findViewById(R.id.card_address_item);
            mRltAddressItem = (RelativeLayout) itemView.findViewById(R.id.rlt_address_item);
            imgSwipeDelete = (ImageView) itemView.findViewById(R.id.imgSwipeDelete);
            tvItem = itemView.findViewById(R.id.tvItem);
            swipereveallayout = (SwipeRevealLayout) itemView.findViewById(R.id.swipereveallayout);
        }

        public ViewHolder(View itemView) {
            super(itemView);
            findViews(itemView);
        }

    }
}
