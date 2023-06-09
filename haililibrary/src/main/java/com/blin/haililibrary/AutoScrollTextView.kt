package com.blin.haililibrary

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.animation.LinearInterpolator
import android.widget.Scroller
import androidx.appcompat.widget.AppCompatTextView

class AutoScrollTextView : AppCompatTextView {
    private var validHeight = 0
    private var scrollSlowFactor = 4.5f
    private var mScroller: Scroller? = null

    constructor(context: Context) : super(context) {
        init(context, null)
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        init(context, attrs)
    }

    private fun init(context: Context, attrs: AttributeSet?) {
        mScroller = Scroller(getContext(), LinearInterpolator())
        if (attrs != null) {
            val array = context.obtainStyledAttributes(attrs, R.styleable.AutoScrollTextView, 0, 0)
            scrollSlowFactor = array.getFloat(R.styleable.AutoScrollTextView_ast_scroll_factor, 3f)
            array.recycle()
        }
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        validHeight = measuredHeight - paddingTop - paddingBottom
    }

    override fun computeScroll() {
        if (mScroller!!.computeScrollOffset()) {
            val currY = mScroller!!.currY
            scrollTo(0, currY)
            invalidate()
        }
    }

    fun startScroll(yDm: Int) {
        val duration = (yDm * scrollSlowFactor).toInt()
        mScroller!!.startScroll(0, scrollY, 0, yDm, duration)
        invalidate()
    }

    fun setAutoText(text: String?) {
        if (this != null) {
            this@AutoScrollTextView.text = text
            mScroller!!.startScroll(0, scrollY, 0, 0 - scrollY, 0) // 回到顶点
            invalidate()
            this.append("")
            post {
                val layout = this@AutoScrollTextView.layout
                Log.e("AutoScrollTextView", "layout:$layout")
                if (layout != null) {
                    val scrollDelta = (layout.getLineBottom(this@AutoScrollTextView.lineCount - 1)
                            - this@AutoScrollTextView.scrollY - validHeight)
                    Log.e("AutoScrollTextView", "scrollDelta:$scrollDelta")
                    if (scrollDelta > 0) startScroll(scrollDelta)
                }
            }
        }
    }
}