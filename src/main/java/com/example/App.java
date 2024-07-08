package com.example;




import java.util.UUID;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.example.pizza.Ingredient;




/**
 * Hello world!
 *
 */
public class App 
{   
   
   

    public static void main( String[] args )
    {

        Ingredient ingredient = Ingredient.create(UUID.randomUUID(), "tomate", 1D);
        ingredient.getId();
        ingredient.getName();
        ingredient.getPrice();

        ingredient.update("tomate", ingredient.getPrice());

        //EntityBase entiy = new EntityBase(UUID.randomUUID());
        System.out.println( "Hello World!" );
        setup();
    }

    public static void setup(){
        final StandardServiceRegistry registry =
				new StandardServiceRegistryBuilder()
						.build();

        SessionFactory sessionFactory = new MetadataSources(registry)
            .addAnnotatedClass(Events.class)
            .buildMetadata()            
            .buildSessionFactory();

        Session session =  sessionFactory.openSession();  

        var tr  =  session.beginTransaction();              
        
        Events events = new Events();
        events.id =1;
        
        session.persist(events);      
        //var result = session.get(Events.class, 1);
        //session.remove(events);        
        

        tr.commit();

        //var result = session.get(Events.class, 1);

        session.close();
    }
}
