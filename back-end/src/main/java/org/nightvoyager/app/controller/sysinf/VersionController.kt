package org.nightvoyager.app.controller.sysinf

import org.nightvoyager.app.service.ITokenManager
import org.nightvoyager.app.style.Restful
import org.nightvoyager.core.security.Permissions
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(VersionController.PATH)
open class VersionController {

    @Autowired
    private lateinit var tokenManager: ITokenManager

    @Restful
    @GetMapping("version")
    open fun version(@CookieValue("token") token: String): Any {
        val person = tokenManager.findPersonByToken(token);
        person.must(Permissions.READ_SYSTEM_STATE)
        return "0.0.1"
    }

    companion object {
        const val PATH = "sysinf"
    }

}