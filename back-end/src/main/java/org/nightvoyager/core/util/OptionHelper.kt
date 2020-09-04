package org.nightvoyager.core.util

fun hasFlag(combination: Long, contained: Long): Boolean {
    return contained == combination and contained
}