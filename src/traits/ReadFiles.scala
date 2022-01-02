package traits

import org.apache.spark.sql.SparkSession

trait ReadFiles {
  def readFiles():SparkSession
}
