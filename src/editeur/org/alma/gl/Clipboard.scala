package org.alma.gl

class Clipboard {
  
  private var clipboard:String = "";
  
  def getContent()={
    clipboard;
  }
  
  def setContent(content:String){
    clipboard = content;
  }
  
  def getLength()={
    clipboard.length;
  }
}