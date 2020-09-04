package org.nightvoyager.app.controllers.sysinf

import org.nightvoyager.app.style.Restful
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(VersionController.PATH)
open class VersionController {

    @Restful
    @GetMapping("version")
    open fun version() : Any{
        return "0.0.1"
    }

//    @Restful
//    @GetMapping("mu")
//    open fun memoryUsage() : Any{
//
//    }
//    open fun cpuUsage(): Any{
//
//    }

    companion object {
        const val PATH = "sysinf"
    }

}