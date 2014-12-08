

class Buffer extends Observable{
  var contenu : String = "";
  var index : Int = 0;
  
  val cb=new Clipboard();
  val sel=new Selectionner();
  val historic = new Historique();
  
  def actualiser(){
    notifierObservateur(contenu);
  }
  
  def memoire(){
    historic.ajouterMemento(sauverDansMemento(), index);
    setIndex(historic.getTailleMemento());
  }

  def sauverDansMemento()={
    new Memento(contenu, sel.getDebut());
  }
  
  def recuperateur(pMemento:Memento){
      contenu = pMemento.getEtat();
      sel.setDebut(pMemento.getCursor());
      sel.setFin(pMemento.getCursor());
  }
  
  historic.ajouterMemento(sauverDansMemento(), index);
  
  def read(){
    print(contenu);
  }
  
  def copy(){
    val cop = new Copier(this);
    cop.execute();
  }
  
  def cut(){
    val cou = new Couper(this);
    cou.execute();
    /*memoire();
    actualiser();*/
  }
  
  def paste(){
    val col = new Coller(this);
    col.execute();
    /*memoire();
    actualiser();*/
  }
  
  def write(text:String){
    val wr = new Ecrire(this, text);
    wr.execute();
    /*memoire();
    actualiser();*/
  }
  
  def backspace(){
    val bk = new Effacer(this);
    bk.execute();
    /*memoire();
    actualiser();*/
  }
  
  def select(deb:Int,fin:Int)={
    sel.selectionner(deb,fin,this);
  }
  
  def cursor(deb:Int)={
    sel.selectionner(deb,deb,this);
  }
  
  def undo() {
    val ud = new Annuler(this);
    ud.execute();
  }
  
  def redo() {
    val rd = new Refaire(this);
    rd.execute();
  }
  
  /* ASSESSEURS */
  
  def getContent() ={
    contenu;
  }
  
  def setContent(content:String){
    contenu=content;
  }
  
  def getSelect()={
    sel;
  }
  
  def getHistoric()={
    historic;
  }
  
  def getLength()={
    contenu.length();
  }
  
  def getCb()={
    cb;
  }
  
  def setCb(str:String){
    cb.setCb(str);
  }
  
  def getIndex()={
    index;
  }
  
  def setIndex(id:Int){
    index = id;
  }
};