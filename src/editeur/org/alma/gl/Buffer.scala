package org.alma.gl

/**
 * Classe implementant la zone de texte de l'editeur.
 * 
 */
class Buffer extends Observable{
  
  private var contenu:String = "";
  private var index:Int = 0;
  
  private val cb = new Clipboard();
  private val select = new Selectionner();
  private val historic = new Historique();
  
  /**
   * Actualise les observateurs des changements du contenu du Buffer
   */
  def actualiser(){
    notifierObservateur(contenu);
  }
  
   /**
   * Methode permettant la creation d'un "Memento" 
   */
  def sauverDansMemento()={
    new Memento(contenu, select.getDebut());
  }
  
  /**
   * Methode permettant l'ajout du "Memento" a l'index voulu
   */
  def memoire(){
    historic.ajouterMemento(sauverDansMemento(), index);
    setIndex(historic.getTailleMemento());
  }
 
  /**
   * Methode permettant de retourner a un "Memento" précis
   * @param pMemento Le "Memento" auquel on retourne
   */
  def recuperateur(pMemento:Memento){
      contenu = pMemento.getEtat();
      select.setDebut(pMemento.getCursor());
      select.setFin(pMemento.getCursor());
  }
  
  historic.ajouterMemento(sauverDansMemento(), index);
  
  /**
   * Lecture du contenu du buffer
   */
  def read(){
    print(contenu);
  }
  
  /**
   * Sauvegarde une chaine dans le Clipboard
   * @param str La chaine a sauvegarder
   */
  def fillClipboard(str:String){
    cb.setContent(str);
  }
  
  /**
   * Execute une commande Copier
   */
  def copy(){
    val cop:Copier = new Copier(this);
    cop.executer();
  }
  
  /**
   * Execute une commande Couper
   */
  def cut(){
    val cou:Couper = new Couper(this);
    cou.executer();
  }
  
  /**
   * Execute une commande Coller
   */
  def paste(){
    val col:Coller = new Coller(this);
    col.executer();
  }
  
  /**
   * Execute une commande Ecrire
   */
  def write(text:String){
    val ecr:Ecrire = new Ecrire(this, text);
    ecr.executer();
  }
  
  /**
   * Execute une commande Effacer
   */
  def backspace(){
    val eff:Effacer = new Effacer(this);
    eff.executer();
  }
  
  /**
   * Definit une selection
   * @param deb Le debut de la selection
   * @param fin La fin de la selection
   */
  def selection(deb:Int, fin:Int){
    select.selection(deb, fin, this);
  }
  
  /**
   * Definit un curseur
   * @param deb La position du curseur
   */
  def cursor(deb:Int){
    select.selection(deb, deb, this);
  }
  
  /**
   * Execute une commande Annuler
   */
  def undo(){
    val ann:Annuler = new Annuler(this);
    ann.executer();
  }
  
  /**
   * Execute une commande Refaire
   */
  def redo(){
    val ref:Refaire = new Refaire(this);
    ref.executer();
  }
  
  /****** ASSESSEURS ******/
  
  /**
   * Retourne le contenu du Buffer
   * @param
   * @return contenu Le contenu du Buffer
   */
  def getContent()={
    contenu;
  }
  
  /**
   * Change le contenu du Buffer
   * @param content Le contenu a changer
   */
  def setContent(content:String){
    contenu = content;
  }
  
  /**
   * Retourne l'index courant
   * @param
   * @return index L'index courant 
   */
  def getIndex()={
    index;
  }
  
  /**
   * Change l'index courant du Buffer
   * @param id L'index à changer
   */
  def setIndex(id:Int){
    index = id;
  }
  
  /**
   * Retourne la longueur du contenu du Bufer
   */
  def getLength()={
    contenu.length();
  }
  
  /**
   * Retourne le Clipboard associe Buffer
   * @param
   * @retunr cb Le Clipboard du Buffer
   */
  def getClipboard()={
    cb;
  }
  
  /**
   * Retourne la selection associee au Buffer
   * @param
   * @return select La selection du Buffer
   */
  def getSelect()={
    select;
  }
  
  /**
   * Retourne l'historique associe au Buffer
   * @param
   * @return historic L'historique du Buffer
   */
  def getHistoric()={
    historic;
  }
};