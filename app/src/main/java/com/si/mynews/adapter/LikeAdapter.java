package com.si.mynews.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.si.mynews.app.Constants;
import com.si.mynews.component.ImageLoader;
import com.si.mynews.model.bean.RealmLikeBean;
import com.si.mynews.ui.TechDetailActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import si.mynews.R;

/**
 * Created by si on 16/8/23.
 */

public class LikeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;
    private List<RealmLikeBean> mList;
    private LayoutInflater inflater;

    private static final int TYPE_ARTICLE = 0;
    private static final int TYPE_GIRL = 1;

    public LikeAdapter(Context mContext, List<RealmLikeBean> mList) {
        this.mContext = mContext;
        this.mList = mList;
        inflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getItemViewType(int position) {
        return TYPE_ARTICLE;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ArticleViewHolder(inflater.inflate(R.layout.item_like_article, parent, false));
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        ((ArticleViewHolder) holder).title.setText(mList.get(position).getTitle());
        switch (mList.get(position).getType()) {
            case Constants.TYPE_WECHAT:
                ImageLoader.load(mContext, mList.get(position).getId(), ((ArticleViewHolder) holder).image);
                ((ArticleViewHolder) holder).from.setText("来自 微信");
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        gotoTechDetail(mList.get(holder.getAdapterPosition()).getUrl(), mList.get(holder.getAdapterPosition()).getImage(), mList.get(holder.getAdapterPosition()).getTitle()
                                , mList.get(holder.getAdapterPosition()).getId(), Constants.TYPE_WECHAT);
                    }
                });
                break;
        }
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public static class ArticleViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_article_image)
        ImageView image;
        @BindView(R.id.tv_article_title)
        TextView title;
        @BindView(R.id.tv_article_from)
        TextView from;

        public ArticleViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

    }

    public void gotoTechDetail(String url, String imgUrl, String title, String id, int type) {
        TechDetailActivity.launch(new TechDetailActivity.Builder()
                .setContext(mContext)
                .setUrl(url)
                .setImgUrl(imgUrl)
                .setId(id)
                .setTitle(title)
                .setType(type));
    }
}
