package com.sethchhim.kuboo_client.ui.reader.comic

import android.annotation.SuppressLint
import com.sethchhim.kuboo_client.Extensions.fadeVisible
import com.sethchhim.kuboo_client.R
import com.sethchhim.kuboo_client.ui.reader.base.ReaderBaseActivity
import com.sethchhim.kuboo_client.ui.reader.comic.custom.ReaderViewPagerImpl1_Edge
import timber.log.Timber

@SuppressLint("Registered")
open class ReaderComicActivityImpl0_View : ReaderBaseActivity() {

    protected lateinit var viewPager: ReaderViewPagerImpl1_Edge

    protected fun initUi() {
        val contentView = layoutInflater.inflate(R.layout.reader_layout_comic_content, null, false)
        contentFrameLayout.removeAllViews()
        contentFrameLayout.addView(contentView)

        viewPager = findViewById(R.id.reader_layout_base_content_readerViewPagerImpl1_Edge)
        viewPager.offscreenPageLimit = getOffScreenPageLimit()
    }

    override fun onEnterTransitionFinished() {
        forceOrientation()
        viewPager.fadeVisible()
    }

    private fun getOffScreenPageLimit() = when (systemUtil.isOrientationPortrait()) {
        true -> when (isLocal) {
            true -> 4
            false -> 2
        }
        false -> when (isLocal) {
            true -> 2
            false -> 1
        }
    }

    override fun onSwipeOutOfBoundsStart() = Timber.i("onSwipeOutOfBoundsStart")

    override fun onSwipeOutOfBoundsEnd() {
        Timber.i("onSwipeOutOfBoundsEnd")
        val isBannedFromRecent = currentBook.isBannedFromRecent()
        val isLastInSeries = nextBook.isEmpty()
        when (isBannedFromRecent || isLastInSeries) {
            true -> showSnackBarEnd()
            false -> showSnackBarNext()
        }
    }
}