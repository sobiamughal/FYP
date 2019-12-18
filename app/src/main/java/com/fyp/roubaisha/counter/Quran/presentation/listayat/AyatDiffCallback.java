package com.fyp.roubaisha.counter.Quran.presentation.listayat;

import android.annotation.SuppressLint;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import com.fyp.roubaisha.counter.Quran.model.Ayat;

public class AyatDiffCallback extends DiffUtil.ItemCallback<Ayat> {

    @Override
    public boolean areItemsTheSame(@NonNull Ayat oldItem, @NonNull Ayat newItem) {
        return oldItem.getAyat().equals(newItem.getAyat());
    }

    @SuppressLint("DiffUtilEquals")
    @Override
    public boolean areContentsTheSame(@NonNull Ayat oldItem, @NonNull Ayat newItem) {
        return oldItem == newItem;
    }
}
