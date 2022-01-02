package com.controllers

import com.config.{LoadfilePath, SparkSessionObject}
import com.traits.ReadFiles
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.SparkSession

class ReadFileCSV extends ReadFiles{
  override def readFiles(): SparkSession = {
    val sessionObject = new SparkSessionObject().getSparkSessionObject()
    val filePath = new LoadfilePath().loadCSVFilePath()
    val csvDF = sessionObject
      .read
      .option("header", "true")
      .format("com.databricks.spark.csv")
      .load(filePath)

    csvDF.createOrReplaceTempView("SALE_TABLE")
    sessionObject
  }

  def readFileAsRDD(): RDD[String] ={
    val sparkSession =new SparkSessionObject().getSparkSessionObject();
    val sparkContext = sparkSession.sparkContext;
    val salesRDD = sparkContext.textFile(new LoadfilePath().loadCSVFilePath());
    salesRDD
  }

}
