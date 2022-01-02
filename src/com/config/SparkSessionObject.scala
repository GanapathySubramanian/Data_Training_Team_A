package com.config

import org.apache.spark.sql.SparkSession
class SparkSessionObject {
  def getSparkSessionObject(): SparkSession ={
    var sessionObject = SparkSession
      .builder()
      .appName("Team-A-Project")
      .master("local[*]")
      .getOrCreate()
    sessionObject
  }
}

