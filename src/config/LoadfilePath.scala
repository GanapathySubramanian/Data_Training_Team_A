package config

import caseclasses.FilePath

class LoadfilePath {

  def loadCSVFilePath():String ={
    val filePath = FilePath("C:\\Users\\vc\\Desktop\\data training\\scalatrainingintellij-master\\data\\sales.csv")
    filePath.filePath
  }


}
