package learningspringboot

import groovy.json.JsonSlurper
import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.scheduling.annotation.Scheduled

@Grab("groovy-all")

@EnableScheduling
class MetricsCollector {

    def url = "http://localhost:8080/metrics"
    def slurper = new JsonSlurper()
    def keys = slurper.parse(new URL(url)).keySet()
            .findAll{
        it.startsWith("counter")
    }

    def header = false;


    @Scheduled(fixedRate = 1000L)
    void run() {
        println(keys)

        if (!header) {
            println(keys.join(','))
            header = true
        }

        def metrics = slurper.parse(new URL(url))

        println(keys.collect{metrics[it]}.join(','))
    }

}