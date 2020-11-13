package com.olehmesh.newsfeed.base

import android.os.Bundle
import android.view.LayoutInflater
import androidx.annotation.Nullable
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import java.lang.reflect.InvocationTargetException
import java.lang.reflect.Method
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type


open class BaseActivity<T : ViewBinding?> : AppCompatActivity() {

    var binding: T? = null

    override fun onCreate(@Nullable savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val superclass: Type = javaClass.genericSuperclass!!
        val aClass = (superclass as ParameterizedType).actualTypeArguments[0] as Class<*>

        try {
            val method: Method = aClass.getDeclaredMethod("inflate", LayoutInflater::class.java)
            binding = method.invoke(null, layoutInflater) as T?
            setContentView(binding!!.root)
        } catch (e: NoSuchMethodException) {
            e.printStackTrace()
        } catch (e: IllegalAccessException) {
            e.printStackTrace()
        } catch (e: InvocationTargetException) {
            e.printStackTrace()
        }
    }

}