package com.matisse.widget

import android.content.Context
import android.content.res.TypedArray
import android.graphics.PorterDuff
import android.graphics.drawable.Drawable
import android.support.v4.content.res.ResourcesCompat
import android.support.v7.widget.AppCompatImageView
import android.util.AttributeSet
import com.matisse.R

class CheckRadioView : AppCompatImageView {

    private var mDrawable: Drawable? = null

    private var mSelectedColor: Int = 0
    private var mUnSelectUdColor: Int = 0

    constructor(context: Context) : super(context) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init()
    }

    private fun init() {
        val ta: TypedArray = context!!.theme!!.obtainStyledAttributes(intArrayOf(R.attr.item_checkRadio))
        mSelectedColor = ResourcesCompat.getColor(resources, R.color.item_checkRadio, context.theme)
        mSelectedColor = ta.getColor(0, mSelectedColor)
        ta.recycle()

        mUnSelectUdColor = ResourcesCompat.getColor(resources, R.color.check_original_radio_disable, context.theme)
        setChecked(false)
    }

    fun setChecked(enable: Boolean) {
        if (enable) {
            setImageResource(R.drawable.ic_preview_radio_on)
            mDrawable = drawable
            mDrawable!!.setColorFilter(mSelectedColor, PorterDuff.Mode.SRC_IN)
        } else {
            setImageResource(R.drawable.ic_preview_radio_off)
            mDrawable = drawable
            mDrawable!!.setColorFilter(mUnSelectUdColor, PorterDuff.Mode.SRC_IN)
        }
    }

    fun setColor(color: Int) {
        if (mDrawable == null) {
            mDrawable = drawable
        }
        mDrawable!!.setColorFilter(color, PorterDuff.Mode.SRC_IN)
    }
}