package org.nightvoyager.core.util

import org.nightvoyager.core.INVSystem
import java.io.InputStream

fun getResource(resName:String) : InputStream {
   return INVSystem::class.java.classLoader.getResourceAsStream(resName);
}