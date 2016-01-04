grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"
grails.project.docs.output.dir = 'docs' // for the gh-pages branch

//grails.tomcat.jvmArgs = ["-Xmx1024m","-Xms512m", "-agentpath:C:\\Program Files (x86)\\YourKit Java Profiler 9.0.9\\bin\\win64\\yjpagent.dll=sampling,onexit=snapshot"]

//grails.project.war.file = "target/${appName}-${appVersion}.war"
grails.project.dependency.resolution = {
    // inherit Grails' default dependencies
    inherits("global") {
        // uncomment to disable ehcache
        // excludes 'ehcache'
    }
    log "warn" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
    repositories {
        mavenLocal()
        mavenRepo("http://repo.grails.org/grails/repo/")

        grailsPlugins()
        grailsHome()
        grailsCentral()

        mavenRepo "http://oss.sonatype.org/content/repositories/releases/"
    }
    dependencies {
        runtime "org.elasticsearch:elasticsearch:0.19.10"
        runtime "org.elasticsearch:elasticsearch-lang-groovy:1.1.0"
    }
    plugins {
		runtime ":hibernate:$grailsVersion"
        build (":release:latest.integration", ":rest-client-builder:latest.integration") {
            export = false
        }
    }
}
