# Introduction

This app exists to show how to integrate Prefab with a Dropwizard application using Guice for Dependency Injection

# Overview

## Prefab Installation

The second commit in this repository shows the installation work. We can break it down as follows

1. Add the dependencies in pom.xml
2. Add the [Guice module](/src/main/java/com/example/helloworld/modules/PrefabModule.java). This currently initializes the client to LOCAL_ONLY mode.
3. Install the Guice module in the [application class](/src/main/java/com/example/helloworld/HelloWorldApplication.java#L54)
4. Add a [default config file](/src/main/resources/.prefab.default.config.yaml)

## Prefab Usage

The next commits adds some example use cases

1. [Home Resource](/src/main/java/com/example/helloworld/resources/HomeResource.java) and its View Counterpart illustrate fetching config values. The view adds links that require login to test protected resource
2. [Protected Resource](/src/main/java/com/example/helloworld/resources/ProtectedResource.java) has some authorization required endpoints that will allow us to demonstrate PrefabContext usage
3. Add a [RequestFilter](/src/main/java/com/example/helloworld/filter/PrefabContextAddingRequestFilter.java) to create a Prefab context for a logged in user and save it to a ThreadLocal 
4. Add a [Response filter](/src/main/java/com/example/helloworld/filter/PrefabContexClearingResponseFilter.java) to clear the Prefab context ThreadLocal so that when the thread is used for a new request, it starts with a clean slate


# Running The Application

To test the example application run the following commands.

* To create the example, package the application using [Apache Maven](https://maven.apache.org/) from the root dropwizard directory.

        cd dropwizard
        ./mvnw package
        cd dropwizard-example

* To run the server run.

        java -jar target/dropwizard-example-$DW_VERSION.jar server example.yml

* To hit the Hello World example (hit refresh a few times).

	http://localhost:8080/hello-world


## Credits

This example is based on https://github.com/Appdynamics/dropwizard-sample-app
