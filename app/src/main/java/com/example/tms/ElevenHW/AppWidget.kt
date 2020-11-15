package com.example.tms.ElevenHW

import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.content.Intent
import android.graphics.drawable.BitmapDrawable
import android.os.Build
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.RemoteViews
import androidx.annotation.RequiresApi
import com.example.tms.R
import com.example.tms.launchIO
import com.example.tms.launchUI
import com.squareup.picasso.Picasso
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import java.net.SocketTimeoutException
import kotlin.math.log


const val REQUEST_CODE = 102
const val WIDGETID = "WidgetID"

class AppWidget : AppWidgetProvider() {


    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray
    ) {
        for (appWidgetId in appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId)
        }
    }

    override fun onDeleted(context: Context, appWidgetIds: IntArray) {
        for (appWidgetId in appWidgetIds) {
            deleteTitlePref(context, appWidgetId)
        }
    }

    override fun onReceive(context: Context?, intent: Intent?) {
        super.onReceive(context, intent)
        val views = RemoteViews(context?.packageName, R.layout.app_widget)
        val appWidgetManager = AppWidgetManager.getInstance(context)
        val appWidgetId = intent?.getIntExtra(WIDGETID, 0) ?: 0
        hideViews(views)
        appWidgetManager.updateAppWidget(appWidgetId, views)
        context?.let {
            updateAppWidget(
                it, appWidgetManager, appWidgetId
            )
        }
    }

}


internal fun updateAppWidget(
    context: Context,
    appWidgetManager: AppWidgetManager,
    appWidgetId: Int
) {
    val views = RemoteViews(context.packageName, R.layout.app_widget)
    val updateIntent = PendingIntent.getBroadcast(
        context, REQUEST_CODE,
        Intent().apply {
            action = AppWidgetManager.ACTION_APPWIDGET_UPDATE
            putExtra(WIDGETID, appWidgetId)
        }, PendingIntent.FLAG_UPDATE_CURRENT
    )
    views.setOnClickPendingIntent(R.id.appwidget_update, updateIntent)
    launchIO {
        var response: Response<WeatherResponse>? = null
        try {
            response =
                RetrofitFactory.getRetrofit().getWeatherAPIAsync(
                    loadTitlePref(context, appWidgetId),
                    APP_ID
                ).await()
        } catch (e: Throwable) {
            Log.e("Errr", e.toString())
        }
        if (response?.isSuccessful == true) {
            val weather = response.body()?.let { Mapper.weatherResponseToWeather(it) }
            weather?.city = loadTitlePref(context, appWidgetId)
            val icon = Picasso.get().load(weather?.icon).get()
            with(views) {
                weather?.let {
                    setTextViewText(R.id.appwidget_temperature, "${it.temperature} °C")
                    setTextViewText(R.id.appwidget_city, it.city.toString())
                    setTextViewText(R.id.appwidget_weather_description, it.description)
                    setImageViewBitmap(R.id.appwidget_icon, icon)
                    showViews(views)
                }

            }

        } else {
            with(views) {
                setViewVisibility(R.id.appwidget_prgress_bar, View.GONE)
                setViewVisibility(R.id.appwidget_error, View.VISIBLE)
            }
        }
        appWidgetManager.updateAppWidget(appWidgetId, views)

    }

}

fun showViews(views: RemoteViews) {
    with(views) {
        setViewVisibility(R.id.appwidget_error, View.GONE)
        setViewVisibility(R.id.appwidget_prgress_bar, View.GONE)
        setViewVisibility(R.id.appwidget_temperature, View.VISIBLE)
        setViewVisibility(R.id.appwidget_city, View.VISIBLE)
        setViewVisibility(R.id.appwidget_icon, View.VISIBLE)
        setViewVisibility(R.id.appwidget_weather_description, View.VISIBLE)
    }
}

fun hideViews(views: RemoteViews) {
    with(views) {
        setViewVisibility(R.id.appwidget_error, View.GONE)
        setViewVisibility(R.id.appwidget_prgress_bar, View.VISIBLE)
        setViewVisibility(R.id.appwidget_temperature, View.GONE)
        setViewVisibility(R.id.appwidget_city, View.GONE)
        setViewVisibility(R.id.appwidget_icon, View.GONE)
        setViewVisibility(R.id.appwidget_weather_description, View.GONE)
    }
}
