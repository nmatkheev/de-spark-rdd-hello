package json_reader_matkheev.sparkProject

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession
import argonaut._
import Argonaut._
import org.apache.log4j.LogManager
import json_reader_matkheev.sparkProject.Wine


object JsonReader extends App {
  val log = LogManager.getLogger("main_logger")

  val inputFile = args(0)
  log.warn("!!!!!!!!!!!!!!!!!!")
  log.warn(s"file: $inputFile")
  log.warn("!!!!!!!!!!!!!!!!!!")

  val conf = new SparkConf()

  val spark = SparkSession.builder
      .appName("Wine Parsing")
      .master("local[*]")
      .config(conf)
      .getOrCreate

  Parser.run(spark, inputFile)
}

object Parser {
  @transient lazy val log = LogManager.getLogger("job_logger")

  def payload(line: String): Option[Wine] = {
    val obj = line.decodeOption[Wine]
    if (obj.isEmpty)
      log.warn(s"unserializable line: $line")
    else
      log.warn(obj.get)
    obj
  }

  def run(spark: SparkSession, filepath: String) = {

    val data = spark.sparkContext.textFile(filepath)

    val jsond = data.map(payload)
    jsond.count
  }
}
