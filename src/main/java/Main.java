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

        System.out.println("Número de elfos: " + elfoService.count());
        try {
            System.out.println("------------- FINDALL -------------");
            elfoService.findAll().forEach(System.out::println);

            System.out.println("------------- FIND -------------");
            System.out.println(elfoService.find("Galadriel"));

            System.out.println("------------- ADD -------------");
            System.out.println(elfoService.add(new Elfo(4L, "asd", 1234)));

            // Update
            System.out.println("------------- UPDATE -------------");
            System.out.println(elfoService.updateById(4L, new Elfo(null, "das", 3456)));

            // Delete
            System.out.println("------------- DELETE -------------");
            elfoService.deleteById(4L);
            for (Elfo elfoItem : elfoService.findAll()) {
                System.out.println(elfoItem);
            }
            System.out.println("------------- QUERY -------------");
            elfoService.query().forEach(System.out::println);

            System.out.println("------------- QUERY2 -------------");
            System.out.println(elfoService.query2("Légolas"));

            System.out.println("------------- QUERY3 -------------");
            System.out.println(elfoService.query3("Elrond"));

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
