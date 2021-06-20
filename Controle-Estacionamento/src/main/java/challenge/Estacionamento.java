package challenge;

import java.util.ArrayList;

public class Estacionamento {
    private final ArrayList<Carro> carrosEstacionados = new ArrayList<>();

    public void estacionar(Carro carro) {
        temHabilitacaoSuspensa(carro.getMotorista());
        ehDeMenor(carro.getMotorista());
        if (carrosEstacionados.size() == 10){
            sohSenior();
            remanejaVagas();
        }
        carrosEstacionados.add(carro);
    }

    public int carrosEstacionados() {
        return carrosEstacionados.size();
    }

    public boolean carroEstacionado(Carro carro) {
        return carrosEstacionados.contains(carro);
    }

    private static void temHabilitacaoSuspensa(Motorista motorista) throws EstacionamentoException {
        if (motorista.getPontos() > 20) {
            throw new EstacionamentoException("Motoristas com habilitação suspensa não são permitidos.");
        }
    }

    private static void ehDeMenor(Motorista motorista) throws EstacionamentoException {
        if (motorista.getIdade() < 18) {
            throw new EstacionamentoException("Motoristas menores de 18 anos não são permitidos.");
        }
    }

    private void sohSenior() throws EstacionamentoException{
        boolean todosSeniors = carrosEstacionados.stream().allMatch(currCarro -> currCarro.getMotorista().getIdade() > 55);
        if (todosSeniors) {
            throw new EstacionamentoException("Não há vagas.");
        }
    }

    private void remanejaVagas() {
        ArrayList<Carro> proximosCarrosElegiveis = new ArrayList<>();
        Carro proximoCarroElegivel = null;
        for (Carro carro : carrosEstacionados) {
            if (carro.getMotorista().getIdade() < 55) {
                proximosCarrosElegiveis.add(carro);
            }
        }
        proximoCarroElegivel = proximosCarrosElegiveis.get(0);
        if (proximoCarroElegivel != null) {
            carrosEstacionados.remove(proximoCarroElegivel);
        }
    }
}
