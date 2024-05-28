package com.joaoferreira.ine_presentation.country_overview.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.joaoferreira.core.R
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Composable
fun parseDateText(date: LocalDate): String {
    val today = LocalDate.now()
    return when(date) {
        today -> stringResource(id = R.string.today)
        today.minusYears(1) -> stringResource(id = R.string.previous_year)
        today.plusYears(1) -> stringResource(id = R.string.next_year)
        else -> DateTimeFormatter.ofPattern("dd LLLL").format(date)
    }
}