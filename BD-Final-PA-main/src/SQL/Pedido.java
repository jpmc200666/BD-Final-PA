package SQL;

public class Pedido {
    int nPepperoni;
    int nVegetariana;
    int nHawaiana;
    int nCarnívora;
    int nMexicana;
    int nMariscos;
    int nRanchera;
    int nNapolitana;
    int nBBQ;

    public Pedido(int nPepperoni, int nVegetariana, int nHawaiana, int nCarnívora, int nMexicana, int nMariscos, int nRanchera, int nNapolitana, int nBBQ){
        this.nPepperoni = nPepperoni;
        this.nVegetariana = nVegetariana;
        this.nHawaiana = nHawaiana;
        this.nCarnívora = nCarnívora;
        this.nMexicana = nMexicana;
        this.nMariscos = nMariscos;
        this.nNapolitana = nNapolitana;
        this.nRanchera = nRanchera;
        this.nBBQ = nBBQ;
    }

    public int getnPepperoni() {
        return nPepperoni;
    }

    public void setnPepperoni(int nPepperoni) {
        this.nPepperoni = nPepperoni;
    }

    public int getnVegetariana() {
        return nVegetariana;
    }

    public void setnVegetariana(int nVegetariana) {
        this.nVegetariana = nVegetariana;
    }

    public int getnHawaiana() {
        return nHawaiana;
    }

    public void setnHawaiana(int nHawaiana) {
        this.nHawaiana = nHawaiana;
    }

    public int getnCarnívora() {
        return nCarnívora;
    }

    public void setnCarnívora(int nCarnívora) {
        this.nCarnívora = nCarnívora;
    }

    public int getnMexicana() {
        return nMexicana;
    }

    public void setnMexicana(int nMexicana) {
        this.nMexicana = nMexicana;
    }

    public int getnMariscos() {
        return nMariscos;
    }

    public void setnMariscos(int nMariscos) {
        this.nMariscos = nMariscos;
    }

    public int getnRanchera() {
        return nRanchera;
    }

    public void setnRanchera(int nRanchera) {
        this.nRanchera = nRanchera;
    }

    public int getnNapolitana() {
        return nNapolitana;
    }

    public void setnNapolitana(int nNapolitana) {
        this.nNapolitana = nNapolitana;
    }

    public int getnBBQ() {
        return nBBQ;
    }

    public void setnBBQ(int nBBQ) {
        this.nBBQ = nBBQ;
    }

    public int cuenta(){
        int cuenta = (nPepperoni + nVegetariana + nHawaiana + nMexicana + nCarnívora + nMariscos + nRanchera + nNapolitana + nBBQ)*10000;
        return cuenta;
    }
}
