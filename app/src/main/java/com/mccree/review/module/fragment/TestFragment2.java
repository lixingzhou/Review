package com.mccree.review.module.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.mccree.review.R;
import com.mccree.review.utils.LLog;

/**
 * Created by: lixingzhou
 * Created Date: 2021/8/27 14:16
 * Description:
 */
public class TestFragment2 extends Fragment {

    public static TestFragment2 getInstance(Bundle bundle) {
        TestFragment2 fragment = new TestFragment2();
        if (bundle != null) {
            fragment.setArguments(bundle);
        }
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.layout_test_fragment, null, false);
        Bundle bundle = getArguments();
        LLog.d("bundle = " + (bundle == null ? null : bundle.toString()));

        TextView textView = rootView.findViewById(R.id.tv_fragment_index);
        textView.setText("Fragment2");
        return rootView;
    }
}
