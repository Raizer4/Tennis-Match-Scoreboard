import entity.Player;
import org.hibernate.cfg.Configuration;

public class Runner {

    public static void main(String[] args) {

        Configuration configuration = new Configuration().configure();

        Player player = Player.builder()
                .name("gena")
                .build();

        try (var sessionFactory = configuration.buildSessionFactory();
             var session = sessionFactory.openSession();
        ) {
            session.beginTransaction();

            session.save(player);

            session.getTransaction().commit();
        }


    }

}
