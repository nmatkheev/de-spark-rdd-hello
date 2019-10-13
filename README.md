#### Spark RDD hello-world  

Important issues:  
* use jdk 1.8  
* sbt archetype (like holdens) is awkward, for students you can make your own   
* sbt is slower than maven+scala


How to run:  
* download Spark (2.3.4, for hadoop 2.7)  
* add Spark path to bin  
* put the payload (json winemag)

```
spark-submit --master local[*] --class json_reader_matkheev.sparkProject.JsonReader scala-2.11/sparkProject-assembly-0.0.1.jar winemag-data-130k-v2.json 
```