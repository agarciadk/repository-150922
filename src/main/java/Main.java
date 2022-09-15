import org.h2.tools.Server;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import model.Elfo;
import service.ElfoService;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        System.out.println("Iniciando app");

        System.out.println("Iniciando BD(H2)");
        final Server server = Server.createTcpServer(args).start();

        final AbstractApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        final ElfoService elfoService = context.getBean(ElfoService.class);
        System.out.println(elfoService);

        long count = elfoService.count();
        System.out.println("Número de elfos: " + count);

        Elfo elfo;
        try {
            elfo = elfoService.find("Galadriel");
            System.out.println(elfo);

            elfo = elfoService.find("asd"); // <-- Will throw an exception
            System.out.println(elfo);

        } catch (Exception e) {
            System.err.println("Ups, algo ha pasado");
            e.printStackTrace();
        } finally {
            System.out.println("Cerrando contexto.");
            context.close();

            System.out.println("Cerrando BD.");
            server.stop();

            System.out.println("Cerrando app.");
        }
    }
}
