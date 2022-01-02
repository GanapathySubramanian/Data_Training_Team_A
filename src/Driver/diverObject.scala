package Driver

import controllers.{FilesOperation, ReadFileCSV}

object diverObject {
  def main(args: Array[String]): Unit = {
    val filesOperation = new FilesOperation()
      filesOperation.findCountOfUniqueValue()
      filesOperation.mapTransition()

//    val data = new ReadFileCSV().readFileAsRDD()
  }
}
