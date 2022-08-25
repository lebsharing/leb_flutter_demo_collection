package com.example.android.codelabs.navigation

import android.os.Bundle
import androidx.navigation.NavArgs
import kotlin.Int
import kotlin.jvm.JvmStatic

public data class FlowStepFragmentArgs(
  public val flowStepNumber: Int = 2
) : NavArgs {
  public fun toBundle(): Bundle {
    val result = Bundle()
    result.putInt("flowStepNumber", this.flowStepNumber)
    return result
  }

  public companion object {
    @JvmStatic
    public fun fromBundle(bundle: Bundle): FlowStepFragmentArgs {
      bundle.setClassLoader(FlowStepFragmentArgs::class.java.classLoader)
      val __flowStepNumber : Int
      if (bundle.containsKey("flowStepNumber")) {
        __flowStepNumber = bundle.getInt("flowStepNumber")
      } else {
        __flowStepNumber = 2
      }
      return FlowStepFragmentArgs(__flowStepNumber)
    }
  }
}
