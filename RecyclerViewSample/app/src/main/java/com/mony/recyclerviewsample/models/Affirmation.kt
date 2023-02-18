package com.mony.recyclerviewsample.models

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

// Class which represents an Affirmation model
data class Affirmation (
    @StringRes val stringResourceId: Int,
    @DrawableRes val imageResourceId: Int
    )
