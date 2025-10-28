package junit;

class Moto {
    //atributos
    private final String modelo;
    private double velocidade;
    private static final int VEL_FINAL = 150;
    private static final double TAMANHO_TANQUE = 30;
    private double qtdGasolina;

    public Moto(String modelo) {
        this.modelo = modelo;
        this.velocidade = 0;
    }
    public String getModelo() {
        return this.modelo;
    }
    public double getVelocidade() {
        return this.velocidade;
    }

    public double getQtdGasolina() {
        return qtdGasolina;
    }

    public void abastece(double litros) {
        if(litros < 0) throw new RuntimeException("Quantidade de litros deve ser positiva.");
        if(this.qtdGasolina + litros > TAMANHO_TANQUE) this.qtdGasolina = TAMANHO_TANQUE;
        else this.qtdGasolina += litros;
    }

    //aumenta a velocidade até a velocidade máxima
    public void acelera(int vel) {
        if(vel<0) throw new RuntimeException("vel deve ser positiva");
        double gasto = vel * 0.01;
        if(this.qtdGasolina <= 0) System.out.println("Sem gasolina! Não é possível acelerar");
        if(this.qtdGasolina < gasto) {
            double velPossivel = this.qtdGasolina / 0.01;
            this.velocidade += velPossivel;
            if(this.velocidade+vel > VEL_FINAL) this.velocidade=VEL_FINAL;
            this.qtdGasolina = 0;
        } else {
            this.qtdGasolina -= gasto;
            this.velocidade += vel;
            if (this.velocidade > VEL_FINAL) this.velocidade = VEL_FINAL;
        }
    }

    //diminui velocidade até parar
    public void freia(int vel) {
        if(this.velocidade-vel<0) this.velocidade = 0;
        else this.velocidade-=vel;
    }
}
