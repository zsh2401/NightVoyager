package org.nightvoyager.app.style

import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.nightvoyager.app.exceptions.NvApiException
import org.springframework.stereotype.Component

@Aspect
@Component
open class AOPHandlers {
    @Around(value = "@annotation(restful)")
    open fun restfulResultHandler(pjp: ProceedingJoinPoint, restful: Restful): Any {
        return try {
            var result = pjp.proceed()
            RestfulResult(0, result);
        }catch (e:NvApiException){
            RestfulResult(e.statusCode,e.cause?.javaClass?.name,e.message)
        } catch (e:Exception){
            RestfulResult(-1,e.javaClass.name,e.toString());
        }
    }
}
