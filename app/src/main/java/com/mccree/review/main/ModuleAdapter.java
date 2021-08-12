package com.mccree.review.main;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.mccree.review.R;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * Created by: lixingzhou
 * Created Date: 2021/7/7 10:10
 * Description:
 */
public class ModuleAdapter extends BaseQuickAdapter<Module, BaseViewHolder> {

    public ModuleAdapter(int layoutResId, @Nullable List<Module> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder holder, Module module) {
        holder.setText(R.id.tv_item_content, module.getModuleName());
    }
}
