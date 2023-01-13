package com.hg.sketchbock.spock.api

import com.hg.sketchbook.spock.api.HelloController
import org.springframework.test.web.servlet.MockMvc
import spock.lang.Specification

import static org.springframework.http.HttpStatus.OK
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup


class HelloControllerTest extends Specification {
    def helloController = new HelloController()

    MockMvc mockMvc = standaloneSetup(helloController).build()

    def "get response"() {
        when: 'call is made'
        def response = mockMvc.perform (get('/hello')).andReturn().response
        def content = response.contentAsString

        then:
        response.status == OK.value()
        content == "Hello world!"
    }

}