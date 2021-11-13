package com.saigyouji.cloudmusic.view.widget

import android.content.Context
import android.graphics.*
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.util.TypedValue
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatImageView
import androidx.compose.ui.graphics.Paint
import com.saigyouji.cloudmusic.R
import kotlin.math.min
class RoundImageView
    : AppCompatImageView{
    private lateinit var mPaint: android.graphics.Paint
    private var currMode = 0
    private var currRound = dp2px(10.toFloat())
    constructor(context: Context): super(context)
    {
        initViews()
    }
    constructor(context: Context, attributeSet: AttributeSet,defStyleAttr: Int) : super(context, attributeSet, defStyleAttr)
    {
        obtainStyledAttrs(context, attributeSet, defStyleAttr)
        initViews()
    }
    constructor(context: Context, attrs: AttributeSet):this(context, attrs, 0)

    private fun obtainStyledAttrs(context: Context, attrs: AttributeSet?, defStyleAttr: Int)
    {
        val a = context.obtainStyledAttributes(attrs, R.styleable.RoundImageView,defStyleAttr,0)
        currMode = if(a.hasValue(R.styleable.RoundImageView_type))
            a.getInt(R.styleable.RoundImageView_type, 0)
        else
            MODE_NONE
        currRound = if(a.hasValue(R.styleable.RoundImageView_radius))
            a.getDimensionPixelSize(R.styleable.RoundImageView_radius, currRound)
        else
            currRound
        a.recycle()
    }

    private fun dp2px(value: Float) : Int
    {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, value, resources.displayMetrics)
            .toInt()
    }

    private fun initViews()
    {
        mPaint = Paint(android.graphics.Paint.ANTI_ALIAS_FLAG or android.graphics.Paint.DITHER_FLAG)
    }

    override fun onDraw(canvas: Canvas) {

        val mDrawable = drawable
        val mDrawMatrix = imageMatrix
        if (mDrawable == null) {
            return  // couldn't resolve the URI
        }
        if (mDrawable.intrinsicWidth == 0 || mDrawable.intrinsicHeight == 0) {
            return  // nothing to draw (empty bounds)
        }

        if (mDrawMatrix == null && paddingTop == 0 && paddingLeft == 0) {
            mDrawable.draw(canvas)
        }
        else {
            val saveCount = canvas.saveCount
            canvas.save()
            if (cropToPadding) {
                val scrollX: Int = scrollX
                val scrollY: Int = scrollY
                canvas.clipRect(
                    scrollX + paddingLeft, scrollY + paddingTop,
                    scrollX + right - left - paddingRight,
                    scrollY + bottom - top - paddingBottom
                )
            }
            canvas.translate(paddingLeft.toFloat(), paddingTop.toFloat())

            if(currMode == MODE_CIRCLE)
            {
                val bitmap: Bitmap = drawable2Bitmap(mDrawable)
                mPaint.shader = BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP)
                canvas.drawCircle((width / 2).toFloat(), (height / 2.0).toFloat()
                    , (width / 2).toFloat(), mPaint)
            }
            else if (currMode == MODE_ROUND)
            {
                val bitmap = drawable2Bitmap(mDrawable)
                mPaint.shader = BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP)
                canvas.drawRoundRect(
                    RectF(
                        paddingLeft.toFloat(), paddingTop.toFloat()
                        , (width - paddingRight).toFloat(), (height - paddingBottom).toFloat()
                    ),
                    currRound.toFloat(), currRound.toFloat(), mPaint)
            }
            else {
                canvas.concat(mDrawMatrix)
                mDrawable.draw(canvas)
            }
            canvas.restoreToCount(saveCount)
            }
        }
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        if(currMode == MODE_CIRCLE) {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec)
            val result = min(measuredHeight, measuredWidth)
            setMeasuredDimension(result,result)
        }
        else
        {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        }
    }
    private fun drawable2Bitmap(drawable: Drawable) : Bitmap
    {
            val bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
            val canvas = Canvas(bitmap)
            val matrix = imageMatrix
            canvas.concat(matrix)
            drawable.draw(canvas)
            return bitmap
    }
    companion object{
        const val  MODE_CIRCLE = 1;
        const val MODE_NONE = 0;
        const val MODE_ROUND = 2;
    }
}
