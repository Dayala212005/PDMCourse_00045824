package com.example.parcial2pdm

import android.app.Application
import com.example.parcial2pdm.data.AppProvider

class Parcial2PDM : Application() {
    val appProvider by lazy { AppProvider(this) }
}