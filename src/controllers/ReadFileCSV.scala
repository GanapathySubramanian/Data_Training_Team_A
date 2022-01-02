package controllers
import caseclasses.FilePath
import org.apache.spark.sql.SparkSession
import traits.ReadFiles
import config.{LoadfilePath, SparkSessionObject}
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.catalyst.plans.logical.MapPartitions

import scala.io.{BufferedSource, Source}
class ReadFileCSV extends ReadFiles{
  override def readFiles(): SparkSession = {
      val sessionObject = new SparkSessionObject().getSparkSessionObject()
      val filePath = new LoadfilePath().loadCSVFilePath()
      val csvDF = sessionObject
        .read
        .option("header", "true")
        .csv(filePath)
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
