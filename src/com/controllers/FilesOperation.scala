package com.controllers


import com.config.SparkSessionObject

class FilesOperation {
  def findCountOfUniqueValue(colDistinct:String,conditionColName:String,conditionValue:String): Unit ={
    val csvDV = new ReadFileCSV().readFiles()
    val result = csvDV.sql("SELECT count(distinct `"+colDistinct+"`) AS `distinct product line ` FROM SALE_TABLE WHERE `"+conditionColName+"`='"+conditionValue+"'")
    result.show()
  }

  // This method is used to find the sum of the column
  def sumRevenue(colToSum:String,conditionName:String,conditionVal:String): Unit ={
    val spark =new SparkSessionObject().getSparkSessionObject();
    val sparkContext = spark.sparkContext
    val csvDV = new ReadFileCSV().readFiles()
    val result = csvDV.sql("SELECT "+colToSum+" FROM SALE_TABLE WHERE `"+conditionName+"`='"+conditionVal+"' and "+colToSum+" != '0'")

    val salesRDD = result.rdd

    val revenue = sparkContext.doubleAccumulator("revenue")
    salesRDD.foreach(each =>
      revenue.add {
        each.getString(0).toFloat
      }
    )

    println(revenue.value)
  }

}

