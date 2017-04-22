package com.si.mynews.ui;

import android.support.v7.app.AppCompatActivity;

/**
 * Created by si on 16/11/27.
 */

public class NewsManagerActivity extends AppCompatActivity {

//    @BindView(R.id.tool_bar)
//    Toolbar toolBar;
//    @BindView(R.id.rv_gold_manager_list)
//    RecyclerView rvGoldManagerList;
//
//    RealmList<NewsManagerItemBean> mList;
//    GoldManagerAdapter mAdapter;
//    DefaultItemTouchHelpCallback mCallback;
//
//    @Override
//    protected int getLayout() {
//        return R.layout.activity_gold_manager;
//    }
//
//    @Override
//    protected void initEventAndData() {
//        setToolBar(toolBar, "首页特别展示");
//        mList = ((NewsManagerBean) getIntent().getParcelableExtra(Constants.IT_GOLD_MANAGER)).getManagerList();
//        mAdapter = new GoldManagerAdapter(mContext, mList);
//        rvGoldManagerList.setLayoutManager(new LinearLayoutManager(mContext));
//        rvGoldManagerList.setAdapter(mAdapter);
//        mCallback = new DefaultItemTouchHelpCallback(new DefaultItemTouchHelpCallback.OnItemTouchCallbackListener() {
//            @Override
//            public void onSwiped(int adapterPosition) {
//            }
//
//            @Override
//            public boolean onMove(int srcPosition, int targetPosition) {
//                if (mList != null) {
//                    Collections.swap(mList, srcPosition, targetPosition);
//                    mAdapter.notifyItemMoved(srcPosition, targetPosition);
//                    return true;
//                }
//                return false;
//            }
//        });
//        mCallback.setDragEnable(true);
//        mCallback.setSwipeEnable(false);
//        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(mCallback);
//        itemTouchHelper.attachToRecyclerView(rvGoldManagerList);
//    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        RxBus.getDefault().post(new NewsManagerBean(mList));
//    }
}
