package com.hg.sketchbook.codegen

import groovy.json.JsonSlurper
import groovy.text.SimpleTemplateEngine

// Boilerplate to manually run the script from the IDE for debug purposes

//Map properties = [
//        'templatePath': "../../../src/test/resources",
//        'schema': "../../../src/test/resources/test_schema.json",
//        'generatedSourcesPath': "../../../target/generated-sources/"
//]

class Field {
    String name
    String type
    String owner
    String visibility
}

jsonToJavaTypes = [
        'string'       : 'String',
        'integer'      : 'Integer',
]

templateDir = new File("${properties['templatePath']}")
generatedSourcesDir = new File("${properties['generatedSourcesPath']}")

def source = new JsonSlurper().parse(new File("${properties['schema']}"))

templateDir.eachFileMatch(~/.*.template/) { template ->
    def fields = convertJsonToFields(source)
    File outputDir = makeOutputDir(template, generatedSourcesDir)
    def fileNameWithoutExtension = template.getName().split("\\.")[0]
    def generatedJavaClass = new SimpleTemplateEngine().createTemplate(template).make(['fields': fields])
    def outputFile = new File("${outputDir.getPath()}/${fileNameWithoutExtension}.java")
    outputFile.text = generatedJavaClass
}

private List<Field> convertJsonToFields(Map source) {
    source.collect { it ->
        def field = new Field()

        field.name = it.key
        field.type = jsonToJavaTypes[it.value.type]
        field.owner = it.value.owner
        field.visibility = it.value.visibility ? it.value.visibility : 'public'

        return field
    }
}

private static File makeOutputDir(File template, File generatedSourcesDir) {
    def packageString
    template.withReader { packageString = it.readLine() }
    def packageSubPath = packageString.minus('package ').minus(';').split('\\.').join('/')
    def outputDir = new File("${generatedSourcesDir.getPath()}/$packageSubPath")
    outputDir.mkdirs()
    outputDir
}
