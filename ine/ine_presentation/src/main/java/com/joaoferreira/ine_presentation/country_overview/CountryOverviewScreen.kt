package com.joaoferreira.ine_presentation.country_overview

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.R
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.joaoferreira.ine_presentation.country_overview.components.CountryHeader
import com.joaoferreira.ine_presentation.country_overview.components.ExpandableStat
import com.joaoferreira.ine_presentation.country_overview.components.YearSelector
import java.time.LocalDate

@Composable
fun CountryOverviewScreen() {
    val context = LocalContext.current
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 12.dp)
    ) {
        item {
            CountryHeader()
            Spacer(modifier = Modifier.height(15.dp))
            YearSelector(
                date = LocalDate.now(),
                onPreviousYearClick = {
                    //TODO
                },
                onNextYearClick = {
                    //TODO
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 15.dp)
            )
            Spacer(modifier = Modifier.height(15.dp))
        }
        items(defaultStats) { stat ->
            ExpandableStat(
                stat = stat,
                onToggleClick = { /*TODO*/ },
                modifier = Modifier.fillMaxWidth(),
                content = {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 10.dp)
                    )
                    {

                    }
                }
            )
        }
    }
}