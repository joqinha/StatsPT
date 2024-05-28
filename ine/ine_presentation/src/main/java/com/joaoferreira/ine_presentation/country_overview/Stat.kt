package com.joaoferreira.ine_presentation.country_overview

import androidx.annotation.DrawableRes
import com.joaoferreira.core.util.UiText
import com.joaoferreira.core.R

data class Stat(
    val name: UiText,
    @DrawableRes val drawableRes: Int,
    val isExpanded: Boolean = false
)

val defaultStats = listOf(
    Stat(
        name = UiText.StringResource(R.string.PopulacaoResidente),
        drawableRes = R.drawable.ic_burger,
    ),
    Stat(
        name = UiText.StringResource(R.string.TaxaDesemprego),
        drawableRes = R.drawable.ic_burger,
    )
)