package com.app.jettodoapp.data.models

import androidx.compose.ui.graphics.Color
import com.app.jettodoapp.ui.theme.HighPriorityColor
import com.app.jettodoapp.ui.theme.LowPriorityColor
import com.app.jettodoapp.ui.theme.MediumPriorityColor
import com.app.jettodoapp.ui.theme.NonePriorityColor

enum class Priority(val color: Color) {
    HIGH(HighPriorityColor),
    Medium(MediumPriorityColor),
    LOW(LowPriorityColor),
    NONE(NonePriorityColor)
}