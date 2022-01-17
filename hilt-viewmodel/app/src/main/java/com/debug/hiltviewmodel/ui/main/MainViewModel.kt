package com.debug.hiltviewmodel.ui.main

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    someInterface: SomeInterface
) : ViewModel()

class SomeImplementation @Inject constructor() : SomeInterface

interface SomeInterface

@Module
@InstallIn(ViewModelComponent::class)
abstract class HiltExample {

    @Binds
    abstract fun bindsInterface(
        someImplementation: SomeImplementation
    ): SomeInterface
}