
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main2 {
    private static final int CAPACIDADE_MAXIMA_CACHE = 10;

    public static void main(String[] args) {

        List<Pessoa> banco = new ArrayList<>();
        banco.add(new Pessoa(1, "Juliana", 25));
        banco.add(new Pessoa(2, "Benedito", 30));
        banco.add(new Pessoa(3, "Carla", 22));
        banco.add(new Pessoa(4, "Diego", 28));
        banco.add(new Pessoa(5, "Elias", 35));
        banco.add(new Pessoa(6, "Felipe", 19));
        banco.add(new Pessoa(7, "Mariana", 27));
        banco.add(new Pessoa(8, "Igor", 40));
        banco.add(new Pessoa(9, "Flávio", 31));
        banco.add(new Pessoa(10, "Thiago", 24));

        List<Pessoa> cache = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            IO.println("\nDigite o ID da pessoa (ou 0 para sair): ");
            int idBuscado = scanner.nextInt();

            if (idBuscado == 0) {
                IO.println("Busca encerrada");
                break;
            }


            Pessoa pessoaEncontrada = buscarPorId(cache, idBuscado);

            if (pessoaEncontrada != null) {
                IO.println("Pessoa encontrada no cache: " + pessoaEncontrada);
            } else {

                pessoaEncontrada = buscarPorId(banco, idBuscado);

                if (pessoaEncontrada != null) {

                    if (cache.size() >= CAPACIDADE_MAXIMA_CACHE) {
                        Pessoa removida = cache.remove(0); // Remove o elemento mais antigo (índice 0)
                        IO.println("[CACHE CHEIO] " + removida.getNome() + " foi removido(a) do cache.");
                    }

                    cache.add(pessoaEncontrada);
                    IO.println("Pessoa buscada no banco e adicionada ao cache: " + pessoaEncontrada);
                } else {
                    IO.println("Pessoa não encontrada no banco de dados.");
                }
            }
        }

        scanner.close();
    }

    private static Pessoa buscarPorId(List<Pessoa> lista, int id) {
        for (Pessoa p : lista) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }
}