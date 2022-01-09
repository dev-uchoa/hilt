package com.debug.hilt

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var firstInjection: InjectionExample

    @Inject
    lateinit var secondInjection: InjectionExample

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val btn = findViewById<Button>(R.id.recreate)
        btn.setOnClickListener {
            recreate()
            Log.i("Inject example", "activity recreated")
        }

        Log.i("Inject example", "memory address $firstInjection")
        Log.i("Inject example", "memory address $secondInjection")
    }
}

@Module
@InstallIn(ActivityRetainedComponent::class)
class MyModule {

    @Provides
    @ActivityRetainedScoped
    fun providesInjectionExample(): InjectionExample {
        return InjectionExampleImpl()
    }
}

class InjectionExampleImpl @Inject constructor() : InjectionExample

interface InjectionExample