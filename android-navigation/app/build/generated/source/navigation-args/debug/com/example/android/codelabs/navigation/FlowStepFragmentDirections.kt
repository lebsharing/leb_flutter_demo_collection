package com.example.android.codelabs.navigation

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections

public class FlowStepFragmentDirections private constructor() {
  public companion object {
    public fun nextAction(): NavDirections = ActionOnlyNavDirections(R.id.next_action)
  }
}
