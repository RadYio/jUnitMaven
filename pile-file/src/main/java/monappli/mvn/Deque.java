package monappli.mvn;

/**
 * Classe Deque
 * @author GONIN-SAGET Allan
 */
public class Deque {
    private Element tete;
    private Element queue;

    
    /**
     * Constructeur de la classe Deque
     */
    Deque() {
        this.tete = null;
        this.queue = null;
    }

    /**
     * Constructeur de la classe Deque
     * @param tete l'élément de tête de la liste
     * @param queue l'élément de queue de la liste
     * 
     */
    Deque(Element tete, Element queue) {
        this.tete = tete;
        this.queue = queue;
    }

    /**
     * Vérifie si la deque est vide
     * @return true si la deque est vide, false sinon
     */
    public boolean estVide() {
        return this.tete == null && this.queue == null;
    }

    /**
     * Ajoute un élément à la tete
     * @param v la valeur de l'élément à ajouter
     */
    public void ajouterTete(int v) {
        Element e = new Element(v);
        if (this.estVide()) {
            this.tete = e;
            this.queue = e;
        } else {
            e.setApres(this.tete);
            this.tete.setAvant(e);
            this.tete = e;
        }
    }

    /**
     * Oter un élément à la tête
     * 
     * @return la valeur de l'élément retiré
     */
    public int oterTete() throws IndexOutOfBoundsException{
        if (this.estVide()) throw new IndexOutOfBoundsException("La deque est vide");
        
        int valeur = this.tete.getValeur();
        this.tete = this.tete.getApres();
        //Si la tete est null, la queue doit l'être aussi
        if(this.tete == null) this.queue = null;
        else this.tete.setAvant(null);
        return valeur;
    }

    /**
     * Ajoute un élément à la queue
     * @param v la valeur de l'élément à ajouter
     */
    public void ajouterQueue(int v) {
        Element e = new Element(v);
        if (this.estVide()) {
            this.tete = e;
            this.queue = e;
        } else {
            e.setAvant(this.queue);
            this.queue.setApres(e);
            this.queue = e;
        }
    }

    /**
     * Oter un élément à la queue
     * @return la valeur de l'élément retiré
     */
    public int oterQueue() throws IndexOutOfBoundsException{
        if (this.estVide()) throw new IndexOutOfBoundsException("La deque est vide");
        int valeur = this.queue.getValeur();
        this.queue = this.queue.getAvant();
        if(this.queue != null)
            this.queue.setApres(null);
            this.tete = null;
        return valeur;

    }

    /**
     * Vider la deque de tous ses éléments
     */
    public void viderDeque(){
        this.tete = null;
        this.queue = null;
    }

    /*
     * toString
     */
    public String toString() {
        String s = "Deque: ";
        Element e = this.tete;
        while (e != null) {
            s += e.getValeur() + ", ";
            e = e.getApres();
        }
        return s;
    }

    public static void main(String args[]){
        System.out.println("fesse");

    }


}
