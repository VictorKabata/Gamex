package com.vickikbt.gamex.ui.fragments

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
import com.vickikbt.gamex.R

class SettingsFragment : PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.settings_fragment, rootKey)
    }
}