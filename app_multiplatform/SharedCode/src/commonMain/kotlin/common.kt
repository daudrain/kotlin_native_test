package com.jetbrains.handson.mpp.mobile

@Target(AnnotationTarget.FUNCTION) @ExperimentalMultiplatform @OptionalExpectation expect annotation class NativeThrows(vararg val exceptionClasses: kotlin.reflect.KClass<out kotlin.Throwable>)

@ExperimentalMultiplatform
@NativeThrows
expect fun createApplicationScreenMessage(): String



