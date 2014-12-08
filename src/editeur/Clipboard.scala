

class Clipboard {
  private var clipboard:String = "";
  
  def getContent() = {
    clipboard;
  }
  
  def getLength()={
    clipboard.length;
  }
  
  def setCb(content:String){
    clipboard=content;
  }
}