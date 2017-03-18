package com.si.mynews.di.component;

import android.app.Activity;

import com.si.mynews.di.FragmentScope;
import com.si.mynews.di.module.FragmentModule;
import com.si.mynews.ui.gank.fragment.GirlFragment;
import com.si.mynews.ui.gank.fragment.TechFragment;
import com.si.mynews.ui.gold.fragment.GoldMainFragment;
import com.si.mynews.ui.gold.fragment.GoldPagerFragment;
import com.si.mynews.ui.main.fragment.LikeFragment;
import com.si.mynews.ui.main.fragment.SettingFragment;
import com.si.mynews.ui.vtex.fragment.VtexPagerFragment;
import com.si.mynews.ui.wechat.fragment.WechatMainFragment;
import com.si.mynews.ui.zhihu.fragment.CommentFragment;
import com.si.mynews.ui.zhihu.fragment.DailyFragment;
import com.si.mynews.ui.zhihu.fragment.HotFragment;
import com.si.mynews.ui.zhihu.fragment.SectionFragment;
import com.si.mynews.ui.zhihu.fragment.ThemeFragment;

import dagger.Component;

/**
 * Created by si on 16/8/7.
 */

@FragmentScope
@Component(dependencies = AppComponent.class, modules = FragmentModule.class)
public interface FragmentComponent {

    Activity getActivity();

    void inject(DailyFragment dailyFragment);

    void inject(ThemeFragment themeFragment);

    void inject(SectionFragment sectionFragment);

    void inject(HotFragment hotFragment);

    void inject(CommentFragment longCommentFragment);

    void inject(TechFragment techFragment);

    void inject(GirlFragment girlFragment);

    void inject(LikeFragment likeFragment);

    void inject(WechatMainFragment wechatMainFragment);

    void inject(SettingFragment settingFragment);

    void inject(GoldMainFragment goldMainFragment);

    void inject(GoldPagerFragment goldPagerFragment);

    void inject(VtexPagerFragment vtexPagerFragment);
}
