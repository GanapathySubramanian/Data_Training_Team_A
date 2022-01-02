package com.driver

import com.controllers.FilesOperation

object driverObject {
  def main(args: Array[String]): Unit = {

    val filesOperation = new FilesOperation()
    filesOperation.findCountOfUniqueValue("Product type","Product Line","Golf Equipment")
    filesOperation.sumRevenue("Revenue","Retailer country","France")

  }
}

