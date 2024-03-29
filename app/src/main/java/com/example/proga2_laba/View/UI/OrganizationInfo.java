package com.example.proga2_laba.View.UI;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.proga2_laba.R;
import com.example.proga2_laba.databinding.OrganizationFragmentBinding;
import com.example.proga2_laba.viewmodel.MainViewModel;
import com.example.proga2_laba.viewmodel.OrganizationViewModel;

public class OrganizationInfo extends Fragment {

    private OrganizationViewModel organizationViewModel;
    private int page;

    public static OrganizationInfo newInstance(int page) {
        OrganizationInfo organizationInfo = new OrganizationInfo();
        Bundle args = new Bundle();
        args.putInt("page", page);
        organizationInfo.setArguments(args);
        return organizationInfo;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        organizationViewModel = ViewModelProviders.of(getActivity()).get(MainViewModel.class).getOrganizationViewModel();
        page = getArguments().getInt("page");
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        OrganizationFragmentBinding organizationFragmentBinding = DataBindingUtil.inflate(
                inflater,
                R.layout.organization_fragment,
                container,
                false
        );
        organizationFragmentBinding.setLifecycleOwner(getActivity());
        organizationFragmentBinding.setOrganizationViewModel(organizationViewModel);
        organizationFragmentBinding.executePendingBindings();
        return organizationFragmentBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
}
