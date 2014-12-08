package org.alma.gl

/**
 * Classe permettant de definir une selection
 */
class Selectionner{
  private var content:String = "";
  private var debut:Int = 0;
  private var fin:Int = 0;
 
  /**
   * Definit la selection
   * @param d Debut de la selection
   * @param f Fin de la selection
   * @param b Buffer sur lequel effectuer la selection
   */
  def selection(d:Int, f:Int, b:Buffer){
    debut=d;
    fin=f;
    
    if(debut>fin){
      debut = f;
      fin = d;
    }
    
    if(debut<0){
      debut = 0;
    }else if(debut>b.getContent().length()){
      debut = b.getContent().length();
    }
    
    if(fin>b.getContent().length()){
      fin = b.getContent().length();
    }else if(fin<0){
      fin = 0;
    }
      
    content=b.getContent().substring(debut,fin);
  }
  
  /**
   * Mise à zero du contenu de la selection
   */
  def resetContent(){
    content="";
  }
  
  /**
   * Retourne le contenu de la selection
   */
  def getContent()={
    content;
  }
  
  /**
   * Retourne la position du curseur de debut de la selection
   */
  def getDebut()={
    debut;
  }
  
  /**
   * Change la position du curseur de debut de la selection
   * @param d La nouvelle position du curseur de debut
   */
  def setDebut(d:Int){
    debut = d;
  }
  
  /**
   * Retourne la position du curseur de fin de la selection
   */
  def getFin()={
    fin;
  }
  
  /**
   * Change la position du curseur de fin de la selection
   * @param f La nouvelle position du curseur de fin
   */
  def setFin(f:Int){
    fin = f;
  }
  
}