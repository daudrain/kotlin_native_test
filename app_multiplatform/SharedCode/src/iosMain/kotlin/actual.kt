package com.jetbrains.handson.mpp.mobile

import platform.UIKit.UIDevice

actual typealias NativeThrows = Throws

@Throws
actual fun createApplicationScreenMessage() : String {
  throw Exception("Hi There!")
}
//@Throws
//actual fun platformName(): String {
//  var prefix = ""
//  try {
//    prefix += "[try]"
//    throw RuntimeException("Hi There!")
//  }
//  catch (e: Exception) {
//    prefix += "[catch:" + e.message+ "]"
//  }
//  finally {
//    prefix += "[finally]"
//  }
//  return prefix + UIDevice.currentDevice.systemName() +
//         " " +
//         UIDevice.currentDevice.systemVersion
//  throw Exception("Hi There!")
//}
