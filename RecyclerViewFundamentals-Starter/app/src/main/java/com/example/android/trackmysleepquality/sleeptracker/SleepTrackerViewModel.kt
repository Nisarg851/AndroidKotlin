<<<<<<< HEAD
=======
/*
 * Copyright 2019, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

>>>>>>> 6134f1383423a6e33ce59e63ae7374d177df0932
package com.example.android.trackmysleepquality.sleeptracker

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android.trackmysleepquality.database.SleepDatabaseDao
import com.example.android.trackmysleepquality.database.SleepNight
import com.example.android.trackmysleepquality.formatNights
import kotlinx.coroutines.launch
<<<<<<< HEAD
=======

/**
 * ViewModel for SleepTrackerFragment.
 */
>>>>>>> 6134f1383423a6e33ce59e63ae7374d177df0932
class SleepTrackerViewModel(
        dataSource: SleepDatabaseDao,
        application: Application) : ViewModel() {

<<<<<<< HEAD
=======
    /**
     * Hold a reference to SleepDatabase via SleepDatabaseDao.
     */
>>>>>>> 6134f1383423a6e33ce59e63ae7374d177df0932
    val database = dataSource

    private var tonight = MutableLiveData<SleepNight?>()

<<<<<<< HEAD
    val nights = database.getAllNights()

    val nightsString = Transformations.map(nights) { nights ->
        formatNights(nights, application.resources)
    }
    val startButtonVisible = Transformations.map(tonight) {
        null == it
    }
    val stopButtonVisible = Transformations.map(tonight) {
        null != it
    }
    val clearButtonVisible = Transformations.map(nights) {
        it?.isNotEmpty()
    }
    private var _showSnackbarEvent = MutableLiveData<Boolean?>()
    val showSnackBarEvent: LiveData<Boolean?>
        get() = _showSnackbarEvent
    private val _navigateToSleepQuality = MutableLiveData<SleepNight>()
    val navigateToSleepQuality: LiveData<SleepNight>
        get() = _navigateToSleepQuality
=======
    private val nights = database.getAllNights()

    /**
     * Converted nights to Spanned for displaying.
     */
    val nightsString = Transformations.map(nights) { nights ->
        formatNights(nights, application.resources)
    }

    /**
     * If tonight has not been set, then the START button should be visible.
     */
    val startButtonVisible = Transformations.map(tonight) {
        null == it
    }

    /**
     * If tonight has been set, then the STOP button should be visible.
     */
    val stopButtonVisible = Transformations.map(tonight) {
        null != it
    }

    /**
     * If there are any nights in the database, show the CLEAR button.
     */
    val clearButtonVisible = Transformations.map(nights) {
        it?.isNotEmpty()
    }

    /**
     * Request a toast by setting this value to true.
     *
     * This is private because we don't want to expose setting this value to the Fragment.
     */
    private var _showSnackbarEvent = MutableLiveData<Boolean?>()

    /**
     * If this is true, immediately `show()` a toast and call `doneShowingSnackbar()`.
     */
    val showSnackBarEvent: LiveData<Boolean?>
        get() = _showSnackbarEvent

    /**
     * Variable that tells the Fragment to navigate to a specific [SleepQualityFragment]
     *
     * This is private because we don't want to expose setting this value to the Fragment.
     */
    private val _navigateToSleepQuality = MutableLiveData<SleepNight>()

    /**
     * If this is non-null, immediately navigate to [SleepQualityFragment] and call [doneNavigating]
     */
    val navigateToSleepQuality: LiveData<SleepNight>
        get() = _navigateToSleepQuality

    /**
     * Call this immediately after calling `show()` on a toast.
     *
     * It will clear the toast request, so if the user rotates their phone it won't show a duplicate
     * toast.
     */
>>>>>>> 6134f1383423a6e33ce59e63ae7374d177df0932
    fun doneShowingSnackbar() {
        _showSnackbarEvent.value = null
    }

<<<<<<< HEAD
=======
    /**
     * Call this immediately after navigating to [SleepQualityFragment]
     *
     * It will clear the navigation request, so if the user rotates their phone it won't navigate
     * twice.
     */
>>>>>>> 6134f1383423a6e33ce59e63ae7374d177df0932
    fun doneNavigating() {
        _navigateToSleepQuality.value = null
    }

    init {
        initializeTonight()
    }

    private fun initializeTonight() {
        viewModelScope.launch {
            tonight.value = getTonightFromDatabase()
        }
    }

<<<<<<< HEAD
=======
    /**
     *  Handling the case of the stopped app or forgotten recording,
     *  the start and end times will be the same.j
     *
     *  If the start time and end time are not the same, then we do not have an unfinished
     *  recording.
     */
>>>>>>> 6134f1383423a6e33ce59e63ae7374d177df0932
    private suspend fun getTonightFromDatabase(): SleepNight? {
            var night = database.getTonight()
            if (night?.endTimeMilli != night?.startTimeMilli) {
                night = null
            }
            return night
    }

    private suspend fun insert(night: SleepNight) {
            database.insert(night)
    }

    private suspend fun update(night: SleepNight) {
            database.update(night)
    }

    private suspend fun clear() {
            database.clear()
    }

<<<<<<< HEAD
    fun onStart() {
        viewModelScope.launch {
=======
    /**
     * Executes when the START button is clicked.
     */
    fun onStart() {
        viewModelScope.launch {
            // Create a new night, which captures the current time,
            // and insert it into the database.
>>>>>>> 6134f1383423a6e33ce59e63ae7374d177df0932
            val newNight = SleepNight()

            insert(newNight)

            tonight.value = getTonightFromDatabase()
        }
    }

<<<<<<< HEAD
    fun onStop() {
        viewModelScope.launch {
            val oldNight = tonight.value ?: return@launch
=======
    /**
     * Executes when the STOP button is clicked.
     */
    fun onStop() {
        viewModelScope.launch {
            // In Kotlin, the return@label syntax is used for specifying which function among
            // several nested ones this statement returns from.
            // In this case, we are specifying to return from launch().
            val oldNight = tonight.value ?: return@launch

            // Update the night in the database to add the end time.
>>>>>>> 6134f1383423a6e33ce59e63ae7374d177df0932
            oldNight.endTimeMilli = System.currentTimeMillis()

            update(oldNight)

<<<<<<< HEAD
=======
            // Set state to navigate to the SleepQualityFragment.
>>>>>>> 6134f1383423a6e33ce59e63ae7374d177df0932
            _navigateToSleepQuality.value = oldNight
        }
    }

<<<<<<< HEAD
    fun onClear() {
        viewModelScope.launch {
            clear()

            tonight.value = null

=======
    /**
     * Executes when the CLEAR button is clicked.
     */
    fun onClear() {
        viewModelScope.launch {
            // Clear the database table.
            clear()

            // And clear tonight since it's no longer in the database
            tonight.value = null

            // Show a snackbar message, because it's friendly.
>>>>>>> 6134f1383423a6e33ce59e63ae7374d177df0932
            _showSnackbarEvent.value = true
        }
    }
}