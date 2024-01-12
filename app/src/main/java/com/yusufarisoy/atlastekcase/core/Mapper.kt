package com.yusufarisoy.atlastekcase.core

interface Mapper<in Input, out Output> {

    fun map(input: Input): Output
}
