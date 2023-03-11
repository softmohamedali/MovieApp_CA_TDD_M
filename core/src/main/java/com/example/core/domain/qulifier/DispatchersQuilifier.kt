package com.example.core.domain.qulifier

import javax.inject.Qualifier



@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class IODispatchers()


@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class MainDispatchers()


@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class IOTestDispatchers()


@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class MainTestDispatchers()


