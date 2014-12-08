

class Memento(pEtat:String, pCursor:Int){
  var memories:String = pEtat;
  var cursor:Int = pCursor;
  
  def getEtat()={
      memories;
  }
  
  def getCursor()={
    cursor;
  }
}