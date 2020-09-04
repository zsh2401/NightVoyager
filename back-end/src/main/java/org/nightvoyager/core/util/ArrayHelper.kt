package org.nightvoyager.core.util

import java.util.*


fun <T> concatAll(first: Array<T>, vararg rest: Array<T>): Array<T>? {
    var totalLength = first.size
    for (array in rest) {
        totalLength += array.size
    }
    val result = Arrays.copyOf(first, totalLength)
    var offset = first.size
    for (array in rest) {
        System.arraycopy(array, 0, result, offset, array.size)
        offset += array.size
    }
    return result
}