package com.debug.hilt

import android.util.Log
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject
import javax.inject.Qualifier

class House @Inject constructor(
    @KitchenQualifier private val kitchenTap: Tap,
    @BathroomQualifier private val bathroomTap: Tap,
){
    fun logTaps(){
        Log.i("Hilt Qualifiers", kitchenTap.javaClass.simpleName)
        Log.i("Hilt Qualifiers", bathroomTap.javaClass.simpleName)
    }
}

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class KitchenQualifier


@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class BathroomQualifier

@Module
@InstallIn(SingletonComponent::class)
abstract class MyQualifiers{

    @Binds
    @KitchenQualifier
    abstract fun bindsKitchenTap(
        tap: KitchenTap
    ) : Tap

    @Binds
    @BathroomQualifier
    abstract fun bindsBathroomTap(
        tap: BathroomTap
    ) : Tap
}

interface Tap

class KitchenTap @Inject constructor() : Tap

class BathroomTap @Inject constructor() : Tap

