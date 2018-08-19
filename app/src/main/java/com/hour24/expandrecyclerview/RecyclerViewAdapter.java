package com.hour24.expandrecyclerview;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

// RecyclerViewAdapter
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    // Variables
    private Context mContext;
    private MainActivity mActivity;
    private ArrayList<ModelItem> mList;

    public RecyclerViewAdapter(Context context, ArrayList<ModelItem> list) {
        this.mContext = context;
        this.mList = list;
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = DataBindingUtil.inflate(LayoutInflater.from(mContext), R.layout.main_item, parent, false).getRoot();
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final RecyclerViewAdapter.ViewHolder holder, final int position) {

        try {
            ModelItem item = mList.get(position);
            holder.getBinding().setVariable(BR.model, item);
//            holder.getBinding().setVariable(BR.handler, new BindingHandler());
            holder.getBinding().executePendingBindings();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ViewDataBinding binding;

        public ViewHolder(View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }

        public ViewDataBinding getBinding() {
            return binding;
        }
    }
//
//    // Handlers
//    public class BindingHandler {
//
//        // xml 에 정의
//        public void onClick(final View view, ModelItem timeline) {
//            try {
//
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//    }

    @BindingAdapter({"item_recyclerview"})
    public static void setRecyclerView(RecyclerView view, ModelItem model) {
        view.setAdapter(new ItemAdapter(view.getContext(), model.getItems()));
        view.setLayoutManager(new LinearLayoutManager(view.getContext()));
    }


    // RecyclerViewAdapter
    public static class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {

        // Variables
        private Context mContext;
        private ArrayList<ModelItem> mList;

        public ItemAdapter(Context context, ArrayList<ModelItem> list) {
            this.mContext = context;
            this.mList = list;
        }

        @Override
        public int getItemCount() {
            return mList.size();
        }

        @Override
        public ItemAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = DataBindingUtil.inflate(LayoutInflater.from(mContext), R.layout.main_checkbox, parent, false).getRoot();
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final ItemAdapter.ViewHolder holder, final int position) {

            try {
                ModelItem item = mList.get(position);
                holder.getBinding().setVariable(BR.model, item);
                holder.getBinding().setVariable(BR.handler, new BindingHandler());
                holder.getBinding().setVariable(BR.position, position);
                holder.getBinding().executePendingBindings();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public class ViewHolder extends RecyclerView.ViewHolder {

            private ViewDataBinding binding;

            public ViewHolder(View itemView) {
                super(itemView);
                binding = DataBindingUtil.bind(itemView);
            }

            public ViewDataBinding getBinding() {
                return binding;
            }
        }

        // Handlers
        public class BindingHandler {

            // xml 에 정의
            public void onClick(final View view, ModelItem model, int position) {
                try {
                    switch (view.getId()) {
                        case R.id.check:
                            model.setChecked(!model.isChecked());
                            notifyItemChanged(position);
                            break;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
