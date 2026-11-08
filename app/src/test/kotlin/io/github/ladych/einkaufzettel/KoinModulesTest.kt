package io.github.ladych.einkaufzettel

import org.junit.Test
import org.koin.core.annotation.KoinExperimentalAPI
import org.koin.dsl.module
import org.koin.test.verify.verify

class KoinModulesTest {
    @OptIn(KoinExperimentalAPI::class)
    @Test
    fun `every koin definition can be resolved`() {
        module { includes(appModules) }.verify()
    }
}
