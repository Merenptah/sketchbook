package com.hg.sketchbock.spock.api

import com.hg.sketchbook.spock.api.JsonController
import groovy.json.JsonSlurper
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import spock.lang.Narrative
import spock.lang.Specification
import spock.lang.Title

import static org.springframework.http.HttpStatus.OK
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup

@Title("This is the JSON API")
@Narrative("""
As a user
I want foo
So that bar
""")
class JsonControllerTest extends Specification {
    def jsonController = new JsonController()

    MockMvc mockMvc = standaloneSetup(jsonController).build()

    def "get response"() {
        when: 'call is made'
        def response = mockMvc.perform (get('/json').accept(MediaType.APPLICATION_JSON)).andReturn().response
        def content = new JsonSlurper().parseText(response.contentAsString)

        then:
        response.status == OK.value()
        verifyAll(content.data) {
            name.contains("Max")
            address == "MÃ¼nchen"
        }
    }

}