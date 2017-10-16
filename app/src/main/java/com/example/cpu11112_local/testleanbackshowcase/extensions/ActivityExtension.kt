package com.example.cpu11112_local.testleanbackshowcase.extensions

import android.app.Fragment
import android.support.annotation.AnimRes
import android.support.annotation.IdRes
import android.app.Activity

/**
 * Created by CPU11112-local on 10/16/2017.
 */

/**
 * Method to replace the fragment. The [fragment] is added to the container view with id
 * [containerViewId] and a [tag]. The operation is performed by the fragmentManager.
 */
fun Activity.replaceFragmentSafely(fragment: Fragment,
                                   tag: String,
                                   allowStateLoss: Boolean = false,
                                   @IdRes containerViewId: Int,
                                   @AnimRes enterAnimation: Int = 0,
                                   @AnimRes exitAnimation: Int = 0,
                                   @AnimRes popEnterAnimation: Int = 0,
                                   @AnimRes popExitAnimation: Int = 0) {
    val ft = fragmentManager
            .beginTransaction()
            .setCustomAnimations(enterAnimation, exitAnimation, popEnterAnimation, popExitAnimation)
            .replace(containerViewId, fragment, tag)
    if (!fragmentManager.isStateSaved) {
        ft.commit()
    } else if (allowStateLoss) {
        ft.commitAllowingStateLoss()
    }
}

/**
 * Method to add the fragment. The [fragment] is added to the container view with id
 * [containerViewId] and a [tag]. The operation is performed by the fragmentManager.
 * This method checks if fragment exists.
 * @return the fragment added.
 */
fun <T : Fragment> Activity.addFragmentSafelfy(fragment: T,
                                                        tag: String,
                                                        allowStateLoss: Boolean = false,
                                                        @IdRes containerViewId: Int,
                                                        @AnimRes enterAnimation: Int = 0,
                                                        @AnimRes exitAnimation: Int = 0,
                                                        @AnimRes popEnterAnimation: Int = 0,
                                                        @AnimRes popExitAnimation: Int = 0): T {
    if (!existsFragmentByTag(tag)) {
        val ft = fragmentManager.beginTransaction()
        ft.setCustomAnimations(enterAnimation, exitAnimation, popEnterAnimation, popExitAnimation)
        ft.add(containerViewId, fragment, tag)
        if (!fragmentManager.isStateSaved) {
            ft.commit()
        } else if (allowStateLoss) {
            ft.commitAllowingStateLoss()
        }
        return fragment
    }
    return findFragmentByTag(tag) as T
}

/**
 * Method to check if fragment exists. The operation is performed by the fragmentManager.
 */
fun Activity.existsFragmentByTag(tag: String): Boolean {
    return fragmentManager.findFragmentByTag(tag) != null
}

/**
 * Method to get fragment by tag. The operation is performed by the fragmentManager.
 */
fun Activity.findFragmentByTag(tag: String): Fragment? {
    return fragmentManager.findFragmentByTag(tag)
}