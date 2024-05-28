package com.joaoferreira.ine_presentation.country_overview.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.joaoferreira.ine_presentation.country_overview.Stat
import com.joaoferreira.core.R

@Composable
fun ExpandableStat(
    stat: Stat,
    onToggleClick: () -> Unit,
    content: @Composable () -> Unit,
    modifier: Modifier
) {
    val context = LocalContext.current
    Column(modifier = modifier) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .clickable { onToggleClick() }
            .padding(5.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = stat.drawableRes),
                contentDescription = stat.name.asString(context)
            )
            Spacer(modifier = Modifier.width(10.dp))
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = stat.name.asString(context),
                        style = MaterialTheme.typography.headlineSmall
                    )
                    Icon(
                        imageVector = if (stat.isExpanded) {
                            Icons.Default.KeyboardArrowUp
                        } else Icons.Default.KeyboardArrowDown,
                        contentDescription = if(stat.isExpanded) {
                            stringResource(id = R.string.collapse)
                        } else stringResource(id = R.string.extend)
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(15.dp))
        AnimatedVisibility(visible = stat.isExpanded) {
            content()
        }
    }
}