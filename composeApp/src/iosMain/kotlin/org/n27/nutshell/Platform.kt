package org.n27.nutshell

import platform.UIKit.UIDevice

class IOSPlatform {
    val name: String = UIDevice.currentDevice.systemName() + " " + UIDevice.currentDevice.systemVersion
}

fun getPlatform() = IOSPlatform()