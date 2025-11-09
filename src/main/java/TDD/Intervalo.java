package TDD;

public class Intervalo {
    private int totalSegundos;

    public Intervalo(int horas, int minutos, int segundos) {
        if (horas < 0 || minutos < 0 || segundos < 0) {
            throw new IllegalArgumentException("Os valores devem ser positivos");
        }

        this.totalSegundos = horas * 60 * 60 + minutos * 60 + segundos;
    }

    public int getHoras() {
        return this.totalSegundos / 3600;
    }

    public int getMinutos() {
        return (this.totalSegundos % 3600) / 60;
    }

    public int getSegundos() {
        return this.totalSegundos % 60;
    }

    public int getMinutosTotais() {
        return this.totalSegundos / 60;
    }

    public int getSegundosTotais() {
        return this.totalSegundos;
    }

    public Intervalo somar (Intervalo outro) {
        return new Intervalo(0, 0, this.totalSegundos + outro.totalSegundos);
    }

    public Intervalo subtrair (Intervalo outro) {
        int resultado = this.totalSegundos - outro.totalSegundos;
        if (resultado < 0) {
            throw new IllegalArgumentException("O valor deve ser positivo");
        }
        return new Intervalo(0, 0, resultado);
    }

    public boolean equals (Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Intervalo)) return false;
        Intervalo outro = (Intervalo) obj;
        return this.totalSegundos == outro.totalSegundos;
    }

    public int hashCode () {
        return Integer.hashCode(this.totalSegundos);
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d:%02d", getHoras(), getMinutos(), getSegundos());
    }
}
