package org.nightvoyager.app.style

import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.springframework.stereotype.Component

@Aspect
@Component
open class Handlers {
    @Around(value = "@annotation(restful)")
    open fun restfulResultHandler(pjp: ProceedingJoinPoint, restful: Restful): Any {
        return try {
            var result = pjp.proceed()
            RestfulResult(0,result);
        } catch (e:Exception){
            RestfulResult(-1,e.javaClass.name,e.toString());
        }
    }
}
