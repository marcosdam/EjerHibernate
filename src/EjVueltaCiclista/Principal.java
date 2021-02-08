package EjVueltaCiclista;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class Principal {
    public static void main(String[] args) {
        // Establecer conexión con el mapeo ORM que intermedia entre Java y la BD
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        // Abrir la sesión para trabajar con la base de datos
        Session session = sessionFactory.openSession();

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // Crear objetos para insertar en BD
        Palmares palmares1 = new Palmares(1, 3,5);
        Palmares palmares2 = new Palmares(2, 6, 4);

        Ciclista ciclista1 = new Ciclista(1, "Miguel", "López Pérez");
        ciclista1.setPalmares(palmares1);
        palmares1.setCiclista(ciclista1);

        Ciclista ciclista2 = new Ciclista(2, "María", "García Sanz");
        ciclista2.setPalmares(palmares2);
        palmares2.setCiclista(ciclista2);

        List<Ciclista> misCiclistas = new ArrayList<Ciclista>();
        misCiclistas.add(ciclista1);
        misCiclistas.add(ciclista2);

        Equipo equipo1 = new Equipo(1, "Valencianos", "Nike");
        equipo1.setCiclistas(misCiclistas);

        ciclista1.setEquipo(equipo1);
        ciclista2.setEquipo(equipo1);

        //
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // 1. Guardar o actualizar objeto en la BD (sesión)
        session.beginTransaction();
        session.saveOrUpdate(equipo1);      // Equipo contiene lista de ciclistas y ciclistas tiene palmarés (insertará tod0)
        session.getTransaction().commit();
        session.close();


        /*
        // SELECT TODOS LOS CICLISTAS
        session = sessionFactory.openSession();
        session.beginTransaction();
        List<Ciclista> misCiclistas = session.createQuery("from Ciclista ").list();
        for (Ciclista c: misCiclistas){
            System.out.println(c.toString());
        }


        // 2. Leer (CAST del objeto)    Ciclista 1
        session.beginTransaction();
        Ciclista ciclista = (Ciclista) session.get(Ciclista.class, 1);
        System.out.println(ciclista.toString());
        session.close();

        // 3. ACTUALIZAR
        session.beginTransaction();
        session.update(new Ciclista(12, "Javi", "Pérez García"));
        session.getTransaction().commit();
        session.close();


        // 4. ELIMINAR
        session.beginTransaction();
        session.delete(ciclista);
        session.getTransaction().commit();
        session.close();


        // 5. GUARDAR (ACTUALIZAR SI YA EXISTE)
        Ciclista ciclistaUpdate = new Ciclista(11, "Miguel", "Simón Castro");
        session.beginTransaction();
        session.saveOrUpdate(ciclistaUpdate);
        session.getTransaction().commit();
        session.close();



         */

    }
}
