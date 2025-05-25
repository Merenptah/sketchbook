# Code generation
This is an example of doing custom code generation using Groovy and the groovy-templater.

Generate the classes by doing a `mvn compile`, which triggers the `generate-files` phase, in which the code generation is configured. OpenJDK 18 did not work for me, Java 11 did.

The Groovy script reads the `source.json`, which is the template configuration file containing all the data controlling the generated files. It maps it into objects which are passed to the corresponding templates. The `SimpleTemplateEngine` takes care of filling the templates with these values.
