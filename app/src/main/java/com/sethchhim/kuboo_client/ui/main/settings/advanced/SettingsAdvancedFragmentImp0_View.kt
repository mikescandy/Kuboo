package com.sethchhim.kuboo_client.ui.main.settings.advanced

import android.content.Context
import android.os.Bundle
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat
import androidx.preference.SwitchPreference
import androidx.preference.SwitchPreferenceCompat
import com.sethchhim.kuboo_client.BaseApplication
import com.sethchhim.kuboo_client.R
import com.sethchhim.kuboo_client.data.ViewModel
import com.sethchhim.kuboo_client.ui.main.MainActivity
import com.sethchhim.kuboo_client.util.DialogUtil
import com.sethchhim.kuboo_client.util.SharedPrefsHelper
import com.sethchhim.kuboo_client.util.SystemUtil
import com.sethchhim.kuboo_remote.KubooRemote
import javax.inject.Inject


open class SettingsAdvancedFragmentImp0_View : PreferenceFragmentCompat() {

    init {
        BaseApplication.appComponent.inject(this)
    }

    @Inject lateinit var dialogUtil: DialogUtil
    @Inject lateinit var kubooRemote: KubooRemote
    @Inject lateinit var sharedPrefsHelper: SharedPrefsHelper
    @Inject lateinit var systemUtil: SystemUtil
    @Inject lateinit var viewModel: ViewModel

    protected lateinit var mainActivity: MainActivity

    protected lateinit var homeRecentlyViewedHeightOffset: Preference
    protected lateinit var browserPreviewPreference: SwitchPreferenceCompat
    protected lateinit var browserReverseLayoutPreference: SwitchPreferenceCompat
    protected lateinit var readerScrollOffset: Preference
    protected lateinit var systemForceDownsizing: Preference
    protected lateinit var sharedElementTransition: SwitchPreferenceCompat

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        addPreferencesFromResource(R.xml.settings_advanced)
        homeRecentlyViewedHeightOffset = findPreference("settings_home_recently_viewed_height_offset")
        browserPreviewPreference = findPreference("settings_browser_preview") as SwitchPreferenceCompat
        browserReverseLayoutPreference = findPreference("settings_browser_reverse_layout") as SwitchPreferenceCompat
        sharedElementTransition = findPreference("settings_shared_element_transition") as SwitchPreferenceCompat
        readerScrollOffset = findPreference("settings_reader_scroll_offset")
        systemForceDownsizing = findPreference("settings_force_downsizing")
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mainActivity = context as MainActivity
    }

}