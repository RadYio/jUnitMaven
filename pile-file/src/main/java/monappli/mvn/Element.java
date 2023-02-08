package monappli.mvn;

public class Element {
    private Element avant;
    private Element apres;
    private int valeur;

    Element(int valeur) {
        this.valeur = valeur;
        this.avant = null;
        this.apres = null;
    }

    /**
     * Retourne la valeur de l'élément
     * @return la valeur de l'élément
     */
    public int getValeur(){
        return this.valeur;
    }

    /**
     * Modifie la valeur de l'élément
     * @param valeur
     */
    public void setValeur(int valeur){
        this.valeur = valeur;
    }

    /**
     * Retourne l'élément avant
     * @return l'élément avant
     */
    public Element getAvant(){
        return this.avant;
    }

    /**
     * Modifie l'élément avant
     * @param avant
     */
    public void setAvant(Element avant){
        this.avant = avant;
    }

    /**
     * Retourne l'élément après
     * @return l'élément après
     */
    public Element getApres(){
        return this.apres;
    }


    /**
     * Modifie l'élément après
     * @param apres
     */
    public void setApres(Element apres){
        this.apres = apres;
    }


    /**
     * Retourne une chaîne de caractères représentant l'élément
     */
    public String toString(){
        return "Element de valeur " + this.valeur;
    }

}
