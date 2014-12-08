import org.junit.Assert
import org.junit.After
import org.junit.Before
import org.junit.Test;
import org.alma.gl._;

class CommandesTests {
  
  private var buffer:Buffer = null;
  
  @Before
  def setUp() {
    buffer = new Buffer();
    Assert.assertNotNull(buffer);
    Assert.assertEquals(buffer.getContent(),"");
  }

  @After
  def tearDown() {
    buffer = null;
  }
  
  /* 
   * Tests concernant la commande Selectionner
   *
   */
  
  @Test
  def selectionText(){
    var text:String = "blabla";
    val ecr:Ecrire = new Ecrire(buffer, text);
    ecr.executer();
    buffer.selection(1, 4);
    var sel:String = "lab";
    
    Assert.assertEquals(buffer.getSelect().getContent(),sel);
    Assert.assertEquals(buffer.getSelect().getDebut(),1);
    Assert.assertEquals(buffer.getSelect().getFin(),4);
  }
  
  @Test
  def selectionCursorIn(){
    var text:String = "blabla";
    val ecr:Ecrire = new Ecrire(buffer, text);
    ecr.executer();
    buffer.cursor(4);
    
    Assert.assertEquals(buffer.getSelect().getContent(),"");
    Assert.assertEquals(buffer.getSelect().getDebut(),4);
    Assert.assertEquals(buffer.getSelect().getFin(),4);
  }
  
  @Test
  def selectionCursorTooFar(){
    var text:String = "blabla";
    val ecr:Ecrire = new Ecrire(buffer, text);
    ecr.executer();
    buffer.cursor(20);
    
    Assert.assertEquals(buffer.getSelect().getContent(),"");
    Assert.assertEquals(buffer.getSelect().getDebut(),buffer.getLength());
    Assert.assertEquals(buffer.getSelect().getFin(),buffer.getLength());
  }
  
  /* 
   * Tests concernant la commande Ecrire
   *
   */
  
  @Test
  def writeSomething(){
    var text:String = "blabla";
    val ecr:Ecrire = new Ecrire(buffer, text);
    ecr.executer();
    
    Assert.assertEquals(buffer.getContent(),text);
  }
  
  /* 
   * Tests concernant la commande Effacer
   *
   */
  
  @Test
  def eraseSomething(){
    var text:String = "blabla";
    val ecr:Ecrire = new Ecrire(buffer, text);
    ecr.executer();
    
    val eff:Effacer = new Effacer(buffer);
    eff.executer();
    
    text = "blabl";
    Assert.assertEquals(buffer.getContent(),text);
  }
  
  @Test
  def eraseNothing(){
    val eff:Effacer = new Effacer(buffer);
    eff.executer();
    
    Assert.assertEquals(buffer.getContent(),"");
  }
  
  @Test
  def eraseSelection(){
    var textBefore:String = "blublu";
    val ecr:Ecrire = new Ecrire(buffer, textBefore);
    ecr.executer();
    buffer.selection(1, 4);
    val eff:Effacer = new Effacer(buffer);
    eff.executer();
    
    var textAfter:String = "blu";
    Assert.assertEquals(buffer.getContent(),textAfter);
  }
  
  /* 
   * Tests concernant la commande Copier
   *
   */
  
  @Test
  def copySomething(){
    var textBefore:String = "blublu";
    val ecr:Ecrire = new Ecrire(buffer, textBefore);
    ecr.executer();
    buffer.selection(1, 4);
    val cop:Copier = new Copier(buffer);
    cop.executer();
    
    var copy:String = "lub";
    var textAfter:String = "blublu";
    Assert.assertEquals(buffer.getClipboard().getContent(),copy);
    Assert.assertEquals(buffer.getSelect().getContent(),copy);
    Assert.assertEquals(buffer.getContent(),textAfter);
  }
  
  @Test
  def copyNothing(){
    var text:String = "blublu";
    val ecr:Ecrire = new Ecrire(buffer, text);
    ecr.executer();
    
    Assert.assertEquals(buffer.getClipboard().getContent(),"");
  }
  
  /* 
   * Tests concernant la commande Couper
   *
   */
  
  @Test
  def cutSomething(){
    var textBefore:String = "blublu";
    val ecr:Ecrire = new Ecrire(buffer, textBefore);
    ecr.executer();
    buffer.selection(1, 4);
    val cou:Couper = new Couper(buffer);
    cou.executer();
    
    var clipboard:String = "lub";
    var textAfter:String = "blu";
    Assert.assertEquals(buffer.getClipboard().getContent(),clipboard);
    Assert.assertEquals(buffer.getContent(),textAfter);
    Assert.assertEquals(buffer.getSelect().getDebut(),1);
    Assert.assertEquals(buffer.getSelect().getFin(),1);
    Assert.assertEquals(buffer.getSelect().getContent(),"");
  }
  
  @Test
  def cutNothing(){
    var textBefore:String = "blublu";
    val ecr:Ecrire = new Ecrire(buffer, textBefore);
    ecr.executer();
    val cou:Couper = new Couper(buffer);
    cou.executer();
    
    var textAfter:String = "blublu";
    Assert.assertEquals(buffer.getClipboard().getContent(),"");
    Assert.assertEquals(buffer.getContent(),textAfter);
  }
  
  /* 
   * Tests concernant la commande Coller
   *
   */
  
  @Test
  def pasteSomething(){
    var textBefore:String = "blublu";
    val ecr:Ecrire = new Ecrire(buffer,textBefore);
    ecr.executer();
    buffer.selection(1, 4);
    val cop:Copier = new Copier(buffer);
    cop.executer();
    buffer.cursor(20);
    val col:Coller = new Coller(buffer);
    col.executer();
    
    var textAfter:String = "blublulub";
    Assert.assertEquals(buffer.getContent(),textAfter);
  }
  
  @Test
  def pasteNothing(){
    var text:String = "blublu";
    val ecr:Ecrire = new Ecrire(buffer, text);
    ecr.executer();
    val col:Coller = new Coller(buffer);
    col.executer();
    
    Assert.assertEquals(buffer.getContent(),"blublu");
  }
  
  /* 
   * Tests concernant la commande Annuler
   *
   */
  
  @Test
  def undoSomething(){
    var textBefore:String = "blibli";
    val ecr:Ecrire = new Ecrire(buffer, textBefore);
    ecr.executer();
    val eff:Effacer = new Effacer(buffer);
    eff.executer();
    val ann:Annuler = new Annuler(buffer);
    ann.executer();
    
    var textAfter:String = "blibli";
    Assert.assertEquals(buffer.getContent(),textAfter);
  }
  
  @Test
  def undoSomething2(){
    var textBefore:String = "blibli";
    val ecr:Ecrire = new Ecrire(buffer, textBefore);
    ecr.executer();
    var textAdd:String = "blu";
    val ecr2:Ecrire = new Ecrire(buffer, textAdd);
    ecr2.executer();
    buffer.selection(1, 4);
    val eff:Effacer = new Effacer(buffer);
    eff.executer();
    val ann:Annuler = new Annuler(buffer);
    ann.executer();
    ann.executer();
    ann.executer();
    
    var textAfter:String = "";
    Assert.assertEquals(buffer.getContent(),textAfter);
  }
  
  @Test
  def undoNothing(){
    val ann:Annuler = new Annuler(buffer);
    ann.executer();
    Assert.assertEquals(buffer.getContent(),"");
  }
  
  /* 
   * Tests concernant la commande Refaire
   *
   */
  
  @Test
  def redoSomething(){
    var textBefore:String = "blibli";
    val ecr:Ecrire = new Ecrire(buffer, textBefore);
    ecr.executer();
    val eff:Effacer = new Effacer(buffer);
    eff.executer();
    val ann:Annuler = new Annuler(buffer);
    ann.executer();
    val ref:Refaire = new Refaire(buffer);
    ref.executer();
    
    var textAfter:String = "blibl";
    Assert.assertEquals(buffer.getContent(),textAfter);
  }
  
  @Test
  def redoNothing(){
    var textBefore:String = "blibli";
    val ecr:Ecrire = new Ecrire(buffer, textBefore);
    ecr.executer();
    val eff:Effacer = new Effacer(buffer);
    eff.executer();
    eff.executer();
    val ref:Refaire = new Refaire(buffer);
    ref.executer();
    
    var textAfter:String = "blib";
    Assert.assertEquals(buffer.getContent(),textAfter);
  }
}