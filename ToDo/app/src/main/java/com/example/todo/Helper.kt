package com.example.todo

import android.content.Context
import android.util.DisplayMetrics
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.roundToInt

class Helper {
    companion object{
        fun convertPixelToDP(context: Context,pixel: Float): Int{
            return (pixel / context.resources.displayMetrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT).roundToInt()
        }
        fun convertDPToPixel(context: Context,dp: Float): Int{
            return (dp * context.resources.displayMetrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT).roundToInt()
        }
    }
}